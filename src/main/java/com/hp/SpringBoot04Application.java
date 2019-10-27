package com.hp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
@MapperScan(value= {"com.hp.mapper"})
public class SpringBoot04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04Application.class, args);
	}
	
	@Bean
	 public Converter<String, Date> dateFormatConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 Date date = null;
            try {
                date = sdf.parse((String) source);
                } catch (Exception e) {
                e.printStackTrace();
                }
             return date;
            }
        };
    }


}
