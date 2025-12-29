# FirstSpringMVC – Hello World Example

This is a simple **Spring Boot + Spring MVC** application that displays a **“HELLO WORLD”** message in the browser using **JSP** as the view technology.

---

## 🎯 Requirement

When the application is run and the browser hits a URL, a **Hello World** message should be displayed.

Example:

```
http://localhost:8080/message
```

Output:

```
HELLO WORLD
```

---

## 🏗 Project Overview

The project follows the **Spring MVC architecture**, which mainly consists of:

1. **View Layer** – JSP (frontend)
2. **Controller Layer** – Handles HTTP requests
3. **Configuration** – application.yml for view resolution

---

## 📁 Project Structure

```
src
 └── main
     ├── java
     │   └── com.example.FirstSpringMVC
     │       ├── FirstSpringMvcApplication.java
     │       └── controller
     │           └── HomeController.java
     ├── resources
     │   └── application.yml
     └── webapp
         └── WEB-INF
             └── views
                 └── home.jsp
```

---

## ⚙️ Step 1: Configure the View Layer (JSP)

### 1️⃣ Create JSP Files

* Create the following directory structure:

  ```
  src/main/webapp/WEB-INF/views
  ```
* Inside `views`, create a JSP file:

**home.jsp**

```jsp
<h1>HELLO WORLD</h1>
```

> JSP is used because it supports both **HTML + Java code**.

---

### 2️⃣ Add JSP Dependencies

Spring Boot does not support JSP by default.
Add the following dependencies to `pom.xml`:

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
```

These dependencies allow Tomcat to compile and render JSP pages.

---

### 3️⃣ Configure View Resolver (application.yml)

Create `application.yml` inside `src/main/resources`.

```yml
spring:
  application:
    name: FirstSpringMVC
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
```

✅ This tells Spring:

* Where JSP files are located
* Which file extension to use

---
## 📌 Why Use `application.yml` Instead of `application.properties`?

Spring Boot supports **both** formats, but `application.yml` offers several advantages, especially for **larger and structured configurations**.

---

### ✅ 1️⃣ Better Readability

YAML is **more human-readable** because it uses **indentation instead of repeated keys**.

**application.properties**

```properties
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

**application.yml**

```yml
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
```

---

### ✅ 2️⃣ Hierarchical Configuration (Nested Structure)

YAML naturally represents **hierarchical data**, which matches Spring Boot’s configuration structure.

```yml
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
```

✔️ No long dot-separated keys
✔️ Cleaner and more organized

---

### ✅ 3️⃣ Native Support for Lists

YAML makes it easy to define **lists**.

```yml
servers:
  - dev.example.com
  - test.example.com
  - prod.example.com
```

---

### ✅ 4️⃣ Native Support for Maps (HashMaps)

YAML is excellent for defining **key-value pairs (Maps / HashMaps)**.

```yml
database:
  credentials:
    username: admin
    password: secret
```

---

### ✅ 5️⃣ Less Boilerplate for Large Applications

As applications grow, `application.properties` becomes:

* Long
* Repetitive
* Hard to maintain

YAML keeps configurations:

* Structured
* Scalable
* Easy to modify

---

### ⚠️ When to Use `application.properties`?

Use `application.properties` when:

* Configuration is very small
* You prefer single-line key-value pairs
* No complex or nested data is needed
```


## 🎮 Step 2: Configure the Controller Layer

Create a controller class to handle incoming requests.

**HomeController.java**

```java
package com.example.FirstSpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/message")
    public String message() {
        return "home"; // resolves to /WEB-INF/views/home.jsp
    }
}
```

---

## 🚀 Step 3: Main Application Class

**FirstSpringMvcApplication.java**

```java
package com.example.FirstSpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringMvcApplication.class, args);
    }
}
```

---

## ▶️ Running the Application

1. Start the Spring Boot application
2. Tomcat runs on port **8080**
3. Open the browser and hit:

```
http://localhost:8080/message
```

---

## ✅ Expected Output

```
HELLO WORLD
```

---

## ❌ Why Whitelabel Error Page Appears?

If you access:

```
http://localhost:8080/
```

You will see a **404 Whitelabel Error Page** because no controller mapping exists for `/`.

✔️ Solution: Always access the mapped URL:

```
/message
```

---

## 📝 Summary

* JSP files are placed under `WEB-INF/views`
* `application.yml` configures view resolution
* Controller handles requests and returns logical view names
* Spring automatically maps the view name to the JSP file
