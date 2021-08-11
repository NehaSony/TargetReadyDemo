package com.demo.restful.TargetReadyDemo.controller;


import com.demo.restful.TargetReadyDemo.model.Product;
import com.demo.restful.TargetReadyDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;

/*
*
* TargetRetail RESTful service
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API,
* which will aggregate product data and return it as JSON to the caller.
Your goal is to create a RESTful service that can retrieve product and price details by ID.
* The URL structure is up to you to define, but try to follow some sort of logical convention.
Build an application that performs the following actions:
* Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number.
* Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793)
*  Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product's price in the data store.
*
* */
@RestController
@RequestMapping(value = "/v1/api/product/")
@Validated
public class ProductController {
    @Autowired
    ProductService productService;
    /**
     * Checks and returns the health of the controller
     *
     * @return
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<?> ping() {
        try {
            return new ResponseEntity<>(("pong"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Application Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *All Product
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> listAllProducts() {
        try {

            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Application Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     *All Product
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@Valid @PathVariable("id") String id) {
        try {

            return new ResponseEntity<>(productService.getProductById(Integer.valueOf(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Application Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *All Product
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProducts(@Valid @PathVariable("id") String id,@RequestBody Product product) {
        try {

            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Application Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
