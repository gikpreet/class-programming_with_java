### Vector
***
* Collection Framework가 추가되기 전에 추가된 레거시 클래스
* ArrayList와 유사하며, 지네릭스를 사용할 수 있도록 재 설계됨
    * List 인터페이스를 구현하여 크기가 가변적으로 변경됨
    * Vector를 개선하여 작성된 ArrayList보다 성능이 떨어짐
* 스레드에 안전하나, 동기화 비용이 발생하여 ArrayList 보다 성능이 떨어짐
***

Vector는 레거시 클래스로, 기능이 개선된 ArrayList가 추가되어 더 이상 사용할 필요가 없으나 코드 호환성을 위해 남아있는 List 구현체입니다. List 인터페이스를 구현하므로 ArrayList와 동일하게 동작합니다. 레거시 코드와의 호환 문제가 아니라면 Vector보다 ArrayList를 사용하는 것이 좋습니다.

<img src="../images/image07.png" width="600" />

**Vector와 ArrayList**

|  |Vector|ArrayList|
|-|-|-|
|동기화|한번에 하나의 쓰레드에 접근 가능|동시에 여러 쓰레드가 작업할 수 있음|
|스레드 안전|Thread Safe|명시적인 Thread Safe |
|성능|느림|빠름(동기화가 되어 있지 않음)|
|크기증가|Vector Size의 100% 증가|ArrayList Size의 50% 증가|

<br />

