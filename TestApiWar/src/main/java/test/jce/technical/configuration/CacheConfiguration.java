package test.jce.technical.configuration;

import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jean-charles_eloi on 07/07/15.
 */
@Configuration
public class CacheConfiguration {



    //TODO: Comment that block to crash the startup
    @Bean
    public ConcurrentMapCacheManager cacheManager() {
        return new ConcurrentMapCacheManager("test");
    }


}
