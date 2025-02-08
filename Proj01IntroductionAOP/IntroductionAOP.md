# Spring AOP: Aspect-Oriented Programming

## What is AOP?

- **AOP** (Aspect-Oriented Programming) is not meant to compete with OOP (Object-Oriented Programming). 
- Instead, it complements OOP by addressing the limitations of OOP in certain scenarios.
- AOP is a methodology to solve problems related to OOP by providing an additional abstraction layer on top of OOP.

## Primary and Secondary Logic in AOP

- **Primary Logic**: These are the core, mandatory logics that are required for the task or activity in your application. For example:
  - Transfer money logic
  - Withdraw money logic
  - Check account balance logic
  - Closing account logic
  - KYC verification logic
  - Change transaction password logic

- **Secondary Logic**: These are optional, configurable logics that can be enabled or disabled according to requirements. For example:
  - Auditing
  - Logging
  - Transaction management
  - Security
  - Performance monitoring

### In OOP Style

In the OOP approach, the service methods or business methods of a class contain both primary and secondary logic together, which leads to the following challenges:

### Example of Mixed Primary and Secondary Logic:

```java
public class BankServiceImpl implements BankService {

    public String withdraw(String accNo, float withdrawAmount) {
        // Secondary logics
        // Security logics (Authentication + Authorization)
        // Logging
        // Auditing

        // Primary logic
        if (accBalance < withdrawAmount) {
            System.out.println("Insufficient funds..");
        } else {
            // Withdraw logic
            accBalance = accBalance - withdrawAmount;
        }

        return "Withdraw successfully";
    }

    public String deposit(String accNo, float depositAmount) {
        // Secondary logics
        // Security logics (Authentication + Authorization)
        // Logging
        // Auditing

        // Primary logic
        if (accBalance < depositAmount) {
            System.out.println("Insufficient funds..");
        } else {
            // Deposit logic
            accBalance = accBalance + depositAmount;
        }

        return "Deposit successfully";
    }
}
```
- Note :: Secondary logic are called middleware service or aspects or cross cutting concerns

## Limitations of OOP Style Programming

1. **Code becomes very clumsy** because it contains both primary and secondary logics mixed together.
2. **No reusability** of secondary logic can be achieved (kills modularity).
3. **Reduces readability** of the code.
4. **Debugging becomes very tough**.
5. **We cannot disable or enable the secondary logic** by our choice without touching the source code.
6. This style **does not suit very complex medium-scale apps or large-scale applications** (this is not an industry standard).

## Solution: AOP (Aspect-Oriented Programming)

To overcome the above problems, **AOP** programming can be used. It suggests:

- **Separate secondary logic from primary logic** at the time of application/project development.
- **Mix them together dynamically at runtime** as needed.

AOP is supported by frameworks such as:
- Spring AOP
- AspectJ AOP
- JBoss AOP
- and others.
