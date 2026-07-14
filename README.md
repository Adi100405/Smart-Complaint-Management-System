# Smart Complaint Management System

A simple minor-project-ready complaint management system using:
- Java 17
- Spring Boot
- Spring Data JPA
- H2 in-memory database
- HTML/CSS/JavaScript frontend

## Features
- Submit complaint from browser UI
- Smart priority detection (High / Medium / Low)
- View complaints list
- Resolve complaints from UI
- Dashboard counters
- H2 console for checking database data

## Run in VS Code
1. Open this folder in VS Code.
2. Make sure Java 17 is selected.
3. Run `ComplaintsystemApplication.java`.
4. Open `http://localhost:8081/`

## Useful URLs
- Home UI: `http://localhost:8081/`
- All complaints: `http://localhost:8081/complaints`
- Dashboard: `http://localhost:8081/complaints/dashboard`
- H2 Console: `http://localhost:8081/h2-console`

## H2 Console Login
- JDBC URL: `jdbc:h2:mem:complaintdb`
- Username: `sa`
- Password: leave blank
