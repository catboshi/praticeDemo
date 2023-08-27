package com.jingdianjichi.tool.converter.anno.impl;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jingdianjichi.tool.converter.anno.CustomConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 时间戳转换日期转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize
@CustomConverter(DateConverterImpl.class)
public @interface DateConverter {

    String value() default "yyyy-MM-dd";

}
