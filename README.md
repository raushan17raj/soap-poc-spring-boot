# soap-poc-spring-boot

**Description**  
A Spring Boot SOAP Web Service Proof of Concept using Java 25. Demonstrates WSDL/XSD-first development, JAXB code generation, and SOAP endpoint implementation.

---

## Features

- SOAP web service implemented with Spring Boot  
- JAXB classes automatically generated from XSD (`user.xsd`)  
- Sample request and response objects  
- Gradle build system with a custom `generateJaxb` task  

---

## Prerequisites

- Java 25  
- Gradle (or use the Gradle wrapper `./gradlew`)  
- Internet connection to download dependencies  

---

## Getting Started

### 1. Clone the repository

```bash
git clone git@github.com:raushan17raj/soap-poc-spring-boot.git
cd soap-poc-spring-boot
```
### 2. Generate JAXB classes from XSD
```
./gradlew generateJaxb
```

This will:

Read the XSD file at src/main/resources/user.xsd

Generate Java classes under the package com.example.soap.gen

Place them in the configured generatedDir

These classes are required to run the SOAP service.

### NOTES
- The SOAP service will start on http://localhost:8080/ws (or the port configured in application.properties).
- Always run generateJaxb after modifying the XSD before building.
- Generated classes are in the package: com.example.soap.gen
- You can extend the generateJaxb task to handle multiple XSDs if needed.

### Testing the SOAP Endpoints

- Use a SOAP client like Postman or SOAP UI
- Send requests according to the WSDL/XSD in src/main/resources/user.xsd
- Example request/response:
```xml
  <!-- Example request -->
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:usr="http://example.com/user">
   <soapenv:Header/>
   <soapenv:Body>
      <usr:getUserRequest>
         <usr:userId>1</usr:userId>
      </usr:getUserRequest>
   </soapenv:Body>
</soapenv:Envelope>

<!-- Example response -->
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:usr="http://example.com/user">
   <soapenv:Header/>
   <soapenv:Body>
      <usr:getUserResponse>
         <usr:user>
            <usr:id>1</usr:id>
            <usr:name>Raushan Raj</usr:name>
         </usr:user>
      </usr:getUserResponse>
   </soapenv:Body>
</soapenv:Envelope>


