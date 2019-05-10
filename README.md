# Overview

This is a simple poc using [Jasync]

## Setup & Testing

1 - PostgreSQL: `docker run -d --name=postgres postgres:latest`

2 - Execute the script below:

`
CREATE TABLE public.produc
	id varchar NULL,
	"name" varchar NULL,
	price float8 NULL,
	CONSTRAINT product_pk PRIMARY KEY (id)
);
`

3 - Execute the curl below:

`curl -d '{"name":"Some name", "price":55.25}' -H "Content-Type: application/json" -X POST http://localhost:8080/products`

[Jasync]: https://github.com/jasync-sql/jasync-sql