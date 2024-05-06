package com.core.hello.web;

import com.core.hello.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String testId) {

        myLogger.log("service id= " + testId);
    }
}
