package com.edenz223.springbootjunit5.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SummonControllerTestRestTemplateTest {

    @LocalServerPort
    private int port;

    private String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp(){
        url = String.format("http://localhost:%d/summon", port);
    }

    @Test
    public void summon(){
        assertThat(this.restTemplate.getForObject(url,String.class)).contains("你已集齐七龙珠，正在召唤神龙。");
    }

}
