### TreeSet
***
* 중복을 허용하지 않고, 저장 순서를 유지하지 않음
* 이진 탐색 트리 구조의 하나인 레드-블랙 트리(Red-Black Tree) 구조
    * 정렬된 순서로 데이터를 저장
    * 추가와 삭제에는 불리하지만 검색과 정렬에는 유리
```java
TreeSet<Integer> treeSet = 
    new TreeSet(Arrays.asList(1,3,2,9,5,6,10,4,8,7));

for(int i: treeSet) {
    System.out.print(i + " ");
}
treeSet.first();
treeSet.last();
treeSet.higher(5);
treeSet.lower(5);
treeSet.headSet(5);
treeSet.tailSet(5);
treeSet.subSet(3,7);
```
***

TreeSet은 중복을 허용하지 않고 저장 순서를 유지하지 않는 Set의 성질을 가지는 구현체입니다. 이진 탐색 트리(Binary Search Tree)로 구성되어 추가와 삭제에는 불리하지만 정렬과 검색에 유리한 자료구조 입니다.

<img src="images/image11.png" width="600" />

**레드-블랙 트리(Red-Black Tree)**  
TreeSet은 이진 탐색 트리 중에서도 성능이 향상된 레드-블랙 트리로 구현되었습니다. 이진 탐색 트리는 트리의 높이만큼 시간이 걸리며, 데이터의 값이 트리에 잘 분산되어 있지 않으면 검색 효율이 떨어지는 구조입니다. 레드 블랙 트리는 상위 노드와 비교하여 큰 값은 오른쪽으로, 작은 값은 왼쪽으로 저장하는 구조로 데이터의 값이 트리에 잘 분산되어 균형을 맞추어 검색 효율을 높입니다.

<img src="../images/image12.png" width="600" />

**주요 메소드**
|Method|설명|
|-|-|
|public E first()|정렬된 순서에서 첫 번째 객체를 반환합니다.|
|public E last()|정렬된 순서에서 마지막 객체를 반환합니다.|
|public E higher(E e)|지정된 객체보다 큰 값을 가진 객체중 제일 가까운 값의 객체를 반환합니다. 없으면 null을 반환합니다.|
|public E lower(E e)|지정된 객체보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환합니다. 없으면 null을 반환합니다.|
|public SortedSet<E> headSet(E toElement)|지정된 객체보다 작은 값의 객체들을 반환합니다.|
|public SortedSet<E> tailSet(E fromElement)|지정된 객체보다 큰 값의 객체들을 반환합니다.|
|public SortedSet<E> subSet(E fromElement, E toElement)|범위검색 결과를 반환합니다. 끝 범위인 toElement는 범위에 포함되지 않습니다.|

**생성 및 데이터 삽입**
```java
TreeSet<Integer> treeSet = new TreeSet<Integer>();
treeSet.add(1);
treeSet.add(5);
treeSet.add(2);
treeSet.add(6);
```
**데이터 확인**
```java
treeSet.first();	    // 첫 번째 값
treeSet.last();	        // 마지막 값
treeSet.higher(5);	    // 5보다 큰 첫 번째 값
treeSet.lower(5);	    // 5보다 작은 첫 번째 값
treeSet.headSet(5);	    // 5보다 작은 집합
treeSet.tailSet(5);	    // 5보다 큰 집합
treeSet.subSet(3,7);	// 3 <= 7인 집합
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

<a href="./23_Map.md">다음 장</a>

