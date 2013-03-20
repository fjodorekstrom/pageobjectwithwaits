package config.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: fjodorekstrom
 * Date: 3/19/13
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class UrlConfig {

    private @Value("${test.main.url}")
    String mainUrlValue;

    @Bean
    public String mainUrl() throws UnknownHostException {

        if (StringUtils.hasText(mainUrlValue)) {
            return mainUrlValue;
        } else {
            return "localhost";
        }

    }
}

