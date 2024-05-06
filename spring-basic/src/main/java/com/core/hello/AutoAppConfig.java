package com.core.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(  // @Componet 어노테이션이 붙은 클래스를 찾아 자동으로 스프링 빈에 등록해주는 역할
        // 컴포넌트 중 제외할 대상을 선정 (기존에 있던 AppConfig 파일을 제외하기 위해 설정)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}