package com.mankan.plumad;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author nbfujx
 * @date 2017/11/20
 */
// Spring Boot 应用的标识
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages= {"com.mipay","com.mankan"})
public class ProviderBootStrap extends SpringBootServletInitializer {

    private static Logger log = LoggerFactory.getLogger(ProviderBootStrap.class);

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(ProviderBootStrap.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProviderBootStrap.class);
    }
}
