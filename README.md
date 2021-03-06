# Airline
Airline customers can book their air tickets at an affordable price following simple and easy steps. If the customers enter their travel details, the website will fetch the best-suited flights for them


#### The functionalities retained in different microservices are:


| Microservice | Functionalities             |
| :----------- | :-------------------------- |
| UserDetailMS | User can login and register new account |
| PaymentMS | User can pay using credit card |
| SearchFlightMS | User can search flights |
| BookFlightsMS | User can book flights |

## Airline Microservice Architecture Diagram

![App Screenshot](https://github.com/MirAbbasAli/Airline/blob/master/airline_design.png)

## API Reference

#### User Login

```
  POST /login
```


#### Register new User

```
  POST /register
```

#### Make payment using credit card

```
  POST /payment
```


#### Save the credit card

```
  POST /save-card
```

#### Fetches all flight details for a given flightId

```
  GET /flights/{flightId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `flightId` | `String` | **Required**. flightId |

#### Fetches all flight sources

```
  GET /flights/sources
```
#### Fetches all flight destinations

```
  GET /flights/destinations
```

#### Fetches flight details for a given source and destination based on journeyDate

```
  GET /flights/{source}/{destination}/{journeyDate}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `source` | `String` | **Required**. source |
| `destination` | `String` | **Required**. destination |
| `journeyDate` | `Date` | **Required**. date of journey in yyyy-dd-mm |

#### Book flight for given flightId and userId

```
  POST /book/{flightId}/{usename}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `flightId` | `String` | **Required**. flightId |
| `username` | `String` | **Required**. username |
