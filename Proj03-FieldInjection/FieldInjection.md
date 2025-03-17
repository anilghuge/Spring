# Field Injection in Spring

## Key Points:
- for this we need to place @Autowrired on top HAS-A properties directly and no need to place any setter method and parameterozed constrcutor
- this support to place @Autowried on top mutiple HAS-A properties/fields at a time.
- IOC container gets the access to provide HAS-A properties using refelction api and completes the injection in those properties with out having support of any other
methods/constructors