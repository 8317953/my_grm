package com.haut.grm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.haut.grm.model.PersonApi;
import com.haut.grm.model.Product;



@RestController
@RequestMapping(value = {"/product/"})
public class ProductController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)public ResponseEntity<Product> get(@PathVariable Long id) {
        Product product = new Product();
        product.setName("空气净化器");
        product.setId(1L);
        product.setProductClass("filters");
        product.setProductId("T12345");
        return ResponseEntity.ok(product);
    }
}