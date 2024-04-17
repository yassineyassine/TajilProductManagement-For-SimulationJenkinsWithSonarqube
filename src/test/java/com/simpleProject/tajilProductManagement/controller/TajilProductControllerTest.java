package com.simpleProject.tajilProductManagement.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.simpleProject.tajilProductManagement.model.TajilProductModule;
import com.simpleProject.tajilProductManagement.service.TajilProductService;

@SpringBootTest
@AutoConfigureMockMvc
public class TajilProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TajilProductService tajilProductService;

    @Test
    void testCreateNewTajilProduct() {

    }

    @Test
    void testDeleteTajilProductById() {

    }

    @SuppressWarnings("null")
    @Test
    void testGetAllTajilProducts() throws Exception {
        //Inisiator Data
        UUID id = UUID.randomUUID();
        TajilProductModule tajilProducts = 
            new TajilProductModule(
                id, "Bakwan", 
                "Gorengan yang terbuat dari tepung dan sayur yang berbebtuk pipih", 
                "Gorengan", 1000, 9);
        List<TajilProductModule> productList = Arrays.asList(tajilProducts);

        // Set expectations on the mock service
        when(tajilProductService.getAllTajilProduct()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/tajilProduct")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productName").value("Bakwan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productDesciption").value("Gorengan yang terbuat dari tepung dan sayur yang berbebtuk pipih"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productCategory").value("Gorengan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productPrice").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productStock").value(9));
    }

    @Test
    void testGetTajilProductById() {

    }

    @Test
    void testUpdateTajilProductById() {

    }
}
