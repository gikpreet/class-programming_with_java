### Set 인터페이스
***
* 집합과 유사한 자료구조 표현
* 중복된 요소를 허용하지 않음
* 저장 순서를 유지하지 않음
* HashSet, LinkedHashSet, TreeSet등으로 구현됨

<img src="../images/image09.png" width="600" />

***

Set은 수학에서의 집합과 유사한 동작을 수행하는 자료구조이며, Java에서는 Set 인터페이스를 통해 구현합니다. Set은 중복되는 요소를 허용하지 않으며, 저장 순서를 유지하지 않습니다. (LinkedHashSet 예외)

List와 가장 다른 점은, 중복되는 요소를 허용하지 않는다는 것입니다. 

**주요 메소드**
|Method|설명|
|-|-|
|public boolean add(E item) |지정된 요소가 없을 경우 Set에 요소를 추가합니다. <br />지정된 요소가 존재하는 경우 false를 반환합니다.|
|public boolean remove(Object o)|지정된 객체가 존재하는 경우 해당 요소를 제거합니다. <br />요소가 없는 경우 false를 반환합니다.|
|public boolean contains(Object o)|지정된 요소가 집합에 있는지 확인합니다.|
|public boolean equals(Object o)|지정된 객체와 현재 집합이 같은지 비교합니다.|
|public boolean isEmpty()|집합이 비어있을 경우 true를, 아닌 경우 false를 반환합니다.|
|public int size()|집합에 포함된 요소의 수를 반환합니다.|
|public void clear()|집합의 모든 요소를 제거합니다.|

<a href="./21_Hashset.md">다음 장</a>

