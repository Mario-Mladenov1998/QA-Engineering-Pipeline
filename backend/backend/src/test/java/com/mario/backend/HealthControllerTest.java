package com.mario.backend;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HealthControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
  void healthEndpointTest() throws Exception {
    mockMvc.perform(get("/health")).andExpect(status().isOk(
    )).andExpect(content().string("UP"));
}
  @Test
  void unknownEndPointReturns404()
  throws Exception {
    mockMvc.perform(get("/wrong-health")).andExpect(status().isNotFound());
  }

}