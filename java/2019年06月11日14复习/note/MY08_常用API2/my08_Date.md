# Date





```java

Date date = new Date();
        System.out.println(date);

//        Date date1 = new Date(1540945016000L);// 传递毫秒值,  必须要加L。。。
        Date date1 = new Date(1540945827610L);// 传递毫秒值,  必须要加L。。。
        System.out.println(date1);

        System.out.println(date.getTime());

```





# DateFormat

是抽象类， 我们用它的子类`SimpleDateFormat`



java.text包下



作用：

格式化（日期-》文本）， 解析（文本 -》日期）



成员方法

```java

 String format(Date date) 
          将一个 Date 格式化为日期/时间字符串。 

```







# SimpleDateFormat



```java


SimpleDateFormat(String pattern) 
          用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。

```



```java



	   SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        String timeStr = format.format(new Date());
        System.out.println(timeStr);

        Date date1 = format.parse("2018年10月31日 08:57:40");
        System.out.println(date1);
        
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format2.parse("2018年10月31日 08:57:40");
        System.out.println(date);

```

