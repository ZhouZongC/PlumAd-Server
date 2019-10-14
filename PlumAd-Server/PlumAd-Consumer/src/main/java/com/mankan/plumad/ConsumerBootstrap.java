package com.mankan.plumad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author nbfujx
 * @date 2017/11/20
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages= {"com.mipay","com.mankan"})
@EnableAsync
public class ConsumerBootstrap extends SpringBootServletInitializer {

        public static void main(String[] args) {
            // 程序启动入口
            // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
            SpringApplication.run(ConsumerBootstrap.class,args);
        }

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            return builder.sources(ConsumerBootstrap.class);
        }
}
