package com.my.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : tanghuai
 * @date : 2021/2/19 13:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EncoderTest {
    @Test
    public void BcrEncoderTest() {
        BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
        System.out.println(bcr.encode("user"));
    }
}
