package com.springboot.config;

import com.springboot.handler.APIFilter;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class APIConfig extends CachingConfigurerSupport {

	@Bean
	public APIFilter aPIFilter() {
		return new APIFilter();
	}

	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		CacheConfiguration tokenCache = new CacheConfiguration();
		tokenCache.setName("tokenCache");
		tokenCache.setMemoryStoreEvictionPolicy("LRU");
		tokenCache.setMaxEntriesLocalHeap(1000);
		tokenCache.setTimeToLiveSeconds(10);

		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(tokenCache);
		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}
}