package com.springboot.mall.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor{

    public Date format1(Date date) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date1 = sdf1.parse(sdf1.format(date));
            return date1;
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;



    }

    public Date format2(Date date) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");


        try {
            Date date1 = sdf1.parse(sdf1.format(date));
            return date1;

        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }


}
