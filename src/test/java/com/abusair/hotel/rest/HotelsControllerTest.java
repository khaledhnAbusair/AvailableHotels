package com.abusair.hotel.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(HotelsController.class)
public class HotelsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAvailableHotels() throws Exception {


    }


}
