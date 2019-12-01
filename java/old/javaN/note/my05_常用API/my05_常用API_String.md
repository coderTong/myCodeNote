# String



java中String是常量， 是不可以改变的。

```java


	   System.out.println("Hello String");

        String str1 = "hello";
        String str2 = "World";
        String str3 = str1.concat(str2);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        // 1.获取？
        char ch = "hello".charAt(1);
        System.out.println(ch);
        System.out.println("===================");


        System.out.println("hello".indexOf("ll"));

```

