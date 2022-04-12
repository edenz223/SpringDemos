package com.edenz223.springbootjunit5.service.impl;

import com.edenz223.springbootjunit5.service.SummonService;
import org.springframework.stereotype.Service;

@Service
public class SummonServiceImpl implements SummonService {
    @Override
    public String summonDragon() {
        return "你已集齐七龙珠，正在召唤神龙。";
    }
}
