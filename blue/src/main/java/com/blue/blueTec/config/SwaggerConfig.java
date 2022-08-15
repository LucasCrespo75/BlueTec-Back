package com.blue.blueTec.config;

	
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

	import com.google.common.base.Predicates;

	import springfox.documentation.builders.ApiInfoBuilder;
	import springfox.documentation.builders.PathSelectors;
	import springfox.documentation.builders.RequestHandlerSelectors;
	import springfox.documentation.service.ApiInfo;
	import springfox.documentation.service.Tag;
	import springfox.documentation.spi.DocumentationType;
	import springfox.documentation.spring.web.plugins.Docket;
	import springfox.documentation.swagger2.annotations.EnableSwagger2;

		@Configuration
		@EnableSwagger2
		public class SwaggerConfig extends WebMvcConfigurationSupport {
			
			public static final String PESSOA_TAG = "pessoa";

			@Bean
		    public Docket api() { 
		        return new Docket(DocumentationType.SWAGGER_2)  
		          .apiInfo(getApiInfo())
		          .select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(PathSelectors.any())
		          .paths(Predicates.not(PathSelectors.regex("/error.*")))
		          .build()                                       
		          .useDefaultResponseMessages(false)
		          .tags(new Tag(PESSOA_TAG, "API de agenda"));
		    }
			
		    private ApiInfo getApiInfo() {

		        return new ApiInfoBuilder()
		                .title("Consumo da aplicação em REST para o projeto de AGENDA")
		                .description("Concretizado AGENDA	")
		                .version("1.0.0")
		                .build();                
		    }
				
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/**")
				  .addResourceLocations("classpath:/static/");
				
			    registry.addResourceHandler("swagger-ui.html")
			      .addResourceLocations("classpath:/META-INF/resources/");

			    registry.addResourceHandler("/webjars/**")
			      .addResourceLocations("classpath:/META-INF/resources/webjars/");
			    
			    super.addResourceHandlers(registry);
			}
			
		}




