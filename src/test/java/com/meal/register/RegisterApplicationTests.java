package com.meal.register;

import com.meal.register.util.MyTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Map;

@SpringBootTest
class RegisterApplicationTests {

    @Autowired
    private MyTool myTool;

    @Test
    void contextLoads() {
        Map<String, LocalDateTime> queryDate = myTool.getQueryDateTime();
    }

}
