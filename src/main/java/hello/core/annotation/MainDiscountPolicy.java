package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.*;
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented  // ^QuQualifier 인터페이스에서 복사해온 내용
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}