package com.xdl.config;

import com.xdl.interceptor.WebAppInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * mvc配置
 *
 * @author xdl
 * @date 2018-08-25
 */
@SpringBootConfiguration
public class WebAppMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    WebAppInterceptor webAppInterceptor;


    /**
     * 默认首页配置
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/seller/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webAppInterceptor)
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/**")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/")
                .excludePathPatterns("/seller/index")
                .excludePathPatterns("/seller/login")
                .excludePathPatterns("/seller/logout")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**");
    }

}
