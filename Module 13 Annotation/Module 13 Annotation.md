## Annotation
이 모듈에서는 프로그램을 작성하는 Java 언어의 일부는 아니지만, 프로그램 작성에 도움을 주는 Annotation에 대해 공부합니다
이 장을 마치면, 다음과 같은 것들을 할 수 있게 됩니다:
* Annotation으로 빌드 과정에서의 오류나 불필요한 경고를 줄일 수 있습니다.
* Annotation으로 도구에서 코드나 XML 파일을 자동 생성하게 할 수 있습니다.
* Annotation으로 실행 시 특정 기능을 수행하도록 설정할 수 있습니다.

### Table of Contents
1. Annotation 개요
2. 표준 Annotation
3. 메타 Annotation
4. Annotation 타입 정의

<br />
<br />
<br />
<br />
<br />

## Annotation 개요
Annotation은 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시켜 프로그램에 유용한 기능을 포함시키고 정보를 제공할 수 있는 기능입니다. 이 장에서는 Annotation에 대해 알아봅니다.

#### Table of Contents
1. Annotation 개요
2. Annotation 선언

<br />

### Annotation 개요
***
* 프로그램을 구성하는 직접적인 코드가 아님
* 프로그램 작성에 도움을 주거나 이에 필요한 기능을 제공
    * 컴파일러에 기능 제공
    * 도구 확장 기능
    * 실시간 처리
* 관점 지향 프로그래밍(AOP)의 Java 구현
***

**일반적인 어노테이션 사용**  
JavaDoc을 사용하여 프로그램을 설명하는 HTML 문서를 만들기 위해 주석을 사용합니다. JavaDoc에서는 설명이 필요한 변수, 메소드, 클래스등의 요소에 /** 로 시작하는 여러 줄 주석을 표시하고, 주석에 어노테이션을 추가하여 응용 프로그램을 설명하는 HTML 문서를 생성하여 공유할 수 있습니다.

```java
/**
 * @author NHN Academy
 * @version 1.0 2022-03-01
 */
public class Hello {
    /**
     * @param args 프로그램이 실행될 때 주어지는 인자값이 포함된 배열입니다
     */
    public static void main(String args[]) {
        System.out.println("Hello, Worlds!");
    }
}
```
JavaDoc에서 사용하는 주석안에는 @로 시작하는 어노테이션이 있습니다. 이 어노테이션은 작성자, 버전, 파라미터 인자등의 정보를 제공하고 JavaDoc은 어노테이션에 표시된 정보를 사용하여 문서를 생성합니다.

어노테이션은 주석처럼 프로그래밍 언어에 영향을 미치지 않으면서도 다른 프로그램에 유용한 정보를 제공할 수 있습니다.

**Aspect-Oriented Programming과 어노테이션**  
AOP라고 줄여서 부르는 관점 지향 프로그래밍은 객체지향 프로그래밍 기법으로 독립적으로 분리하기 어려운 부가 기능을 모듈화하는 방식입니다. 관점 지향이란 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어보고 그 관점을 기준으로 각각 모듈화 하겠다는 것을 의미합니다.

AOP에서 각 관점을 기준으로 로직을 모듈화 한다는 것은 코드들을 부분적으로 나누어서 모듈화 하겠다는 것을 의미합니다. 이때 소스 코드상에서 다른 부분에 계속 반복해서 쓰는 코드들을 발견할 수 있는데 이것들 흩어진 관심사(Crosscutting Concerns)라고 합니다.

<img src="images/image01.png" />
 
이런 흩어진 관심사를 Aspect로 모듈화하고 핵심적인 비즈니스 로직에서 분리하여 재 사용하겠다는 것이 AOP, 관점 지향 프로그래밍입니다.

Java에서는 이 흩어진 관심사(Crosscutting Concerns)을 하나로 묶어서 모듈화할 수 있습니다. 이렇게 모듈화된 관심사는 관심사가 필요한 대상(클래스, 메소드 등)의 Target에 적용할 수 있습니다. Java에서는 AspectJ, Spring AOP등이 유명합니다.

**AOP 주요 개념**  
* Aspect  
흩어진 관심사(Crosscutting concerns)를 묶어서 모듈화 한 것으로 Advice와 Point cut이 들어갑니다. Java에서 어노테이션으로 구체화합니다.
* Target  
Aspect가 가지고 있는 Advice가 적용되는 대상입니다. Java에서는 패키지, 클래스, 인터페이스, 메소드, 지역 변수, 타입 파라미터 등이 됩니다.
* Advice  
어떤 일을 해야할 지에 대한 것으로, 해야 할 일에 대한 정보를 가지고 있습니다.
* Join Point  
Advice가 적용될 위치, 끼어들 수 있는 지점, 생성자 호출 직전, 필드에 접근하기 전등의 메소드 실행 시점을 말합니다.
* Point cut  
Join Point의 상세한 스펙을 정의합니다. 어디에 적용해야 하는지에 대한 구체적인 정보를 가지고 있습니다.

Java에서는 Aspect를 어노테이션으로 만들어 클래스와 메소드 등의 Target에 적용할 수 있습니다. 어노테이션은 아래와 같은 방식으로 적용할 수 있습니다.
```java
@Component
@Aspect
public class PerfAspect {
    @Around("@annotation(PerfLogging)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }
}
```

<br />

### Annotation 선언
***
* @기호 다음에 이름을 붙여 Annotation을 지정
    * 각 요소의 선언부에 적용될 수 있음
    * 특정 키워드 앞에 선언될 수 있음
* 하나의 대상에 대해 중복 사용 가능
* 같은 Annotation을 반복해서 사용 가능
```java
@GPL(version="3")
package com.horstmann.corejava;

@Override
@Test
void myMethod() {...}

@SuppressWarnings(value = "unchecked")
void myMethod() {...}
```
***

Annotation은 @뒤에 Annotation 이름을 붙이는 형식으로 지정하며, 해당 요소에 값을 지정할 수 있습니다. Annotation은 각 요소의 선언부에 적용하며, 특정 키워드 앞에 선언될 수 있습니다.

```java
@Author (name = "Benjamin Franklin", 날짜 = "3/27/2003")
class MyCalss {
  ...
}
```

Annotation에 설정할 별도의 요소가 없는 경우 괄호를 생략할 수 있으며, 이를 Marker Annotation이라고 부릅니다.

```java
@Override
void myMethod() {...}
```

요소가 하나만 있는 어노테이션의 경우 요소의 이름과 = 기호를 생략할 수 있으며, 이를 단일값 어노테이션(single value annotation)이라고 부릅니다.

```java
@SuppressWarnings("unchecked")  //원래 @SuppressWarnings(value = "unchecked")
void myMethod() {...}
```

하나의 Target에서 여러 어노테이션을 사용할 수 있으며, 종류에 따라 반복 가능하다고 정의되어 있으면 동일한 어노테이션을 여러 번 반복해서 사용할 수 있습니다.
```java
@Test
@SuppressWarnings("unchecked")
public void myTest() {...}

@Customer(name="영희", cn=1021)
@Customer(name="철수", cn=1022)
public class CustomerList() { ... }
```

<br />
<br />
<br />
<br />
<br />

## Annotation Target
Annotation은 기본적으로 선언에 적용될 수 있습니다. 클래스, 필드, 메소드 및 기타 프로그램 요소의 선언에 적용될 수 있으며, Java 8부터 일부 Annotation이 구현부에서 타입과 함께 사용될 수 있습니다. 이번 장에서는 Annotation의 Target에 대해 알아봅니다.

#### Table of Contents
1. 선언부 Annotation
2. 구현부 Annotation

<br />

### 선언부 Annotation
***
* 패키지
* 클래스와 인터페이스
* 메소드
* 지역 변수
* 예외 발생 가능 명시
* 타입 파라미터
***

**패키지(Packages)**  
어노테이션은 패키지 선언 앞에 적용될 수 있습니다. 단, 패키지에 적용된 어노테이션은 소스 수준에서만 유지되므로 컴파일 과정에서 삭제되어 바이트코드에서는 확인할 수 없습니다.
```java
/**
Package-level Javadoca
*/
@GPL(version="3")
package com.horstmann.corejava;
import org.gnu.GPL;
```

**클래스(Class)**  
클래스 선언에 적용할 수 있습니다. 하나 이상의 어노테이션이 올 수 있으며, 해당 클래스 전체에 영향을 미칩니다. 열거형(enum)도 동일하게 적용됩니다.
```java
@Documented
@RetentionSource
public class ClassA extends Base { ... }
```

**인터페이스(Interface)**  
인터페이스 선언 앞이나 선언하고자 하는 어노테이션 인터페이스 이름 앞에 적용할 수 있습니다. 어노테이션 인터페이스도 동일하게 적용됩니다
```java
@Retention(RetentionPolicy.SOURCE)
@interface RetentionSource
{
   String value() default "RetentionPolicy.Source";
}
```

**메소드(Method)**  
메소드 선언앞에 어노테이션을 선언하여 적용할 수 있습니다. 어노테이션의 적용 범위는 해당 메소드로 제한됩니다.
```java
@SuppressWarnings("deprecation")
void useDeprecatedMethod() {
objectOne.deprecatedMethod();
}
```

**지역 변수(Local Variable)**  
지역 변수에 어노테이션을 적용할 수 있으며, 어노테이션의 적용 범위는 해당 지역 변수로 제한됩니다. 
```java
@SuppressWarnings("unchecked") List<User> users = ...;
public User getUser(@Param("id") String userId)
```

**예외 발생 가능 명시(throws)**
예외 발생 가능 명시를 위한 어노테이션은 throws 키워드 뒤, 발생 가능한 예외 이름 앞에 위치합니다.
```java
void monitorTemperature() throws
   @Critical TemperatureException { ... }
```

**타입 파라미터**
타입 매개 변수를 위한 어노테이션은 타입 매개 변수 앞에 위치한다.
```java
public class Cache<@Immutable V> { . . . }
```

<br />

### 구현부 Annotation
***
* 생성자
* 타입 변환
* instanceof
* 배열
***

**생성자**  
인스턴스 생성자에 선언하여 객체 초기화를 어드바이스 할 수 있습니다.
```java
MyObject myObject= new @Interned MyObject();
```
**타입 변환**
타입 변환되는 변수 앞에 선언되어 타입 변환을 어드바이스 할 수 있습니다. 외부 도구를 위해 제공되며, 타입 변환 동작에는 영향을 주지 않습니다.
```java
myString = (@NonNull String)str;
```
**instanceof**
instanceof 연산자에 제공되어 어드바이스 할 수 있으며, 외부 도구를 위해 제공되어 연산자에는 영향을 주지 않습니다.
```java
if (text instanceof @Localized String) {...}
```
**배열**
배열의 다양한 위치에서 제공되어 배열 생성과 사용을 어드바이스 할 수 있습니다.
```java
@NonNull String[][] words;	    // words[i][j]는 null이 아님
String @NonNull [][] words;	    // words는 null이 아님
String[] @NonNull [] words; 	// words[i]는 null이 아님
```

<br />
<br />
<br />
<br />
<br />

## 표준 Annotation
Java에서는 용도에 따라 사용할 수 있는 기본 Annotation들을 제공합니다. 이 장에서는 표준 Annotation과 사용법을 알아봅니다.

#### Table of Contents
1. @Deprecate
2. @Override
3. @SuppressWarnings
4. @SaftVarags
5. @FuncationalInterface

<br />