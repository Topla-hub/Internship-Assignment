package com.logistics.transfer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class TransferControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindCheapestRoute() throws Exception {
        String requestBody = "{\n" +
                "    \"maxWeight\": 15,\n" +
                "    \"availableTransfers\": [\n" +
                "        {\"weight\": 5, \"cost\": 10},\n" +
                "        {\"weight\": 10, \"cost\": 20},\n" +
                "        {\"weight\": 3, \"cost\": 5},\n" +
                "        {\"weight\": 8, \"cost\": 15}\n" +
                "    ]\n" +
                "}";

        mockMvc.perform(post("/api/transfers/cheapest-route")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalCost").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalWeight").value(15))
                .andExpect(MockMvcResultMatchers.jsonPath("$.selectedTransfers[0].weight").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.selectedTransfers[0].cost").value(10));
    }
}
