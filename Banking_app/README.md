# 🏦 Spring Boot Banking Application

Simple banking system built with Spring Boot.

## ✨ Features
- Open account
- Deposit
- Withdraw
- Transfer
- Show balance
- Account statement

## ▶️ How to run
1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Run as Spring Boot App
4. Make sure MySQL is running and update `application.properties` accordingly

## 🔌 API List

| Method | URL              | Description            |
|-------|------------------|------------------------|
| POST  | /bank/open       | Open new account       |
| POST  | /bank/deposit    | Deposit money          |
| POST  | /bank/withdraw   | Withdraw money         |
| POST  | /bank/transfer   | Transfer money         |
| GET   | /bank/balance    | Show balance           |
| GET   | /bank/statement  | Account statement      |

## ⚠️ Note
Remove real DB password from `application.properties` before pushing.
