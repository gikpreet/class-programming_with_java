# Abstract Data Type

ADT(Abstract Data Type - 추상 데이터 타입)은 프로그램에서 데이터 구조를 사용하는 방법을 데이터 구조 자체의 특정 형식과 분리할 수 있게 해주는 강력한 아이디어입니다.추상 데이터 타입은 클라이언트가 타입의 내부적인 표현에 대해 강제하는 위험성을 해결합니다.

### Java에서의 접근 제어
[Java에서의 접근 제어](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)를 다시 한번 살펴보세요.

#### 연습 문제 1
아래 코드를 읽으세요. 읽고, 질문에 답해보세요.
```java
class Wallet {
    private int amount;

    public void loanTo(Wallet that) {
/*A*/   that.amount += this.amount;
/*B*/   amount = 0;
    }

    public static void main(String[] args) {
/*C*/   Wallet W = new Wallet();
/*D*/   w.amount = 100;
/*E*/   w.loanTo(w);
    }
}

class Person {
    private Wallet w;

    public int getNetWorth() {
/*F*/   return w.amount;
    }

    public boolean isBroke() {
/*G*/   return Wallet.amount == 0;
    }
}
```
**Question 1**   
/* A */ 주석 부분에서 참인 것을 모두 고르세요.
```java
that.amount += this.amount;
```
- [ ] this.amount에 대한 참조는 java에서 허용됩니다.
- [ ] this.amount에 대한 참조에서 this는 private 필드에 대해 사용되므로 허용되지 않습니다.
- [ ] that.amount는 Java에서 허용됩니다.
- [ ] that.amount에서 that.amount는 다른 객체의 private 필드에 대해 사용되므로 허용되지 않습니다.
- [ ] 허용되지 않는 접근은 정적으로 포착됩니다.
- [ ] 허용되지 않는 접근은 동적으로 포착됩니다.

**Question 2**  
/* B */ 주석 부분에서 참인 것을 모두 고르세요
```java
amount - 0;
```
- [ ] amount에 대한 참조는 Java에서 허용됩니다.
- [ ] amount에 대한 참조는 this를 사용하지 않았으므로 허용되지 않습니다.
- [ ] 허용되지 않는 접근은 static으로 포착됩니다.
- [ ] 허용되지 않는 접근은 dynamic으로 포착됩니다.

**Question 3**  
/* C */ 주석 부분에서 참인 것을 모두 고르세요
```java
Wallet w = new Wallet();
```
- [ ] Wallet() 생성자 호출은 Java에서 허용됩니다.
- [ ] Wallet() 생성자 호출은 public Wallet() 생성자가 선언되지 않았으므로 Java에서 허용되지 않습니다.
- [ ] 허용되지 않는 접근은 static으로 포착됩니다.
- [ ] 허용되지 않는 접근은 dynamic으로 포착됩니다.

**Question 4**  
/* D */ 주석 부분에서 참인것을 모두 고르세요
```java
w.amount = 100;
```
- [ ] w.amount 액세스는 Java에서 허용됩니다.
- [ ] w.amount 액세스에서 amount는 private 이므로 Java에서 허용되지 않습니다.
- [ ] 허용되지 않는 접근은 static으로 포착됩니다.
- [ ] 허용되지 않는 접근은 dynamic으로 포착됩니다.

**Question 5**  
/* E */ 주석 부분에서 참인것을 모두 고르시오.
```java
w.loanTo(w);
```
- [ ] loanTo() 호출은 Java에서 허용됩니다.
- [ ] loanTo() 호출에서 this와 that이 같은 객체이므로 Java에서 허용되지 않습니다.
- [ ] 문제는 stacic check로 발견됩니다.
- [ ] 문제는 dynamic check로 발견됩니다.
- [ ] 이 라인 후에, Wallet 객체는 amount 0을 가진 객체를 가리킵니다.
- [ ] 이 라인 후에, Wallet 객체는 amount 100을 가진 객체를 가리킵니다.
- [ ] 이 라인 후에, Wallet 객체는 amount 200을 가진 객체를 가리킵니다.

**Question 6**  
/* F */ 주석 부분에서 참인것을 모두 고르시오.
```java
return w.amount;
```
- [ ] w.amount에 대한 참조는 w와 amount가 모두 private 변수이므로 Java에서 허용됩니다.
- [ ] w.amount에 대한 참조는 private인지 여부와 관계없이 primitive type이므로 Java에서 허용됩니다.
- [ ] w.amount의 참조는 다른 클래스의 private 필드이므로 Java에서 허용되지 않습니다.
- [ ] 허용되지 않는 접근은 static으로 포착됩니다.
- [ ] 허용되지 않는 접근은 dynamic으로 포착됩니다.

**Question 7**  
/* G */ 주석 부분에서 참인것을 모두 고르시오.
```java
return Wallet.amount == 0;
```
- [ ] Wallet.amount에 대한 참조는 Wallet은 자신의 private 필드인 amount에 대해 접근 권한을 가지고 있으므로 Java에서 허용됩니다.
- [ ] Wallet.amount에 대한 참조는 amount는 static 변수이므로 허용됩니다.
- [ ] Wallet.amount에 대한 참조는 amount는 private 필드이므로 허용되지 않습니다.
- [ ] Wallet.amount에 대한 참조는 amount는 인스턴스 변수이므로 허용되지 않습니다.
- [ ] 허용되지 않는 접근은 static으로 포착됩니다.
- [ ] 허용되지 않는 접근은 dynamic으로 포착됩니다.

## Abstraction이 뜻하는 것
Abstract Data Type은 소프트웨어 공학의 일반적 원칙의 한 예이며, 조금은 다른 의미를 가진 많은 이름으로도 알려져 있습니다. 여기에서 사용되는 이름은 다음과 같습니다.
* **Abstracton.** 더 집약되고 높은 수준의 아이디어로 낮은 수준의 세부 정보의 생략하거나 숨깁니다.
* **Modularity.** 시스템을 나머지 시스템과 별도로 설계(designed), 구현(implemented), 테스트(tested), 추론(reasoned) 및 재사용할 수 있는 구성 요소(Component) 또는 모듈(Module)로 분할합니다.
* **Encapsulation.** 모듈이 자체 내부 동작을 담당하고 시스템의 다른 부분에 있는 버그가 모듈의 무결성을 손상시킬 수 없도록 모듈(hard shell 또는 capsule) 주위에 벽을 쌓습니다.
* **Information hiding.** 나중에 시스템의 나머지 부분을 변경하지 않고 세부 사항을 변경할 수 있도록 시스템의 나머지 부분에서 모듈 구현의 세부 정보를 숨깁니다.
* **Separation of concerns.** 기능(또는 관심사)을 여러 모듈에 분산시키지 않고 단일 모듈의 책임으로 만듭니다.

위의 용어들은 소프트웨어 엔지니어링에서 매우 자주 사용되는 언어입니다. 소프트웨어 엔지니어로서 이러한 용어에 익수해져 있어야 합니다.

### User Defined Types
컴퓨터의 초기에는 프로그래밍 언어에 built-in 타입(integer, boolean, string 등)과 built-in 프로시저(input과 output 등)가 제공되었습니다. 사용자는 기본적으로 제공되는 built-in 타입과 프로시저들을 사용하여 자신만의 프로시저를 정의할 수 있습니다. 이런 방식으로 대규모 시스템을 구축했습니다.

소프트웨어 개발의 주요 발전은 User Defined Type(사용자 정의 타입)도 허용하도록 프로그래밍 언어를 설계할 수 있는 abstraction type에서 이루어졌습니다. 프로그래밍 언어 Simular를 만든 Dahl, abstraction type에 대한 reasoning에 많은 기술을 개발한 Hoare, Information hiding이라는 용어를 만든 Parnas, MIT 대학에서 absraction type의 specification과 이를 위한 프로그래밍 언어 지원에 중요한 작업을 수행한, 튜링 상 수상자 Barbara Liskov와 John Guttag이 이런 발전을 이끌었습니다.

data abstraction의 가장 중요한 아이디어는 타입이 수행(permit)할 수 있는 작업(operation)으로 특정지어 진다는 것입니다. 숫자(number)는 더하고 곱할 수 있는 것입니다. 문자열(string)은 연결하고 하위 문자열을 가져올 수 있는것이며, 부율(boolean)은 부정할 수 있는 것 등입니다. 어떤 의미이에서, 사용자는 초기 프로그래밍 언어에서 이미 자신의 타입을 정의할 수 있었습니다. 일, 월, 연도에 대한 정수 필드를 사용하여 레코드 유형 날짜를 만들 수 있습니다. 그러나 abstract type을 새롭고 다르게 만든 것은 초점을 "동작(operation)"에 맞춘 다는 것이었습니다. 프로그래머가, 컴파일러가 실제로 정수를 저장하는 방법을 무시할 수 있는 것과 같은 방식으로 타입 사용자는 해당 값이 실제로 저장되는 방법에 대해 알아야 할 필요가 없습니다. 중요한것은 동작(operation)입니다.

## 타입(type)과 동작(operations)의 분류
built-in 타입이건 user defined 타입이건, 타입은 mutable(가변) 또는 immmutable(불변)으로 분류할 수 있습니다. mutable 타입의 객체는 변경될 수 있습니다. 즉, 실행될 때 동일한 개체에 대한 다른 동작의 결과가 다른 결과를 제공하는 작업을 제공합니다. 예를 들어, Date는 변경할 수 있습니다. setMonth 동작으로 변경하고 getMonth 동작으로 변경을 관찰할 수 있습니다. 그러나 String은 변경할 수 없습니다. String에 대한 변경 동작은 기존 String을 변경하는 대신 새 String 객체를 생성하기 때문입니다. 경우에 따라 타입은 mutable 타입과 immutable 두 가지 타입 모두로 제공합니다. 예를 들어, Java의 StringBuilder는 String의 변경 가능한 버전입니다. (Java에서 두 타입은 완전히 동일한 타입이 아니며, 교환 가능하지 않습니다)

abstract 타입에서, 동작은 다음과 같이 분류됩니다.
* **Creator** 해당 타입의 새 객체를 생성합니다. Creator는 객체를 인수(argument)로 사용할 수 있으나, 사용중인 타입의 객체는 안됩니다.
* **Producer** 타입의 이전 객체에서 새 객체를 생성합니다. 예를 들어, String 타입의 concat 메소드는 String의 생산자입니다. concat 메소드는 두 String 개체가 결합된 새 String을 생성합니다.
* **Observers** abstract 타입의 객체를 취해 다른 타입의 객체를 반환합니다. 예를 들어, List 타입의 size 메소드는 int 타입을 반환합니다.
* **Mutator** 객체를 변경합니다. 예를 들어, List의 add 메소드는 List의 끝에 요소를 추가합니다.

이런 구분은 아래와 같이 개략적으로 요약할 수 있습니다.
* creator: t<sup>*</sup> &rightarrow; T
* producer: T+, t<sup>*</sup> &rightarrow; T
* observer: T+, t<sup>*</sup> &rightarrow; t
* mutator: T+, t<sup>*</sup> &rightarrow; void|t|T

이는 다양한 클래스의 동작 시그너처를 특별한 격식없는 모양으로 보여줍니다. T는 abstract 타입 자체를 의미하며, t는 다른 타입을 의미합니다. + 는 시그너처의 해당 위치에서 타입이 한번 이상 나올 수 있음을 표시하고, * 는 0번 이상 나옴을 나타냅니다. 예를 들어, producer는 String.concat() 처럼 두 abstract 타입을 값을 취할 수 있습니다. 일부 observer는 non-abstract 인수를 사용하지 않고, 일부는 여러 인수를 사용하기 때문에 왼쪽의 t로 생략될 수 있습니다.

creator 동작은 *new ArrayList()* 와 같이 생성자(constructor)로 구현됩니다. 그러나 Arrays.asList()와 같은 단순한 static 메소드일 수도 있습니다. static 메소드로 구현된 creator를 **Factory Method**라고도 합니다.

mutator는 void  리턴 타입으로 신호를 받습니다. 메소드가 아무것도 반환하지 않을 경우 일종의 부작용이 생기므로, 값을 반환하지 않을 경우 반드시 void 타입으로 선언해야 합니다. 모든 mutator가 void를 반환하는 것은 아닙니다. 예를 들어 Set.add()는 집합이 실제로 변경 되었는지의 여부를 나타내는 부울 값을 반환합니다. 다른 예로, Java의 그래픽 인터페이스 툴킷에서 Component.add()는 개체 자체를 반환하므로 여러 add() 호출을 함께 연결할 수 있습니다.

### Abstract 데이터 타입 예제
**int**는 Java의 primitive 정수 타입입니다. ```int```는 immutable입니다. 따라서, mutator가 없습니다.
* creators: 숫자 리터럴 0, 1, 2...
* producers: 산술 연산자 $+$, $-$, $\times$, $\div$
* observers: 비교 연산자 $==$ , $!=$, $<$ $>$
* mutator: 없음 (int는 immutable 타입)

**List**는 Java의 리스트 타입입니다. ```List```는 mutable입니다. ```List```는 또한 인터페이스로, ```ArrayList``` 및 ```LinkedList```등의 다른 클래스에서 데이터 타입의 실제 구현을 제공합니다.
* creators: ```ArrayList```와 ```LinkedList``` 생성자, [Collections.singletonList](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#singletonList-T-)
* producers [Collections.unmidifiableList](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#unmodifiableList-T-)
* observers: ```size```, ```get```
* mutators: ```add```, ```remove```, ```addAll```, [Collection.sort](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#sort-java.util.List-)


**String**은 Java의 문자열 타입입니다. ```String ```은 immutable 입니다.
* creators: ```String``` 생성자
* producers: ```concat```, ```substring```, ```toUpperCase```
* observers: ```length```, ```charAt```
* mutators: 없음 (String은 immutable 타입)

위와 같은 분류는 몇 가지 유용한 용어들을 제공하지만 완벽하지는 않습니다. 예를 들어, 복잡한 데이터 유형에는 producer 이면서 mutator인 작업이 있을 수 있습니다. mutation이 없는 작업에만 producer라는 용어를 사용하는 경우도 있습니다.

### 연습 문제 2
아래의 메소드들은 Java 라이브러리에서 제공하는 abstract 데이터 타입의 동작들입니다.  링크를 클릭하여 Java Tutorial에서 메소드를 확인하고 동작의 타입 시그너처를 생각해 보세요. 그리고 동작을 분류하세요.

힌트: 타입 자체가 파라미터로 나타나는지 반환값으로 나타나는지 살펴보세요. static 키워드가 없는 인스턴스 메소드에는 암시적 파라미터가 있음을 기억하세요.

[Integer.valueof()](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#valueOf-java.lang.String-)
* [ ] creator
* [ ]  producer
* [ ] consumer
* [ ] observer
* [ ] mutator
* [ ] destructor

[BigInteger.mod()](https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html#mod-java.math.BigInteger-)
* [ ] creator
* [ ] producer
* [ ] consumer
* [ ] observer
* [ ] mutator
* [ ] destructor

[List.addAll()](https://docs.oracle.com/javase/8/docs/api/java/util/List.html#addAll-java.util.Collection-)
* [ ] creator
* [ ] producer
* [ ] consumer
* [ ] observer
* [ ] mutator
* [ ] destructor

[Collections.ummidifiableList()](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#unmodifiableList-java.util.List-)
* [ ] creator
* [ ] producer
* [ ] consumer
* [ ] observer
* [ ] mutator
* [ ] destructor

[String.toUpperCase()](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#toUpperCase--)
* [ ] creator
* [ ] producer
* [ ] consumer
* [ ] observer
* [ ] mutator
* [ ] destructor

[Set.contains()](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html#contains-java.lang.Object-)
* [ ] creator
* [ ] producer
* [ ] consumer
* [ ] observer
* [ ] mutator
* [ ] destructor

[BufferedReader.readLine()](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html#readLine--)
* [ ] creator
* [ ] producer
* [ ] consumer
* [ ] observer
* [ ] mutator
* [ ] destructor

## Abstract 타입 설계
Abstract 타입을 설계하려면 좋은 동작(Operation)을 설계하고 동작 방법을 결정해야 합니다. 다음은 경험에서 비롯된 몇 가지 법칙입니다.
* 복잡하고 많은 동작보다 강력한 방법으로 결합할 수 있는 **몇 개의 간단한 동작**이 있는 것이 좋습니다.
* 각 동작에는 잘 정의된 목적(purpose)이 있어야 하며 특별한 상황이 아닌 **일관된 행위(coherent behavior)** 가 있어야 합니다. 예를 들어, List에 합계 연산을 추가하면 안됩니다. 정수 목록으로 동작하는 클라이언트에게 도움이 될수도 있으나 문자열을 포함하는 List나 중첩된 List의  경우 합계를 이해하기 어렵게하고, 사용하기 어려운 동작으로 만듭니다.
* 묶여지는 동작은 클라이언트가 수행하려는 계산을 수행하기에 충분하다는 관점에서 **알맞아야(adequate)** 합니다. 예를 들어, get 동작이 없으면 목록의 요소가 무엇인지 알 수 없습니다. 또한 기본 정보를 얻기가 지나치게 복잡하거나 어려워서는 안됩니다. 예를 들면, size 메소드는 인덱스에 get을 적용할 수 있기 때문에 List에 반드시 필요한 것은 아니지만, 인덱스에 get을 사용하는 것은 비효율적이고 불편합니다.
* 타입은 **일반적(Generic)** 일 수 있습니다(ex. 리스트, 집합 또는 그래프). 또는 도로 지도, 직원 데이터베이스, 전화번호부 등과 같이 영역별로 다를 수(domain-specific)일 수 있습니다. 그러나 읿반적인 기능과 영역(domain)별 기능을 섞어서는 안됩니다. 카드놀이에서 사용하기 위한 Deck 타입에는 정수 또는 문자열과 같은 객체를 허용하는 일반적인 ```add``` 메소드가 없어야 하며, 반대로 ```dealCards```와 같은 영역(domain)의 특정 메소드를 일반적인 타입(Generic Type) ```List```에 넣는 것은 맞지 않습니다.

## 표현의 독립성(Representation Independence)
좋은 Abstract 데이터 타입은 표현에 독립적이어야 합니다. 이는 Abstract 타입의 사용이 그 표현(Repeseantation - 이를 구현하는데 사용되는 실제 데이터 구조 또는 데이터 필드)과 독립적이므로 표현의 변경이 Abstract 타입 차제 외부의 코드에 영향을 미치지 않는다는 것을 의미합니다. 예를 들어, ```List```에서 제공하는 작업은 List가 Linked List로 표현되는지 Array로 표현되는지 여부와 무관합니다.

클라이언트가 의존해야 할 항목을 알고 안전하게 변경할 수 있는 항목을 알 수 있도록 동작이 Pre-condition과 Post-condition으로 완전하게 지정되지 않는 한 ADT의 표현을 전혀 변경할 수 없습니다.

### 예제: 문자열의 다른 표현
간단한 abstract 데이터 타입을 보고 표현이 독립성이 뜻하는 것과 이가 왜 유용한지 알아봅시다. 아래의 ```MyString``` 타입은 Java의 ```String```과 비교하여 적은 동작을 가지고 있고, 사양 또한 조금 다르지만 실제적인 예제입니다. 아래는 ADT 사양(spec)입니다.
```java
/** MyString 은 변경할 수 없는 문자 시퀀스를 나타냅니다. **/
public class MyString {

    ////////////////////////// creator 동작 예제 ///////////////////////////////
    /** @param b 부울린 값
     *   @return b의 문자열 표현, "true" 또는 "false" */
    public static MyString valueOf(boolean b) { ... }

    ////////////////////////// observer 동작 예제 //////////////////////////////
    /** @return 문자열내의 문자 개수 */
    public int length() { ... }

    /** @param i 문자 위치 (0 <= i < 문자열 길이)
     *  @return i 위치에 있는 문자 */
    public char charAt(int i) { ... }

    ////////////////////////// producer 동작 예제 //////////////////////////////
    /** 시작(포함)과 끝(제외) 사이의 문자열을 가져옴
     * @param start 시작 인덱스
     * @param end 종료 인덱스. 0 <= start <= end <= starting length
     * @return charAt(start) ... charAt(end) 사이의 문자로 구성된 문자열 */
    public MyString subString(int start, int end) { ... }
}
```
이들 public 동작은 사양과 클라이언트가 이 데이터 타입에 대해 알 수 있는 유일한 정보입니다. 테스트 우선 프로그래밍 패러다임에 따라, 실제로 만들어야 하는 첫 번쨰 클라이언트는 사양에 따라 이러한 작업을 수행하는 테스트 묶음입니다. 현재는 MyString에 정의된 동등 연산이 없기 때문에 ```assertEquals```를 사용하는 테스트 케이스를 작성하는 것은 작동하지 않습니다. 동등을 신중하게 구현하는 방법에 대해서는 나중에 다룹니다. 현재 MyString으로 수행할 수 있는 작업은 위에서 정의한 ```valueOf```, ```charAt```, ```subString```입니다. 테스트는 이 동작들로 제한되어야 합니다. 예를 들어 다음은 ```valueOf``` 동작에 대한 테스트입니다.
```java
MyString s = MyString.valueOf(true);
assertEquals(4, s.length());
assertEquals('t', s.charAt(0));
assertEquals('r', s.charAt(1));
assertEquals('u', s.charAt(2));
assertEquals('e', s.charAt(3));
```
```MyString```에 대한 간단한 표현을 살펴봅시다. 단지 문자의 배열이고, 문자열의 명확한 길이를 가지고 있으며, 끝에는 추가 공간이 없습니다. 내부 표현이 클래스 내의 인스턴스 변수로 선언되는 방법은 다음과 같습니다.

```java
private char[] a;
```
이런 방법의 표현을 선택하면, 동작이 간단한 방식으로 구현됩니다.
```java
public static MyString valueOf(boolean b) {
    MyString s = new MyString();
    s.a = b ? new char[] {'t','r','u','e'}
            : new char[] {'f','a','l','s','e'};
    return s;
}

public int length() {
    return a.length;
}

public char charAt(int i) {
    return a[i];
}

public MyString subString(int start, int end) {
    MyString that = new MyString();
    that.a = new char([end - start]);
    System.arraycopy(this.a, start, that.a, 0, end - start);
    return that;
}
```
깊이 생각해 볼 질문: charAt 및 subString이 파라미터가 유효한 범위 내에 있는지 확인하지 않아도 되는 이유는 무엇입니까? 클라이언트가 잘못된 입력으로 위 구현을 호출하면 어떻게 될까요?

위 구현의 한 가지 문제는 성능 향상의 기회를 놓치고 있다는 것입니다. 이 데이터 타입은 변경할 수 없기 때문에 subString 동작은 실제로 문자를 새로운 배열로 복사할 필요가 없습니다. 원래 MyString 객체의 문자 배열을 가리키고 새 subString 문자열 객체가 나타내는 시작과 끝을 추적할 수 있습니다. 일부 Java 버전의 문자열 구현은 이 작업을 수행합니다.

이 최적화 방법을 구현하기 위해 클래스의 내부 표현을 아래와 같이 변경합니다:
```java
private char[] a;
private int start;
private int end;
```
새 표현을 사용하여, 동작은 아래와 같이 구현됩니다:
```java
public static MyString valueOf(boolean b) {
    MyString s = new MyString();
    s.a = b ? new char[] {'t','r','u','e'}
            : new char[] {'f','a','l','s','e'};
    s.start = 0;
    s.end = s.a.length;
    return s;
}

public int length() {
    return end - start;
}

public char charAt(int i) {
    return a[start + i];
}

public MyString subString(int start, int end) {
    MyString that = new MyString();
    that.a = this.a;
    that.start = this.start + start;
    that.end = this.start + end;
    return that;
}
```
MyString을 사용하던 기존 클라이언트는 MyString의 private 필드가 아닌 public 메소드의 사양(specification)에만 의존하기 때문에 모든 클라이언트 코드를 검사하고 변경하지 않고도 이 변경을 수행할 수 있습니다. 이것이 표현 독립성의 힘입니다.

### 연습문제 3
#### 문제 3-1
아래 abstract data type을 살펴보세요.
```Java
/**
 * 함께 사는 가족을 표현합니다.
 * 가족은 항상 최소 한 명 이상의 사람을 가집니다.
 * Families는 가변(mutable)입니다.
 */
class Family {
    // 가족 구성원, 나이가 많은 사람순으로 정렬되며, 중복되지 않음.
    public List<Person> people;

    /**
     * @return 중복되지 않은 모든 가족 구성원이 포함된 리스트를 반환.
     */
    public List<Person> getMembers() {
        return people;
    }
}
```
이 abstract 데이터 타입의 클라이언트입니다.
```java
void client1(Family f) {
    // 가족 중 가장 나이 어린 사람을 가져옵니다.
    Person baby = f.people.get(f.people.size() - 1);
}
```
```Family```와 ```Client1``` 코드가 모두 올바르게 동작하고 테스트를 통과한다고 가정합니다.
이제 ```Family```의 표현이 아래와 같이 ```List```에서 ```Set```으로 변경되었습니다.

```java
/**
 * 함께 사는 가족을 표현합니다.
 * 가족은 항상 최소 한 명 이상의 사람을 가집니다.
 * Families는 가변(mutable)입니다.
 */
class Family {
    // 가족 구성원
    public Set<Person> people;

    /**
     * @return 중복되지 않은 모든 가족 구성원이 포함된 리스트를 반환.
     */
    public List<Person> getMembers() {
        return new ArrayList<Person>(people);
    }
}
```
```Family```가 바르게 컴파일 되었다고 가정합니다.

**```Family```가 변경된 후 ```client1```에 대해 true인 것은 어떤 것입니까?**
- [ ] ```client1```은 ```Family```의 표현과 독립적이므로 계속 올바르게 동작합니다.
- [ ] ```client1```은 ```Family```의 표현에 의존하며, 종속성은 static 오류로 포착됩니다.
- [ ] ```client1```은 ```Family```의 표현에 의존하며, 종속성은 dymanic 오류로 포착됩니다.
- [ ] ```client1```은 ```Family```의 표현에 의존하며, 종속성은 포착되지 않지만 런타임에 틀린 답을 생성합니다.
- [ ] ```client1```은 ```Family```의 표현에 의존하며, (다행히) 여전히 동일한 답을 생성합니다.

#### 문제 3-2
이제 ```client2```를 살펴봅시다.
```java
void client2(Family f) {
    // 가족 구성원 수를 가져옵니다.
    int familySize = f.people.size();
}
```
**```Family```가 변경된 후 ```client2```에 대해 true인 것은 어떤 것입니까?**
- [ ] ```client2```는 ```Family```의 표현과 독립적이므로 계속 올바르게 동작합니다.
- [ ] ```client2```는 ```Family```의 표현에 의존하며, 종속성은 static 오류로 포착됩니다.
- [ ] ```client2```는 ```Family```의 표현에 의존하며, 종속성은 dymanic 오류로 포착됩니다.
- [ ] ```client2```는 ```Family```의 표현에 의존하며, 종속성은 포착되지 않지만 런타임에 틀린 답을 생성합니다.
- [ ] ```client2```는 ```Family```의 표현에 의존하며, (다행히) 여전히 동일한 답을 생성합니다.

#### 문제 3-3
이제 ```client3```를 살펴봅시다.
```java
void client3(Family f) {
    // 한 가족 구성원을 가져옵니다.
    Person anybody = f.getMembers().get(0);
    ...
}
```
**```Family```가 변경된 후 ```client3```에 대해 true인 것은 어떤 것입니까?**
- [ ] ```client3```는 ```Family```의 표현과 독립적이므로 계속 올바르게 동작합니다.
- [ ] ```client3```는 ```Family```의 표현에 의존하며, 종속성은 static 오류로 포착됩니다.
- [ ] ```client3```는 ```Family```의 표현에 의존하며, 종속성은 dymanic 오류로 포착됩니다.
- [ ] ```client3```는 ```Family```의 표현에 의존하며, 종속성은 포착되지 않지만 런타임에 틀린 답을 생성합니다.
- [ ] ```client3```는 ```Family```의 표현에 의존하며, (다행히) 여전히 동일한 답을 생성합니다.

#### 연습문제 3-4
아래 Family 데이터 타입의 코드에서, 어떤 부분이 ADT의 사양(specification), 표현(representation), 구현(implementation)에 해당합니까?

```java
/**
 * 함께 사는 가족을 표현합니다.
 * 가족은 항상 최소 한 명 이상의 사람을 가집니다.
 * Families는 가변(mutable)입니다.
 */
```
- [ ] specification
- [ ] representation
- [ ] implementation

```java
public class Family {
```
- [ ] specification
- [ ] representation
- [ ] implementation

```java
// 가족 구성원, 나이가 많은 사람순으로 정렬되며, 중복되지 않음.
```
- [ ] specification
- [ ] representation
- [ ] implementation

```java
    private List<Person> people;
```
- [ ] specification
- [ ] representation
- [ ] implementation

```java
    /**
     * @return 중복되지 않은 모든 가족 구성원이 포함된 리스트를 반환.
     */
```
- [ ] specification
- [ ] representation
- [ ] implementation

```java
    public List<Person> getMembers() {
```
- [ ] specification
- [ ] representation
- [ ] implementation

```java
        return people;
```
- [ ] specification
- [ ] representation
- [ ] implementation

## Java에서 ADT 개념 구현
이 글은 모든 언어의 프로그래밍에 일반적으로 적용할 수 있습니다. 이 글에서 논의한 몇 가지 일반적인 아이디디어와 Java 언어 기능을 사용하여 구체적인 구현을 요약해 보겠습니다. 요점은 이를 수행하는 방법에는 여러가지가 있으며 creator 동작과 같은 큰 아이디어를 이해하는 것과 실제로 그 아이디어를 달성하는 다양한 방법을 모두 이해하는 것이 중요하다는 것입니다.

여기에서 논의되지 않은 것은 creator 동작으로 상수를 사용하는 것입니다. 이 패턴은 일반적으로  가장 단순하거나, 비어있는 값이 public 상수이고 creator가 복잡한 값을 만드는데 사용되는 불변(immutable) 타입에서 흔히 볼 수 있습니다.

|ADT 개념|Java에서 구현|예  |
|--------|------------|----|
|Creator operation| Constructor <br> Static(Factory) <br> method <br> Constant | [ArrayList()](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#ArrayList--) <br> [Collections.singletonList()](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#singletonList-T-) <br> [Arrays.toList](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#asList-T...-) <br> [BigInteger.ZERO](https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html#ZERO) |
|Observer operation| Instance method <br> Static method| [List.get()](https://docs.oracle.com/javase/8/docs/api/java/util/List.html#get-int-) <br> [String.trim()](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#trim--)|
|Producer operation| Instance method <br> Static method | [String.trim()](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#trim--)<br> [Collections.unmodificatableList()](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#unmodifiableList-java.util.List-)|
|Mutator method| Instance method <br> Static method | [List.add()](https://docs.oracle.com/javase/8/docs/api/java/util/List.html#add-E-)<br>[Collections.copy()](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#copy-java.util.List-java.util.List-)|
|Representation|```private``` field ||

## Abstract 데이터 타입 테스트
각 동작에 대한 테스트를 생성하여 abstract 데이터 타입에 대한 테스트 세트를 구성합니다. 이런 테스트는 서로 상호작용합니다. creator, producer, mutator를 테스트하는 유일한 방법은 결과 객체에 대해 observer를 호출하는 것입니다. 마찬가지로, observer를 테스트하는 유일한 방법은 관찰할 객체를 만드는 것입니다.

아래는 MyString 타입에서 네 가지 작업의 입력 공간을 분할하는 방법입니다.
```java
// testing strategy for each operation of MyString:
//
// valueOf():
//    true, false
// length():
//    string len = 0, 1, n
//    string = produced by valueOf(), produced by substring()
// charAt():
//    string len = 1, n
//    i = 0, middle, len-1
//    string = produced by valueOf(), produced by substring()
// substring():
//    string len = 0, 1, n
//    start = 0, middle, len
//    end = 0, middle, len
//    end-start = 0, n
//    string = produced by valueOf(), produced by substring()
```
다음, 이런 모든 파티션을 다루는 컴팩트한 테스트 세트는 아래와 같습니다.
```java
@Test public void testValueOfTrue() {
    MyString s = MyString.valueOf(true);
    assertEquals(4, s.length());
    assertEquals('t', s.charAt(0));
    assertEquals('r', s.charAt(1));
    assertEquals('u', s.charAt(2));
    assertEquals('e', s.charAt(3));
}

@Test public void testValueOfFalse() {
    MyString s = MyString.valueOf(false);
    assertEquals(5, s.length());
    assertEquals('f', s.charAt(0));
    assertEquals('a', s.charAt(1));
    assertEquals('l', s.charAt(2));
    assertEquals('s', s.charAt(3));
    assertEquals('e', s.charAt(4));
}

@Test public void testEndSubstring() {
    MyString s = MyString.valueOf(true).substring(2, 4);
    assertEquals(2, s.length());
    assertEquals('u', s.charAt(0));
    assertEquals('e', s.charAt(1));
}

@Test public void testMiddleSubstring() {
    MyString s = MyString.valueOf(false).substring(1, 2);
    assertEquals(1, s.length());
    assertEquals('a', s.charAt(0));
}

@Test public void testSubstringIsWholeString() {
    MyString s = MyString.valueOf(false).substring(0, 5);
    assertEquals(5, s.length());
    assertEquals('f', s.charAt(0));
    assertEquals('a', s.charAt(1));
    assertEquals('l', s.charAt(2));
    assertEquals('s', s.charAt(3));
    assertEquals('e', s.charAt(4));
}

@Test public void testSubstringOfEmptySubstring() {
    MyString s = MyString.valueOf(false).substring(1, 1).substring(0, 0);
    assertEquals(0, s.length());
}
```
각 테스트 케이스는 일반적으로 해당 타입의 생성하거나 수정하는 몇 개의 동작(creators, producers, mutators)과 해당 타입의 개체를 검사하는 일부 동작(observers)를 호출합니다. 결과적으로 각 테스트케이스는 여러 동작의 일부를 커버합니다.

### 연습 문제
아래 데이터 타입을 살펴보세요:
```java
/** 학생의 진행 상황을 나타내는 불변(Immutable) 데이터 타입 **/
class Student {
    /** 1학년 생성 **/
    public Student() { ... } 

    /** @return 한 학년 올라간 학생을 반환 예:
     * 1학년은 2학년을 반환
     * 2학년은 3학년을 반환
     * 3학년은 3학년을 반환
     * 4학년은 졸업생을 반환
     * 졸업생은 졸업생을 반환, 졸업생은 학년이 올라가지 못함 */
    public Student promote() { ... }

    /** @return 학교를 이수현 연수. 예: 1학년: 0, 졸업생: 4 */
    public int getYears() { ... }
}
```
**1. ADT 동작 분할**
* Student() constructor의 입력은 합리적으로 몇 개의 부분으로 분할됩니까?
* promote() 의 입력은 합리적으로(완전하지 않더라도) 몇 개의 부분으로 분할됩니까?
* getYears() 의 입력은 합리적으로(완전하지 않더라도) 몇 개의 부분으로 분할됩니까?

**2. ADT 테스트 케이스 선택**
아래의 메소드 호출 순서는 단일 테스트 케이스입니다. 각 메서드가 호출되는 객체에 대한 세부 정보와 반환 값은 생략했습니다.  
위의 모든 분할을 포함하는 테스트 사례를 모두 고르세요
- [ ] promote(), promote(), promote(), promote()
- [ ] Student(), promote(), promote(), promote(), promote(), getYears()
- [ ] Student(), promote(), getYears(), promote(), getYears(), promote(), getYears(), promote(), getYears()
- [ ] Student(), getYears(), promote(), getYears(), promote(), promote(), promote(), getYears()
- [ ] Student(), getYears(), promote(), getYears(), promote(), getYears(), promote(), getYears(), promote(), getYears()

## 요약
* Abstract 데이터 타입은 동작(Operation)으로 특징지어집니다.
* 동작(Operation)은 creator, producer, observer, mutator로 분류됩니다.
* ADT의 사양(Specification)은 동작의 묶음과 해당 사양입니다.
* 좋은 ADT는 단순하고, 일관되며, 적절하고 표현 독립적입니다.
* ADT는 각 동작에 대한 테스트를 생성하여 테스트 되지만 creator, producer, mutator, observer를 동일한 테스트 상에서 함께 사용합니다.

이 아이디어들은 아래 좋은 소프트웨어의 세 가지 핵심 속성과 연결됩니다.
* **버그 안전성.**  좋은 ADT는 데이터 타입에 대해 잘 정의된 계약을 제공하므로 클라이언트는 데이터 타입에서 기대할 수 있는 것을 잘 알 수 있고 구현자는 잘 정의된 수정의 자유를 가질 수 있습니다.
* **이해하기 쉬움.** 좋은 ADT는 간단한 동작 뒤에 구현을 숨기므로 ADT를 사용하는 프로그래머는 구현의 세부 사항이 아닌 작업만 이해하면 됩니다.
* **준비된 변경.** 표현 독립성(Represenation Independence)은 Abstract 데이터 타입의 구현이 클라이언트의 변경 없이도 수정 가능하도록 합니다.