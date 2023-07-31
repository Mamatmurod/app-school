package ai.ecma.school.feign;

import ai.ecma.school.utils.CommonUtils;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class FeignConfig {

    @Value("${service.username}")
    private String usernameService;

    private final Environment environment;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("ServiceUsername", usernameService);
            requestTemplate.header("ServicePassword", environment.getProperty(usernameService));
            requestTemplate.header("Authorization", CommonUtils.getTokenFromRequest());
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }
}