# Difference Between Pool and Cache

## Pool
A pool is a set of the **same items**, providing reusability for those items.

- **Examples**: String constant pool, JDBC connection pool.
- To implement a pool, the support of a **List collection** is used.
- A **popular example** of a pool is the **JDBC connection pool**, which is a factory containing a set of readily available JDBC connection objects.

### Key Points:
- All JDBC connection objects in a JDBC connection pool represent connectivity to the **same database software**.
- **Example 1**: JDBC connection pool for **Oracle** means all the JDBC connection objects in that pool represent connectivity with the same Oracle database software.
- **Example 2**: JDBC connection pool for **MySQL** means all the JDBC connection objects in that pool represent connectivity with the same MySQL database software.

---

## Cache
A cache is a set of **different items**, providing reusability for those different items.

- **Examples**: IOC container cache, Servlet container cache.
- To implement a cache, the support of a **Map collection** is used.
- A **popular example** of a cache is the internal cache of the **IOC container** in Spring, where Spring bean class objects are maintained. The bean IDs are the **keys**, and the Spring bean class object references are the **values**.

### Code Example:
```java
Object bean = context.getBean("wmg");
Object bean1 = context.getBean("wmg");
System.out.println(bean.hashCode() + " " + bean1.hashCode());
System.out.println("obj == obj1: " + (bean == bean1));
```
# XML Document Construction Rules

## Techniques to Define XML Rules

We can define rules to construct XML documents using the following two techniques:

### a) DTD (Document Type Definition)
- **Old style (outdated)**: DTD is used to define the structure and the rules for XML documents.
  
### b) XSD (XML Schema Definition)
- **Current standard (running)**: XSD defines the structure, content, and rules of XML documents in a more advanced and flexible way than DTD.

By supplying XSD/DTD rules to developers, we ensure that all developers constructing XML documents use the same set of tags, attributes, and rules. To achieve this, all developers should import the XSD/DTD rules at the top of their XML documents.

## Spring Framework and XML Rules

The **Spring Framework** provides DTD/XSD rules in the form of `.dtd` and `.xsd` files, which are maintained in the Spring API JAR files. These rules ensure that developers follow the same tags, attributes, rules, and guidelines when creating Spring bean configuration files in different applications.

## Well-formed vs. Valid XML Documents

### Well-formed XML Document
- An XML document/file is considered **well-formed** if it satisfies the basic XML syntax rules.

### Valid XML Document
- An XML document/file is considered **valid** if it satisfies both the XML syntax rules and the imported DTD/XSD rules.

# XML Parser and Spring's IOC Container with Built-in XML Parser

## XML Parser Overview

An **XML Parser** is a software program/application that processes and loads XML files from storage (e.g., Hard Disk Drive). The parser performs the following tasks:

1. **Loads the XML file** into memory for further processing.
2. **Verifies the XML's Well-Formedness**: Ensures that the document follows the correct XML syntax (properly nested tags, correct quotes, etc.).
3. **Validates the XML**: Checks if the XML adheres to a defined schema (e.g., XSD - XML Schema Definition).
4. **Reads the XML content**: Extracts the data from the XML document.
5. **Prepares In-Memory Metadata**: Builds an in-memory structure (metadata) of the XML document that can be accessed and used efficiently within the application.

The XML parser is often used to improve performance by storing the XML document's content in memory (RAM) for quick access multiple times during the application's execution.

## XML Parsing in Spring's IOC Container

The **Spring Framework's Inversion of Control (IOC) Container** includes built-in support for XML parsing. Specifically, it uses **SAX Parser** (Simple API for XML) for reading XML configuration files.

- **SAX Parser** is an event-driven parser, which reads the XML document sequentially from top to bottom, triggering events when it encounters XML elements like start tags, end tags, and text content.
- The Spring IOC Container uses this parsing mechanism to read and process XML configuration files, allowing Spring to create and manage beans as per the XML-based configuration.

### Advantages of SAX Parser in Spring IOC

- **Memory Efficient**: Unlike DOM (Document Object Model) parsers, SAX does not load the entire document into memory. Instead, it processes the document in a sequential manner, which can be beneficial for large XML files.
- **Event-driven**: SAX processes XML data based on events such as element opening and closing, which makes it suitable for applications where you don't need to retain the entire XML structure in memory.

## Conclusion

In summary, an XML parser, like the one built into Spring’s IOC container, is an essential tool for efficiently reading, verifying, and processing XML data. The built-in **SAX parser** enables Spring applications to manage configurations defined in XML files in a memory-efficient and event-driven manner.

# IOC Container and Spring Bean Scopes

## Bean Scopes in Spring

The IOC container allows you to keep Spring bean class objects in different scopes. The default scope is **singleton** if no scope is specified.

### 1. Singleton Scope

- The **Singleton scope** means that the IOC container creates only one object for a Spring bean, irrespective of the number of times `ctx.getBean(-)` is called with the same bean ID.
  
### 2. BeanFactory IOC Container

- The **BeanFactory** IOC container performs **lazy/late instantiation** of Spring beans. This means that objects for Spring beans are created only when `getBean(-)` is called (i.e., objects are created on demand).
  
### 3. ApplicationContext IOC Container

- The **ApplicationContext** IOC container performs **eager/early/pre-instantiation** of singleton scope Spring beans. This means that the objects for singleton scope Spring beans are created the moment the IOC container is created, irrespective of whether `getBean(-)` is called or not.

