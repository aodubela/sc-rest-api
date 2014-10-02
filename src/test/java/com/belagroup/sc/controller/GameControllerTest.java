package com.belagroup.sc.controller;

import com.belagroup.sc.Application;
import com.belagroup.sc.config.PersistenceConfig;
import com.belagroup.sc.dto.Response;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class, PersistenceConfig.class})
@WebAppConfiguration
public class GameControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
     public void getGames() throws Exception {
        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(content().string(CoreMatchers.containsString(Response.OK)));

     }


    @Test
    public void deleteGame() throws Exception {
        mockMvc.perform(delete("/games/1"))
                .andDo(print())
                .andExpect(content().string(CoreMatchers.containsString(Response.FAILED)));

    }
}
