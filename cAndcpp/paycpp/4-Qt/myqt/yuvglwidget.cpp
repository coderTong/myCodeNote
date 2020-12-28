#include "yuvglwidget.h"
#include<QGLFormat>
#include<QFile>
#include<thread>
//自动加双引号
#define GET_STR(x) #x
#define A_VER 3
#define T_VER 4

//顶点shader
const char *vertexShader = GET_STR(
    attribute vec4 vertexIn;
    attribute vec2 textureIn;
    varying vec2 textureOut;
    void main(void)
    {
        gl_Position = vertexIn;
        textureOut = textureIn;
    }
);

//片元shader
const char *fragShader = GET_STR(
    varying vec2 textureOut;
    uniform sampler2D tex_y;
    uniform sampler2D tex_u;
    uniform sampler2D tex_v;
    void main(void)
    {
        vec3 yuv;
        vec3 rgb;
        yuv.x = texture2D(tex_y, textureOut).r;
        yuv.y = texture2D(tex_u, textureOut).r - 0.5;
        yuv.z = texture2D(tex_v, textureOut).r - 0.5;
        rgb = mat3(1.0, 1.0, 1.0,
            0.0, -0.39465, 2.03211,
            1.13983, -0.58060, 0.0) * yuv;
        gl_FragColor = vec4(rgb, 1.0);
    }
);

YUVGLWidget::YUVGLWidget(QWidget *parent): QOpenGLWidget(parent)
{
    qDebug("YUVGLWidget");

    ysize=srcW_*srcH_;
    timer=new QTimer(this);
    connect(timer,&QTimer::timeout,this,&YUVGLWidget::update);
    timer->setInterval(40);
    timer->start();

}

YUVGLWidget::~YUVGLWidget()
{
    fclose(f);
    if(timer){
        emit timer->stop();
        delete timer;
    }
    if(datas){
        delete [] datas[0];
        delete [] datas[1];
        delete [] datas[2];
    }
}

void YUVGLWidget::initializeGL()
{
    qDebug() << "initializeGL";

    //初始化opengl （QOpenGLFunctions继承）函数
    initializeOpenGLFunctions();

    //加载shader代码
    program.addShaderFromSourceCode(QOpenGLShader::Vertex,vertexShader);
    program.addShaderFromSourceCode(QOpenGLShader::Fragment,fragShader);

    //设置顶点坐标变量
    program.bindAttributeLocation("vertexIn",A_VER);
    //设置材质坐标变量
    program.bindAttributeLocation("textureIn",T_VER);
    //编译shader
    qDebug()<< "program.link():"<<program.link();
    qDebug()<< "program.bind():"<<program.bind();

    //传递顶点和材质坐标
    //顶点
    static const GLfloat ver[] = {
            -1.0f,-1.0f,
            1.0f,-1.0f,
            -1.0f, 1.0f,
            1.0f,1.0f
        };

        //材质
        static const GLfloat tex[] = {
            0.0f, 1.0f,
            1.0f, 1.0f,
            0.0f, 0.0f,
            1.0f, 0.0f
        };

    glVertexAttribPointer(A_VER,2,GL_FLOAT,0,0,ver);
    glEnableVertexAttribArray(A_VER);

    glVertexAttribPointer(T_VER,2,GL_FLOAT,0,0,tex);
    glEnableVertexAttribArray(T_VER);

    //从shader获取材质
    unis[0]=program.uniformLocation("tex_y");
    unis[1]=program.uniformLocation("tex_u");
    unis[2]=program.uniformLocation("tex_v");

    //创建材质
    glGenTextures(3,texs);

    for (int i=0;i<3;i++) {
        glBindTexture(GL_TEXTURE_2D,texs[i]);
        //放大过滤，线性插值   GL_NEAREST(效率高，但马赛克严重)
        glTexParameterf(GL_TEXTURE_2D,GL_TEXTURE_MAG_FILTER,GL_LINEAR);
        glTexParameterf(GL_TEXTURE_2D,GL_TEXTURE_MIN_FILTER,GL_LINEAR);
        //创建材质显卡空间
        glTexImage2D(GL_TEXTURE_2D,0,GL_RED,(i==0 ? srcW_ : srcW_/2),(i==0 ? srcH_ : srcH_/2),0,GL_RED,GL_UNSIGNED_BYTE,0);
    }

    //分配材质空间
    datas[0]=new uint8_t[ysize];
    datas[1]=new uint8_t[ysize/4];
    datas[2]=new uint8_t[ysize/4];

    fopen_s(&f,"d:\\2.yuv","rb");
    if (!f)
    {
        qDebug() << "yuv file open failed!";
    }

}

void YUVGLWidget::resizeGL(int w, int h)
{

}

void YUVGLWidget::paintGL()
{
    static int i=0;
    qDebug()<<i;
    i++;
    glClearColor(0.0f,0.0f,0.0f,1.0f);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
//    glViewport(0,0,srcW_,srcH_);

    if(feof(f)){
        i=0;
        fseek(f,0,SEEK_SET);
    }
    fread(datas[0],1,ysize,f);
    fread(datas[1],1,ysize/4,f);
    fread(datas[2],1,ysize/4,f);

    for (int i=0;i<3;i++) {
        glActiveTexture(GL_TEXTURE0+i);
        glBindTexture(GL_TEXTURE_2D,texs[i]);
        glTexSubImage2D(GL_TEXTURE_2D,0,0,0,(i==0 ? srcW_ : srcW_/2),(i==0 ? srcH_ : srcH_/2),GL_RED,GL_UNSIGNED_BYTE,datas[i]);
        //与shader uni遍历关联
        glUniform1i(unis[i],i);
    }

    glDrawArrays(GL_TRIANGLE_STRIP,0,4);

}

void YUVGLWidget::update()
{
    paintGL();
}
