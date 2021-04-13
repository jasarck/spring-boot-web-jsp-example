package hello;


import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class RequestHandlerInterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RequestHandelrInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(requestInterceptor);
        registry.addInterceptor(requestInterceptor)
                .excludePathPatterns("/s/*")
                .excludePathPatterns("/j/*")
                .excludePathPatterns("/v1/meeting/notifyMeetingEnd")
                .excludePathPatterns("/v1/recording/*")
                .excludePathPatterns("/v1/user/create")
                .excludePathPatterns("/test/*")
                .excludePathPatterns("/v1/meeting/notifyRecordingReady");
    }

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
            }
        };
    }
}
