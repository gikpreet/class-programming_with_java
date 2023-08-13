# Lab 15-1 Annotation 적용과 사용
이 연습에서는 Java Annotation 적용 후 프로그램의 빌드와 동작과정에서의 영향을 알아봅니다.

## 연습 1: @Override Annotation 사용
이 연습에서는 @Override Annotation의 사용법에 대해 연습합니다.

**Person 클래스 확인**
1. Labs 폴더의 Lab13-1/Starter/Exercise1 디렉토리에서 내용을 확인합니다.
2. Labs13-1/Starter/Exercise1 디렉토리를 Visual Studio Code에서 엽니다.
3. **작성자 신뢰 경고** 창에서, **예, 작성자를 신뢰합니다.** 버튼을 클릭합니다.
4. Visual Studio Code 탐색기에서 Person.java 파일을 엽니다.
5. Visual Studio Code 탐색기에서 OverrideExample.java 파일을 엽니다.
6. jason과 celine 두 객체가 생성되어 서로 인사하는 코드를 확인합니다.
```java
public static void main(String [] args) {
    Person jason = new Man("jason");
    Person celine = new Woman("celine");

    jason.hey(celine);
    celine.hey(jason);
}
```
7. 아래 명령을 수행하여 프로그램을 컴파일 합니다.

**객체의 성별 출력**
1. Visual Studio Code 탐색기에서 OverrideExample.java 파일을 엽니다.
2. main 함수에서 성별을 체크하는 코드를 작성합니다. 코드는 아래와 같을 것입니다.
```java
System.out.println(jason.getGender());
System.out.println(celine.getGender());
```
3. 아래 명령을 수행하여 프로그램을 컴파일합니다.
```bash
$ javac *.java
```

**오류 찾기**
1. Visual Studio Code 탐색기에서 Person.java 파일을 열고 getGender 메소드를 확인합니다. 
```java
public String getGender() { return null; };
```
2. Visual Studio Code 탐색기에서 Woman.java 파일을 열고 getGender 메소드가 Person 클래스의 getGender 메소드를 오버라이드 하는 것을 확인합니다.
```java
@Override
public String getGender() {
    return "Woman";
}
```
3.	Visual Studio Code 탐색기에서 Man.java 파일을 열고 Person 클래스의 getGender 메소드를 오버라이드하는 메소드가 없음을 확인합니다.
4.	getGeder 메소드에 @Override 어노테이션을 적용합니다.
```java
@Override
public String getGeder() {
    return "Man";
}
```
5.	아래 명령을 수행하여 프로그램을 컴파일하고 오류를 확인합니다.
```bash
$ javac OverrideExample.java
.\Man.java:6: error: method does not override or implement a method from a supertype
    @Override
    ^
1 error
```

**@Override 어노테이션 적용**
1.	Man 클래스의 getGeder 메소드의 이름을 getGender로 변경합니다.
```java
@Override
public String getGender() {
    return "Man";
}
```
2.	아래 명령을 수행하여 프로그램을 컴파일합니다.
```bash
$ javac OverrideExample.java
```
3.	아래 명령을 수행하여 프로그램을 실행하고 결과를 확인합니다.
```bash
$ java OverrideExample      
Hey, celine
Hey, jason
Man
Woman
```

## 연습 2: @Deprecated와 @SuppressWarning Annotation 사용
이 연습에서는 @Deprecated와 @SuppressWarning Annotation의 기능을 알아봅니다.

**Person 클래스 확인**
1. Labs 폴더의 Lab13-1/Starter/Exercise1 디렉토리에서 내용을 확인합니다.
2. Labs13-1/Starter/Exercise1 디렉토리를 Visual Studio Code에서 엽니다.
3. **작성자 신뢰 경고** 창에서, **예, 작성자를 신뢰합니다.** 버튼을 클릭합니다.
4.	Visual Studio Code 탐색기에서 DeprecatedExample.java 파일을 열고 DeprecatedExample 클래스를 확인합니다.
5.	main 메소드 정의된 두 Person 타입 객체의 동작을 확인합니다.
```java
public static void main(String [] args) {
    Person steve = new Person("steve");
    Person jackson = new Person("jackson");

    steve.hey(jackson);
    jackson.hey(steve);
}
```
6. 아래 명령을 수행하여 프로그램을 컴파일 합니다.
```bash
$ javac *.java
```
7. 아래 명령을 수행하여 프로그램을 실행합니다.
```bash
$ java DeprecatedExample
Hey, celine
Hey, jason
```

이 프로그램에서는 Hey 메소드를 삭제하고 Hello 메소드로 변경하려 합니다. Hey 메소드를 여러 프로그램에서 사용하고 있어 기존 버전과의 호환을 위해 남겨두고 곧 제거됨을 알립니다.

**새로운 메소드 추가와 @Deprecated 어노테이션 추가**
1. Visual Studio Code 탐색기에서 Person.java 파일을 엽니다.
2. Person 클래스에 hello 메소드를 추가합니다.
```java
public void hello(Person person) {
    System.out.println("Hello, " + person.getName());
}
```
3.	hey 메소드는 곧 제거됨을 알리는 @Deprecated 어노테이션을 추가합니다. 코드는 아래와 유사할 것입니다.
```java
@Deprecated
public void hey(Person person) {
    System.out.println("Hey, " + person.getName());
}
```
4.	아래 명령을 실행하여 프로그램을 컴파일하고 경고를 확인합니다.
```bash
$ javac *.java
Note: DeprecatedExample.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```
5.	아래 명령을 수행하여 프로그램을 실행합니다.
```bash
$ java DeprecatedExample
Hey, celine
Hey, jason
```
6.	아래 명령을 실행하여 자세한 컴파일 정보를 확인합니다.
```bash
$ javac -Xlint:deprecation *.java
DeprecatedExample.java:6: warning: [deprecation] hey(Person) in Person has been deprecated
        jason.hey(celine);
             ^
DeprecatedExample.java:7: warning: [deprecation] hey(Person) in Person has been deprecated
        celine.hey(jason);
              ^
2 warnings
```

**경고 메시지 무시**
1. Visual Studio Code 탐색기에서 DeprecatedExample.java 파일을 엽니다.
2. main 메소드에 @SuppressWarnings 어노테이션을 추가하고, deprecation 메시지 경고를 발생하지 않도록 지정합니다. 
```java
@SuppressWarnings({"deprecation"})
public static void main(String [] args) {
    Person jason = new Person("jason");
    Person celine = new Person("celine");

    jason.hey(celine);
    celine.hey(jason);
}
```
3.	아래 명령을 실행하여 프로그램을 컴파일하고 경고가 발생하지 않는 것을 확인합니다.
```bash
> javac *.java
```



