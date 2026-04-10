package com.dong.lease.web.admin.custom.converter;

import com.dong.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String code) {
               T[] enumConstants = targetType.getEnumConstants();
               for (T e : enumConstants) {
                   if (e.getCode().equals(Integer.valueOf(code))) {
                       return e;
                   }
               }
                throw new IllegalArgumentException("code:"+code+"illegal");
            }
        };
    }
}
