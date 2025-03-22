# 🏋️‍♂️ HealthyLifeReminder - Your Daily Health Tracker 🥗💧

## 📌 Overview


``` HealthyLifeReminder/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/com/
│   │   │   │   ├── app/
│   │   │   │   │   ├── Main.java  --> (Entry point of the application)
│   │   │   │   ├── controller/
│   │   │   │   │   ├── UserController.java  --> (Manages user interaction and calls services)
│   │   │   │   ├── database/
│   │   │   │   │   ├── DatabaseHelper.java  --> (Handles SQLite database connection & table creation)
│   │   │   │   ├── model/
│   │   │   │   │   ├── User.java  --> (Encapsulates user data with getters/setters)
│   │   │   │   ├── service/
│   │   │   │   │   ├── UserService.java  --> (Handles user database operations)
│   │   │   │   ├── services/
│   │   │   │   │   ├── Loggable.java  --> (Interface for all reminder services)
│   │   │   │   │   ├── BaseService.java  --> (Abstract base class with common logging methods)
│   │   │   │   │   ├── ExerciseService.java  --> (Handles exercise logging)
│   │   │   │   │   ├── WaterService.java  --> (Handles water intake logging)
│   │   │   │   │   ├── FruitService.java  --> (Handles fruit intake logging)
│   │   │   │   │   ├── VegetableService.java  --> (Handles vegetable intake logging)
│── test/
│   ├── java/
│   │   ├── org/com/
│   │   │   ├── database/
│   │   │   │   ├── DatabaseHelperTest.java  --> (Tests database connection & table creation)
│   │   │   ├── service/
│   │   │   │   ├── UserServiceTest.java  --> (Tests user database operations)
│   │   │   ├── services/
│   │   │   │   ├── BaseServiceTest.java  --> (Tests common logging in BaseService)
│   │   │   │   ├── ExerciseServiceTest.java  --> (Tests exercise logging)
│   │   │   │   ├── WaterServiceTest.java  --> (Tests water intake logging)
│   │   │   │   ├── FruitServiceTest.java  --> (Tests fruit intake logging)
│   │   │   │   ├── VegetableServiceTest.java  --> (Tests vegetable intake logging)
│── HealthyLifeReminder.db  --> (SQLite database file)
│── pom.xml  --> (Maven configuration file, if using Maven)
│── README.md  --> (Project documentation)
```



## 🎯 Technologies Used
- Java 22
- SQLite (Database)
- JUnit 5 (Testing)
- Maven (Dependency management)



## 🚀 Features
 - **User Registration** - Stores user details (name, age, gender, activity level).  
 - **Exercise Tracking** - Logs whether the user exercised in the morning.  
 - **Water Intake Tracking** - Records daily water consumption and gives hydration tips.  
 - **Fruit & Vegetable Intake Logging** - Encourages healthy eating habits.  
 - **SQLite Database Support** - Stores activity logs for future reference.  
 - **OOP Principles** - Uses **Encapsulation, Inheritance, Polymorphism, and Interfaces**.  
 - **Unit Tests** - Ensures reliability using **JUnit testing**.



---

## **🛠️ Installation & Setup**

### **1️⃣ Prerequisites**
Before running this project, make sure you have:
- ⚠️Note: This project uses features introduced in Java 22. Ensure your IDE and build tools are configured to support Java 22.
- **Maven (optional)**
- **SQLite installed** (optional for database debugging)

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/your-username/HealthyLifeReminder.git
cd HealthyLifeReminder
```

### **3️⃣ Build and Run**

```
mvn compile
mvn exec:java -Dexec.mainClass="org.com.app.Main"
```


# Future Improvements
-  Add GUI using JavaFX/Spring Boot
-  Track daily steps & calories
-  Generate PDF reports of health logs
-  Add mobile support via app





# Contact
- Created with love by Volodymyr
- 🔗LinkedIn: https://www.linkedin.com/in/volodymyr-behma/
