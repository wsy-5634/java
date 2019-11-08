package com.bianyiit05.resolver;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//数据源类型目标转换。  String --->Data
public class DateConverter implements Converter<String, Date> {
    @Override
    /*
    方法参数    需要被转换的源数据   2000-12-11
    方法返回值   转换之后的对象
     */
    public Date convert(String source) {
        System.out.println(source);
        Date data = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            data = dateFormat.parse(source);
            System.out.println("kkk");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
