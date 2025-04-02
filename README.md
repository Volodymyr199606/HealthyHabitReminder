# 🏋️‍♂️ HealthyHabitReminder - Your Daily Health Tracker 🥗💧

## 📌 Overview

```
HealthyHabitReminder/
├── .idea/                             # IntelliJ project files
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── com/
│   │   │           └── app/
│   │   │               ├── Main.java                     # Entry point of the application
│   │   │               ├── controller/
│   │   │               │   └── UserController.java       # User interaction logic
│   │   │               ├── database/
│   │   │               │   └── DatabaseHelper.java       # DB connection and setup
│   │   │               ├── model/
│   │   │               │   └── User.java                 # User model
│   │   │               ├── service/
│   │   │               │   └── UserService.java          # Service to handle user logic
│   │   │               └── services/
│   │   │                   ├── BaseService.java          # Base logic for logging
│   │   │                   ├── ExerciseService.java      # Handles exercise logs
│   │   │                   ├── FruitService.java         # Handles fruit logs
│   │   │                   ├── Loggable.java             # Interface for logging
│   │   │                   ├── VegetableService.java     # Handles vegetable logs
│   │   │                   └── WaterService.java         # Handles water logs
│   │   └── resources/
│   │       └── schema.sql                # SQL script for setting up DB and tables
│
│   └── test/
│       └── java/
│           ├── database/
│           │   └── DatabaseHelperTest.java              # DB helper connection tests
│           ├── service/
│           │   └── UserServiceTest.java                 # Tests for user logic
│           └── services/
│               ├── BaseServiceInteractiveTest.java
│               ├── ExerciseServiceInteractiveTest.java
│               ├── FruitServiceInteractiveTest.java
│               ├── VegetableServiceInteractiveTest.java
│               └── WaterServiceInteractiveTest.java
│                                                   # Interactive tests for each log service
├── target/                         # Compiled output
├── .gitignore                      # Git ignored files
├── dependency-reduced-pom.xml     # Auto-generated by shade plugin
├── LICENSE                         # License file
├── pom.xml                         # Maven config file
└── README.md                       # Project overview

```


## 🎯 Technologies Used
- Java 22
- MySQL (Database)
- JUnit 5 (Testing)
- Maven (Dependency management)



## 🚀 Features
 - **User Registration** - Stores user details (name, age, gender, activity level).  
 - **Exercise Tracking** - Logs whether the user exercised in the morning.  
 - **Water Intake Tracking** - Records daily water consumption and gives hydration tips.  
 - **Fruit & Vegetable Intake Logging** - Encourages healthy eating habits.  
 - **MySQL Database Support** - Persistent storage for all activity logs.  
 - **OOP Principles** - Uses Encapsulation, Inheritance, Polymorphism, and Interfaces.  
 - **JUnit Tests** - Ensures reliability using JUnit testing.



---

## **🛠️ Installation & Setup**

### **1️⃣ Prerequisites**
Before running this project, make sure you have:
- Java 22+
- MySQL installed and running (default port 3306)
- Note: This project uses features introduced in Java 22. Ensure your IDE and build tools are configured to support Java 22.
- Maven (optional)
- MySQL Workbench or similar (optional for DB access)

### **2️⃣ Clone the Repository**
```
git clone https://github.com/Volodymyr199606/HealthyHabitReminder.git
```
```
cd HealthyHabitReminder
```

### **3️⃣ Build and Run**

```
mvn compile
```
```
mvn exec:java -Dexec.mainClass=org.com.app.Main
```

### 🔧 Setup MySQL Database

- Start MySQL Server
- Run the schema.sql Script
- You can do this using MySQL Workbench, IntelliJ DB Console, or CLI:
```
-- Run this in MySQL Workbench or your SQL CLI:
SOURCE path/to/schema.sql;

```

### 🗂️ Using the schema.sql File

```
- Step 1: Locate the schema file
- The SQL script is located in:src/main/resources/schema.sql
- It includes the necessary CREATE DATABASE and CREATE TABLE commands to initialize:
- users, exercise_log, water_log, fruit_log, vegetable_log

- Step 2: Execute the script
- You can run it using MySQL Workbench, the MySQL CLI, or IntelliJ's DB Console.
- MySQL CLI: mysql -u root -p < src/main/resources/schema.sql
- MySQL Workbench: 1.Open the schema.sql file in MySQL Workbench. 2. Execute the script.
```

 ### SQL Commands to View User Data
 ```
SELECT * FROM users;
SELECT * FROM fruit_log;
SELECT * FROM vegetable_log;
SELECT * FROM water_log;
SELECT * FROM exercise_log;
```

# Future Improvements
-  Add GUI using JavaFX/Spring Boot
-  Track daily steps & calories
-  Generate PDF reports of health logs
-  Add mobile support via app





# Contact
- Created with love by Volodymyr
- 🌐 LinkedIn: https://www.linkedin.com/in/volodymyr-behma/
