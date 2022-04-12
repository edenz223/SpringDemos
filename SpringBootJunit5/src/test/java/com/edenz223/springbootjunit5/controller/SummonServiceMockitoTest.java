package com.edenz223.springbootjunit5.controller;


import com.edenz223.springbootjunit5.service.SummonService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SummonServiceMockitoTest {

    @Mock
    private SummonService summonService;

    @InjectMocks
    private SummonController summonController;

    @BeforeEach
    void setOutput(){
        when(summonService.summonDragon()).thenReturn("你获得阿拉丁神灯。");
    }

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("召唤")
    public void summon(){
        System.out.println(summonController.summon());
    }

}
