package com.neuedu.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.pagehelper.PageHelper;
import com.neuedu.util.MyPropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
public class MyConfig {
    @Bean
    public HttpMessageConverters getHttpMessageConverters(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero
        );
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(fastJsonHttpMessageConverter,stringHttpMessageConverter);
        return httpMessageConverters;
    }

    @Bean
    public PageHelper getPageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
    @Bean
    public MyPropertyPlaceholderConfigurer getMyPropertyPlaceholderConfigurer(){
        MyPropertyPlaceholderConfigurer myPropertyPlaceholderConfigurer = new MyPropertyPlaceholderConfigurer();
        myPropertyPlaceholderConfigurer.setLocations(
                new ClassPathResource("db.properties")
        );
        myPropertyPlaceholderConfigurer.setFileEncoding("UTF-8");
        return myPropertyPlaceholderConfigurer;
    }

}
