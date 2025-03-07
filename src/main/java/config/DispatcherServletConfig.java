package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
public class DispatcherServletConfig implements WebMvcConfigurer{
    
    //handler mapper added automatically

    //for resources mapping in mxl, here ResourceaHandlerRegistry registry
    //this will map any request with /static/ to the classpath i.e. main/resourcesfolder's static folder
    // @SuppressWarnings("null")
    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry){
    //     registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    // }


    @SuppressWarnings("null")
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


}
