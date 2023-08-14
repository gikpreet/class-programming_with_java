### 읽기 전용 Collection
***
* Collection에 저장된 데이터를 읽기전용으로 만듦
* 외부에서 변경할 수 없으므로 데이터의 무결성이 보장됨
* 읽기전용으로 설정된 Collection의 요소에 변경을 시도하면 UnsupportedOperationException 발생
```java
List<String> list = new ArrayList();
list = Collections.unmodifiableList(list);
```
***

Collection 객체는 자유롭게 데이터를 추가하고, 읽고, 수정하고, 지울 수 있습니다. Collection이 한번 생성된 후 데이터의 무결성을 위해 수정이 불가능해야 하는 경우, Collections 클래스의 unmodifiableList, unmodifiableSet, unmodifiableMap 메소드를 사용해 읽기 전용으로 설정할 수 있습니다.
```java
List<String> list = new ArrayList(){{
    add("red");
    add("green");
    add("blue");
}};

list = Collections.unmodifiableList(list);

try {
    list.add("pink");
} 
catch (UnsupportedOperationException e){
   e.printStackTrace();
}
```

<a href="./31_Checked_Collection.md">다음 장</a>

