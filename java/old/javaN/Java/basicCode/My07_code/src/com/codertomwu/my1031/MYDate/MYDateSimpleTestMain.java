package com.codertomwu.my1031.MYDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MYDateSimpleTestMain {

    public static void main(String[] args) throws ParseException {


        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        String timeStr = format.format(new Date());
        System.out.println(timeStr);

        Date date1 = format.parse("2018年10月31日 08:57:40");
        System.out.println(date1);

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format2.parse("2018年10月31日 08:57:40");
        System.out.println(date);



    }

}
