

#  Constructors in Java

In Java, a **constructor** is a special method that initializes new objects. It’s called automatically when an object is created and sets up initial values for the object’s properties. Constructors have the same name as the class and no return type, not even `void`.

## Types of Constructors

1. **Default Constructor**: Automatically provided by Java if no other constructor is defined. It doesn’t take any parameters.
2. **Parameterized Constructor**: A constructor that accepts parameters to initialize an object with custom values.
3. **Copy Constructor**: Used to create a new object as a copy of an existing object.
4. **Shallow Copy and Deep Copy Constructors**: Constructors that create copies of objects, either shallow (copying references) or deep (copying actual values).

---

### 1. Default Constructor

A default constructor has no parameters and initializes objects with default values (e.g., `0` for integers, `null` for objects).

```java
class DefaultExample {
    int number;
    
    // Default Constructor
    public DefaultExample() {
        number = 10; // Initialize with a default value
    }
    
    public void display() {
        System.out.println("Number: " + number);
    }
}

public class Main {
    public static void main(String[] args) {
        DefaultExample example = new DefaultExample();
        example.display();
    }
}
```

**Output:**
```
Number: 10
```

### 2. Parameterized Constructor

A parameterized constructor accepts parameters and initializes fields with custom values.

```java
class ParameterizedExample {
    int number;
    
    // Parameterized Constructor
    public ParameterizedExample(int num) {
        this.number = num;
    }
    
    public void display() {
        System.out.println("Number: " + number);
    }
}

public class Main {
    public static void main(String[] args) {
        ParameterizedExample example = new ParameterizedExample(25);
        example.display();
    }
}
```

**Output:**
```
Number: 25
```

### 3. Copy Constructor

Java doesn’t have a built-in copy constructor, but we can create one by passing an object as a parameter and copying its properties.

```java
class CopyExample {
    int number;
    
    // Parameterized Constructor
    public CopyExample(int num) {
        this.number = num;
    }
    
    // Copy Constructor
    public CopyExample(CopyExample obj) {
        this.number = obj.number;
    }
    
    public void display() {
        System.out.println("Number: " + number);
    }
}

public class Main {
    public static void main(String[] args) {
        CopyExample original = new CopyExample(30);
        CopyExample copy = new CopyExample(original); // Creating a copy
        copy.display();
    }
}
```

**Output:**
```
Number: 30
```

---

## Shallow Copy vs. Deep Copy

- **Shallow Copy**: Creates a new object but copies references to other objects rather than creating separate copies. Changes in one object affect the other.
- **Deep Copy**: Creates a new object with copies of all referenced objects, fully isolating changes between copies.

```java
class ShallowDeepExample {
    int[] numbers;
    
    // Constructor for Deep Copy
    public ShallowDeepExample(int[] nums) {
        // Deep Copy using a new array
        this.numbers = nums.clone(); // Deep copy
    }

    // Constructor for Shallow Copy
    public ShallowDeepExample(ShallowDeepExample obj) {
        this.numbers = obj.numbers; // Shallow copy
    }
    
    public void display() {
        System.out.print("Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShallowDeepExample deepExample = new ShallowDeepExample(nums);
        ShallowDeepExample shallowExample = new ShallowDeepExample(deepExample); // Shallow copy
        
        nums[0] = 10; // Modify the original array
        
        System.out.println("Deep Copy:");
        deepExample.display();
        
        System.out.println("Shallow Copy:");
        shallowExample.display();
    }
}
```

**Output:**
```
Deep Copy:
Numbers: 1 2 3 
Shallow Copy:
Numbers: 10 2 3 
```



## Destructors in Java

Java does not have destructors like C++ because it has automatic garbage collection to manage memory. However, Java does have a `finalize()` method, which is called before an object is garbage collected. Note that `finalize()` is not recommended for general use because it is unreliable and has been deprecated.

---

### Summary

In this section, we covered:

1. **Default Constructor** - Initializes objects with default values.
2. **Parameterized Constructor** - Initializes objects with specific values.
3. **Copy Constructor** - Creates a new object as a copy of another.
4. **Shallow vs. Deep Copy** - Understanding the differences between references and actual copies.
5. **Lazy Initialization** - Creates objects only when needed to save resources.
6. **Destructors** - Java doesn’t have destructors due to automatic garbage collection.

Understanding constructors is crucial in creating well-initialized and efficient Java programs.