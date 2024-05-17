### Checked Collection
***
* Collection에 단일 타입의 객체를 저장하고자 할 때 사용
* 지정된 타입 외 다른 타입이 저장될 때 ClassCast Exception 사용
    * checkedList, checkedSet, checkedMap 메소드 지원
```java
List colors = Collections.checkedList(new ArrayList(),String.class);
```
***

일반적으로 Collection 클래스에는 다양한 타입의 객체를 저장할 수 있습니다. 한 가지 타입의 객체를 저장하고자 한다면 checked 형태의 collection을 사용할 수 있습니다.

Collections 클래스에서 제공하는 checklist, checkedSet, checkedMap 메소드를 사용하여 단일 타입만 저장 가능한 Collection을 생성할 수 있습니다. 
```java
List colors = Collections.checkedList(new ArrayList(),String.class) ;
colors.add("white");
colors.add("black");
colors.add("green");
colors.add("pink");

try {
    colors.add(123);
}
catch (ClassCastException e){
    System.out.println(e.getMessage());
}

colors.forEach(color->{
    System.out.println(color);
});
```

<a href="./32_검토.md">다음 장</a>
