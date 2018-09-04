package pl.krzysiek.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
//@EnableWebMvc // tak jak w XML: <mvc:annotation-driven />
@ComponentScan({"pl.krzysiek"})
public class RestConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        super.configureMessageConverters(messageConverters);
    }
}