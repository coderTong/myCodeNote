gluniform 给当前的着色器程序对象设置一个值

gluniform — Specify the value of a uniform variable for the current program object

```

void glUniform1i( GLint location,﻿

GLint v0);




void glUniformMatrix3fv( GLint location,﻿ GLsizei count,﻿ GLboolean transpose,﻿ const GLfloat *value);



```

location﻿
Specifies the location of the uniform variable to be modified.
指定位置的uniform 变量将会被改变



v0, v1, v2, v3﻿

```

数量命令,  设置uniform变量的值将被v0, v1, v2, v3﻿替代
For the scalar commands, specifies the new values to be used for the specified uniform variable.

```

count﻿

```
百度翻译: 对于矢量（gluniform * V）命令，指定是要修改的元素个数。如果目标均匀变量不是数组，如果数组是1或更多，则该值应该是1。
For the vector (glUniform*v) commands, specifies the number of elements that are to be modified. This should be 1 if the targeted uniform variable is not an array, and 1 or more if it is an array.﻿

For the matrix (glUniformMatrix*) commands, specifies the number of matrices that are to be modified. This should be 1 if the targeted uniform variable is not an array of matrices, and 1 or more if it is an array of matrices.

```




transpose﻿

```

For the matrix commands, specifies whether to transpose the matrix as the values are loaded into the uniform variable.


```
# 说明
glUniform* 这类的函数, 将会修改uniform变量或者uniform数组变量默认的值, location是修改的位置(写哪个位置,哪个位置的默认值将会变成v0, v1, v2, v3﻿写的值), 用glGetUniformLocation这个函数可以看到被你设置的新值.






