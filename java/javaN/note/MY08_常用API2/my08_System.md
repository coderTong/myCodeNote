# System

```java

package com.codertomwu.my1031.MYSystemTest;

import java.util.Arrays;

public class MySystemTestMain {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 9999; i++) {

            System.out.print("");
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);



        // 数组复制方法
        /**
         * static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         *           从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
         * src 原数组
         * srcPos 原数组的起始位置（其实索引）
         * dest 目标数组
         * destPos 目标数据中的起始位置
         * Length 要复制的数组元素的数量
         *  */

        /**
         * 将src数组前三个元素， 复制到dest数组的前3个位置上
         * src [1,2,3,4,5]  dest[6,7,8,9,10]
         * src [1,2,3,4,5]  dest[1,2,3,9,10]
         * */
        int[] src = {1,2,3,4,5};
        int[] dest =  {6,7,8,9,10};
        System.arraycopy(src,0,dest,0,3);


        System.out.println(Arrays.toString(dest));

    }
}


```



