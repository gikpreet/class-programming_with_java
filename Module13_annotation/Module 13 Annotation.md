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

### @Deprecated
***
* 더 이상 지원되지 않거나 내포된 문제가 있을 수 있으므로 사용하지 않을 것을 권장
* @Deprecated 명시와 상관없이 사용은 가능
* 명시된 선언부 사용시 컴파일러에서 경고 생성
* 경고에 대해 알고 있을 경우, @SupressWarning Annotation 사용
* @Deprecated 표시된 요소는 Javadoc 태그 @Depececated를 이용해 사용하지 않도록 표시하는 것을 권장
***

Java는 버전이 올라감에 따라 일관성을 위해 메소드 이름이 바뀌고 새롭고 더 다은 클래스와 메소드가 추가되며 필드가 변경됩니다. 이런 변경은 발전된 기능을 제공하여 프로그래밍을 도와주고 일관된 방법을 사용할 수 있게 해 주지만, 이런 변화는 문제를 야기할 수 있습니다. 

**사용 중단**  
API를 설계할 때 이전 API를 대체하는지 여부를 신속하게 고려해야 합니다. 일반적으로 아래와 같은 경우 API를 대체합니다.
* 안전하지 않거나 매우 비효율적
* 다음 릴리스에서 사라질 예정
* 나쁜 코딩 관행 조장

사용 중단은 “이전 버전과의 호환성”은 유지하면서 개발자가 새 API로 변경하도록 권장하기 때문에 매우 중요합니다. 또한 사용 중단에 대한 설명은 개발자가 새 API로 이동할 시기를 결정하는데 도움이 되므로 사용 중단에 대한 기술적인 이유를 설명해야 합니다.

**사용 중단 통지 방법**  
Java는 API가 불가피하게 변경되므로 변경되거나 삭제된 API에 대한 사용 중단을 표현하는 두 가지 방법을 제공합니다.
* 주석 사용 및 Javadoc 태그
* @Deprecated 어노테이션 사용

**Javadoc 태그 사용**  
javadoc에서 더 이상 사용되지 않는 프로그램 요소를 표시할 때 @deprecated 태그를 사용합니다. @deprecated 태그 뒤에는 공백이나 개행 문자가 와야 하고, 태그 다음 단락에서 항목이 더 이상 사용되지 않는 이유를 설명하고 대신 사용할 항목을 제안합니다.
```java
/**
 * @deprecated  As of release 1.3, replaced by {@link #getPreferredSize()}
 */
@Deprecated public Dimension preferredSize() {
return getPreferredSize();
}
```
**@Deprecated 어노테이션 적용**
클래스, 메소드 또는 필드 선언 앞에 “@Deprecated”를 명시합니다. 컴파일러는 더 이상 사용하지 않을 것을 Warning 레벨로 경고합니다.
```java
@Deprecated 
public synchronized void delItems(int start, int end) {
...
}
```

<br />

### @Override
***
* 슈퍼 클래스 또는 인터페이스의 메소드를 오버라이드하는 메소드임을 나타냄
* Annotation을 적용한 메소드가 상위 타입에서 정의되지 않았을 경우 컴파일 오류 발생
* 사용하지 않아도 컴파일에 문제는 없음
* 오류에 대한 검증을 컴파일 단계에서 처리
* 실행 단계의 오류를 줄여 줌
***

@Override Annotation은 메소드에 적용하며, 해당 메소드가 상속하는 클래스 또는 인터페이스에 정의된 메소드를 오버라이드하는 메소드임을 표시합니다.

오버라이드 메소드에 @Override를 사용하지 않아도 컴파일에 문제는 없으나, 만약 @Override Annotation을 적용한 메소드가 상위 타입에 존재하지 않는 경우 컴파일러가 오류를 발생합니다. 

**적용**
```java
interface IAccount {
    public boolean withDraw(BigDecimal balance);
    public BigDecimal deposit(BigDecimal balance);
    public BigDecimal getBalance();
}

public class BankAccount implements IAccount {
    @Override		// IAccount 인터페이스의 withDraw 메소드 오버라이드
    public boolean withDraw(BigDecimal amount) { ... }

    @Override		// IAccount 인터페이스의 deposit 메소드 오버라이드
    public BigDecimal deposit(BigDecimal amount) { ... }

    // 올바른 오버라이드인 경우 @Override 없이도 오류 발생 않음
    public BigDecimal getBalance() { ... }

    @Override		// IAccount에 setBalance 메소드가 없으므로 컴파일 오류
    public void setBalance(BigDecimal amount) { ... }
}
```

<br />

### @SuppressWarning
***
* 컴파일러에서 특정 경고에 대한 메시지를 생성하지 않도록 지시
* Java 언어의 경고 범주
* deprecation – 사용이 제한된 요소 사용에 대한 경고
* unchecked – 지네릭스가 출현하기 이전 코드와 동작시 위험성에 관한 경고
* 여러 범주를 함께 묶어서 처리 가능
```java
@SuppressWarnings({"unchecked", "deprecation“})
void useDeprecatedMethod() {
   …
}
``````
***
@Deprecated Annotation이 적용되어 있는 메소드를 호출할 경우, 컴파일러는 경고를 생성합니다. 하지만 사용자가 그 사실을 알면서 경고를 무시하고 해당 메소드를 사용하고자 하는 경우, 경고 메시지는 번거로운 내용일 수 있습니다.

@SuppressWarning Annotation을 적용하면 지시된 경고 타입에 대해 컴파일러가 경고 메시지를 생성하지 않습니다.

```java
public class ObjectClass {  
    @Deprecated
    void deprecatedMethod() { }
}
```
@Deprecated Annotation이 적용된 ObjectClass의 useDeprecatedMethod를 호출하면 컴파일러가 경고를 발생합니다.
```java
class MyClass {
    ObjectClass objectOne = new ObjectClass();
    
void useDeprecatedMethod() {
        objectOne.deprecatedMethod();
    }
}
```
```bash
$ javac ObjectClass.java MyClass.java
Note: ObjectClass.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```
MyClass의 useDeprecatedMethod 메소드에서 @Deprecated Annotation이 적용된 ObjectClass의 deprecatedMethod를 호출할 때 컴파일러 경고를 발생하지 않도록 하려면 @SuppressWarning Annotation을 적용합니다.
```java
class MyClass {
    ObjectClass objectOne = new ObjectClass();
    
    @SuppressWarning("deprecated");
void useDeprecatedMethod() {
        objectOne.deprecatedMethod();
    }
}
```

**@SuppressWarning 어노테이션 전파**
@SuppressWarnings 어노테이션이 클래스와 메소드에 각각 주어질 경우, 컴파일러에서는 메소드에도 클래스에서 주어진 경고 제한을 적용해야 합니다. 클래스와 메소드에서 각기 다른 경고 제약이 주어질 경우, 메소드에서는 두가지 경고 제약을 모두 적용되어야 합니다.
```java
@SuppressWarnings("deprecation")
Public class Base<T> {
   @SuppressWarnings("unchecked")
    public T get() { … }
}
```
위 코드는 Base 클래스에 경고 제한으로 “deprecation”이 주어지고, 메소드 get에는 “unchecked”가 적용되었습니다. 이에 따라, Base 클래스내에서는 @Deprecated로 표기된 클래스나 메소드 등의 사용으로 인해 발생할 수 있는 경고 메시지를 제한하고, 메소드 get에는 @Deprecated로 표기된 클래스나 메소드 등의 사용으로 인해 발생할 수 있는 경고메시지 뿐만 아니라 미확인 오퍼레이션이과 관련된 경고메시지 또한 제한합니다.

**주의 사항**
@SuppressWarning 어노테이션 사용시에는 Target 뿐 아니라 Advice(경고 타입)에도 주의해야 합니다. 아래와 같이 경고 메시지 타입을 all로 적용하면 해당 Target에서 발생할 수 있는 모든 경고 메시지를 제한하여, 잠재적인 오류까지도 숨길 수 있습니다.
```java
@SuppressWarnings("all")
Public class Base<T> {
   @SuppressWarnings("unchecked")
    public T get() { … }
}
```

**@SuppressWarning 어노테이션의 경고 메시지 종류**
|경고 메시지 타입|설명|
|------------|---|
|Boxing|Boxing/Unboxing 작업과 관련된 경고를 표시하지 않음|
|unused|사용하지 않은 코드에 대한 경고를 표시하지 않음|
|cast|객체 캐스트 작업과 관련된 경고를 표시하지 않음|
|deprecation|더 이상 사용되지 않는 클래스 또는 메소드와 같은 사용 중단과 관련된 경고를 표시하지 않음|
|restriction|권장되거나 금지된 참조 사용과 관련된 경고를 표시하지 않음|
|dep-ann|더 이상 사용되지 않는 어노테이션과 관련된 경고를 표시하지 않음|
|fallthrough|switch문에서 break 문 누락과 관련된 경고를 표시하지 않음|
|finally|반환되지 않는 finally 블록 과 관련된 경고를 표시하지 않음|
|hiding|변수를 숨기는 지역 관련 경고를 표시하지 않음|
|incomplete-switch|switch 문의 누락된 항목과 관련된 경고를 표시하지 않음(enum case)|
|nls|nls이 아닌 문자열 리터럴과 관련된 경고를 표시하지 않음|
|null|null 분석과 관련된 경고를 표시하지 않음|
|serial|일반적으로 Serializable 클래스에서 발견되는 누락된 serialVersionUID 필드와 관련된 경고를 표시하지 않음|
|static-access|잘못된 정적 변수 액세스와 관련된 경고를 표시하지 않음|
|synthetic-access|내부 클래스의 최적화되지 않은 액세스와 관련된 경고를 표시하지 않음|
|unchecked|확인되지 않은 작업과 관련된 경고를 표시하지 않음|
|unqualified-field-access|규정되지 않은 필드 액세스와 관련된 경고를 표시하지 않음|
|javadoc|Javadoc과 관련된 경고를 표시하지 않음|
|rawtypes|원시 유형 사용과 관련된 경고를 표시하지 않음|
|resource|Closeable 유형의 리소스 사용과 관련된 경고를 표시하지 않음|
|super|수퍼 호출없이 메소드 재정의와 관련된 경고를 표시하지 않음|
|sync-override|동기화된 메소드를 재정의할 때동기화 누락으로 인한 경고를 표시하지 않음|

<br />

### @SafeVarags
***
* 가변 길이 파라피터 사용시 발생할 수 있는 잠재적 불완전 요소에 대해 보장할 경우 사용
* 재정의 불가 메소드에 대해서만 사용 가능
    * Java 8에서는 static 메소드와 final 인스턴스 메소드에만 적용 가능
    * Java 9부터 private 인스턴스 메소드에도 적용 가능
```java
@SafeVarargs
public final void unsaftAdd(T... items) {
    Collections.addAll(this.itemList, items);
}
```
***

@SafeVarargs Annotation이 적용된 메소드 또는 생성자는 가변 길이 파라미터로인해 발생할 수 있는 잠재적인 오류 가능성에 대해 경고하지 않습니다. 이는 메소드나 생성자의 작성자가 가변 길이 파라미터에 대해 안정성을 보장할 경우 해당 메소드나 생성자에 적용합니다. 

@SafeVarargs Annotaation은 해당 메소드나 생성자에 한해 적용되며, 이를 상속받은 메소드나 생성자에는 적용되지 않습니다.

```java
public class MyClass<T> {
private List<T> itemList = new ArrayList<>();

@SafeVarargs
public final void unsafeAdd(T... items) {
      Collections.addAll(this.itemList, items);
  }
}
```

<br />

### @FunctionalInterface
***
* Target이 함수형 인터페이스임을 적용
```java
@FunctionalInterface
public interface Functional {
    int apply(int left, int right);
}

class Calculate {
    public int calc(Functional binder, int i, int j) {
        return binder.apply(i, j);
    }
}
```
***
함수형 인터페이스는 abstract 메소드가 단 하나만 존재하는 인터페이스를 말합니다. Java의 Lambda Expression은 함수형 인터페이스를 기반으로만 작성할 수 있습니다.

@FuncationalInterface Annotation은 인터페이스가 함수형 인터페이스임을 적용합니다.

<br />
<br />
<br />
<br />
<br />

## <a href="./Lab 13-1 Annotation 적용과 사용.md"> Lab 13-1 Annotation 적용과 사용</a>
해당 연습을 수행하십시오.

<br />
<br />
<br />
<br />
<br />

## Meta Annotation
Java에서 Annotation은 Class, Method, Instance등과 같은 프로그램 요소에 메타 데이터를 첨부하는데 사용됩니다. 일부 Annotation은 다른 Annotation에 주석을 다는데 사용됩니다. 이러한 유형의 Annotation을 Meta Annotation이라고 합니다. 이번 장에서는 Meta Annotation에 대해 학습합니다.

### Table of Contents
1. @Retention
2. @Documented
3. @Target
4. @Inherited
5. @Repeatable

<br />

### @Retention
***
* Java 컴파일러에게 해당 Annotation이 어느 시점까지 영향을 미치는지 알림
* RetentionPolicy로 제한을 둠
    * SOURCE  
    소스 수준에서만 유효하며, 컴파일러에서 무시됨
    * CLASS  
    컴파일시에는 유효하지만, JVM에서는 무시됨
    * RUNTIME
    런타임 환경에서 사용될 수 있도록 Reflection을 이용하여 JVM에서 유효함

```java
@Retention(RetentionPolicy.SOURCE)
@interface RetentionSource
{
  String value() default "RetentionPolicy.Source";
}
```
***

@Retention은 일부 보존 정책과 함께 제공되는 메타 어노테이션입니다. 보존 정책은 어노테이션이 유지되는 기간, 즉 삭제 시점을 결정합니다. 보존 정책은 SOURCE, CLASS, RUNTIME 세 가지 중 하나를 지정할 수 있습니다.

@Override, @SuppressWarning 어노테이션은 SOURCE 보존 정책에 해당합니다. 이런 종류의 어노테이션은 컴파일러 차원에서 유효합니다.

```java
@Retention(RetentionPolicy.SOURCE)
@interface RetentionSource
{
String value() default "RetentionPolicy.Source";
}
```

CLASS 보존 정책은 컴파일러가 어노테이션의 정보를 클래스 파일에 지정하게는 하지만 클래스 파일이 JVM에 로딩될 때는 어노테이션 정보가 무시되어 실행시에는 어노테이션 정보를 얻을 수 없습니다.

```java
@Retention(RetentionPolicy.CLASS)
@interface RetentionClass
{
String value() default "RetentionPolicy.CLASS";
}
```

RUNTIME 유지 정책은 실행시에 리플렉션을 이용하여 클래스 파일에 저장된 어노테이션의 정보를 읽어서 처리할 수 있도록 합니다. @FunctionalInterface 어노테이션은 유지 정책이 RUNTIME으로, 실행시에도 사용됩니다.

```java
@Retention(RetentionPolicy.RUNTIME)
@interface RetentionRuntime
{
    String value() default "RetentionPolicy.RUNTIME";
}
```

<br />

### @Documented
***
Annotation 정보가 javadoc으로 생성한 문서에 포함되도록 함

```java
@Documented
@interface CustomAnnotation {
    String value();
}
```
***

@Documented 어노테이션은 어노테이션에 대한 정보가 javadoc으로 작성한 문서에 포함되도록 합니다. 
```java
@Documented
@interface CustomAnnotation {
    String value();
}
```
@Documented 메타 어노테이션이 적용된 CustomAnnotation은 javadoc을 사용한 문서 생성시 생성된 문서에 정보가 포함됩니다.
```java
@CustomAnnotation("Hello")
public class DocumentedAnnotationTest {
    public static void main(String[] args) {
        System.out.println("DocumentedAnnotationTest");
    }
}
```
<img src="images/image02.png" />

### @Target
***
* 해당 사용자 정의 Annotation이 적용될 수 있는 대상을 지정
* 메소드, 생성자, 필드, 지역 변수 등 Annotation이 지정될 대상 지정
* 적용 대상은 ElementType에 정의됨
```java
@Target(ElementType.METHOD)
@interface CustomAnnotation {
   String value();
}
```
***
@Target 어노테이션은 사용자 정의 애노테이션이 적용될 수 있는 대상을 지정합니다. 대상은 메소드, 생성자, 필드, 지역 변수 등이 될 수 있으며, 대상은 ElementType에 정의되어 있습니다.

|대상|설명|
|---|---|
|ANNOTATION_TYPE|	어노테이션 타입|
|CONSTRUCTOR|	생성자|
|FIELD|	필드|
|LOCAL_VARIABLE|	지역 변수|
|METHOD|	메소드|
|PACKAGE|	패키지|
|PARAMETER|	파라미터|
|TYPE|	클래스, 인터페이스, Enum 타입|

@Target 어노테이션은 하나 이상의 대상을 지정할 수 있습니다.
```java
@Target({ElementType.METHOD, ElementType.FIELD, ...})
```

<br />

### @Inherited
***
* Annotation이 서브 클래스에 상속되도록 함
* @Inherited Annotation이 적용된 클래스의 서브 클래스는 Annotation을 명시하지 않아도 적용된 것과 같이 인식됨
* 클래스 정의에서만 사용됨
```java
@Inherited
@interface CustomAnnotation { }

@CustomAnnotation
class BaseClass {}

class DerivedClass extends BaseClass {} // @CustomAnnotation 어노테이션이 적용됨
```
***

@Inherited 어노테이션은 어노테이션의 타겟 클래스의 서브 클래스가 필드, 메소드, 생성자뿐만 아니라 어노테이션까지 같이 상속하도록 지정합니다. 

@Inherited 어노테이션은 클래스에만 적용됩니다.

```java
@Inherited
@interface CustomAnnotation { }

@CustomAnnotation
class BaseClass {}

class DerivedClass extends BaseClass {} // @CustomAnnotation 어노테이션이 적용됨
```

<br />

### @Repeatable
***
* 반복되는 Annotation이 필요할 경우 사용
* 반복되는 Annotation을 위한 컨테이너 Annotation

```java
@Repeatable(Animals.class)
@interface Animal {
    String species();
    String lifespan();
}

@Retention(RetenionPolicy.RUNTIME)
@interface Animals {
    Animal[] value;
}

@Animal(species="cat", lifespan="15")
@Animal(species="cow", lifespan="20")
public class RepeatableAnnotationTest { ... }
```
***

@Repeatable 어노테이션은 여러 번 반복해서 적용해야 하는 어노테이션을 정의할 때 사용합니다. 
```java
@Animal(species="cat", lifespan="15")
@Animal(species="cow", lifespan="20")
public class RepeatableAnnotationTest { }
```
일반적인 어노테이션과 달리 같은 이름의 어노테이션이 있을 수 있어 어노테이션들을 하나로 묶어서 다룰 수 있는 어노테이션 컨테이너가 필요합니다.
```java
@Repeatable(Animals.class)
@interface Animal {
   String species();
   String lifespan();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Animals{
   Animal[] value();
}
```

<br />
<br />
<br />
<br />
<br />

## Annotation 타입 정의
Java는 사용자의 프로그램에 필요한 사용자 정의 Annotation을 만들 수 있도록 제공합니다. 이 장에서는 사용자 정의 Annotation을 정의하는 방법에 대해 알아봅니다.

#### Table of Contents
1. Annotation 타입 생성

<br />

### Annotation 타입 생성
***
* 인터페이스 선언과 동일한 방법으로 선언
    * 필드를 파라미터 없는 메소드로 선언
    * default 키워드를 사용하여 기본 값 할당
```java
<Access Modifier> @interface <Type name> {
    <Field Type> <Field Name>() [default <default value>];
}
```
* Reflection을 이용해 접근
***
Annotation 타입을 생성하는 것은 인터페이스를 선언하는 방식과 동일합니다. @Interface 키워드를 사용하고 필드는 파라미터 없는 메소드로 선언됩니다. 필드에 기본 값을 할당하려면 default 키워드를 사용합니다.

```java
<Access Modifier> @Interface <Type Name> {
    <Field Type> <FieldName>() [default <default value>];
}
```
**Type Name**
클래스와 인터페이스와 마찬가지로 Camel Casing을 사용합니다.

**Field Type**
어노테이션을 구성하는 요소들의 타입으로 아래의 타입에서 선택 가능합니다.
* 기본 데이터 타입(Primitive Data Type)
* String
* Class (Class <? extends MyClass>와 같은 선택적 타입 파라미터 사용)
* Enum 타입 
* Annotation 타입
* 위 타입들의 배열

**Field Name**
어노테이션을 구성하는 요소들의 이름

**default value**
어노테이션 구성요소들의 기본 값으로 Annotation 적용시 해당 요소에 대한 값이 주어지지 않을 때 사용

**예제**
클래스의 정보를 Annotation으로 제공하기 위한 사용자 정보를 아래와 같이 구성할 수 있습니다. 아래의 DeviceAnnotation은 타입에만 적용할 수 있으며, 런타임 정보로 사용될 수 있고 해당 Annotation이 적용된 타겟 타입에서 파생된 하위 클래스에도 상속 됩니다.
```java
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DeviceInformation {
    boolean communicationSupport() default false;
    String communicationInterface() default "None";
    boolean batterySupport() default false;
}
```
생성한 사용자 정의 Annotation은 아래와 같이 타입에 적용할 수 있습니다.
```java
@DeviceInformation({communication=”true”, communicationInterface=”5G”, 
batterySupport=”true”})
public class CellPhone { … }
```

## <a href="./Lab 13-2 사용자 정의 Annotation 생성.md"> Lab 13-2: 사용자 정의 Annotation 생성</a>
해당 연습을 수행하십시오.

