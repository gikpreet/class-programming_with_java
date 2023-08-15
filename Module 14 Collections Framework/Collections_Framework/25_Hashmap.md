### HashMap
***
* Map 인터페이스를 구현한 자료구조
* Key, Value 쌍으로 데이터를 입력
* 해당 Key를 이용해 데이터에 액세스
* 스레드에 안전하지 않으나, 속도 측면에서 유리함
```java
Map map = new HashMap();
map.put("red", "Anne of Green Gables");
map.put("white","White Rabbit");

map.containsKey("red");
map.containsValue("White Rabbit");

map.get("white");

map.remove("red");
```
***

HashMap은 Map 인터페이스의 구현체이며 Key-Value의 쌍으로 데이터를 저장하고 Key를 해싱하여 데이터에 액세스하고 삭제합니다. Key는 컬렉션 내에서 유일한 값을 가집니다.

<img src="../images/image13.png" width="600" />

HashMap에서 Key는 중복될 수 없으며, Value는 중복될 수 있습니다. Collection 또는 Iterable 인터페이스를 구현하지 않아 foreach문 등에서 순회될 수 없습니다. HashMap은 내부에 Key와 Value를 저장하는 자료 구조를 가지고 있습니다. HashMap은 HashSet와 유사한 방법으로 Key와 Value가 저장되는 위치를 결정합니다. 따라서 요소가 삽입되는 순서와 위치는 Hash 알고리즘이 결정합니다.

기존에 저장된 키와 동일한 키로 값을 저장하면 기존 값이 새 값으로 대치되며, Hashing을 사용하므로 많은 양의 데이터를 검색하는데 있어 뛰어난 성능을 보입니다.

|Method|설명|
|-|-|
|boolean containsKey(Object key)|지정된 key가 포함되어 있는지 여부를 반환합니다.|
|boolean containsValue(Object value)|지정된 value가 포함되어 있는지 여부를 반환합니다.|
|Set<Map.Entry<K,V>> entrySet()|지정된 키와 값을 Entry(key/value)의 형태로 Set에 저장하여 반환합니다.|
|Set<K> keySet()|지정된 모든 key를 Set에 저장하여 반환합니다.|
|void clear()|지정된 모든 객체를 제거합니다.|
|remove(Object key, Object value)|key에 해당하는 value를 제거합니다.|
|V getOrDefault(Object key, V defaultValue)|key에 해당되는 값을 반환합니다. 값이 존재하지 않는다면 defaultValue값을 반환합니다.|
|void putAll(Map<? extends K)|Map 저장된 모든요소를 HashMap에 저장합니다.|
|V replace(K key, V value)|당 key값을 value로 변경합니다.|
|boolean replace(K key, V oldValue, V newValue)|key, value 모두 일치한다면 newValue값으로 변경합니다.|

**생성 및 데이터 삽입**
```java
Map map = new HashMap();
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
```

<a href="./26_Hashtable.md">다음 장</a>