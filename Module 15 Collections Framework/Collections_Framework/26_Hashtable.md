### Hashtable
***
* Hash를 이용해 Key와 Value 쌍으로 이루어진 데이터를 저장하는 전통적 자료구조
* HashMap과 동일한 방법으로 저장
    * Key, Value 쌍으로 데이터를 입력
    * 해당 Key를 이용해 데이터에 액세스
* 스레드에 안전함
* Collection Framework 이전부터 존재하던 레거시 클래스
```java
Map map = new Hashtable();
map.put("red", "Anne of Green Gables");
map.put("white","White Rabbit");

map.containsKey("red");
map.containsValue("White Rabbit");

map.get("white");

map.remove("red");
```
***
Hashtable은 Collection Framework 이전부터 존재하던 레거시 클래스로, HashMap과 동일하게 동작합니다. Hashtable은 HashMap과 달리 스레드에 안전합니다. 또, null 입력이 가능한 HashMap과 달리 null을 사용할 수 없습니다.

<img src="../images/image14.png" width="600" />

**생성 및 데이터 삽입**
```java
Map map = new Hashtable();
map.put("red", "Anne of Green Gables");
map.put("white","White Rabbit");
```
**키와 값 존재 여부 확인**
```java
map.containsKey("red");
map.containsValue("White Rabbit");
```
**데이터 조회**
```java
map.get("white")
```
**데이터 삭제**
```java
map.remove("red");
```
**데이터 순회**
```java
Set<Map.Entry> entrySet = map.entrySet();

for(Map.Entry entry: entrySet) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

Iterator iterator = entrySet.iterator();
while(iterator.hasNext()) {
    Map.Entry entry = (Map.Entry) iterator.next();  
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

<a href="./27_Collection_클래스.md">다음 장</a>

