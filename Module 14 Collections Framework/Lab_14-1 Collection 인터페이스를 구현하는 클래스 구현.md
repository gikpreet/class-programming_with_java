# Lab 12-1 Collection 인터페이스를 구현하는 클래스 구현

이 연습에서는 Collection 인터페이스를 구현하여 표준적인 방법으로 데이터 읽기, 비교 및 다른 방법으로의 비교가 가능한 클래스를 작성합니다.

## 연습 1 표준적인 방법으로 값을 비교할 수 있는 클래스 작성
이 연습에서는 Comparable 인터페이스를 구현하여 표준적인 방법으로 값을 비교할 수 있는 클래스를 작성합니다. 이 연습에서는 age 전역 변수의 값을 기준으로 값을 비교하는 클래스를 작성합니다. 아래 절차를 따릅니다.

1. Visual Studio Code를 실행합니다.
2. 파일 메뉴에서 폴더 열기를 클릭하고 c:\Labs\14-1\Starter 폴더를 엽니다.
3. 작성자 신뢰 경고 창에서, 예, 작성자를 신뢰합니다 버튼을 클릭합니다.
4. Visual Studio Code 탐색기에서 User.java 파일을 엽니다.

### 특정 값을 기준으로 값 비교가 가능한 User 클래스 작성
1. User 클래스가 Comparable<T> 인터페이스를 구현하도록 실행합니다. 타입 파라미터로 User를 지정합니다.
    1.  Comparable 인터페이스의 compareTo 메소드를 구현합니다. CompreTo 메소드는 User 클래스의 userAge 값을 기준으로 메소드 파라미터로 전달받은 User 객체의 userAge 값이 같으면 0, 작으면 -1, 크면 1을 반환합니다.
    2. toString 메소드를 오버라이드 합니다. userNo, userName, userAge를 차례대로 출력합니다.
2. 수정한 코드는 아래와 유사할 것입니다.
```java
class User implements Comparable<User> {
    private final int userNo;
    private final String userName;
    private final int userAge;

    public int getUserAge() {
        return userAge;
    }

    public User(int userNo, String userName, int userAge) {
        this.userNo = userNo;
        this.userName = userName;
        this.userAge = userAge;
    }

   public int compareTo(User o) {
        if(this.userAge == o.userAge){
            return 0;
        }else if(this.userAge < o.userAge){
            return -1;
        }else{
            return 1;
        }
    }

    public String toString() {
        return "User {" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
```

### 프로그램 테스트
1. Visual Studio Code 탐색기에서, Test.java 파일을 엽니다.
2. 코드를 확인합니다.
    1. Test 클래스의 main 메소드에서, 5개의 User 객체를 생성합니다.
    2. List<User> 타입의 users 객체를 ArrayList<User> 인스턴스로 생성하고, 생성한 5개의 User 클래스를 추가합니다.
    3. Collections 클래스의 정적 메소드 sort를 이용하여 users 리스트의 객체를 정렬합니다.
    4. users 리스트의 요소를 반복하여 출력합니다.
3. 완성된 코드는 아래와 유사할 것입니다.
```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1,"User 1",30);
        User user2 = new User(2,"User 2",20);
        User user3 = new User(3,"User 3",10);
        User user4 = new User(4,"User 4",20);
        User user5 = new User(5,"User 5",30);

        List<User> users = new ArrayList<User>() {
            {
                add(user1);
                add(user2);
                add(user3);
                add(user4);
                add(user5);
            }
        };

        Collections.sort(users);
        for (User user: users) {
            System.out.println(user);
        }
    }
}
```
4. 다음 명령을 수행하여 프로그램을 컴파일합니다.
```bash
$ javac User.java Test.java
```
5. 다음 명령을 수행하여 프로그램을 실행합니다.
```bash
$ java Test
User{userNo=3, userName='User 3', userAge=10}
User{userNo=2, userName='User 2', userAge=20}
User{userNo=4, userName='User 4', userAge=20}
User{userNo=1, userName='User 1', userAge=30}
User{userNo=5, userName='User 5', userAge=30}
```

## 연습 2 Comparator 인터페이스를 구현하여 내림차순 정렬 가능하도록 구현

이 연습에서는 Comparator 인터페이스를 구현하는 DesendingOrder 클래스를 작성하고, compare 메소드를 사용하여 User 객체에 대한 내림차순 정렬이 가능하도록 프로그램을 수정합니다.

1. Visual Studio Code를 실행합니다.
2. 파일 메뉴에서 폴더 열기를 클릭하고 c:\Labs\14-1\Starter 폴더를 엽니다.
3. 작성자 신뢰 경고 창에서, 예, 작성자를 신뢰합니다 버튼을 클릭합니다.
4. Visual Studio Code 탐색기에서 DesendingOrder.java 파일을 엽니다.

### Comparator 인터페이스를 구한하여 내림차순 정렬 가능하도록 수정
1. DesendingOrder 클래스가 Comparator<User> 인터페이스를 구현하도록 수정하고 내림차순 정렬이 가능하도록 코드를 작성합니다.
    1. Comparator 인터페이스의 compare 메소드를 구현하는 메소드를 작성합니다.
    2. compare 메소드는 두 개의 User 객체를 파라미터로 받습니다.
    3. 첫 번째 파라미터가 두 번째 파라미터보다 크면 -1을, 작으면 1을, 같으면 0을 반환합니다.
2. 완성한 코드는 아래와 유사할 것입니다.

```java
import java.util.Comparator;

public class DesendingOrder implements Comparator<User> {
    public int compare(User o1, User o2) {
        if(o1.getUserAge() > o2.getUserAge()){
            return -1;
        }else if( o1.getUserAge() < o2.getUserAge()){
            return 1;
        }else {
            return 0;
        }
    }
}
```

### 프로그램 테스트
1. Visual Studio Code 탐색기에서 Test.java 파일을 엽니다.
2. Test 클래스의 main 메소드에서, Collection 클래스의 static 메소드 sort를 이용하여 정렬하는 메소드를 DesendingOrder 클래스를 사용하여 내림차순 정렬하도록 코드를 수정합니다.

```java
Collections.sort(users, new DesendingOrder());
```

3. 다음 명령을 수행하여 프로그램을 컴파일합니다.
```bash
$ javac User.java Test.java DesendingOrder.java
```
4. 다음 명령을 수행하여 프로그램을 실행합니다.
```bash
> java Test
User {userNo=1, userName='User 1', userAge=30}
User {userNo=5, userName='User 5', userAge=30}
User {userNo=2, userName='User 2', userAge=20}
User {userNo=4, userName='User 4', userAge=20}
User {userNo=3, userName='User 3', userAge=10}
```

## 연습 3 Iterable 인터페이스를 구현하여 표준 방식으로 데이터를 읽을 수 있도록 수정

이 연습에서는 User 객체를 리스트로 저장하는 Users 클래스를 만들고, Users 클래스가 Iterable을 확장하여 표준 방식으로 읽을 수 있도록 생성합니다.

1. Visual Studio Code를 실행합니다.
2. 파일 메뉴에서 폴더 열기를 클릭하고 c:\Labs\14-1\Starter 폴더를 엽니다.
3. 작성자 신뢰 경고 창에서, 예, 작성자를 신뢰합니다 버튼을 클릭합니다.
4. Visual Studio Code 탐색기에서 Users.java 파일을 엽니다.

### Users 클래스가 User 리스트를 저장할 수 있도록 작성
1. Users 클래스가 User 리스트를 저장할 수 있도록 작성합니다.
    1. Users 클래스에 List<User> 타입의 userList를 선언하고 ArrayList<User> 인스턴스로 생성합니다.
    2. Users 클래스에 User 타입의 user를 파라미터로 하는 addUser 메소드를 작성하고 userList 리스트에 인자로 전달받은 user를 추가하는 코드를 작성합니다.
2. 수정한 코드는 아래와 유사할 것입니다.
```Java
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Users {
    private List<User> userList = new ArrayList<User>();

    public void addUser(User user) {
        userList.add(user);
    }
}
```
3. Visual Studio Code에서 Test.java 파일을 엽니다.
4. Users 클래스를 생성하고 생성한 5개의 User 객체를 ArrayList가 아닌 Users 객체에 추가하는 코드를 작성하고, foreach 문을 사용해서 Users 객체에 추가된 User 객체를 출력하는 코드를 작성합니다.
5. 완성된 코드는 아래와 유사할 것입니다.
```java
private static void main(String[] args) {
    User user1 = new User(1,"User 1",30);
    User user2 = new User(2,"User 2",20);
    User user3 = new User(3,"User 3",10);
    User user4 = new User(4,"User 4",20);
    User user5 = new User(5,"User 5",30);

    Users users = new Users();
    users.addUser(user1);
    users.addUser(user2);
    users.addUser(user3);
    users.addUser(user4);
    users.addUser(user5);

    for(User user: users) {
        System.out.println(user);
    }
}
```
3. 아래 명령을 수행하여 프로그램을 컴파일하고 오류를 확인합니다.

```bash
> javac *.java
Test.java:70: error: for-each not applicable to expression type
        for(User user: users) {
                       ^
  required: array or java.lang.Iterable
  found:    Users
1 error
```
### Iterable을 확장하도록 Users 클래스 수정

1. Users 클래스가 Iterable을 확장하도록 코드를 수정합니다.
    1. Users 클래스가 Iterable<Users>를 확장하도록 코드를 수정합니다.
    2. Users 클래스에서 Iterator<User>를 return 타입으로 하는 iterator() 메소드를 구현하고 userList의 iterator 메소드를 호출하여 return 합니다.
2. 완성된 코드는 아래와 유사할 것입니다.
```java
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Users implements Iterable<User> {
    private List<User> userList = new ArrayList<User>();

    public void addUser(User user) {
        userList.add(user);
    }

    public Iterator<User> iterator() {
        return this.userList.iterator();
    }
}
```
3. 아래 명령을 수행하여 프로그램을 컴파일 합니다.
```bash
> javac *.java
```
4. 아래 명령을 수행하여 Users 클래스가 foreach 문에서 동작하는 것을 확인합니다.
```bash
> java Test
User {userNo=1, userName='User 1', userAge=30}
User {userNo=2, userName='User 2', userAge=20}
User {userNo=3, userName='User 3', userAge=10}
User {userNo=4, userName='User 4', userAge=20}
User {userNo=5, userName='User 5', userAge=30}
```

<a href="./Collections_Framework/13_List_인터페이스.md">다음 장</a>