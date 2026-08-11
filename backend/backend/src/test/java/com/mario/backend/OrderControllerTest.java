package com.mario.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest{

    @Autowired
    MockMvc mockMvc;

    @Test
    void createOrderReturns201() throws Exception {
        mockMvc.perform(post("/orders").contentType("application/json").content("""
                                                                               
        {
            "product": "Laptop", "quantity": 2
        }
        """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.product").value("Laptop"))
        .andExpect(jsonPath("$.quantity").value(2))
        .andExpect(jsonPath("$.status").value("CREATED"));
    }

    @Test
    void getExistingOrderReturns200() throws Exception {

        String response = mockMvc.perform(post("/orders")
                .contentType("application/json")
                .content("""
                        {
                            "product": "Laptop",
                            "quantity": 2
                        }
                        """))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        String id = response.replaceAll(".*\"id\":(\\d+).*", "$1");

        mockMvc.perform(get("/orders/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product").value("Laptop"))
                .andExpect(jsonPath("$.quantity").value(2))
                .andExpect(jsonPath("$.status").value("CREATED"));
    }
    @Test
void createOrderWithZeroQuantityReturns400() throws Exception {

    mockMvc.perform(post("/orders")
            .contentType("application/json")
            .content("""
                    {
                        "product": "Laptop",
                        "quantity": 0
                    }
                    """))
            .andExpect(status().isBadRequest());
}
  @Test
  void getNonExistingOrderReturns404() throws Exception {

    mockMvc.perform(get("/orders/9999"))
           .andExpect(status().isNotFound());

  }
    @Test
void updateExistingOrderReturns200() throws Exception {

    String response = mockMvc.perform(post("/orders")
            .contentType("application/json")
            .content("""
                    {
                        "product": "Laptop",
                        "quantity": 2
                    }
                    """))
            .andExpect(status().isCreated())
            .andReturn()
            .getResponse()
            .getContentAsString();

    String id = response.replaceAll(".*\"id\":(\\d+).*", "$1");

    mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                    .put("/orders/" + id)
                    .contentType("application/json")
                    .content("""
                            {
                                "product": "Mouse",
                                "quantity": 5
                            }
                            """))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(Integer.parseInt(id)))
            .andExpect(jsonPath("$.product").value("Mouse"))
            .andExpect(jsonPath("$.quantity").value(5))
            .andExpect(jsonPath("$.status").value("CREATED"));
}
    @Test
void updateNonExistingOrderReturns404() throws Exception {

    mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                    .put("/orders/9999")
                    .contentType("application/json")
                    .content("""
                            {
                                "product": "Mouse",
                                "quantity": 5
                            }
                            """))
            .andExpect(status().isNotFound());
}
   @Test
   void deleteExistingOrderReturns204() throws Exception {
      String response = mockMvc.perform(post("/orders")
            .contentType("application/json")
            .content("""
                    {
                        "product": "Laptop",
                        "quantity": 2
                    }
                    """))   
                               .andExpect(status().isCreated())
                               .andReturn()
                               .getResponse()
                               .getContentAsString();

                        
            String id = response.replaceAll(".*\"id\":(\\d+).*", "$1");
            System.out.println("CREATED ORDER ID = " + id);

            mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete("/orders/" + id))
                .andExpect(status().isNoContent());
            
   }
    @Test
void updateOrderWithZeroQuantityReturns400() throws Exception {

    String response = mockMvc.perform(post("/orders")
            .contentType("application/json")
            .content("""
                    {
                        "product": "Laptop",
                        "quantity": 2
                    }
                    """))
            .andExpect(status().isCreated())
            .andReturn()
            .getResponse()
            .getContentAsString();

    String id = response.replaceAll(".*\"id\":(\\d+).*", "$1");

    mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                    .put("/orders/" + id)
                    .contentType("application/json")
                    .content("""
                            {
                                "product": "Mouse",
                                "quantity": 0
                            }
                            """))
            .andExpect(status().isBadRequest());
}
                                               
                                               
    }



    
                
                                       

