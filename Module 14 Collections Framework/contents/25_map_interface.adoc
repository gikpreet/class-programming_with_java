### Map 인터페이스
***
* Key-Value 쌍으로 이루어진 데이터를 저장하는 자료구조
    * Key는 중복을 허용하지 않음
    * Value는 중복을 허용함
* 입력된 순서를 유지하지 않으며, 정렬되지 않음
* 삽입, 삭제, 검색에 유리
***

Map 인터페이스는 중복을 허용하지 않는 Key와 중복이 가능한 Value를 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는데 사용되는 인터페이스입니다. Key와 Value의 쌍으로 구성된 데이터를 저장하고, 조회와 삭제는 Key를 이용하여 수행합니다.

Map은 Key는 중복될 수 없으나 Value는 중복되며, 기존에 저장된 Key와 같은 값의 Key로 Value가 저장되면 기존의 값은 없어지고 새 Value가 저장되는 특징을 가지는 자료구조입니다.

|Method|설명|
|-|-|
|void clear()|Map의 모든 개체를 삭제합니다.|
|boolean containsKey(Object key)|지정된 Key와 일치하는 Map의 Key가 있는지 확인합니다.|
|boolean containsValue(Object value)|지정된 value와 일치하는 value가 있는지 확인합니다.|
|Set entrySet()|Map에 저장된 key-value 상을 Map.Entry 객체로 저장한 Set로 반환합니다.|
|Object get(Object Key)|지정한 Key에 대응하는 Value를 반환합니다.|
|boolean isEmpty()|Map 객체가 비어있는지 여부를 반환합니다.|
|Set keyset()|Map에 저장된 모든 Key를 반환합니다.|
|Object put(Object key, Object value)|Key-Value 쌍을 Map에 저장합니다.|
|void putAll(Map t)|파라미터로 전달받은 Map의 모든 Key-Value 쌍을 저장합니다.|
|int size()|Map에 저장된 key-value 쌍을 반환합니다.|
|Collection values()|Map에 저장된 모든 value를 반환합니다.|

<a href="./25_Hashmap.md">다음 장</a>