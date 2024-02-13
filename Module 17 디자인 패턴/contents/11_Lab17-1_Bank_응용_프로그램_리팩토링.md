## Lab 13-1 : Bank 응용 프로그램 리팩토링
이 연습에서는 이전 연습에서 실습했던 Bank Account 예제에서 계좌를 생성하는 CreateAccount 클래스를 싱글턴으로 리팩토링합니다.

1. Visual Studio Code를 엽니다.
2. 파일 메뉴에서 폴더 열기를 클릭하고 c:\Labs\Lab17-1\Starter 폴더를 엽니다.
3. 작성자 신뢰 경고 창에서, 예, 작성자를 신뢰합니다 버튼을 클릭합니다.
4. Visual Studio Code 탐색기에서, CreateAccount.java 파일을 엽니다.

**계좌 번호를 생성하는 CreateAccount 클래스를 싱글턴으로 리팩토링**
1. CreateAccount 클래스에, CreateAccount 타입 createAccount를 private 접근 제한자를 가지는 static 변수로 선언합니다.
2. CreateAccount 클래스에 아무 동작을 하지 않는 private 생성자를 선언합니다.
3. createAccountNumber 메소드를 static에서 dynamic 메소드로 변경합니다.
4. 완성된 코드는 아래와 유사할 것입니다.

```java
public class CreateAccount {
    private static CreateAccount createAccount;

    private static String nextAccountNumber = "0";

    private CreateAccount() {}

    public String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return "0000-" + nextAccountNumber;
    }
}
```
5. 작업을 저장합니다.

**싱글턴 객체에 접근할 수 있는 유일한 메소드 생성**
1. CreateAccount 클래스에 createAccount 정적 객체를 반환하는 getCreateAccount 메소드를 생성합니다.
    1. createAccount 정적 객체가 null이면 CreateAccount 클래스 인스턴스로 생성합니다.
    2. createAccount 객체를 반환합니다.
2. createAccountNumber 메소드를 private으로 변경합니다.
3. 완성된 코드는 다음과 유사할 것입니다.

```java
public class CreateAccount {
    private static CreateAccount createAccount;

    private static String nextAccountNumber = "0";

    private CreateAccount() {}

    public static CreateAccount getCreateAccount() {
        if (createAccount == null) {
            createAccount = new CreateAccount();
        }
        return createAccount;
    }

    public String createAccountNumber() {
        int accountNumber = Integer.parseInt(createAccount.nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return "0000-" + nextAccountNumber;
    }
}
```
4. 작업을 저장합니다.
5. 아래 명령을 수행하여 프로그램을 컴파일합니다.

```bash
$ javac *.java
```

6. 오류를 확인합니다.
```bash
$ javac *.java
BankAccount.java:9: error: non-static method createAccountNumber() cannot be referenced from a static context
        this.accountNumber = CreateAccount.createAccountNumber();
                                          ^
```

**BankAccount 클래스에서 싱글턴 객체를 사용하도록 수정**
1. Visual Studio Code 탐색기에서, BankAccount.java 파일을 엽니다.
2. BankAccount 생성자에서, 계좌 번호를 생성하는 createAccountNumber 메소드를 CreateAccount 클래스의 유일한 인스턴스를 반환하는 메소드 getCreateAccount 메소드의 호출로 반환된 static 인스턴스를 사용하도록 변경합니다.
3. 완성된 코드는 아래와 유사할 것입니다.
```java
import java.math.BigDecimal;

public class BankAccount implements IAccount {
    protected String accountNumber;
    protected String ownerName;
    protected BigDecimal balance;

    public BankAccount(String ownerName, BigDecimal balance) {
        this.accountNumber = CreateAccount.getCreateAccount().createAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    …
}
```
4. nextAccountNumber 정적 변수와 createAccountNumber() 정적 메소드를 삭제합니다.
5. 아래 명령을 수행하여 프로그램을 컴파일합니다. 오류가 있으면 수정합니다.
```bash
$ javac *.java
```
6. 아래 명령을 수행하여 프로그램을 실행합니다.
```java
$ java Test
Account Number: 0000-1
Owner Name: Jason
Balance: 100
Account Number: 0000-2
Owner Name: James
Balance: 100
Balance Limited: 1000
```

<a href="./12_연습문제.md">연습 문제</a>