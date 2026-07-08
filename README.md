# 🚀 Automation Exercise - UI Test Automation Framework

## 📖 Overview

This project is an end-to-end **UI Test Automation Framework** developed for the **Automation Exercise** website using **Java, Selenium WebDriver, Cucumber (BDD), TestNG, and Maven**.

The framework follows the **Page Object Model (POM)** design pattern and is built with reusable components, making it scalable, maintainable, and easy to extend. It includes comprehensive reporting with **Extent Reports** and **Allure Reports**, along with logging and configurable test execution.

**Application Under Test:** https://automationexercise.com

---

# 🛠️ Tech Stack

* Java
* Selenium WebDriver
* Cucumber (BDD)
* TestNG
* Maven
* Page Object Model (POM)
* Extent Reports
* Allure Reports
* Git & GitHub

---

# ✨ Features

* Behavior Driven Development (BDD) using Cucumber
* Page Object Model (POM) architecture
* Test execution using TestNG
* Reusable Page Classes
* Configurable framework using Properties files
* Extent HTML Reports
* Allure Interactive Reports
* Screenshot capture for failed test cases
* Maven-based dependency management
* Easy maintenance and scalability

---

# 📂 Project Structure

```text
AutomationExerciseProject
│
├── src/main/java
│
├── src/main/resources
│
├── src/test/java
│   ├── hooks
│   │     └── Hooks.java
│   │
│   ├── pages
│   │     ├── HomePage.java
│   │     ├── LoginPage.java
│   │     ├── RegisterPage.java
│   │     ├── ProductPage.java
│   │     ├── CartPage.java
│   │     ├── CheckoutPage.java
│   │     ├── ContactPage.java
│   │     ├── BrandFilterPage.java
│   │     └── SubscriptionPage.java
│   │
│   ├── runners
│   │     └── TestRunner.java
│   │
│   ├── stepDefinitions
│   │     ├── LoginSteps.java
│   │     ├── RegisterSteps.java
│   │     ├── ProductSteps.java
│   │     ├── CartSteps.java
│   │     ├── CheckoutSteps.java
│   │     ├── ContactSteps.java
│   │     ├── BrandFilterSteps.java
│   │     └── SubscriptionSteps.java
│   │
│   ├── utilities
│   │     ├── BaseClass.java
│   │     ├── DriverFactory.java
│   │     ├── ConfigReader.java
│   │     └── ExtentReportManager.java
│
├── src/test/resources
│   ├── features
│   │     ├── Login.feature
│   │     ├── Register.feature
│   │     ├── Product.feature
│   │     ├── Cart.feature
│   │     ├── Checkout.feature
│   │     ├── Contact.feature
│   │     ├── BrandFilter.feature
│   │     └── Subscription.feature
│   │
│   ├── config.properties
│   ├── extent.properties
│   └── allure.properties
│
├── reports
├── target
├── test-output
├── pom.xml
└── testng.xml
```

---

# 🧪 Automated Test Modules

* User Registration
* User Login
* User Logout
* Product Search
* Product Details Verification
* Shopping Cart
* Checkout Process
* Contact Us Form
* Brand Filtering
* Subscription

---

# ▶️ Prerequisites

Before running the project, ensure you have:

* Java JDK 17 or later
* Maven
* Eclipse IDE or IntelliJ IDEA
* Google Chrome
* Git
* Jenkins

---

# ⚙️ Installation

Clone the repository:

```bash
git clone https://github.com/asamkousalya/AutomationExerciseProject.git
```

Navigate to the project:

```bash
cd AutomationExerciseProject
```

Install dependencies:

```bash
mvn clean install
```

---

# ▶️ Running the Tests

Run all test scenarios:

```bash
mvn clean test
```

Or execute the `testng.xml` file directly from your IDE.

---

# 📊 Test Reports

### Extent Reports

After execution, Extent Reports are generated in the configured reports directory, providing a detailed HTML summary of the test execution.

### Allure Reports

Generate and open the Allure report using:

```bash
mvn allure:serve
```

---

# 📸 Screenshots

The framework captures screenshots automatically whenever a test case fails, making it easier to debug failures.

---

# 📌 Framework Design

The project follows the **Page Object Model (POM)** design pattern, which improves:

* Code Reusability
* Maintainability
* Readability
* Scalability

---

# 👥 Contributors

* Asam Kousalya
* Aryan Tijare
* Amar Sai Peddelli
* Soham Sontake
* Sri Veera Shankar Borsu
* Vaibhav Makne

---

# 📄 License

This project is intended for educational, learning, and demonstration purposes using the Automation Exercise practice website.

---

# 🌐 Application Under Test

https://automationexercise.com

---

⭐ If you found this project useful, consider giving the repository a **Star**.
