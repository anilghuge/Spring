# Container

A **Container** is software programming that takes care of the entire lifecycle of a given resource or class, from birth (Object Creation) to death (Object Destruction).

## Container Operations
A Container manages the following operations on a given class:
- Loading of the class
- Creation of the object
- Management of the object
- Raising lifecycle events and calling lifecycle methods
- Destruction of the object (Garbage Collection)

## Examples of Containers
- **Servlet Container**: Takes care of the servlet component's lifecycle
- **JSP Container**: Takes care of the JSP component's lifecycle
- **Spring Container/IOC Container**: Takes care of Spring bean's lifecycle
- **EJB Container**: Takes care of EJB bean's lifecycle

# Spring Bean

A **Spring Bean** is a Java class whose object is created and managed by the **Spring Container/IOC Container**.

## Key Points about Spring Bean:
- The **IOC Container/Spring Container** manages the entire lifecycle of a Spring Bean.
- You can use any user-defined class, pre-defined class, or third-party supplied class as a Spring Bean.
- **Interfaces and abstract classes** cannot be used as Spring Beans because their instantiation is not possible.

## Configuration of Spring Beans:
- To make a Java class a Spring Bean, you need to pass instructions/configurations to the Spring Container/IOC Container, either using:
  - XML configurations (Legacy)
  - Annotations (preferred method)
  
### Example of Using Annotations for Spring Beans:

If the Java class is user-defined, it is recommended to configure it as a Spring Bean using annotations, such as `@Component`.

```java
@Component("wmg")  // Bean ID --> Object Name
public class WishMessageGenerator {

    public String generateWishMessage(String user) {
        // Implementation
    }
}
```
# Spring Bean Configuration with `@Component` and Other Methods

Based on `@Component("wmg")`, the **IOC container** creates an object for the `WishMessageGenerator` class with the name "wsg".

## Configuring Pre-defined/Third-Party Supplied Classes as Spring Beans

To configure pre-defined or third-party supplied Java classes as Spring Beans, you can provide instructions to the IOC container either using:
- XML configuration (`<bean>` tag)
- Special annotations (`@Bean` method)

### 1. Using XML Configuration with `<bean>` Tag

```xml
<bean id="dt" class="java.util.Date">
    <!-- Bean ID         Fully Qualified Java Class -->
</bean>

@Bean("dt1")
public Date createDate() {
    return new Date();
}
```
- IOC conatiner takes the method returned DAte class Obj and makes it as spring bean having  the bean id "dt1".

# Spring Annotations and Modules

## Annotations

- `@Component` is applicable at the **class level** and **not applicable at the method level**. It is used for **user-defined classes**.
- `@Bean` is applicable at the **method level** and **not applicable at the class level**. It is used for **pre-defined classes**.

## Spring/Spring Boot Framework Overview

Spring and Spring Boot are collections of modules (30+ modules) that allow you to develop various types of applications, such as:
- Standalone applications
- Web applications
- Distributed applications
- And more...

Each module of the Spring/Spring Boot framework comes in the form of a bunch of JAR files. You can use either a **single module**, **multiple modules**, or **all the modules** in your project, based on your requirements.

### Modules in Spring/Spring Boot Framework

A collection of libraries and APIs grouped together is called a **module** in the Spring/Spring Boot framework. Some key modules include:
- Core
- JDBC
- AOP
- MVC
- Security
- JEE
- Mail
- Scheduling
- Transactional Management
- Messaging
- Cloud
- Batch
- And more...

## Spring Core Module

- **Spring Core** is the base module for other modules of the Spring framework, i.e., all other Spring modules are created using this module.
- This module is often referred to as the "**core Java**" of the Spring framework.
- If you use this module alone, you can develop only **standalone applications**.

# IOC Containers and Dependency Management

## Spring IOC Containers

The Spring Core module provides two main IOC containers:
1. **BeanFactory** (Basic IOC Container)
2. **ApplicationContext** (Advanced IOC Container, extends BeanFactory)

These Spring-supplied IOC containers serve two main purposes:
1. **Spring Bean Lifecycle Management**
2. **Dependency Management**

## Dependency Management

### 1. Dependency Lookup

In **Dependency Lookup**, the target class writes logic to search for and get the dependent class object from different resources. The target class **pulls** the dependent class object from external sources.

#### Example of Dependency Lookup:

- In the case of JNDI (Java Naming and Directory Interface), the target class (Java class) looks for the dependent class object in the JNDI registry.

> **JNDI**: Java Naming and Directory Interface (used for looking up objects in a directory service).

#### Object Scope in Dependency Lookup:

- If the object is created **inside a method**, the object's scope is **method scope**.
- If the object is created inside another class as a **non-static member variable**, the object's scope is the **other class's object scope**.
- If the object is created inside another class as a **static member variable**, the object's scope is the **other class's scope**.

To provide global visibility and accessibility to an object or object reference, it is placed in a **JNDI registry**.

#### Examples of JNDI Registries:
- RMI registry
- COS registry
- Tomcat Registry
- WebLogic registry
- And more...

> **Note**: Every web server/application server contains a built-in JNDI registry.

#### JNDI Lookup:

All useful object references are kept in the JNDI registry to provide global visibility and accessibility. 

- **Example:** 
  - PayTM (PayTMService class object reference)
  - GooglePay (GooglePayService class object reference)

These object references are stored in the JNDI registry and can be accessed through **JNDI Lookup** (Dependency Lookup operation).

#### JNDI Lookup Code:

The JNDI lookup code in a target class (Java application) searches for and retrieves a dependent class object reference from the JNDI registry. This is called **JNDI Lookup** (or Dependency Lookup).

```java
// Sample JNDI Lookup code
Context ctx = new InitialContext();
MyService myService = (MyService) ctx.lookup("java:comp/env/MyService");
```
# Spring Bean and Container Management

## Container

A **Container** is software that manages the entire lifecycle of a given resource or class, from birth (Object Creation) to death (Object Destruction).

The container performs the following operations on the given class:
- **Loading of class**
- **Creation of object**
- **Management of object**
- **Raising lifecycle events and calling lifecycle methods**
- **Destruction of the object** (Garbage collection)

### Examples of Containers:
- **Servlet Container**: Takes care of the servlet component's lifecycle.
- **JSP Container**: Takes care of the JSP component's lifecycle.
- **Spring Container/IOC Container**: Manages the lifecycle of Spring Beans.
- **EJB Container**: Manages the lifecycle of EJB Beans.

---

## Spring Bean

A **Spring Bean** is a Java class whose object is created and managed by the **Spring Container/IOC Container**.

### Key Points about Spring Bean:
- The **IOC Container/Spring Container** manages the entire lifecycle of a Spring Bean.
- You can use any **user-defined class**, **pre-defined class**, or **third-party supplied class** as a Spring Bean.
- **Interfaces** and **abstract classes** cannot be used as Spring Beans because their instantiation is not possible.

### Configuring Spring Beans:
To make a Java class a Spring Bean, you need to provide configuration to the Spring Container/IOC Container. This can be done either:
- Using **XML configuration** (Legacy)
- Using **Annotations** (Preferred method)

If the Java class is user-defined, it's preferable to configure it as a Spring Bean using annotations, such as `@Component`.

```java
@Component("wmg")  // Bean ID --> Object Name
public class WishMessageGenerator {

    public String generateWishMessage(String user) {
        // Implementation
    }
}
```
# Spring Bean Configuration and Framework Overview

## Spring Bean Configuration with `@Component`

Based on `@Component("wmg")`, the **IOC Container** creates an object for the `WishMessageGenerator` with the name `"wsg"`.

### Configuring Pre-defined/Third-Party Supplied Classes as Spring Beans

To configure pre-defined or third-party supplied Java classes as Spring Beans, you can provide instructions to the **IOC Container** either using:
1. **XML Configuration** (`<bean>` tag)
2. **Special Annotations** (`@Bean` method)

---

## 1. Using XML Configuration with `<bean>` Tag

```xml
<bean id="dt" class="java.util.Date">
    <!-- Bean ID             Fully Qualified Java Class -->
</bean>
```
## 2. Using @Bean method
---------------------------------
```java
@Bean("dt1")
public Date createDate(){
return new Date();
}
```
# Spring IOC Container and Framework Overview

## Spring Bean Management

The **IOC Container** takes the method-returned `Date` class object and makes it a Spring Bean with the bean ID `"dt1"`.

---

## Annotations and Their Applicability

- `@Component` is applicable **at the class level** and **not applicable at the method level**. It is used for **user-defined classes**.
- `@Bean` is applicable **at the method level** and **not applicable at the class level**. It is used for **pre-defined classes**.

---

## Spring/Spring Boot Framework Overview

The **Spring/Spring Boot Framework** is a collection of **30+ modules**. Each module comes in the form of a set of JAR files. We can use Spring/Spring Boot to develop different types of applications, such as:
- Standalone applications
- Web applications
- Distributed applications
- And more...

You can choose to use either a **single module**, **multiple modules**, or **all modules** in your application.

### Key Modules in Spring/Spring Boot Framework:

A collection of libraries and APIs grouped together is called a **module** in the Spring/Spring Boot framework. Some key modules include:
- Core
- JDBC
- AOP
- MVC
- Security
- JEE
- Mail
- Scheduling
- Transactional Management
- Messaging
- Cloud
- Batch
- And more...

# Spring Core Module and IOC Containers

## Spring Core

- **Spring Core** is the base module for other modules in the Spring framework. All other Spring modules are created using this module.
- This module is often referred to as the "**Core Java**" of the Spring framework.
- If this module is used alone, then we can develop only **standalone applications**.

---

## IOC Containers in Spring Core Module

This module provides two main types of IOC Containers:

1. **BeanFactory** (Basic IOC Container)
2. **ApplicationContext** (Advanced IOC Container, extends `BeanFactory`)

---

## Main Operations of Spring IOC Containers

The Spring-supplied IOC containers are responsible for two main operations:

1. **Spring Bean Lifecycle Management**
2. **Dependency Management**

---

## Dependency Management in Spring

Dependency Management is a key feature in Spring and includes two main concepts:

### 1. Dependency Lookup

In **Dependency Lookup**, the target class writes logic to search for and retrieve dependent class objects from different resources. The target class **pulls** the dependent class object from different places.

#### Example: 
A Java class (target class) gets a dependent class object by searching for it in a **JNDI registry**.

> **JNDI** (Java Naming and Directory Interface) is used to access resources like database connections, EJBs, or any other managed objects.

#### Object Scope in Dependency Lookup:
- If the object is created **inside a method**, the object's scope is **method scope**.
- If the object is created **inside another class as a non-static member variable**, the object's scope is the **scope of the other class's object**.
- If the object is created **inside another class as a static member variable**, the object's scope is the **scope of the other class**.

To provide global visibility and accessibility to any object or object reference, we need to place that reference in a **JNDI registry**.

#### Examples of JNDI Registries:
- RMI Registry
- COS Registry
- Tomcat Registry
- WebLogic Registry
- And more...

> **Note**: Every web server/application server contains a built-in JNDI registry.

---

## Conclusion

The **Spring Core** module is essential for understanding the foundations of the Spring framework and how the IOC containers work. By leveraging **Dependency Lookup** and **Dependency Injection**, you can effectively manage the lifecycle and dependencies of your application components.

# JNDI Lookup Operations

All useful object references are kept in the **JNDI registry** to provide global visibility and accessibility for them.

### Example:

- **PayTm**: `PayTMService` class object reference
- **GPay**: `GooglePayService` class object reference

The process flow looks like this:

payTm → PayTMService class obj ref
gpay → GooglePayService class obj ref
---- → ----
keys → object/object references
|
|-- JNDI Lookup Operation (Dependency Lookup Operations)
|
java app (java class) → target class


### JNDI Lookup Code to Retrieve Objects from the Registry

```java
// JNDI lookup code to search and get a certain object reference from the JNDI registry
Context context = new InitialContext(props); // details of JNDI registry like name, location, etc.
PayTmService paytmService = (PayTmService) context.lookup("jpayTm");
GooglePayService gpayService = (GooglePayService) context.lookup("java:comp/env/gpay");
```
# Dependency Management in Spring Framework

## Advantages of Dependency Lookup

- The target class can search and get only the required dependent class object by writing logic in the target class.

## Disadvantages of Dependency Lookup

- The programmer needs to spend some time and write logic to search and get the required dependent class object.

---

## 2. Dependency Injection

In **Dependency Injection**, the underlying server/container/framework/JVM/runtime environment dynamically assigns the dependent class object to the target class object.

- The server/container/framework/JVM/runtime environment **pushes** the dependent class object to the target class object.
- If we configure the target and dependent classes as Spring beans by enabling dependency injection, the **IOC container** performs the following operations:
  1. The **IOC container** loads both target and dependent classes.
  2. The **IOC container** creates both target and dependent class objects.
  3. The **IOC container** assigns the dependent class object to the target class object.
  4. The **IOC container** manages both the dependent class object and the target class object.
  5. The **IOC container** provides both objects to the programmer whenever they are required.
  6. The **IOC container** can destroy both objects when necessary.

---

### Advantages of Dependency Injection:

- The programmer does not need to write any logic in the target class to get the dependent class object because the underlying container/server/framework/JVM/runtime environment dynamically assigns the dependent class object to the target class object.

### Disadvantages of Dependency Injection:

- The underlying container/server/framework/JVM/runtime environment may inject both necessary and unnecessary dependent objects into the target class object.

# Spring Dependency Management

## Spring Supports Both "Dependency Lookup" and "Dependency Injection"

### Why Are Spring Containers Called IOC Containers?

- **IOC** stands for **Inversion of Control** (Reverse of the Traditional Process).
  
  - In normal Java apps (Core Java style apps), tasks such as loading classes, creating objects, assigning dependent class objects to target objects, managing objects, using them, and destroying objects at the end should be done by programmers, directly or indirectly (the traditional process). This approach burdens the programmer.

  - In **Spring/Spring Boot** apps, all the above operations are taken care of by the **Spring container** (also known as the **IOC container**). It reverses the traditional process by taking full control of all these operations, which is why Spring containers are called **IOC containers**.

---

## Dependency Management Using Spring Framework

### 1. Dependency Lookup

- Using the **IOC container** supplied `getBean()` method, we can search and retrieve the desired dependent Spring bean class object.

### 2. Dependency Injection

- Spring supports various types of **Dependency Injection**:
  - **a. Setter Injection**
  - **b. Constructor Injection**
  - **c. Field Injection**
  - **d. Arbitrary Method Injection**
  - **e. Interface Injection / Aware Injection**
  - **f. Lookup Method Injection**
  - **g. Method Injection / Method Replacer**

# Creating IOC Container in Spring

In Spring, the IOC (Inversion of Control) container is required for Spring Bean lifecycle management and dependency management.

## Types of IOC Containers in Spring

Spring provides two types of IOC containers:

1. **BeanFactory IOC Container**
2. **ApplicationContext IOC Container**

`ApplicationContext` is an enhanced version of the `BeanFactory` IOC container.

### Spring's IOC Containers are Lightweight

Spring's IOC containers are lightweight because we can create them in any kind of Java application by simply creating an object of Spring's API-supplied pre-defined classes.

### Creating a BeanFactory IOC Container

To create a **BeanFactory IOC Container**, we need to instantiate a class that implements `org.springframework.beans.factory.BeanFactory` (either directly or indirectly). 

**Package:** `org.springframework.beans.factory`  
**Interface:** `BeanFactory`  

#### Known Subinterfaces:
- `ApplicationContext`
- `AutowireCapableBeanFactory`
- `ConfigurableApplicationContext`
- `ConfigurableBeanFactory`
- `ConfigurableListableBeanFactory`
- `ConfigurableWebApplicationContext`
- `HierarchicalBeanFactory`
- `ListableBeanFactory`
- `WebApplicationContext`

#### Known Implementing Classes:
- `AbstractApplicationContext`
- `AbstractAutowireCapableBeanFactory`
- `AbstractBeanFactory`
- `AbstractRefreshableApplicationContext`
- `AbstractRefreshableConfigApplicationContext`
- `AbstractRefreshableWebApplicationContext`
- `AbstractXmlApplicationContext`
- `AnnotationConfigApplicationContext`
- `AnnotationConfigWebApplicationContext`
- `ClassPathXmlApplicationContext`
- `DefaultListableBeanFactory`
- `FileSystemXmlApplicationContext`
- `GenericApplicationContext`
- `GenericGroovyApplicationContext`
- `GenericWebApplicationContext`
- `GenericXmlApplicationContext`
- `GroovyWebApplicationContext`
- `SimpleJndiBeanFactory`
- `StaticApplicationContext`
- `StaticListableBeanFactory`
- `StaticWebApplicationContext`
- `XmlWebApplicationContext`

### Preferred Classes to Create a BeanFactory IOC Container

- **Package:** `org.springframework.web.context.support`  
  **Class:** `XmlWebApplicationContext`

- **Package:** `org.springframework.beans.factory.support`  
  **Class:** `DefaultListableBeanFactory`

### Industry Standard IOC Container

The industry-standard IOC container is the `ApplicationContext` container.

### Differences Between BeanFactory and ApplicationContext

Both **BeanFactory** and **ApplicationContext** containers support all modes of dependency management. However, the `ApplicationContext` container offers additional features such as:
- Support for annotations-driven configurations
- Internationalization (I18n) support (makes the application work for different locales, including languages and countries)

# Spring Framework: ApplicationContext IOC Container

To create an "ApplicationContext" IOC Container, you need to create an object of one of the Spring API-supplied pre-defined classes that implement `org.springframework.context.ApplicationContext`.

### Package: `org.springframework.context`

#### Interface: `ApplicationContext`

The `ApplicationContext` interface extends several other important interfaces:

- `ApplicationEventPublisher`
- `BeanFactory`
- `EnvironmentCapable`
- `HierarchicalBeanFactory`
- `ListableBeanFactory`
- `MessageSource`
- `ResourceLoader`
- `ResourcePatternResolver`

#### All Known Subinterfaces:
- `ConfigurableApplicationContext`
- `ConfigurableWebApplicationContext`
- `WebApplicationContext`

#### All Known Implementing Classes:
- `AbstractApplicationContext`
- `AbstractRefreshableApplicationContext`
- `AbstractRefreshableConfigApplicationContext`
- `AbstractRefreshableWebApplicationContext`
- `AbstractXmlApplicationContext`
- `AnnotationConfigApplicationContext`
- `AnnotationConfigWebApplicationContext`
- `ClassPathXmlApplicationContext`
- `FileSystemXmlApplicationContext`
- `GenericApplicationContext`
- `GenericGroovyApplicationContext`
- `GenericWebApplicationContext`
- `GenericXmlApplicationContext`
- `GroovyWebApplicationContext`
- `StaticApplicationContext`
- `StaticWebApplicationContext`
- `XmlWebApplicationContext`

### Important Implementation Classes:
1. `org.springframework.context.support.FileSystemXmlApplicationContext`
2. `org.springframework.web.context.support.XmlWebApplicationContext`
3. `org.springframework.web.context.support.AnnotationConfigWebApplicationContext`

### Sample Code to Create "ApplicationContext" Container:

In any Java application:

```java
FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(".../applicationContext.xml");
```

# Spring Bean Configuration File

### Spring Bean Configuration File

- Any `<filename>.xml` can be used as the Spring bean configuration file name.
- The standard/recommended name is `applicationContext.xml`.

Using this file, we can provide input and instructions to the IOC container that is being created. The configuration file allows you to:

- Configure Java classes as Spring beans
- Specify the mode of dependency injections
- Configure the Spring bean lifecycle
- And more...

### Different Ways of Developing Spring Applications

1. **Using XML-driven Configurations**  
   - The instructions to the IOC container are given **only** using the XML configuration file.

2. **Using XML + Annotation-driven Configurations**  
   - The instructions to the IOC container are given using both **annotations** and **XML file**.

3. **Using 100% Code-driven Configuration (Java Config Approach)**  
   - The instructions to the IOC container are given using **annotations** and **Java code statements**.

4. **Using Spring Boot-driven Configurations**  
   - The instructions to the IOC container are provided using **annotations**, **Java statements**, **properties files**, **YAML files**, etc.

### `ApplicationContext` as a Subinterface of `BeanFactory`

```plaintext
org.springframework.beans.factory.BeanFactory
          ^
          |
          | extends
org.springframework.beans.factory.ListableBeanFactory
          ^
          | extends
          |
org.springframework.beans.factory.ApplicationContext
```
# Thumb Rules for Developing Spring Apps Using XML + Annotation Driven Configurations (Approach 2)

1. **Configure Pre-defined Java Classes as Spring Beans Using `<bean>` Tags in Spring Bean Configuration File (XML)**  
   - This is necessary because we cannot add annotations like `@Component` to pre-defined classes when we don't have access to their source code.

   Example in `applicationContext.xml` (Spring Bean Configuration File):

```xml
   <bean id="dt" class="java.util.Date"/>
```
2. **Configuring User-defined Java Classes as Spring Beans Using `@Component` Annotation

To configure user-defined Java classes as Spring Beans, you can use the `@Component` annotation directly in the `.java` file. The `@Component` annotation should be placed at the top of the class definition to indicate that the class is a Spring Bean. This allows Spring's component scanning to automatically detect and register the class as a Spring Bean in the IOC container.

### Example:

```java
@Component("wmg")
public class WishMessageGenerator {
    // Class implementation
    public String generateWishMessage(String name) {
        return "Hello, " + name + "!";
    }
}
```
3. **Enabling Component Scanning Using `<context:component-scan>` Tag in Spring XML Configuration

To enable Spring's component scanning feature, you need to add the `<context:component-scan>` tag in your Spring bean configuration XML file. This tag instructs the Spring IOC container to scan the specified packages and automatically register any classes annotated with `@Component`, `@Repository`, `@Service`, `@Controller`, etc., as Spring Beans.

### Example:

```xml
<context:component-scan base-package="com.example"/>
```
# Spring Bean Configuration and Factory Methods

## Component Scan in Spring

To configure the Spring IOC container to search for beans:

```xml
<context:component-scan base-package="com.example.dao,com.example.service"/>
```

or

```xml
<context:component-scan base-package="com.example"/>
```

The IOC container will search in the specified package(s) and their subpackages for classes annotated with `@Component` to register them as Spring beans.

## Creating the IOC Container in the `main` Method

Example:

```java
public class ClientApp {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("../applicationContext.xml");
        // Use the context to retrieve beans
    }
}
```

## Factory Methods

A **Factory Method** is a method in a class that creates and returns an object of its own class or a related/different class.

### Types of Factory Methods:

1. **Static Factory Method**: Can be called on the class name.
2. **Non-Static Factory Method / Instance Factory Method**: Must be called on an object.

### Examples of Static Factory Methods

#### Example 1:
```java
Thread t = Thread.currentThread(); // Returns its own class object
```

#### Example 2:
```java
Calendar cal = Calendar.getInstance(); // Returns a related class object (GregorianCalendar)
```

#### Example 3:
```java
Properties props = System.getProperties();
```

### Examples of Non-Static Factory Methods

#### Example 1:
```java
String s1 = new String("hello");
String s2 = s1.concat("123"); // Returns its own class object "hello123"
```

## Creating Spring Bean Objects Using Factory Methods

### Methods to Create Spring Beans:

1. **Using Constructor** (Default `<bean>` tag)
2. **Using Static Factory Method** (`<bean>` tag with `factory-method` attribute)
3. **Using Instance Factory Method** (`<bean>` tag with `factory-method` and `factory-bean` attributes)

### Examples

#### Example 1: Constructor
```xml
<bean id="dt" class="java.util.Date"/>
```
This creates a `java.util.Date` class object using its no-argument constructor.

#### Example 2: Static Factory Method
```xml
<bean id="ldt" class="java.time.LocalDateTime" factory-method="now"/>
```
This calls `LocalDateTime.now()` to create and return a `LocalDateTime` object with the system's current date and time.

#### Example 3: Constructor with Arguments
```xml
<bean id="sb" class="java.lang.StringBuffer">
    <constructor-arg value="hello, how are you"/>
</bean>
```
This creates a `StringBuffer` object with the value "hello, how are you".

Equivalent Java code:
```java
StringBuffer sb = new StringBuffer("hello, how are you");
```

#### Example 4: Instance Factory Method
```xml
<bean id="s1" factory-bean="sb" factory-method="substring">
    <constructor-arg value="0"/>
    <constructor-arg value="5"/>
</bean>
```
This calls the `substring` method of the `StringBuffer` bean `sb` and returns a `String` object with the value "hello".

Equivalent Java code:
```java
String s1 = sb.substring(0, 5);
```
# Notes on `<constructor-arg>` in Spring

The `<constructor-arg>` tag in Spring can be used in two primary ways:

### a) To Provide Constructor Argument Values for Parameterized Constructors (**)
This approach is used to supply values for parameters of a constructor when creating an object of a Spring bean class using a parameterized constructor.

**Example:**
```xml
<bean id="exampleBean" class="com.example.ExampleClass">
    <constructor-arg name="param1" value="value1" />
    <constructor-arg name="param2" value="value2" />
</bean>
```

In this case, Spring will call the parameterized constructor of `ExampleClass` with the specified arguments `value1` and `value2`.

---

### b) To Pass Factory Method Values While Using Factory Method Bean Instantiation (***):
This approach is used to pass values to a factory method while creating an object of a Spring bean class through the factory method instantiation process.

**Example:**
```xml
<bean id="factoryBean" class="com.example.FactoryClass" factory-method="createInstance">
    <constructor-arg name="factoryParam" value="factoryValue" />
</bean>
```

Here, Spring will call the static or instance factory method `createInstance` of `FactoryClass` with the argument `factoryValue` to create the bean object.

---
