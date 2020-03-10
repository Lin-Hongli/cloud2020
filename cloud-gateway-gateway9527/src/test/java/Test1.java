
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @author lhl
 * @create 2020/3/10 23:56
 */
@SpringBootTest(classes = Test1.class)
public class Test1 {

    @Test
    public void test(){
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        /*当前时间和时区*/
        System.out.println(zonedDateTime);
    }
}
