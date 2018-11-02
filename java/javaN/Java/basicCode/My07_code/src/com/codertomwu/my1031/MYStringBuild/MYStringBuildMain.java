package com.codertomwu.my1031.MYStringBuild;

public class MYStringBuildMain {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder("222");

        System.out.println(builder);

        System.out.println(builder2);


        // 成员方法

        builder.append("mm");
        builder.append(2);
        builder.append(10.4);
        System.out.println(builder);

        String str = builder.toString();
        System.out.println(str);
    }

}
