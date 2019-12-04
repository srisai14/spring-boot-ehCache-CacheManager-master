package com.springboot.service;

import com.springboot.model.TokenDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class AuthTokenService {

    @CacheEvict(value = "tokenCache", key = "#Id1", beforeInvocation = true)
    @Cacheable(value = "tokenCache", key = "#Id1", condition = "#isCacheable == null || !#isCacheable")
    public Optional<String> getToken(String Id1, boolean isCachable) throws InterruptedException{
        Thread.sleep(4000);
         return Arrays
                .asList(new TokenDTO("101","19VC21", "John"),
                        new TokenDTO("102","19VC22", "Mary"),
                        new TokenDTO("313","19VC23", "Peter"))
                .stream().filter(t -> t.getTokenId().equalsIgnoreCase(Id1)).map( p -> p.getTokenVal() ).findFirst();
    }
}
