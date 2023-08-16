package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;
@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// ComponentScan : 자동으로 컴포넌트 스캔
// excludeFilters = @Filter : 자동등록에서 제외할것. AppConfig가 @Configuration이 돼있어서 여기선 제외.
public class AutoAppConfig {

}
