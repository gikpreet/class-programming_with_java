# Module 13 Generics
이 모듈에서는 Java에서 파라미터를 이용한 다형성을 구현할 수 이는 Generics에 대해 알아보고, Generics를 이용해 메소드 또는 클래스를 사용하여 보다 폭 넓은 방식의 객체를 구현하여 얻을 수 있는 이점에 대해 학습합니다.

이 모듈을 마치면, 다음과 같은 것들을 할 수 있게 됩니다:
* Generics에 대해 이해하고, 설명할 수 있습니다.
* Generics를 이용해 타입과 메소드를 정의할 수 있습니다.
* Generics를 이용해 런타임에서 발생할 오류를 컴파일 타임에 찾아 수정할 수 있습니다.
* Generics를 이용해 이전에 작성한 코드를 보다 다양하게 사용할 수 있는 코드로 수정할 수 있습니다.

#### Table of Contents
1. Generics 개요
2. Generic 타입
3. Generic 메소드
4. 타입 파라미터
5. 타입 삭제
6. 제한 사항

<br />
<br />
<br />
<br />
<br />

## Generics 개요
Generics는 Generic이라는 단어가 주는 의미처럼, 다양한 타입에 적용할 수 있는 객체를 만들수 있도록 지원합니다. 이 장에서는 Java 언어의 Generics 개요에 대해 알아봅니다.

#### Table of Contents
1. Generics 개요
2. 강력한 타입 검사
3. 형 변환 감소
4. 일반 알고리즘의 구현

<br />

### Generics 개요
***
* 객체 생성시 부여되는 타입을 이용한 파라미터 다형성(Parametric Polymorphism) 구현
* 타입(Class, Interface) 또는 메소드에 정의
```java
class Box<T> {
    T item;
    ...
}
Box<String> stringBox = new Box<>(“String”);
Box<Integer> integerBox = new Box<>(100);

class Box<T> {
    T item;
    
    public T simpleFunction(T item) { ... }
}
```
***
Generics는 Generic이라는 단어가 주는 의미<sup id="a1">[1](#footnote1)</sup>처럼 다양한 타입에 적용할 수 있도록 지원합니다. Generics는 타입(클래스, 인터페이스)에 정의 가능하며 메소드 정의에도 사용할 수 있습니다.
```java
class Box<T> {
    T item;

    public Box(T string) {
        this.item = string;
    }

    public T getItem() {
        return this.item;
    }
}
```
Generics는 객체 생성시 명확한 타입 적용을 통해 컴파일러에서 타입 사용에 대한 안정성 검사를 지원합니다. 또한, 객체 생성시 주어지는 타입 정보는 불필요한 타입 변환을 줄여 간결한 코드 작성을 도와줍니다. 

클래스나 메소드의 작성시 타입 파라미터를 통해 타입 지정이 가능하도록 하여, 특정 타입에 국한되지 않는 코드 작성으로 특정 타입에 제한되지 않는 일반적인(Generic 한) 알고리즘 구현이 가능하도록 합니다.

<sup id="footnote1">1</sup> 형용사, 포괄적인, 총칭(통칭)의. 

<br />

### 강력한 타입 검사
***
* Generics는 타입 안정성(Type Safety)를 지원
    * 타입 파라미터를 통해 전달된 타입 정보를 이용하여 컴파일 타임에 검사
* java.lang.Object 타입으로 변환되는 객체 형 변환은 런타임에 검사됨
    * 컴파일시에 오류를 발견할 수 없음
    * java.lang.ClassCastException 예외 발생
* Generics는 타입이 명확히 명시되므로 컴파일 타임에 오류를 검출할 수 있음
***

Generic이 적용되면 타임 파라미터를 기준으로 타입 안정성을 검사합니다. 이는 코드 작성 중 빈번히 발생될 수 있는 타입 검사 오류를 컴파일시에 확인해 줌으로써, 코드 작성 중 검출할 수 없고 런타임에 발생하는 오류 처리에서 발생하는 손실 비용을 최소화할 수 있도록 해 줍니다.

Generoc이 적용되지 않은 코드에서 일반적인 데이터를 처리하기 위해서는 데이터를 최상위 타입인 java.lang.Object로 처리합니다. 

```java
public class TypeSafetyExample {
    public static class Box {
        Object item;

        public void set(Object item) {
            this.item = item;
        }

        public Object get() {
            return this.item;
        }
    }
    public static void main(String [] args) {
        Box box = new Box();
        box.set("Hello");
        Integer value = (Integer) box.get();
        System.out.println("Value is " + value);
    }
}
```
위 코드는 전역변수 item이 일반적인 데이터를 처리하도록 하기 위해 Object 타입을 사용합니다. item의 setter 메소드에서 item에 Hello 문자열을 저장할 경우, String 타입은 Object의 서브타입이므로 item의 값을 가져오기 위해서는 Object 타입을 String 타입으로 타입 변환해야 합니다. 이 경우 컴파일러는 특정 타입을 Object로 타입 변환하는 것에 대해 오류를 발생하지 않습니다.

오류는 프로그램을 실행할 때 발생합니다. 프로그램은 타입 사이의 변환 실패로 오류를 출력하고 실행을 종료합니다. 
```bash
$ java TypeSafetyExample    
Exception in thread "main" java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
        at TypeSafetyExample.main(TypeSafetyExample.java:16)
```
해당 코드에 Generic을 적용하면 이런 종류의 런타임 오류를 회피할 수 있습니다.
```java
public class TypeSafetyGenericsExample {
    public static class Box<T> {
        T item;

        public void set(T item) {
            this.item = item;
        }

        public T get() {
            return this.item;
        }
    }
    public static void main(String [] args) {
        Box<String> box = new Box<>();
        box.set("Hello");
        Integer value = box.get();
        System.out.println("Value is " + value);
    }
}
```

Generic을 사용하여 수정한 위 코드는 컴파일 타임에 오류를 검출합니다.

```bash
$ javac TypeSafetyGenericsExample.java
TypeSafetyGenericsExample.java:16: error: incompatible types: String cannot be converted to Integer
        Integer value = box.get();
```
Generic의 적용은 타입 검사를 통해 런타임에 발생할 수 있는 타입 오류를 컴파일시에 찾아 줌으로써 오류 발생 지연을 방지하는 기능을 수행할 수 있습니다.

<br />

### 타입 변환 감소
***
* 수퍼 타입을 서브 타입으로 변환하기 위해서는 타입 변환이 필요함
```java
public class TypeSafetyExample {
    public static class Box {
        Object item;
        …
    }
    public static void main(String [] args) {
        …
        Integer value = (Integer) box.get();
        …
    }
}
```
* Generic을 적용할 경우 별도의 타입 변환 과정을 필요로 하지 않음
```java
public class TypeSafetyGenericsExample {
    public static class Box<T> {
        T item;
        …
    }
    public static void main(String [] args) {
        …
        Integer value = box.get();
        …
    }
}
```
***

Generic이 적용되지 않은 경우, Box 클래스의 전역 변수 item이 다양한 타입을 처리할 수 있도록 정의되어야 하는 경우 java.lang.Object로 선언됩니다. Java에서 기본 데이터 타입(Primitive Data Type)을 제외한 모든 타입은 Object의 서브 타입이므로 데이터의 설정에는 별다른 작업이 필요하지 않습니다.

하지만 데이터를 사용해야 하는 경우에 Box에 저장되어 있는 데이터는 클래스 인스턴스 타입으로 변환되어야 합니다. 이 과정을 수행할 때 마다 타입 변환이 요구됩니다.

이에 비해 Generic을 적용할 경우 클래스의 전역 변수 타입이 타입 인자를 통해 명확하게 설명되므로 컴파일러에서 확인이 가능하여, 이를 통해 데이터 간 호환 타입에 대한 부가적인 설명이 필요 없게 되어 타입 변환이 없는 간결한 코드 작성이 가능합니다.

<br />

### 알고리즘 일반화 구현
***
* Generics는 알고리즘 일반화를 구현할 수 있도록 함
    * 다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스에 컴파일 시 타입 체크를 가능하도록 함
```java 
public static <T extends Comparable<T>> void bubbleSort(T[] items) {
    for(int i = items.length - 1 ; i > 0 ; i--) {
        for(int j = 0 ; j < i ; j++)  {
            if (items[j].compareTo(items[j+1]) > 0) {
                T item = items[j];
                items[j] = items[j+1];
                items[j+1] = item;
            }
        }
    }
}
```
* 타입 파라미터가 Compatable의 서브 타입이면 정렬 가능하도록 정의
* 비교 가능한 아이템의 경우 정렬이 가능하도록 선언하며, 특정 데이터 타입에 국한되지 않는 일반적인 알고리즘의 구현이 가능
***

Generics는 모듈이나 알고리즘을 구현한 후 다양한 타입에 적용할 수 있도록 지원합니다. 

버블 정렬은 각 항목의 비교를 통해 항목의 순서를 정렬하는 잘 알려진 알고리즘입니다. 일반적인 버블 정렬 알고리즘은 하나의 타입에 대한 정렬을 수행하지만, Generic는 항목간 비교가 가능한 Comparable 항목이라면 정렬 가능한 일반적인 알고리즘 작성을 가능하게 합니다. 또한, 알고리즘 구현 단계에서 특정 타입을 이용한 검증을 통해 알고리즘의 신뢰성이 확보되었다면 다른 타입에 대해서도 신뢰성이 보장되었다고 할 수 있습니다.

```java
public class BubbleSortExample {
    public static <T extends Comparable<T>> void bubbleSort(T[] items) {
        for(int i = items.length - 1 ; i > 0 ; i--) {
            for(int j = 0 ; j < i; j++)  {
                if (items[j].compareTo(items[j+1]) > 0) {
                    T item = items[j];
                    items[j] = items[j+1];
                    items[j+1] = item;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integerList =  {1, 10, 7, 2, 5, 4, 9, 8, 3, 6};
        String[] stringList =  {"James", "Robert", "John", "Michael", "William", "Noah", "Liam", "Jacob"};

        System.out.println("정렬 전 : " + Arrays.toString(integerList));
        bubbleSort(integerList);
        System.out.println("정렬 후 : " + Arrays.toString(integerList));

        System.out.println("정렬 전 : " + Arrays.toString(stringList));
        bubbleSort(stringList);
        System.out.println("정렬 후 : " + Arrays.toString(stringList));
    }
}
```
실행 결과는 아래와 같습니다.
```
정렬 전 : [1, 10, 7, 2, 5, 4, 9, 8, 3, 6] 
정렬 후 : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 
정렬 전 : [James, Robert, John, Michael, William, Noah, Liam, Jacob] 
정렬 후 : [Jacob, James, John, Liam, Michael, Noah, Robert, William]
```

<br />
<br />
<br />
<br />
<br />

## Generic 타입
Generic 타입은 클래스 또는 인터페이스에 선언하며, 타입 파라미터 이름은 단일 대문자를 사용하고 기본 데이터 타입은 사용할 수 없으며 인자의 상속관계는 Generic 타입의 상속관계와는 관련이 없는 등의 특징을 가지고 있습니다. 이 장에서는 Generic 타입에 대해 알아봅니다.

#### Table of Contents
1. Generic 타입 선언
2. 객체 생성

<br />

### Generic 타입 선언
***
* 일반 타입 선언(클래스와 인터페이스)에 타입 파라미터를 추가한 형태로 사용
* 타입 파라미터는 클래스나 인터페이스의 이름뒤에 선언하며, < > 기호 사이에 열거됨
```java
public class Box<T> {
   private T t;
​
   public void set(T t) {
       this.t = t;
  }
​
   public T get() {
       return  this.t;
  }
}
```
* 하나 이상의 타입 파라미터를 사용할 수 있음
```java
class Pair<K, V> {
   private K key;
   private V value;
​
   public K getKey() {
       return this. key;
  }
​
   public V getValue() {
       return  this. value;
  }
}
```
***

Generic 타입은 일반 타입(클래스 또는 인터페이스)의 선언과 유사합니다. 

아래의 Box 클래스는 전역 변수 item을 일반적인 타입으로 선언하기 위해 Object 타입으로 선언했습니다.

```java
public static class Box {
    Object item;

    public void set(Object item) {
        this.item = item;
    }

    public Object get() {
        return this.item;
    }
}
```

위와 같은 형식의 클래스를 Generic 타입으로 변경하는 절차는 아래와 같습니다.

1. Box 클래스 이름 뒤에 타입 파라미터 T를 추가
```java
public static class Box<T> {
    Object item;

    public void set(Object item) {
        this.item = item;
    }

    public Object get() {
        return this.item;
    }
}
```
2. 클래스 내부에 선언된 유효한 타입들을 타입 파라미터 T로 치환합니다.
```java
public static class Box<T> {
    T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}
```

<br />

### Generic 타입 생성자
***
* Generic 타입 생성자에서는 타입 파라미터를 사용하지 않음
* 일반 크래스와 동일한 방법으로 생성자 선언

```java
class Box<T> {
    T box;
    public Box(T box) {
        this.box = box;
    }
}
```
***

Generic 클래스 생성자에서는 타입 파라미터를 사용하지 않습니다. Generic 클래스의 생성자는 일반 클래스의 생성자 규칙과 동일합니다.
```java
class Box<T> {
    T box;

    public Box(T box) {
        this.box = box;
    }
}
```
위와 같이 선언한 클래스는 아래와 같은 방식으로 생성할 수 있습니다.
```java
Box<Integer> box = new Box<Integer>(1);
```

<br />

### Generic 객체 생성
***
* Generic 타입을 생성할 때 타입 파라미터가 주어져야 함
* 참조 변수와 생성자에 주어지는 타입 파라미터는 동일해야 함

```java
Box<Integer> box = new Box<Integer>();
Box<String> box = new Box<String>();
```
* 타입 파라미터의 상속 관계는 Generic 타입 생성시 영향을 주지 않음
    * 타입 파라미터는 불공변성을 가짐
    * Generic 타입의 상속 관계는 일반 상속관계와 동일하게 적용됨
* 타입 파라미터가 명확한 경우, 생성자 호출시 전달되어야 하는 타입 변수는 생략 가능
***

Generic 타입을 이용해 객체를 생성할 때는 타입 파라미터에 사용하고자 하는 타입 파라미터를 제공해야 합니다.

Box<T>에서 T는 타입 파라미터이며, T의 타입으로 Integer라는 타입 파라미터를 전달하여 Box<T>가 Integer를 받거나 제공할 수 있는 객체로 생성됩니다.
Box의 생성자에서는 Integer를 타입 파라미터로, 참조 변수에서는 타입 인수로 생성할 경우, 타입 인수간 상속 관계로 동작에 문제가 없어 보이지만 Generic에서 타입 파라미터는 불공변성을 가지므로 Integer로 선언된 타입에는 반드시 Integer 타입 파라미터로 생성되어야 합니다.
Generic 타입 객체는 아래와 같이 생성됩니다.

```java
Box<Integer> box1 = new Box<Integer>(1);
Box<String> box2 = new Box<String>(“Hello”);
```
생성자를 호출할 때 타입 파라미터의 타입을 생략할 수 있습니다.
```java
Box<Integer> box = new Box<>(1);
```
타입 파라미터 자체를 생략하면, 컴파일시에 타입 오류를 발생하지 않고 오류 가능성을 경고만 합니다. 오류는 런타임에 발생합니다.
```java
Box<Integer> box = new Box<>("Hello");	// 컴파일 오류
Box<Integer> box = new Box("Hello");	// 오류 가능성 경고
```

<br />
<br />
<br />
<br />
<br />

## Generic 메소드

Generic 메소드는 Generic 타입과 같이 타입 파라미터를 적용해 다양한 타입에 적용할 수 있는 벙용적인 메소드를 구현하도록 합니다. 이 장에서는 Generic 메소드에 대해 알아봅니다.

#### Table of Contents
1. Generic 메소드 선언
2. 타입 추론

<br />

### Generic 메소드 선언
***
* 일반 메소드 선언과 동일하며, 일반화 할 타입을 타입 파라미터로 선언
* 메소드 앞에 <> 기호를 사용하여 타입 파라미터 목록을 선언

```java
<Access Modifier> <Type Parameter List> <Return Type> Method name(Parameter list)

public <T> List<T> arrayToList(T[] array) { ... }
```
***

Generic 메소드의 선언은 일반 메소드 선언과 동일하며, 일반화할 타입을 타입 파라미터로 선언합니다. 메소드는 타입 파라미터의 목록을 가져야 하며, 메소드 선언에 타입 파라미터 목록을 선언해야 합니다.
다음 메소드는 배열을 파라미터로 받아 리스트를 반환합니다.

```java
public class GenericMethod {
    public static <T> List<T> arrayToList(T[] array) {
        List<T> list = new LinkedList<T>();
            
        for(T t : array) {
            list.add(t);
        }   
        return  list;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};

        GenericMethod me = new GenericMethod();
        List<Integer> list = me.<Integer>arrayToList(array);
    }
}
```

메소드 호출 시 메소드 이름앞에 <> 기호와 함께 타입 파라미터를 선언해야 합니다.
```java
Integer[] array = {1, 2, 3};
List<Integer> list = GenericMethod.<Integer>arrayToList(array);
```
타입 파라미터는 Generic 타입에서와 마찬가지로 두 개 이상 사용할 수 있습니다.

<br />

### 타입 추론
***
* 메소드 시그너처의 타입 파라미터는 호출시 생략이 가능함
    * 컴파일러에서 주어진 파라미터를 통해 적용될 타입의 추론이 가능함
```java
public <T> void fromArrayToCollection (T[] array, Collection<T> collection) {
    ...  
}

String[] sa = new String[100];
Collection<String> cs = new ArrayList< >();

fromArrayToCollection(sa, cs);	// T는 String으로 추론됨
```

* 하나의 타입 파라미터에 대해 추정되는 타입이 2개 이상 존재할 경우 오류 발생
```java
String[] sa = new String[100];
Collection<Integer> ci = new ArrayList< >();
​
fromArrayToCollection(sa, ci);	// T는 String과 Integer로 추론됨
```
***

아래의 코드는 배열과 컬렉션을 파라미터로 배열의 원소들을 컬렉션을 복사하는 Generic 메소드입니다.
```java
public <T> void fromArrayToCollection (T[] array, Collection<T> collection) {
    for(T t : array) {
        collection.add(t);
    }  
}
```
아래와 같이 Object 타입을 타입 파라미터로 Generic 메소드를 호출할 수 있습니다. 이 경우 T는 Object로 추론됩니다.
```java
Object[] objectArray= new Object[10];
Collection<Object> objectCollection = new ArrayList<Object>();

fromArrayToCollection(objectArray, objectCollection);	// T는 Object로 추론
```

아래와 같이 String 타입을 타입 파라미터로 Generic 메소드를 호출하면 T는 String 타입으로 추론됩니다.
```java
String[] objectArray= new String[10];
Collection<String> stringCollection = new ArrayList< String >();

fromArrayToCollection(objectArray, objectCollection);
```
다양한 타입들이 Generic 메소드의 파라미터로 사용되는 아래와 같은 경우, 계층 구조에 따른 암시적 형변환 형식으로 타입이 추론되며, 추론되는 타입이 다를 경우 컴파일 오류가 발생합니다.
``` java
Integer[] integerArray = new Integer[100];
Float[] floatArray = new Float[100];
Number[] numberArray = new Number[100];
Collection<Number> numberCollection = new ArrayList<Number>();
// T는 Number로 추정됩니다. (Integer는 Number의 서브 타입)
fromArrayToCollection(integerArray, numberCollection);
// T는 Number로 추정됩니다. (Float는 Number의 서브 타입)
fromArrayToCollection(floatArray, numberCollection);
// T는 Number로 추정됨
fromArrayToCollection(numberArray, numberCollection);
// T는 Object로 추정됨
fromArrayToCollection(objectArray, numberCollection);
// 컴파일 타임 오류 - 추론되는 두 타입이 하나의 타입으로 호환되지 않음
fromArrayToCollection(numberArray, stringCollection);
```
Generic 메소드에 실제 타입 파라미터를 전달할 필요는 없습니다. 컴파일러에서는 주어진 파라미터의 타입에서 실제 타입 인자를 추론할 수 있고, 단일 타입으로 추론이 어려운 경우 오류가 발생합니다.

<br />
<br />
<br />
<br />
<br />

## 타입 파라미터

Generic 타입은 타입 파라미터가 필요합니다. 타입 파라미터에는 기본 데이터 타입을 제외한 모든 타입을 사용할 수 있으며, 정의되는 타입 내에서 변수 선언의 타입으로 사용됩니다. 이 장에서는 타입 파라미터에 대해 알아봅니다.

#### Table of Contents
1. 타입 파라미터 규칙
2. 다중 타입 파라미터
3. 타입 제한

<br />

### 타입 파라미터 명명 규칙
***
* 타입 파라미터 명명 권장 사항
    * E : 요소 (Element – Java Collections Framework에서 폭 넓게 사용됨)
    * K – 키 (Key)
    * N – 숫자 (Number)
    * T – 타입 (Type)
    * V – 값 (Value)
    * S, U, V 등 – 2번째, 3번째, 4번째 등
***

타입 파라미터의 이름에 특별한 제약은 없지만, 일반 클래스나 인터페이스와 혼동을 피하기 위해 사용되는 명명 규칙을 사용하는 것이 권장됩니다.

<br />

### 다중 타입 파라미터
***
* 파라미터에는 하나 이상의 타입을 지정할 수 있음
```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}
```
* 다중 파라미터 타입도 타입 인자를 통해 타입 파라미터의 추론이 가능한 경우, 생성자에서 타입 인수의 생략이 가능함
```java
Pair<String, Integer> p1 = new OrderPair("Even", 8);
Pair<String, String> p2 = new OrderPair("Hello", "World");
```
***
Java의 Generic 타입은 타입 파라미터에 하나 이상의 타입 파라미터를 사용할 수 있습니다.
```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}
 
public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;
 
    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
   }
 
    public K getKey() { return key; }
    public V getValue() { return value; }
}
```
키로 문자열을 사용하고 값으로 정수를 가지는 OrderPair 객체의 생성은 다음과 같이 할 수 있습니다:
```java
Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
```
키로 문자열을 사용하고 값 또한 문자열을 사용하는 OrderPair 객체의 생성은 다음과 같이 할 수 있습니다.
```java
Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");
```
아래와 같이 생성자에서 타입 파라미터를 타입 추론하게 할 수 있습니다.
```java
Pair<String, Integer> p1 = new OrderedPair("Even", 8);
Pair<String, String> p2 = new OrderedPair("hello", "world");
```

<br />

### 타입 제한
***
* 타입 파라미터로 전달 가능한 함수는 참조 타입, 즉 클래스나 인터페이스로 제한됨
* int, boolean등 기본 데이터 타입을 사용해야 하는 경우 Wrapper 클래스를 사용
***
Java의 Generics에서는 타입 파라미터로 기본 데이터 타입을 사용할 수 없으며, 사용할 경우 컴파일 타임에 오류가 발생합니다.
```java
Pair<String, int> p1 = new OrderedPair<String, int>("Even", 8);
```
```bash
unexpected type 
required: reference 
found: int
```
정수형, 부동 소수점 형등의 Generic 사용을 위해서는 Wrapper 클래스를 사용할 수 있습니다.
```java
Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
```

<br />

### 상속 및 서브타입
***
* 타입 파라미터의 상속 관계는 Generic 타입의 상속과 무관함
* Generic 파라미터로 지정된 타입 인스턴스의 동작은 공변적

```java
Box<Number> box = new Box<Number>();
box.add(new Integer(10));   // OK
box.add(new Double(10.1));  // OK
```
* 타입 파라미터는 반공변적
```java
Box<Number> box = new Box<Integer>();	// 컴파일 오류
```
* Generic 클래스의 확장
    * 타입 파라미터를 변경하지 않는 한 서브 타입 지정 관계가 유지됨
***

Generic 파라미터로 전달되어 생성된 인스턴스는 클래스의 타입 변환 규칙과 동일합니다. 타입 파라미터로 지정되어 생성된 Generic 객체 내의 타입은 Java의 타입 변환 규칙을 위반하지 않는 한 같은 방식으로 동작할 수 있습니다.
```java
Box<Number> box = new Box<Number>();
box.add(new Integer(10));   // OK
box.add(new Double(10.1));  // OK
```
선언되는 Generic 파라미터 타입과 생성자에서 생성되는 Generic 파라미터 타입은 타입 변환 규칙을 따르지 않습니다. 반드시 같은 타입으로 선언되어야 합니다. 아래 코드에서 Box<Number>와 Box<Integer>는 별개의 타입으로 인식됩니다.
```java
Box<Number> box = new Box<Integer>();		// 컴파일 오류
```

**Generic 타입 상속**  
Generic 클래스 역시 일반 클래스와 동일하게 확장될 수 있습니다. 서브 타입은 슈퍼 타입 Generic 파라미터 보다 더 많은 Generic 파라미터를 가질 수 있습니다.
```java
public class Product<T, M> {
    private T kind;
    private M model;
 
    public T getKind() {
        return kind;
    }
 
    public void setKind(T kind) {
        this.kind = kind;
    }
 
    public M getModel() {
        return model;
    }
 
    public void setModel(M model) {
        this.model = model;
    }
}

public class ChildProduct<T, M, C> extends Product<T, M> {
    private C company;
 
    public C getCompany() {
        return company;
    }
 
    public void setCompany(C company) {
        this.company = company;
    }
}
```

<br />

### 와일드 카드
***
* 파라미터나 return 값이 특정한 타입 파라미터를 정의하지 않고 임의의 타입을 지정
    * 타입 인자에 대한 제한을 두지 않음
    * 특정 타입 또는 상속 받은 타입으로 타입 인자를 제한
    * 특정 타입 또는 상위 타입으로 타입 인자를 제한
* 무제한 와일드 카드
    * 타입 인자에 제한을 두지 않음

```java
void genericMethod(Collection<?> collection) { ... }
```

* 슈퍼 타입 제한 와일드 카드
    * 지정된 타입이나 그로부터 상속 받은 타입에 한해서만 적용
    * 타입 파라미터에 extends 키워드를 사용해 허용가능한 최상위 타입을 선언

```java
void genericMethod(List<? extends Number>) { ... }
```

* 서브 타입 제한 와일드 카드
    * 지정된 타입이나 슈퍼 타입에 한해서만 적용
    * 타입 파라미터에 super 키워드를 사용해 허용 가능한 최하위 타입을 선언

```java
void genericMethod(List<? super Number>) { ... }
```
***

와일드 카드는 Generic을 정의할 때 return 값에 대해 특정한 타입 파라미터를 정의하지 않고 임의의 타입이 올 수 있는 기능을 제공합니다. Generic 파라미터의 와일드 카드는 <?> 형식으로 정의되며, 인자로 받을 수 있는 타입의 제한이 가능합니다.

**무제한 와일드 카드(Unbounds Wildcards)**  
Generic 파라미터로 전달받은 타입에 제한을 두지 않으며, 아래와 같이 사용합니다.
```
<Access Modifier> <Type Parameter List> <Return Type> 
Method name(<?>Parameter list)
```

```java
public class GenericMethodWithWildcardTest {
    static void showList(List<?> list) {
        Iterator<?> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next().toString() + ' ');
        }
        System.out.println("");
    }
 
    public static void main(String[] args) {
        List<Number> numberList = Arrays.asList(1, 2, 3);
        List<String> stringList = Arrays.asList("one", "two", "three");
 
        showList(numberList);
        showList(stringList);
    }
}
```
```bash
1 2 3 
one two three
```
**슈퍼 타입 제한 와일드 카드**
```java
<? extends [Type]>
``````
슈퍼 타입 제한 와일드 카드는 와일드 카드에 들어갈 수 있는 타입 인수를 주어진 타입이거나 상속된 타입으로만 제한합니다.
```java
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class GenericMethodWithWildcardTest {
    static <T> void find(T item, List<? extends Number> list) {
        Iterator<?> it = list.iterator();
        while(it.hasNext()) {
            Object element = it.next();
            if (element.equals(item)) {
                System.out.println(item + " found");
                return;
            }
        }
        System.out.println(item + " not found.");
    }

   public static void main(String[] args) {
       List<Number> list = Arrays.asList(1, 2, 3);
       Number value = new Integer(2);

       find(value, list);
    }
}
```
GenericMethodWIthWildcardTest 클래스의 find 메소드는 슈퍼 타입 제한 와일드 카드를 사용해 Number의 서브 타입에 대해서만 호출을 허용합니다. 만약, Number의 서브 타입이 아닌 객체가 Generic 파라미터로 넘겨지면 컴파일러는 오류를 출력합니다.

```java
public static void main(String[] args) {
    List<Object> list = Arrays.asList(1, 2, 3);
    Number value = new Integer(2);

    find(value, list);
}
```
```bash
java: method find in class GenericMethodWithWildcardTest cannot be applied to given types;
  required: T,java.util.List<? extends java.lang.Number>
  found: java.lang.Number,java.util.List<java.lang.Object>
  reason: cannot infer type-variable(s) T
    (argument mismatch; java.util.List<java.lang.Object> cannot be converted to java.util.List<? extends java.lang.Number>)
```
**서브 타입 제한 와일드카드**

```java
<? super [Type]>
```

서브 타입 제한 와일드카드는 와일드카드에 들어올 수 있는 타입 인자를 주어진 타입이거나 또는 주어진 타입의 슈퍼 타입으로 제한합니다.
```java
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class GenericMethodWithWildcardTest {
    static <T> void find(T item, List<? super Number> list) {
        Iterator<?> it = list.iterator();
        while(it.hasNext()) {
            Object  element = it.next();
            if (element.equals(item)) {
                System.out.println(item + " found");
                return;
            }
        }
        System.out.println(item + " not found.");
    }

    public static void main(String[] args) {
        List<Object> list = Arrays.asList(1, 2, 3);
        Number value = new Integer(2);

        find(value, list);
    }
}
```
GenericMethodWIthWildcardTest 클래스의 find 메소드는 서브 타입 제한 와일드 카드를 사용해 Number의 슈퍼 타입에 대해서만 호출을 허용합니다. 만약, Number의 슈퍼 타입이 아닌 객체가 Generic 파라미터로 넘겨지면 컴파일러는 오류를 출력합니다.

```java
public static void main(String[] args) {
   List<Integer> list = Arrays.asList(1, 2, 3);
   Number value = new Integer(2);

   find(value, list);
}
```

```bash
java: method find in class GenericMethodWithWildcardTest cannot be applied to given types;
required: T,java.util.List<? super java.lang.Number>
found: java.lang.Number,java.util.List<java.lang.Integer>
reason: cannot infer type-variable(s) T
  (argument mismatch; java.util.List<java.lang.Integer> cannot be converted to java.util.List<? super java.lang.Number>)
```

<br />
<br />
<br />
<br />
<br />

## 타입 삭제
Generics에서 타입 파라미터는 컴파일 타임에만 사용되고, 컴파일 후에는 삭제 후 Object 타입으로 치환되어 바이트 코드에는 Generic에 관한 정보가 저장되지 않습니다. 이 장에서는 Generics에서 타입 삭제에 관해 알아봅니다.

#### Table of Contents
1. Generic 타입에서 타입 삭제
2. Generic 메소드에서 타입 삭제

<br />

### Generic에서의 타입 삭제
***
* Generic 타입 파라미터는 컴파일시에 모두 삭제됨
* 타입 파라미터가 제한되지 않는 경우, Object 타입으로 변경됨
* 타입 제한이 있는 경우, 해당 타입으로 변경됨

```java
public class Node<T> {
    private T data;
    private Node<T> next;
 
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
   }
}

public class Node {
    private Object data;
    private Node next;
 
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
   }
}
```
***

Java 소스 파일이 컴파일 될 때, 컴파일러는 모든 타입 파라미터를 지웁니다. 타입 파라미터를 삭제한 후 타입 파라미터가 슈퍼 타입 또는 서브 타입으로 제한되면 각 타입으로, 제한되지 않은 경우 Object로 변경합니다.

**타입 파라미터 제한이 없는 경우**  
타입 파라미터를 삭제한 후 타입 파라미터를 Object로 대치합니다.
```java
public class Node<T> {
    private T data;
    private Node<T> next;
 
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
 
    public T getData() { 
        return data; 
    }
}
```

<T> 타입 파라미터를 가지는 클래스 Node는 타입 파라미터 제한이 없으므로 컴파일러는 이를 Object로 대체합니다.

```java
public class Node {
    private Object data;
    private Node next;
 
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
 
    public Object getData() { 
        return data; 
    }
}
```
**제한된 타입 파라미터를 사용하는 경우**  
타입 파라미터를 삭제한 후 해당 타입으로 대치합니다.
```java
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> next;
 
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
 
    public T getData() { 
        return data; 
    }
}
``````
Generic 타입 Node는 Comparable의 서브 타입으로 Generic 파라미터를 제한합니다. 이 경우 컴파일러는 타입 파라미터 T를 첫 번째 바인딩된 타입인 Comparable로 대치합니다.
```java
public class Node {
    private Comparable data;
    private Node next;
 
    public Node(Comparable data, Node next) {
        this.data = data;
        this.next = next;
    }
 
    public Comparable getData() { 
        return data; 
    }
}
```

<br />

### Generic 메소드에서의 타입 삭제
***
* Generic 타입과 동일하게 타입 파라미터는 삭제됨
* 타입 제한이 없는 경우 타입 파라미터는 Object 타입으로 변경됨
* 타입 제한이 없는 경우 해당 타입으로 변경됨
```java
public static <T> int count(T[] anArray, T elem) {
   int cnt = 0;
   for (T e : anArray)
       …
}

public static int count(Object[] anArray, Object elem) {
   int cnt = 0;
   for (Object e : anArray)
        …
}
```
***

Generic 타입에서와 동일하게, Java 컴파일러는 Generic 메소드의 타입 파라미터도 삭제합니다.

**타입 파라미터 제한이 없는 경우**  
타입 파라미터를 삭제한 후 타입 파라미터를 Object로 대치합니다.
```java
public static <T> int count(T[] array, T element) {
    int count = 0;
    for (T e : array) {
        if (e.equals(element)) {
            ++count;
        }
    }
    return count;
}
```

<T> 타입 파라미터를 가지는 Generic 메소드 count는 타입 파라미터 제한이 없으므로 컴파일러는 이를 Object로 대체합니다.
```java
public static int count(Object[] array, Object element) {
    int count = 0;
    for (Object e : array) {
        if (e.equals(element)) {
            ++count;
        }
    }
    return count;
}
```

**제한된 타입 파라미터를 사용하는 경우**  
타입 파라미터를 삭제한 후 해당 타입으로 대치합니다.
```java
class Shape { ... }
class Circle extends Shape { ... }
class Rectangle extends Shape { ... }
```
Shape, Shape의 서브타입인 Circle, Shape의 서브타입인 Rectangle 클래스가 있을 때, 다양한 모양을 그릴 수 있는 일반적인 Generic 메소드를 아래와 같이 정의할 수 있습니다.
```java
public static <T extends Shape> void draw(T shape) { ... }
```
컴파일시에, 컴파일러는 draw Generic 메소드의 타입 파라미터 T를 Shape로 대치합니다.
```java
public static void draw(Shape shape) { ... }
```

<br />
<br />
<br />
<br />
<br />

## Generics 제약
Generic 타입은 일반 타입과 달리 제약 사항들이 있습니다. 이 장에서는 Generics에서 할 수 있는 제약 사항들을 알아봅니다.

#### Table of Contents
1. 타입 파라미터 제약
2. Generic 타입 제약
3. 메소드 오버로딩 제약

<br />

### 타입 파라미터 제약
***
* 타입 파라미터 인자로 기본 데이터 타입을 사용할 수 없음
    * 컴파일 과정에서 타입 파라미터 정보는 모두 삭제되고, Object 타입으로 처리됨
* 타입 파라미터 변수의 객체를 생성할 수 없음
    * 타입 파라미터는 타입의 인자가 주어지지 전까지는 생성할 수 없음
* static 필드로 선언할 수 없음
    * 타입 파라미터 인자가 달라질 수 있어 특정 타입으로 생성할 수 없음
***

Generic 타입은 타입 파라미터와 관련하여 몇 가지 제약 사항들이 있습니다.

**타입 파라미터 인자로 기본 데이터 타입을 사용할 수 없음**  
Generic 타입은 컴파일시 삭제되고, 정해진 규칙에 따라 Object 또는 첫 번째 바인딩 된 타입으로 치환됩니다. 타입 파라미터는 타입 파라미터의 슈퍼 타입 제약 또는 서브 타입 제약에 따라 정해진 타입으로 치환되고, 치환되는 타입은 참조 타입이어야 합니다. 따라서, 타입 파라미터 인자로 기본 데이터 타입을 사용할 수 없습니다.

**타입 파라미터 변수의 객체를 생성할 수 없음**  
클래스의 인스턴스를 생성하기 위해서는 객체를 위한 메모리 공간을 할당한 후 클래스의 생성자를 호출 해야 합니다. 타입 파라미터의 타입은 결정되지 않은 상태이기 때문에 클래스의 생성자를 호추랄 수 없 어, 컴파일 시 오류가 발생합니다. 필요한 경우, 리플렉션을 사용할 수 있습니다.

```java
public static <E> void append(List<E> list, Class<E> cls) {
    E elem = cls.newInstance();
    list.add(elem);
}
```

**static 필드로는 선언할 수 없음**  
static 필드는 객체와 다른 영역에 할당되는 공유 수준 변수이고, 클래스가 로드 될 때 생성됩니다. 타입 파라미터 인자가 달라질 수 있으므로, 특정 타입으로 생성되어야 하는 static으로 선언될 수 없습니다.

<br />

### Generic 타입 제약
***
* Generic 타입은 타입 변환 될 수 없으며, instanceof 연산자를 사용할 수 없음
    * 타입 파라미터는 모두 컴파일시 Object로 치환됨
    * 컴파일러에서 타입 변환은 참조 타입의 경우 상속 관계만 확인
    * 타입 파라미터가 Object 타입으로 치환되어 instanceof로 구분이 어려움
* Generic 타입의 배열은 생성할 수 없음
    * Java의 배열은 공변적이지만 Generic 타입은 불공변적
    * Java의 배열은 타입 안전을 보장할 수 없음
* Exception 타입의 서브 타입이 될 수 없음
    * Generic 클래스는 Throwable 클래스를 직접적 또는 간접적으로 확장할 수 없음
***

Generic 타입은 클래스 내에서 일반적인 형태를 가지게 되고, 컴파일시 Object 또는 선언된 타입으로 지원되는 형식이어서 일반적인 타입에 비해 여러 제약을 가집니다. 

**타입 변환 불가, instanceof 연산자 사용 불가**
Java 컴파일러는 지네릭 코드의 모든 타입 파라미터를 지우고 치환하기 때문에 런타임에 지니렉 타입에 어떤 파라니터가 사용되었는지 알 수 없습니다. 런타임에는 타입 파라미터를 추적할 수 없으므로, Generic 타입의 차이를 알 수 없어 타입 변환할 수 없으며, instanceof 연산자를 사용할 수 없습니다.

**Generic 타입의 배열은 생성할 수 없음**
* 배열의 경우 A \<: B (A가 B의 서브 타입)일 때 A[] \<: B[]가 됩니다.(공변적)
* Generic 타입의 경우 A \<: B 이더라도 List\<A\> \<: List\<B\>가 성립하지 않습니다.(불공변적)

```java
Object[] array = new String[5];
Object[0] = 1
```

위 코드에서 array는 Object 타입 배열이므로, array 요소에 1 을 할당해도 컴파일 시에는 오류가 발생하지 않으나, 런타임에 array는 String 타입 배열이 되어 오류가 발생합니다.

```java
ArrayList<Object> list = new ArrayList<String>();
```

Generic은 뷸공변하기 때문에 위 코드는 컴파일 오류가 발생합니다. 

배열은 런타임에 실체화되고, Generic은 런타임에 소거되므로, 다르게 동작합니다.

```java
// 실제로 작성된 코드
ArrayList<String> stringList = new ArrayList<String>();
ArrayList<Integer> integerList = new ArrayList<Integer>();
```
```java
// 런타임에 변환되는 코드
ArrayList stringList = new ArrayList();
ArrayList integerList = new ArrayList();
```

Java에서 Generic 배열이 가능하다면 아래와 같은 문제가 발생할 수 있습니다.

```java
// 실제로는 컴파일 오류가 발생함
ArrayList<String>[] stringLists = new ArrayList<String>[1]; // 런타임시에는 제네릭
ArrayList<Integer> intList = Arrays.asList(1); // 타입소거로 인해 런타임시 ArrayList가 됨 
Object[] objects = stringLists; // 배열은 공변성, Object[]는 ArrayList[]가 될 수 있음. 
objects[0] = intList; // intList또한 ArrayList이므로 배열의 요소가 될 수 있음
String s = stringLists[0].get(0) // String 타입을 가져야 하지만 Integer이므로 예외 발생
```

Java에서 Generic 배열을 생성하려면 와일드 카드 타입을 사용할 수 있습니다.
```java
List<?> lists = new List<?>[2];
lists[0] = Arrays.asList(1);
lists[1] = Arrays.asList("A");
    for (List<?> list : lists) {
        System.out.println(list);
    }
```
**Exception 타입의 서브 타입이 될 수 없음**  

지네릭 클래스는 Throwable 클래스를 직접 또는 간접적으로 확장할 수 없습니다.
// 직접적으로 Exception 클래스 확장
class MathException<T> extends Exception { /* ... */ } // 컴파일시 오류 
// Throwable 직접적으로 확장
class QueueFullException<T> extends Throwable { /* ... */ // 컴파일시 오류

<br />

### 메소드 오버로딩 제약
***
* 타입 파라미터만 다른 동일한 시그너처의 메소드는 존재할 수 없음
    * 타입 파라미터는 모두 컴파일시 Object로 치환됨
***
클래스는 타입 파라미터를 삭제한 후 동일한 타입을 가지는 두 개의 중복된 메소드를 가질 수 없습니다.
```java
public class Example {
    public void print(Set<String> set) { }
    public void print(Set<Integer> set) { }
}
```
위 코드는 컴파일 후 아래와 같이 변경되고, 정상적으로 컴파일 되지 않습니다.
```java
public class Example {
    public void print(Set<Object> set) { }
    public void print(Set<Object> set) { }
}
```

<br />

