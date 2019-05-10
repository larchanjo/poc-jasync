package com.poc.jasync

import java.util.*

data class Product(val id: String = UUID.randomUUID().toString(), val name: String, val price: Double) {

    fun toProductResponse() = ProductResponse(id, name, price)

}

data class ProductRequest(val name: String, val price: Double) {

    fun toProduct() = Product(name = name, price = price)

}

data class ProductResponse(val id: String, val name: String, val price: Double)