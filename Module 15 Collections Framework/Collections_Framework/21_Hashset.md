### HashSet
***
* Set 인터페이스를 구현한 가장 대표적인 컬렉션
* 입력의 순서가 없고 입력된 요소의 순서가 유지되지 않음
* 중복된 요소를 저장하지 않음
* Hash 알고리즘으로 데이터를 매핑
    * Hash에 의해 데이터의 위치를 특정시켜 해당 데이터를 빠르게 색인
    * 삽입, 삭제, 색인이 매우 빠른 컬렉션
```java
Set<String> set  = new HashSet();
System.out.println( "1.add color : " +  set.add("white"));
System.out.println( "2.add color : " +  set.add("white"));
System.out.println( "3.add color : " +  set.add("red"));

for(String s: set) {
    System.out.print(s + " ");
}
```
***

Set은 수학에서의 집합과 유사한 동작을 수행하는 자료구조이며, Java에서는 Set 인터페이스를 통해 구현합니다. Set은 중복되는 요소를 허용하지 않으며, 저장 순서를 유지하지 않습니다. (LinkedHashSet 예외)

HashSet은 데이터의 위치를 Hash에 의해 특정하므로 해당 데이터를 빠르게 검색할 수 있도록 합니다. HashSet은 집합의 전형적인 기능을 가지며, 데이터를 검색하기 위해 Hash 알고리즘을 이용하는 자료 구조입니다.

**Hash**  
Hash는 데이터를 검색할 때 사용할 Key와 실제 데이터의 Value가 한 쌍으로 존재하고, key 값이 배열의 인덱스로 저장되도록 하여 검색과 저장의 시간 복잡도를 O(1)에 수렴하게 되는, 검색과 저장을 빠르게 하는 기법을 의미합니다.

<img src="../images/image10.png" width="600" />

**주요 메소드**
|Method|설명|
|-|-|
|public boolean addAll(Collection c) |주어진 컬렉션에 저장된 모든 개체를 추가합니다. (합집합)|
|public void clear()|Set에 있는 모든 요소를 삭제합니다|
|public boolean containsAll(Collection c)|주어진 컬렉션에 있는 모든 개체를 저장하고 있는지 확인합니다.|
|Public boolean removeAll(Collection e)|주어진 컬렉션에 저장된 모든 개체와 동일한 요소를 삭제합니다. (차집합)|

**생성 및 데이터 삽입**
```java
Set<String> set = new HashSet<>();
set.add("Jason");
set.add("Celine");
set.add("Jason");	// false를 반환하고 데이터가 입력되지 않음
```
**데이터 확인**
```java
set.contains("Jason");
```
**데이터 삭제**
```java
set.remove("Jason");
```
**데이터 순회**
```java
for(String s: set) {
    System.out.print(s);
}

Iterator iterator = set.iterator();
while(iterator.hasNext()) {
    System.out.print(iterator.next());
}
```

<a href="./22_TreeSet.md">다음 장</a>