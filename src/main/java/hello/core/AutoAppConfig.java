package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core", //시작위치
        //basePackageClasses = AutoAppConfig.class,//이 패키지
        //지정을 안하면 해당클래스 하위 패키를 뒤진다 여기선 hello.core와 그 하위 패키지
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))

    public class AutoAppConfig {


    }
