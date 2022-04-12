package com.edenz223.springbootjunit5.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SummonControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void summon() throws Exception {
        mvc.perform(get("/summon"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("你已集齐七龙珠，正在召唤神龙。"));
    }
}