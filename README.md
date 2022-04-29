# Quarkus + Amadeus Java SDK Demo

[![Java CI](https://github.com/jabrena/quarkus-amadeus-sdk-demo/actions/workflows/build.yml/badge.svg)](https://github.com/jabrena/quarkus-amadeus-sdk-demo/actions/workflows/build.yml)

## Motivation

Sometimes, I need to travel in Europe or cross the Atlantic ocean but
after 2 years of COVID, before travelling I need to review the country restrictions
defined for travellers.

## Value

This example show how to see COVID restrictions in a particular [country](https://www.iso.org/iso-3166-country-codes.html).

## How to use it?

Register in [Amadeus for Developers](https://developers.amadeus.com) to get your `AMADEUS_CLIENT_ID` & `AMADEUS_CLIENT_SECRET`

Export the values:

```
export AMADEUS_CLIENT_ID=YOUR_CLIENT_ID
export AMADEUS_CLIENT_SECRET=YOUR_CLIENT_SECRET
```

## How to run in local?

```
./mvnw clean compile quarkus:dev
./mvnw clean package
java -jar target/quarkus-app/quarkus-run.jar
curl 'http://localhost:8080/api/v1/covid-restrictions'
curl 'http://localhost:8080/api/v1/covid-restrictions?country-code=FR'
```

# References

- https://quarkus.io/guides/getting-started
