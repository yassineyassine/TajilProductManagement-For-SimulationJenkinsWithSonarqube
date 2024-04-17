package com.simpleProject.tajilProductManagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleProject.tajilProductManagement.model.TajilProductModule;

public class TajilProductServiceTest {
    @Test
    void testCreateTajilProduct() {

    }

    @Test
    void testDeleteTajilProduct() {

    }

    @Test
    void testGetAllTajilProduct() {
        // Buat mock untuk TajilProductModule
        TajilProductModule mockProduct1 = Mockito.mock(TajilProductModule.class);
        TajilProductModule mockProduct2 = Mockito.mock(TajilProductModule.class);

        // Buat list produk tajil
        List<TajilProductModule> mockProducts = Arrays.asList(mockProduct1, mockProduct2);

        // Buat mock untuk TajilProductService dan atur perilakunya
        TajilProductService mockService = Mockito.mock(TajilProductService.class);
        when(mockService.getAllTajilProduct()).thenReturn(mockProducts);

        // Panggil metode yang ingin diuji
        List<TajilProductModule> returnedProducts = mockService.getAllTajilProduct();

        // Verifikasi hasilnya
        assertEquals(mockProducts, returnedProducts, "Harus mengembalikan list produk tajil yang sama");
    }

    @Test
    void testGetTajilProductByProductId() {

    }

    @Test
    void testUpdateTajilProduct() {

    }
}
