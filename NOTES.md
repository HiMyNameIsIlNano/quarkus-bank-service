# Bank Service Project Study Notes

## Some useful tips on how to use mvn with Quarkus

- [Maven Tooling](https://quarkus.io/guides/maven-tooling)

## External Configuration

As for Spring Boot, Microprofile supports the definition of configuration values from different sources:

- System Property (e.g. `-Dbank.name=value`)
- Environment Variables
    - the `bank.name` is searched through the env variables   
    - the `bank_name` is searched through the env variables   
    - the `BANK_NAME` is searched through the env variables   
- Kubernetes Config Maps
- `application.yml`
- `application.properties`