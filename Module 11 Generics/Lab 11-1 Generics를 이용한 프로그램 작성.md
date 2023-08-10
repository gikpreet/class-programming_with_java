# Lab 11-1 Generics를 이용한 응용 프로그램 작성

## 연습 1 일반 클래스를 Generic 클래스로 변경

이 연습에서는 Generics를 이용해 클래스를 선언하고, 실제 코드에서 사용하는 것을 연습합니다. 아래 절차에 따릅니다.

**데이터를 저장할 수 있는 Box 클래스 생성**
1. Labs 폴더의 Lab11-1/Starter 디렉토리에서 내용을 확인합니다.
2. Labs11-1/Starter 디렉토리를 Visual Studio에서 엽니다.
3. **작성자 신뢰 경고** 창에서, **예, 작성자를 신뢰합니다.** 버튼을 클릭합니다.
4. Visual Studio 탐색기에서 GenericBoxExample.java 파일을 엽니다.
5. Box 클래스를 확인합니다.
6. 아래 명령을 수행하여 GenericBoxExample.java 파일을 컴파일합니다.
```bash
$ javac GenericBoxExample.java
```
7. 아래 명령을 수행하여 프로그램을 실행합니다.
```bash
$ java GenericBoxExample.java
box has 1
```

**정수 Box 클래스를 GenerixBox 클래스로 변경**
1. Box 클래스의 이름 뒤에 T 형식의 타입 파라미터를 추가합니다.
2. Box 클래스의 Integer를 모두 T 형식으로 변경합니다.
3. 완성된 코드는 아래와 유사할 것입니다.
```java
public class Box<T> {
    String name;
    T value;

    Box(String name) {
        this.name = name;
    }

    public String getName() {
       return this.name;
    }
    public void setValue(T value) {
        this.value = value;
    }

     public T getValue() {
        return this.value;
    }
}
```
4. GenericBoxExample 클래스의 run 메소드에서, Box 클래스를 생성하는 코드에 Generic 파라미터를 적용합니다.
```java
Box<Integer> box1 = new Box<Integer>("box 1");
```
5. 아래 명령을 수행하여 GenericBoxExample.java 파일을 컴파일합니다.
```bash
$ java GenrericBoxExample.java
```
6. 아래 명령을 수행하여 프로그램을 실행합니다.
```bash
$ java GenericBoxExample
box 1 has 1
```

## 연습 2 Generic 클래스 생성
이 연습에서는 Generics 클래스를 이용해 클래스를 선언하고 실제 코드에 적용합니다.

**데이터를 저장하는 Box 클래스 작성**
1. Labs 폴더의 Lab11-1/Starter 디렉토리에서 내용을 확인합니다.
2. Labs11-1/Starter 디렉토리를 Visual Studio에서 엽니다.
3. **작성자 신뢰 경고** 창에서, **예, 작성자를 신뢰합니다.** 버튼을 클릭합니다.
4. Visual Studio 탐색기에서 MultipleTypeParametersExample.java 파일을 엽니다.
5. Box 클래스를 확인합니다.
6. 아래 명령을 수행하여 MultipleTypeParametersExample.java 파일을 컴파일합니다.
```bash
$ MultipleTypeParametersExample.java
```
7. 아래 명령을 수행하여 프로그램을 실행합니다.
```bash
$ javac MultipleTypeParametersExample
box1 has 1
```

**단일 타입 파라미터를 두 개로 변경**
1. Box 클래스의 타입 파라미터 <T>를 타입 파라미터 2개의 <T, U>로 변경하고, name의 타입을 타입 파라미터 U로 변경합니다.
2. 수정된 Box 클래스는 아래와 유사할 것입니다.
```java
public class Box<T, U> {
    U name;
    T value;

    Box(U name) {
        this.name = name;
    }

    public U getName() {
        return this.name;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
       return this.value;
    }
}
```
3. MultipleTypeParametersExample 클래스의 run 메소드에서, Box 클래스 생성 타입 파라미터를 <Integer, String>으로 변경합니다.
```java
Box<Integer, String> box1 = new Box<>("box1");
```
4. 아래 명령을 수행하여 MultipleTypeParametersExample.java 파일을 컴파일합니다.
```bash
$ javac MultipleTypeParametersExample.java
```
5. 아래 명령을 수행하여 MultipleTypeParametersExample 프로그램을 실행합니다.
```bash
$ java MultipleTypeParametersExample
box has 1;
```
6. Box 클래스의 run 메소드에서, Box 클래스의 U 타입 파라미터를 Interger로 변경하고, 생성자 파라미터를 1로 변경합니다.
```java
Box<Integer, Integer> box 1 = new Box<>(1);
```
7. 아래 명령을 수행하여 MultipleTypeParametersExample.java 파일을 컴파일합니다.
```bash
$ javac MultipleTypeParametersExample.java
```
5. 아래 명령을 수행하여 MultipleTypeParametersExample 프로그램을 실행합니다.
```bash
$ java MultipleTypeParametersExample
1 has 1;
```

## 연습 3 경계 유형 클래스 생성
이 연습에서는 Generic 클래스를 정의하여 클래스에서 사용될 타입 파라미터를 특정 타입으로 제한합니다.

**데이터를 저장하는 Box 클래스 생성**
1. Labs 폴더의 Lab11-1/Starter 디렉토리에서 내용을 확인합니다.
2. Labs11-1/Starter 디렉토리를 Visual Studio에서 엽니다.
3. **작성자 신뢰 경고** 창에서, **예, 작성자를 신뢰합니다.** 버튼을 클릭합니다.
4. Visual Studio 탐색기에서 BoundedGenericBoxExample.java 파일을 엽니다.
5. Box 클래스를 확인합니다.
6. 아래 명령을 수행하여 BoundedGenericBoxExample.java 파일을 컴파일 합니다.
```bash
$ javac BoundedGenericBoxExample.java
```
7. 아래 명령을 수행하여 프로그램을 실행합니다.
```bash
$ java BoundedGenericBoxExample
box1 has 1
box2 has Hello
```

**타입 파라미터를 숫자로 제한**
1. Box 클래스에서, Box<T>의 타입 파라미터를 숫자로 제한하도록 변경합니다.
2. 수정한 코드는 아래와 유사할 것입니다.
```java
public class Box<T extends Number> {
    String name;
    T value;

    Box(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
```
3. 작업을 저장합니다.
4. 아래 명령을 수행하여 프로그램을 컴파일하고 오류를 확인합니다.
```bash
$ javac BoundedGenericBoxExample.java
BoundedGenericBoxExample.java:25: error: type argument String is not within bounds of type-variable T
        Box<String> box2 = new Box<String>("box2");
            ^
  where T is a type-variable:
    T extends Number declared in class BoundedGenericBoxExample.Box
BoundedGenericBoxExample.java:25: error: type argument String is not within bounds of type-variable T
        Box<String> box2 = new Box<String>("box2");
                                   ^
  where T is a type-variable:
    T extends Number declared in class BoundedGenericBoxExample.Box
2 errors
```
5. BoundedGenericBoxExample 클래스의 run 메소드에서, String 타입 파라미터를 Double로 변경하고, box2 객체의 setValue 메소드의 파라미터를 Double 값으로 변경합니다.
```java
public void run() {
    Box<Integer> box1 = new Box<Integer>("box1");
    Box<Double> box2 = new Box<Double>("box2");

    box1.setValue(1);
    box2.setValue(3.2);
    System.out.println("Box1 has " + box1.getValue());
    System.out.println("Box2 has " + box2.getValue());
}
```
6. 아래 명령을 수행하여 BoundedGenericBoxExample.java 파일을 컴파일합니다.
```bash
> javac BoundedGenericBoxExample.java
```
7. 아래 명령을 수행하여 프로그램을 실행합니다.
```bash
> java BoundedGenericBoxExample
box1 has 1
box2 has 3.2
```
