package com.abusair.hotel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(RestServiceApplication.class)
public class RestServiceApplicationTest {

    @Test
    public void compile() {
    }
}
