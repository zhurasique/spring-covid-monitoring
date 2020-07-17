# spring-covid-monitoring
REST API to getting COVID-19 data

## How this works
- Refreshing data every 5 min. by using web crawling technology from [wikipedia](https://en.wikipedia.org/wiki/Template:COVID-19_pandemic_data)
- Parsing data, then saving to DB
- Returning data in JSON format using REST technology

## Endpoints
| URL  | Data |
| ------------- | ------------- |
| localhost:8080/api  | Stats for all countries  |
| localhost:8080/country?country=Country  | Stats for country you looking for  |
| localhost:8080/id?id=ID | Stats for country by ID |
