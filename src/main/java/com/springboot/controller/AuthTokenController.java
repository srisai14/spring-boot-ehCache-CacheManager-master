package com.springboot.controller;

import com.springboot.model.TokenDTO;
import com.springboot.service.AuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authToken")
public class AuthTokenController {

    @Autowired
    public AuthTokenService authTokenService;

    @GetMapping
    public ResponseEntity<TokenDTO> getAuthToken(@RequestParam(name = "Id1") String Id1,
                                                 @RequestParam(name = "isCacheable") boolean isCacheable) throws InterruptedException {

        return new ResponseEntity(authTokenService.getToken(Id1, isCacheable).get() , HttpStatus.OK );
    }
}
