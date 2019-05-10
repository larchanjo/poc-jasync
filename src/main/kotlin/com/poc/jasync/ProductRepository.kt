package com.poc.jasync

import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

@Repository
class ProductRepository(
        @param:Value("\${database}") val database: String,
        @param:Value("\${database.host}") val host: String,
        @param:Value("\${database.port}") val port: Int,
        @param:Value("\${database.username}") val username: String,
        @param:Value("\${database.password}") val password: String
) {

    val log = LoggerFactory.getLogger(this::class.java)

    fun save(product: Product): Product {
        log.info("Saving $product")
        val query = "INSERT INTO PRODUCT(ID,NAME,PRICE) VALUES('${product.id}','${product.name}',${product.price});"

        log.info("Executing query $query")
        val connection = PostgreSQLConnectionBuilder.createConnectionPool(
                "jdbc:postgresql://$host:$port/$database?user=$username&password=$password")
        connection.sendPreparedStatement(query)

        return product;
    }

}