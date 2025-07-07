# Spring Boot Banking Application

A simple banking system built with Spring Boot.  
Features:
- Open account
- Deposit, Withdraw, Transfer
- Show balance
- Account statement

## How to run
1. Clone this repo
2. Import into IDE (IntelliJ / Eclipse)
3. Run as Spring Boot app

## APIs
| Method | URL              | Description            |
|-------|------------------|------------------------|
| POST  | /bank/open       | Open new account       |
| POST  | /bank/deposit    | Deposit money          |
| POST  | /bank/withdraw   | Withdraw money         |
| POST  | /bank/transfer   | Transfer money         |
| GET   | /bank/balance    | Show balance           |
| GET   | /bank/statement  | Account statement      |
