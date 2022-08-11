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

## Quarkus Profiles

Quarkus configuration builds on top of `smallrye/microprofile` adding three profiles:

- `dev`: activated when running the application with `mvnw quarkus:dev`
- `test`: activated when running the tests
- `prod`: activated when running neither the `dev` and `test` profiles are active

To use specific configuration values for specific profiles the configuration must be prepended with the `%profile.`.
For example:

```properties
# This value is a fallback value used when running the tests for example as no specific value for the property has been
# specified in that case
bank.name=Local Bank
%dev.bank.name=Dev Bank
%prod.bank.name=The real Bank
```

To activate a specific profile the `-Dquarkus.profile` property (or `QUARKUS_PROFILE` environment variable) can be set.

## Buildtime Properties VS Runtime Properties

Some properties are immutable values that are compiled into the build artifact and never change (e.g. the DB Driver to use). If one tries
to change this value the change will not be picked up as those are immutable. Other properties like for example a DB Url in a runtime property
and can be changed at any given time. Quarkus differentiates these two different types of properties and they get to be shown in the documentation
with a special icon in the form of a small lock icon. 