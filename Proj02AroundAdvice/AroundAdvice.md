# Spring Framework AOP Support

Spring Framework supports two AOP-enabled software:
- **Spring AOP**
- **Spring integrated AspectAOP**

Initially, AspectJAOP was not part of the Spring framework.

## AOP Style Programming in Spring Framework

We can do AOP-style programming in the Spring framework by following these approaches:
1. **Spring AOP declarative approach** (XML config)
2. **Spring AOP programming approach** (no XML files)
3. **Spring AOP 100% Java code-driven approach**
4. **Spring Boot AOP Approach**

## Spring AOP Declarative Approach (using XML Configuration File)

The declarative approach supports all four types of Advice:
1. **BeforeAdvice**
2. **AfterAdvice**
3. **AroundAdvice**
4. **ThrowsAdvice**

### 1. AfterAdvice

This Advice executes around the target method (i.e., it executes before entering the business method and after executing the business method).

To develop this advice class (AroundAdvice), the class must implement the interface:

```java
org.aopalliance.intercept.MethodInterceptor

public class PerformanceMonitoringAdvice implements MethodInterceptor{

	Public Object invoke(MethodInvocation invocation){
		long startTime=System.currentTimeMillis();
		Object invocationValue=invocation.proceed();
		long endTime=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName());
		System.out.println("the target method/business method has taken "+(endTime-startTime)+"ms to complete the execution");
	 return invocationValue;
	}

}
```
## Explanation of MethodInvocation and AroundAdvice

- **MethodInvocation invocation**: The `MethodInvocation` object holds the target method details on which advice is applied.
  
- **startTime**: Pre-logic (executes before entering the target method call).
- **endTime**: Post-logic (executes after the complete execution of the target method).

### Use-Cases:
- Performance monitoring
- Caching
- Transaction management
- Around logging
- And more...

### Notes:
- Every **AroundAdvice** behaves like a servlet filter component to a servlet component/JSP.
- The client application gets the dynamically generated in-memory proxy class object and calls the target method. The overridden target method in the proxy class internally calls the `invoke()` method of our created **Advice** class object to apply secondary logic around the target method execution.

### Important Points:
- In the **Advice** logic placed in the `invoke()` method, we can access and modify the target method argument values.
- In the **Advice** logic placed in the `invoke()` method, we can access and modify the target method returning values.
- In the **Advice** logic placed in the `invoke()` method, we can control the target method execution.

### Note:
In real-time projects, AOP advice/aspects are applied on the service class methods, not on DAO class methods. This is because the service class method internally calls DAO class methods, so applying AOP advice/aspects on service class methods indirectly applies on DAO class methods.

---

## Procedure to Develop a Spring AOP Declarative Approach Application

1. **Develop Target Class/Service Class**:
   - Create the target method/business method with primary logic.

2. **Develop Aspects/Advice Classes**:
   - Create secondary logic in Aspect/Advice classes.

3. **Develop Spring Bean Configuration File**:
   1. Configure the target class as a Spring bean.
   2. Configure the advice/aspect class as a Spring bean.
   3. Configure the `ProxyFactoryBean` by injecting the target and advice class objects.

4. **Develop Client/Main Application**:
   1. Create the IOC container.
   2. Get the proxy class object from the IOC container by calling `getBean()` with the "proxyFactoryBean" class bean ID.
   3. Invoke your target or business method on the proxy class object.
   4. Close the IOC container.

### Note:
If `spring-context-<version>` is included as a dependency through Maven or Gradle, the `spring-aop-<version>.jar` file will be attached to your project automatically.

---

## AspectJAOP

### Limitations of Spring AOP:
1. Aspect/Advice classes are invasive (tightly coupled).
2. Does not support any annotations to make Spring beans as aspect or advice classes.
3. Spring AOP is less popular compared to AspectJAOP, which provides greater flexibility.
