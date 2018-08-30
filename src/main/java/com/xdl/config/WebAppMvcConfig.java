package com.xdl.config;

import com.xdl.interceptor.WebAppInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc配置
 *
 * @author xdl
 * @date 2018-08-25
 */
@Configuration
public class WebAppMvcConfig implements WebMvcConfigurer {

    @Autowired
    WebAppInterceptor webAppInterceptor;

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
                .excludePathPatterns("/", "/seller/index")
                .excludePathPatterns("/seller/login", "/seller/logout");
    }

}
