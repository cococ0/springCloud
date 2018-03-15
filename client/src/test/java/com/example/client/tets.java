package com.example.client;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class tets {
//        public static void  main(String[] args)
//        {
//            Calendar calendar =Calendar.getInstance(); //当前日期
//            int currentyear = calendar.get(Calendar.YEAR);
//            int nextyear = 1+calendar.get(Calendar.YEAR);
//            Calendar cstart =Calendar.getInstance();
//            Calendar cend =Calendar.getInstance();
//            cstart.set(currentyear, 0, 1);//2010-1-1
//            cend.set(nextyear, 0, 1);//2011-1-1
//
//            calendar.add(Calendar.DAY_OF_MONTH,-calendar.get(Calendar.DAY_OF_WEEK)); //周六
//
//            Calendar d = (Calendar)calendar.clone();
//            //向前
//            for(;calendar.before(cend)&&calendar.after(cstart);calendar.add(Calendar.DAY_OF_YEAR, -7))
//            {
//                printf(calendar);
//
//            }
//            //向后
//            for(;d.before(cend)&&d.after(cstart);d.add(Calendar.DAY_OF_YEAR, 7))
//            {
//                printf(d);
//
//            }
//        }
//
//        //打印
//        public static void printf(Calendar calendar)
//        {
//            System.out.println(calendar.get(Calendar.YEAR)+"-"+(1+calendar.get(Calendar.MONTH))+"-"+calendar.get(Calendar.DATE));
//
//        }

    public static void main(String[] args) {
        int year = 2017;
        Calendar c = new GregorianCalendar(2017,0,1);
        int i=1;
        while (c.get(Calendar.YEAR)==year){
            c.set(Calendar.WEEK_OF_YEAR,i++);
            c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
            if (c.get(Calendar.YEAR)==year){

                System.out.printf("星期天：%tF%n",c);
            }
        }
    }
}
