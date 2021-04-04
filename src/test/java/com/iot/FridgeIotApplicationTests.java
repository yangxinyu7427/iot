package com.iot;

import com.iot.bean.User;
import com.iot.sevlet.impl.UserSeviceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FridgeIotApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    UserSeviceImpl userServiceImpl1;
}
