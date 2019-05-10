package com.poc.jasync

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(val productService: ProductService) {

    @PostMapping
    fun createProduct(@RequestBody request: ProductRequest) = productService.createProduct(request.toProduct())

}