package tk.dingjining.studyspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket customDocket() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				// 文档说明
				.title("测试专用")
				// 文档版本说明
				.version("1.0.0").description("学习测试专用").license("Apache 2.0").build();
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
				.apis(RequestHandlerSelectors.basePackage("tk.dingjining.studyspring.controller")).build();
	}
}
