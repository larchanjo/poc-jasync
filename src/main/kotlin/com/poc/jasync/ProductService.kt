package com.poc.jasync

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductService(val productRepository: ProductRepository) {

    val log = LoggerFactory.getLogger(this::class.java)

    fun createProduct(product: Product): ProductResponse {
        log.info("Creating $product")
        val savedProduct = productRepository.save(product)
        return savedProduct.toProductResponse();
    }

}