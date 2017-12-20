yuv和rgb是可以互相转换的, 通过举证运算

kColorConversion709

```

// Color Conversion Constants (YUV to RGB) including adjustment from 16-235/16-240 (video range)

// BT.601, which is the standard for SDTV.

static const GLfloat kColorConversion601[] = {

  1.164, 1.164, 1.164,

  0.0, -0.392, 2.017,

  1.596, -0.813, 0.0,

};

// BT.709, which is the standard for HDTV.

static const GLfloat kColorConversion709[] = {

  1.164, 1.164, 1.164,

  0.0, -0.213, 2.112,

  1.793, -0.533, 0.0,

};


```


# 1. 初始化设置


```

// 1.opaque

// 2.drawableProperties

// 3. 上下文
_context = [[EAGLContext  alloc] initWithAPI:kEAGLRenderingAPIOpenGLES2];

 [EAGLContext  setCurrentContext:_context];


// 4. contentsScale


```
# 2. 设置OpenGL

```

// 1. 设置buffer

// 2. 加载着色器

// 3. 使用着色器




```

## 2.1加载着色器
着色器和着色器程序

```

加载和编译只是说,生成了一个或多个可执行的代码. 和当前的OpenGL没有毛线关系
glUseProgram(self.program);
像这样一搞就有关系了.


```


# 3. 纹理制作

```


// 1. 做纹理 

// 2. 检测CVPixelBufferRef是哪个标准的视频数据

// 3. 渲染设置


```
