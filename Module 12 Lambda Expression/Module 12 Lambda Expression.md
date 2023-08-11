# Module 12 Lambda Expression
Lambda Expression은 메소드를 하나의 식(Expression)으로 표현할 수 있도록 하여, 함수를 간결하고 명확한 식으로 표현할 수 있게 해 주는 Java의 함수형 언어 지원입니다. 이 모듈에서는 Java의 Lambda Expression에 대해 학습합니다.
이 장을 마치면, 다음과 같은 것들을 할 수 있게 됩니다:
* Lambda Expression에 대해 이해하고 적용할 수 있습니다.
* Lambda Expression을 적용해 Java에서 함수형 프로그래밍 기법을 사용할 수 있습니다.

### Table of Contents
1. Lambda Expression 개요
2. Lambda Expression 형식
3. Lambda Expression 활용

<br />
<br />
<br />
<br />
<br />

## Lambda Expression 개요
Anonymous Method 형식으로 동작하는 Lambda Expression은 파라미터를 받아 짧은 코드 블록으로 수행하고 필요에 따라 값을 반환하는 표현 방법을 말합니다. 이 장에서는 Lambda Expression에 대해 공부합니다.

Table of Contents
1.	Funcational Interface
2.	Lambda Expression

<br />

### Funcational Interface
***
* 하나의 abstract method를 가지고 있는 인터페이스
    * SAM(Single Abstract Method) 인터페이스
* @FunctionalInterface 어노테이션이 적용될 수 있는 Target 인터페이스
* Java에서 함수를 객체처럼 다를 수 있도록 함

```java
@FunctionalInterface
public interface BinaryOp {
    public int apply(int right, int left);
}
```
***
Functional Interface는 단 하나의 abstract method를 가지고 있는 인터페이스를 말하며, SAM(Single Abstract Method) 인터페이스 라고도 부릅니다. 

```java
@FunctionalInterface
public interface BinaryOp {
    public int apply(int right, int left);
}
```

Funcational Interface의 자격은 단 하나의 abstract method를 가지는데 한합니다. static 클래스와 default 메소드의 존재는 인터페이스가 Funcational Interface로 취급되는데 영향을 미치지 않습니다.

```java
@FunctionalInterface
public interface RunSomething {
    void doIt();

static void printName(){
        System.out.println("catsbi");
    }
    
    default void printAge(){
        System.out.println("33");
    }
}
```
Functional Interface는 Java에서 함수를 객체처럼 다룰 수 있도록 합니다.
* 변수에 할당(Assignment) 할 수 있습니다.
* 다른 함수의 인자(Argument)로 전달받습니다.
* 다른 함수의 결과로서 return 될 수 있습니다.

<br />

### Anomymous Class
***
* 단 한번만 사용될 수 있고 하나의 객체만을 생성할 수 있는 일회용 클래스
* 클래스의 선언과 객체 생성을 동시에 수행
* Funcational Interface에 대한 Anomymous Class를 생성해 사용

```java
@FunctionalInterface
public interface BinaryOp {
    public int apply(int right, int left);
}

BinaryOp binder = new BinaryOp() {
    public int apply(int right, int left) {
        return right + left;
    }
};
```
***

Anomymous Method는 단 한번만 사용할 수 있고, 하나의 객체만을 생성할 수 있는 일회용 클래스입니다. Functional Interface는 익명, 내부 클래스를 사용하여 일회성을 생성하여 사용할 수 있습니다. 

```java
@FunctionalInterface
public interface RunSomething {
    void doIt();

static void printName(){
        System.out.println("catsbi");
    }
    
    default void printAge(){
        System.out.println("33");
    }
}
```

default 메소드와 static 메소드가 포함된 위와 같은 Internal Interface는 아래와 같이 anomymous method를 사용할 수 있습니다.

```java
RunSomething run = new RunSomething() {
    public void doIt() {
        System.out.print("Hello");
    }
};
```

<br />

### Lambda Expression
***
* 파라미터를 받아 짧은 코드 블록을 수행하고 필요에 따라 값을 return하는 표현 방법
* 메소드와 유사하지만 이름을 갖지 않으며 표현식에 사용할 수 있는 모든 곳에서 구현 가능
* Java 8 에서 추가

```java
@FunctionalInterface
public interface BinaryOp {
    public int apply(int right, int left);
}

BinaryOp binder = (i, j) -> i + j;
```
***

Lambda Expression은 Java 8에서 추가된, 파라미터를 받아 짧은 코드 블록을 수행하고 필요에 따라 값을 return하는 표현 방법입니다. 
메소드와 유사하지만 이름을 갖지 않으며, 표현식에 사용할 수 있는 모든 곳에서 구현 가능합니다.
```java
@FunctionalInterface
public interface RunSomething {
    void doIt();

    static void printName(){
        System.out.println("catsbi");
    }
    
    default void printAge(){
        System.out.println("33");
    }
}
```
default 메소드와 static 메소드가 포함된 위와 같은 함수형 인터페이스는 아래와 같이 람다 식을 사용하여 사용할 수 있습니다.
```java
RunSomething run = () -> System.out.println("Hello, World!");
```
아래와 같이 블록을 사용할 수 있습니다.
```java
RunSomething run2 = () -> {
    System.out.print("Hello,");
    System.out.println(" World!");
};
```

<br />
<br />
<br />
<br />
<br />

## Lambda Expression

Lambda Expression은 파라미터를 받아 짧은 코드 블록으로 실행할 수 있습니다. 이 장에서는 Lambda Experssion 표기 방법과 사용 방법을 알아봅니다.

### Table of Contents
1. Funcational Interface
2. Lambda Expression

<br />

### Lambda Expression 형식
***
* 파라미터 목록과 표현 식의 블록으로 선언
```java
(int I, int j, ...) -> (int x = a + b; ...)
```
* 파라미터 타입은 생략 가능
```java
(a, b, …) -> { int x = a + b; … }
```
* 파라미터가 하나인 경우, 괄호 생략 가능
```java
a -> { int x = a + b; … }
```
* 수행문이 하나이고, 지역 변수 선언 또는 return이 없는 경우 { } 생략 가능
```java
(Task task) -> task.run()
```
* 괄호가 생략된 수행문에 return 키워드가 포함되어 있을 경우 return 생략 가능
```java
(a, b) -> a + b
```
* 가장 단순한 형태
```java
x -> x
```
***

Lambda Expression은 파라미터 목록과 짧은 코드 블록으로 구성됩니다. Lambda Expression의 기본 블록은 아래와 같습니다.

<img src="images/image01.png" />  

```java
(int a) -> { return a + a; }
(int a, int b) -> { int temp = a * b; System.out.println(temp); }
() -> { System.out.println(“Hello World!”); return 0; }
```

**파라미터 데이터 타입 생략 가능**
Lambda Expression에서는 파라미터 타입을 생략할 수 있습니다.

<img src="images/image02.png" />

```java
(a, b) -> { return a + b; }
(x) -> { return x * x * x; }
```

**파라미터가 하나인 경우 괄호 생략 가능**
파라미터가 하나인 경우 파라미터 목록에 괄호를 생략할 수 있습니다.

<img src="images/image03.png" />

**단일 수행문 적용시 블록 제거 가능**
Lambda Expression 수행문 블록 내에 수행문이 하나일 경우, 제한적으로 불록 구성을 위한 괄호 제거가 가능합니다. 제안 요건은 다음과 같습니다.
* 지역 변수 선언이 없음
* return 키워드가 없음

<img src="images/image04.png" />

```java
x -> return x * x * x:    	// 사용 불가 
x -> { return x * x * x: } 	// 사용 가능
```

**결과를 반환하는 단일문은 괄효와 return 생략 가능**
단일 수행문이면서 결과를 반환해야 할 경우, 괄호와 return문을 생략할 수 있습니다.

<img src="images/image05.png" />
```java
x -> x * x * x
() -> Math.random()
```
return만 생략할 경우, return 값이 없는 수행문으로 처리됩니다.

```java
x -> { x * x * x;}
```
가장 단순한 형태로 아래와 같이 쓸 수 있습니다.

<img src="images/image06.png" />

<br />
<br />
<br />
<br />
<br />

