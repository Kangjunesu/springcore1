package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.context.annotation.ComponentScan.Filter;
public class ComponentFilterAppConfigTest {
    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();
        Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class));
    }
    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, //애너테이션 타입 필터. 기본값이라 생략해도 동작
                    classes = MyIncludeComponent.class),
            excludeFilters = @Filter(classes = MyExcludeComponent.class) //타입 생략해도 동작
    )
    static class ComponentFilterAppConfig {
    }

    //includeFilters에 MyIncludeComponent 애노테이션을 추가해서 BeanA가 스프링 빈에 등록.
    //excludeFilters에 MyExcludeComponent 애노테이션을 추가해서 BeanB는 스프링 빈에 등록되지 않음.
}
