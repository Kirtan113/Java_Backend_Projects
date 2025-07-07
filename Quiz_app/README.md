# 🧠 Spring Boot Quiz App

Simple quiz app where user can start a quiz session, get random questions, submit answers & see results.

## ✨ Features
- Start new quiz session
- Random question from DB
- Submit answer & auto-check
- Track correct & incorrect answers
- Show result summary

## ▶️ How to run
1. Clone repo
2. Open in IntelliJ / Eclipse
3. Run as Spring Boot app
4. Make sure MySQL is running; update `application.properties`

## 📦 APIs
| Method | URL                        | Description                       |
|-------|----------------------------|----------------------------------|
| POST  | /quiz/start                | Start new quiz session           |
| GET   | /quiz/next/{sessionId}     | Get next random question         |
| POST  | /quiz/submit               | Submit answer                    |
| GET   | /quiz/result/{sessionId}   | Get quiz result                  |
| POST  | /questions/upload          | Upload list of questions         |

## ⚠️ Note
Do not push real DB credentials to GitHub.
