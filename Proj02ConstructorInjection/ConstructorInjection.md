# Constructor Injection in Spring

Constructor Injection is a technique where the IOC (Inversion of Control) container uses the parameterized constructor of the target class. The dependent class object is passed as an argument to the constructor, and the IOC container injects this dependent class object to create the target class object.

## Key Points:
- The IOC container uses the parameterized constructor of the target class to inject the dependent class object.
- You can only place the `@Autowired` annotation on one parameterized constructor, as the IOC container uses only one constructor at a time.
- Placing `@Autowired` on multiple parameterized constructors will raise an exception.
- You can use `@Autowired` on multiple setter methods, fields, or arbitrary methods to perform respective injection on multiple properties.

## Example: WishMessageGenerator Class

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component("wmg")
public class WishMessageGenerator {

    private LocalDateTime localDateTime;

    @Autowired
    public WishMessageGenerator(LocalDateTime localDateTime) {
        System.out.println("WishMessageGenerator.WishMessageGenerator()");
        this.localDateTime = localDateTime;
    }

    public String getGeneratorMessage(String user) {
        System.out.println("WishMessageGenerator.getGeneratorMessage()");
        int hour = localDateTime.getHour();

        if (hour < 12)
            return "Good Morning :" + user;
        else if (hour < 16)
            return "Good Afternoon :" + user;
        else if (hour < 20)
            return "Good Evening :" + user;
        else
            return "Good Night :" + user;
    }
}
```

# Note on @Autowired and Constructor Injection

- **At max, we can place `@Autowired` annotation only on one parameterized constructor** in a Spring bean class. This is because the IOC (Inversion of Control) container uses only one parameterized constructor at a time to instantiate the target Spring bean object. 
- **Placing `@Autowired` on multiple parameterized constructors** will raise an exception, as the IOC container will not know which constructor to use for dependency injection.

### Example:
```java
@Component
public class MyBean {

    private DependencyA dependencyA;
    private DependencyB dependencyB;

    // Constructor 1
    @Autowired
    public MyBean(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }

    // Constructor 2 (Will raise an exception if @Autowired is placed here)
    @Autowired
    public MyBean(DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }
}
```
day 16:1 hr