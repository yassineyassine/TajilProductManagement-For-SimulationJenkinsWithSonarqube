package com.simpleProject.tajilProductManagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleProject.tajilProductManagement.model.TajilProductModule;
import com.simpleProject.tajilProductManagement.service.TajilProductService;

@RestController
@RequestMapping("/tajilProduct")
public class TajilProductController {
    private final TajilProductService tajilProductService;

    public TajilProductController(TajilProductService tajilProductService) {
        this.tajilProductService = tajilProductService;
    }

    @GetMapping
    public ResponseEntity<List<TajilProductModule>> getAllTajilProducts(){
        return new ResponseEntity<>(tajilProductService.getAllTajilProduct(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TajilProductModule> getTajilProductById(@PathVariable UUID id){
        Optional<TajilProductModule> optionalTajilProduct = tajilProductService.getTajilProductByProductId(id);
        if (optionalTajilProduct.isPresent()) {
            return new ResponseEntity<>(optionalTajilProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TajilProductModule> createNewTajilProduct(@RequestBody TajilProductModule tajilProduct){
        return new ResponseEntity<>(tajilProductService.createTajilProduct(tajilProduct), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TajilProductModule> updateTajilProductById(@PathVariable UUID id, @RequestBody TajilProductModule tajilProduct){
        Optional<TajilProductModule> optionalUpdateTajilProduct = tajilProductService.updateTajilProduct(id, tajilProduct);
        if (optionalUpdateTajilProduct.isPresent()) {
            return new ResponseEntity<>(optionalUpdateTajilProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTajilProductById(@PathVariable UUID id){
        tajilProductService.deleteTajilProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
