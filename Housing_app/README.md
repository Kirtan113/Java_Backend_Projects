# 🏠 Spring Boot Housing App

Stores housing data & provides insights using SQL native queries.

## ✨ Features
- Save housing JSON data to MySQL
- Average sale price overall
- Average sale price per location
- Max sale price
- Min sale price
- Get avg price by location (query param)

## ▶️ How to run
1. Clone repo
2. Open in IntelliJ / Eclipse
3. Run as Spring Boot app
4. Make sure MySQL is running; update `application.properties`

## 📦 APIs
| Method | URL                                      | Description                          |
|-------|-------------------------------------------|--------------------------------------|
| POST  | /housing/save-all                         | Save all housing data                |
| GET   | /housing/avg-overall                      | Avg price overall                    |
| GET   | /housing/max                              | Max price data                       |
| GET   | /housing/min                              | Min price                            |
| GET   | /housing/avg-by-location?location=A       | Avg price by location                |
| GET   | /housing/avg-house-per-location           | Avg price per location (all)         |

## ⚠️ Note
Real DB credentials must not be pushed to GitHub.
