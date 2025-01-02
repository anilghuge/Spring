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

day 14:58:43