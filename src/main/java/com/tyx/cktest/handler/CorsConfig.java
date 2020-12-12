package com.tyx.cktest.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author ***
 * @ClassName CorsConfig
 * @Description 跨域处理
 * @create ***
 * @desc ***
 **/

@Configuration
public class CorsConfig {
	private CorsConfiguration buildConfig(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); //允许任何域名使用
		corsConfiguration.addAllowedHeader("*"); //允许任何头
		corsConfiguration.addAllowedMethod("*"); //允许任何请求方法（post、get等）
		return  corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter(){

		UrlBasedCorsConfigurationSource source = new  UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",buildConfig());
		return new CorsFilter(source);
	}
}