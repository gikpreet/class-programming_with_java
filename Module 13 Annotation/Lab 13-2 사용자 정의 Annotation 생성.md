# Lab 13-2 사용자 정의 Annotation 생성
이 연습에서는 사용자 정의 Annotation을 생성하고, Meta Annotation을 사용하여 Annotation에 Annotation을 적용합니다.

## 연습 1: 사용자 정의 Annotation 생성
이 연습에서는 디바이스, 게이트웨이, 노드를 가지고 상속 관계를 가지는 사용자 정의 Annotation을 생성합니다.

**디바이스 클래스 확인**
1. Labs 폴더의 Lab13-2/Starter/Exercise1 디렉토리에서 내용을 확인합니다.
2. Labs13-2/Starter/Exercise1 디렉토리를 Visual Studio Code에서 엽니다.
3. **작성자 신뢰 경고** 창에서, **예, 작성자를 신뢰합니다.** 버튼을 클릭합니다.
4. Visual Studio Code에서 Device.java 파일을 엽니다.
5. Device 클래스의 getDeviceInformation 메소드를 확인합니다. getDeviceInformation 메소드는 Reflection을 이용해 클래스의 Annotation 정보를 가져옵니다.
```java
private DeviceInformation getDeviceInformation() {
    Annotation[] annotations = this.getClass().getAnnotations();
    for(Annotation annotation : annotations) {
        if (annotation instanceof DeviceInformation) {
            return  (DeviceInformation) annotation;
        }
    }
    throw new UnsupportedOperationException("No Device Information");
}
```
6. 아래 명령을 수행하여 프로그램을 컴파일합니다.
```java
$ javac *.java
```
7. 아래 명령을 수행하여 프로그램을 실행하고 결과를 확인합니다.
```java
$ java DeviceExample
Type : unknown
Model : unknown
```

**디바이스 정보 Annotation 생성**
1.	Visual Studio Code 탐색기에서 DeviceInformation.java 파일을 엽니다.
2.	DeviceInformation 어노테이션 타입에 필드를 추가합니다.
    1. 기본값이 “device”인 String 타입의 type
    2. 기본값이 없는 String 타입의 model
3.	완성된 어노테이션 타입은 아래와 유사할 것입니다.
```java
import java.lang.annotation.*;

public @interface DeviceInformation {
    String type() default "device";
    String model();
}
```
4.	작업을 저장합니다.
5.	아래 명령을 수행하여 프로그램을 컴파일합니다. 오류가 있으면 수정합니다.
```bash
$ javac *.java
```

**디바이스 정보 Annotation 추가**
1.	Visual Studio Code에서 Device.java 파일을 엽니다.
2.	Device 클래스에 DeviceInformation 어노테이션을 추가합니다.
3.	코드는 아래와 유사할 것입니다.
```java
@DeviceInformation
public class Device { … }
```
4.	아래 명령을 실행하여 프로그램을 컴파일하고 오류를 확인합니다.
```bash
$ javac *.java
Device.java:3: error: annotation @DeviceInformation is missing a default value for the element 'model'
@DeviceInformation
^
1 error
```
5. @DeviceInformation Annotation에 model=”Galaxy Book Pro”를 파라미터를 추가합니다.
```java
@DeviceInformation(model=”Galaxy Book Pro”)
public class Device { … }
```
6. 아래 명령을 수행하여 프로그램을 컴파일합니다.
```bash
$ javac Device.java
```
7.	아래 명령을 수행하여 프로그램을 실행하고 결과를 확인합니다.
```bash
$ java DeviceExample
Type : unknown
Model : unknown
```

**Annotation 설정**
1.	Visual Studio Code 탐색기에서 DeviceInformation.java 파일을 엽니다.
2.	DeviceInformation 어노테이션 타입에 @Target 어노테이션을 Element.TYPE 대상으로 추가합니다.
3.	DeviceInformation 어노테이션 타입에 @Retention 어노테이션을 RetentionPolicy.RUNTIME 시점으로 추가합니다.
4.	완성된 코드는 아래와 유사할 것입니다.
```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DeviceInformation {
    String type() default "device";
    String model();
}
```
5.	아래 명령을 수행하여 프로그램을 컴파일 합니다.
```bash
$ javac *.java
```
6.	아래 명령을 수행하여 프로그램을 실행합니다.
```java
$ java DeviceExample
Type : device
Model : Galaxy Book Pro
```