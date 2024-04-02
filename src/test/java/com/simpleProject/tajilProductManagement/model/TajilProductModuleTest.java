package com.simpleProject.tajilProductManagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class TajilProductModuleTest {
    @Test
    void testCanEqual() {
        TajilProductModule product1 = new TajilProductModule();
        TajilProductModule product2 = new TajilProductModule();
        assertTrue(product1.canEqual(product2));
    }

    @Test
    void testEquals() {
        TajilProductModule product1 = new TajilProductModule();
        TajilProductModule product2 = new TajilProductModule();
        assertEquals(product1, product2);
    }

    @Test
    void testGetProductCategory() {
        TajilProductModule product = new TajilProductModule();
        product.setProductCategory("Electronics");
        assertEquals("Electronics", product.getProductCategory());
    }

    @Test
    void testGetProductDesciption() {
        TajilProductModule product = new TajilProductModule();
        product.setProductDesciption("This is a product");
        assertEquals("This is a product", product.getProductDesciption());
    }

    @Test
    void testGetProductId() {
        TajilProductModule product = new TajilProductModule();
        UUID id = UUID.randomUUID();
        product.setProductId(id);
        assertEquals(id, product.getProductId());
    }

    @Test
    void testGetProductName() {
        TajilProductModule product = new TajilProductModule();
        product.setProductName("Product Name");
        assertEquals("Product Name", product.getProductName());
    }

    @Test
    void testGetProductPrice() {
        TajilProductModule product = new TajilProductModule();
        product.setProductPrice(100);
        assertEquals(100, product.getProductPrice());
    }

    @Test
    void testGetProductStock() {
        TajilProductModule product = new TajilProductModule();
        product.setProductStock(10);
        assertEquals(10, product.getProductStock());
    }

    @Test
    void testHashCode() {
        TajilProductModule product = new TajilProductModule();
        assertNotNull(product.hashCode());
    }

    @Test
    void testSetProductCategory() {
        TajilProductModule product = new TajilProductModule();
        product.setProductCategory("Electronics");
        assertEquals("Electronics", product.getProductCategory());
    }

    @Test
    void testSetProductDesciption() {
        TajilProductModule product = new TajilProductModule();
        product.setProductDesciption("This is a product");
        assertEquals("This is a product", product.getProductDesciption());
    }

    @Test
    void testSetProductId() {
        TajilProductModule product = new TajilProductModule();
        UUID id = UUID.randomUUID();
        product.setProductId(id);
        assertEquals(id, product.getProductId());
    }

    @Test
    void testSetProductName() {
        TajilProductModule product = new TajilProductModule();
        product.setProductName("Product Name");
        assertEquals("Product Name", product.getProductName());
    }

    @Test
    void testSetProductPrice() {
        TajilProductModule product = new TajilProductModule();
        product.setProductPrice(100);
        assertEquals(100, product.getProductPrice());
    }

    @Test
    void testSetProductStock() {
        TajilProductModule product = new TajilProductModule();
        product.setProductStock(10);
        assertEquals(10, product.getProductStock());
    }

    @Test
    void testToString() {
        TajilProductModule product = new TajilProductModule();
        assertNotNull(product.toString());
    }
}
