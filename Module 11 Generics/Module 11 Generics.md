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
Generics는 Generic이라는 단어가 주는 의미[1]처럼 다양한 타입에 적용할 수 있도록 지원합니다. 지네릭스는 타입(클래스, 인터페이스)에 정의 가능하며 메소드 정의에도 사용할 수 있습니다.
class Box<T> {
    T item;

    public Box(T string) {
        this.item = string;
    }

    public T getItem() {
        return this.item;
    }
}
지네릭스는 객체 생성시 명확한 타입 적용을 통해 컴파일러에서 타입 사용에 대한 안정성 검사를 지원합니다. 또한, 객체 생성시 주어지는 타입 정보는 불필요한 타입 변환을 줄여 간결한 코드 작성을 도와줍니다. 

클래스나 메소드의 작성시 타입 파라미터를 통해 타입 지정이 가능하도록 하여, 특정 타입에 국한되지 않는 코드 작성으로 특정 타입에 제한되지 않는 일반적인(Generic 한) 알고리즘 구현이 가능하도록 합니다.

[^1]: 각주 내용은 다음과 같다.