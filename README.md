# Java Masking With Mapstruct

### Introduction
An example of masking Java objects using MapStruct.
* [Original Blog - With full details of the code](https://johndobie.com/blog/java-masking-with-mapstruct)

### Running The Application
```bash
mvn clean install spring-boot:run
```

### Testing The Endpoints
UnMasked Data

[http://localhost:8080/customer](http://localhost:8080/customer)
```bash
curl http://localhost:8080/customer
```
```json
{"firstName":"John","middleName":"A","lastName":"Dobie","personalDetails":{"niNumber":"NS1234567","dateOfBirth":"1970-01-01"}}
```
Masked Data

[http://localhost:8080/customer/masked](http://localhost:8080/customer/masked)
```bash
curl http://localhost:8080/customer/masked
```
```json
{"firstName":"John","middleName":null,"lastName":"Dobie","personalDetails":{"niNumber":"********","dateOfBirth":"****-**-**"}}
```