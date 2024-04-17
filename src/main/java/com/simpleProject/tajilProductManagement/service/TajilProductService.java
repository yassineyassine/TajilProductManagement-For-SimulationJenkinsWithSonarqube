package com.simpleProject.tajilProductManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simpleProject.tajilProductManagement.model.TajilProductModule;

@Service
public class TajilProductService {
    private List<TajilProductModule> tajilProducts = new ArrayList<>();

    public List<TajilProductModule> getAllTajilProduct() {
        return tajilProducts;
    }

    public Optional<TajilProductModule> getTajilProductByProductId(UUID id){
        return tajilProducts.stream().filter(t -> t.getProductId().equals(id)).findFirst();
    }

    public TajilProductModule createTajilProduct(TajilProductModule tajilProduct){
        tajilProducts.add(tajilProduct);
        return tajilProduct;
    }

    public Optional<TajilProductModule> updateTajilProduct(UUID id, TajilProductModule tajilProductDetails){
        Optional<TajilProductModule> tajilProductOptional = getTajilProductByProductId(id);
        if (tajilProductOptional.isPresent()) {
            TajilProductModule tajilProduct = tajilProductOptional.get();
            tajilProduct.setProductName(tajilProductDetails.getProductName());
            tajilProduct.setProductDesciption(tajilProductDetails.getProductDesciption());
            tajilProduct.setProductPrice(tajilProductDetails.getProductPrice());
            tajilProduct.setProductCategory(tajilProductDetails.getProductCategory());
            tajilProduct.setProductStock(tajilProductDetails.getProductStock());
        }

        return tajilProductOptional;
    }

    public void deleteTajilProduct(UUID id){
        tajilProducts.removeIf(t -> t.getProductId().equals(id));
    }
}
