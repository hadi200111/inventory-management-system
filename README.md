# -inventory-management-system

## This api consist of 4 APIs


### The first one is customer API
```bash
This API consist of:
1. ID as primary key
2. Name
3. Address
5. Phone 
4. List<Order>
```
```bash
The first function the Customer API have is create customer
The request path is: localhost:8080/customer with a POST method
```
```bash
The second function the Customer API have is get all customer
The request path is: localhost:8080/customer with a GET method
```
```bash
The third function the Customer API have is get customer by id
The request path is: localhost:8080/customer/{id} with a GET method
```
```bash
The fourth function the Customer API have is update customer
The request path is: localhost:8080/customer/{id} with a PUT method
```
```bash
The fifth function the Customer API have is delete customer
The request path is: localhost:8080/customer/{id} with a DELETE method
```
```bash
The sixth function the Customer API have is Partially update customer
The request path is: localhost:8080/customer with a PATCH method
```

### The second one is product API
```bash
This API consist of:
1. ID as primary key
2. name
3. price
4. quantity
```
```bash
The first function the Product API have is create Product
The request path is: localhost:8080/product with a POST method
```
```bash
The second function the Product API have is get all Product
The request path is: localhost:8080/product with a GET method
```
```bash
The third function the Product API have is get Product by id
The request path is: localhost:8080/product/{id} with a GET method
```
```bash
The fourth function the Product API have is update Product
The request path is: localhost:8080/product/{id} with a PUT method
```
```bash
The fifth function the Product API have is delete Product
The request path is: localhost:8080/product/{id} with a DELETE method
```
```bash
The sixth function the Product API have is Partially update order
The request path is: localhost:8080/product with a PATCH method
```

### The third one is order API
```bash
This API consist of:
1. ID as primary key
2. Date 
3. customer id
4. Status
5. Total Cost
```
```bash
The first function the Order API have is create Order
The request path is: localhost:8080/order/customer/{id} with a POST method
```
```bash
The second function the Order API have is get all Order
The request path is: localhost:8080/order with a GET method
```
```bash
The third function the Order API have is get Order by id
The request path is: localhost:8080/order/{id} with a GET method
```
```bash
The fourth function the Order API have is update Order
The request path is: localhost:8080/order/{id} with a PUT method
```
```bash
The fifth function the Order API have is delete Order
The request path is: localhost:8080/order/{id} with a DELETE method
```
```bash
The sixth function the Order API have is Partially update order
The request path is: localhost:8080/Order with a PATCH method
```

### The forth one is Warehouse API
```bash
This API consist of:
1. ID
2. Address
3. Capacity
4. Name
```
```bash
The first function the Warehous API have is create Warehous
The request path is: localhost:8080/Warehous/{id} with a DELETE method
```
```bash
The second function the Warehous API have is get all Warehous
The request path is: localhost:8080/Warehous/{id} with a DELETE method
```
```bash
The third function the Warehous API have is get Warehous by id
The request path is: localhost:8080/Warehous/{id} with a DELETE method
```
```bash
The fourth function the Warehous API have is update Warehous
The request path is: localhost:8080/Warehous/{id} with a DELETE method
```
```bash
The fifth function the Warehous API have is delete Warehous
The request path is: localhost:8080/Warehous/{id} with a DELETE method
```
```bash
The sixth function the Warehouse API have is Partially Warehouse customer
The request path is: localhost:8080/Warehouse with a PATCH method
```

```bash
Note: the rest of the requirments are in the word file with the ER Diagram
```
