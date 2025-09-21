# 📝 To-Do List Application (Spring Boot + Thymeleaf + H2)

## 📌 About
A simple **To-Do List web application** built using:
- Java 17+
- Spring Boot
- Spring Data JPA
- Thymeleaf
- H2 Database (in-memory)

This project demonstrates basic **CRUD operations**:
- Create a new task  
- Read (view) all tasks  
- Update task (edit title or mark as completed)  
- Delete a task  

---

## 🚀 Features
- ➕ Add new tasks  
- 👀 View all tasks in a table  
- ✅ Mark tasks as completed / ❌ not completed  
- ✏️ Edit tasks (title + status)  
- 🗑️ Delete tasks  
- Data stored in **H2 in-memory DB**  

---

## 🛠️ Setup & Run

### 1. Clone the repo
```
git clone https://github.com/yourusername/todo-springboot.git
cd todo-springboot
```
### 2. Build & Run
If using Maven:

```
mvn spring-boot:run
```

### 3. Open in browser
App: ```http://localhost:8080```
H2 Console: ```http://localhost:8080/h2-console```

### 4. H2 Login settings:
- JDBC URL: 
```
jdbc:h2:mem:testdb
```
- Username: sa
- Password: 

### 5. 📂 Project Structure
src
 ├─ main
 │   ├─ java/com/example/todo
 │   │   ├─ model/Todo.java                 # Entity (Task)
 │   │   ├─ repository/TodoRepository.java  # JPA Repository
 │   │   ├─ controller/TodoController.java  # Handles requests
 │   │   └─ TodoApplication.java            # Main Spring Boot app
 │   └─ resources
 │       ├─ templates
 │       │   ├─ index.html                  # List all tasks
 │       │   ├─ add.html                    # Add new task
 │       │   └─ edit.html                   # Edit task
 │       └─ application.properties          # H2 + JPA config
vbnet

