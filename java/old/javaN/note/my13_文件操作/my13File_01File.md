# 静态 变量



 

| `static String` | `**pathSeparator**`             与系统有关的路径分隔符，为了方便，它被表示为一个字符串。 |
| --------------- | ------------------------------------------------------------ |
| `static char`   | `**pathSeparatorChar**`             与系统有关的路径分隔符。 |
| `static String` | `**separator**`             与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。 |
| `static char`   | `**separatorChar**`             与系统有关的默认名称分隔符。 |





# 构造方法





```java
package com.codertomwu.file.Demo1;

import java.io.File;

public class MyFileDemo1Main {

    public static void main(String[] args) {


        show3(new File("cccc"), "ccccc");
    }




    public static void show3(File parent, String child){


        File file = new File(parent, child);

        System.out.println(file);
    }
    public static void show2(String parent, String child){


        File file = new File(parent, child);

        System.out.println(file);;
    }
    public static void show1(){

        File file = new File("C://ss/s/s");
        System.out.println(file);

    }

}
```



# File获取功能







# File 判断功能



# 创建 删除



# 遍历

