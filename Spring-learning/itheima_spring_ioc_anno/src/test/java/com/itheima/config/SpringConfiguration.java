package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: Freaver
 * @Date: 3/31/2021  16:25
 */

@Configuration //核心配置类
//<context:component-scan base-package="com.itheima"/>
@ComponentScan("com.itheima")
//<context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")

@Import(DataSourceConfiguration.class)
public class SpringConfiguration {


}
