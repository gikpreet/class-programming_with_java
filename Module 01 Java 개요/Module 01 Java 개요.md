# Module 01: Java 개요
이 장에서는 Java 소프트웨어 플랫폼의 개요로 시작하여 Java 프로그래밍 언어, 실행 환경과 Java 가상 머신(JVM)을 소개하고 Java의 디자인 목표와 언어 지원에 대해 설명합니다. Java의 역사와 여러 JDK 공급자, 다양한 Java 환경에 대해 설명하며, Java 프로그래밍 환경을 구성하는 방법에 대해 실습합니다.

이 장을 마치면, 다음과 같은 것을 할 수 있습니다.
* Java 소프트웨어 플랫폼을 설명할 수 있습니다.
* Java 소프트웨어 플랫폼을 구성하는 요소들에 대해 알게 됩니다.
* Java 실행 환경, 개발 환경을 구분하고 각 환경을 구성하는 구성 요소들에 대해 알게 됩니다.
* Java 계열 프로그래밍 언어와 각 실행 환경에 대해 설명할 수 있습니다.
* Java 프로그래밍 환경과 실행 환경을 구성할 수 있습니다.

### 목차
1. Java 소프트웨어 플랫폼 소개
2. Java 가상 머신
3. Java의 역사
4. Lab 1-1: Java 실행 환경 구성
5. Lab 1-2: 개발 도구 구성

<br />
<br />
<br />
<br />
<br />

## Java 소프트웨어 플랫폼 소개
Java는 단순히 프로그래밍 언어의 이름으로 사용되는 경우가 많지만, 보다 넓은 의미로 Java 프로그래밍 언어로 작성된 프로그램을 개발하고 실행할 수 있는 플랫폼의 총칭으로 사용됩니다. 이 장에서는 Java 소프트웨어 플랫폼에 대해 알아봅니다.

#### Table of Contents
1. Java 소프트웨어 플랫폼
2. Java 프로그래밍 언어 소개
3. Write Once Run Anywhere

<br />

### Java 소프트웨어 플랫폼
---------------
* Java 언어로 기술된 프로그램을 개발하고 실행할 수 있는 소프트웨어 모임의 총칭
* Java 프로그램의 실행 환경과 개발 환경을 제공
    * Java 프로그램은 운영체제와 하드웨어에 의존하지 않는 바이트코드(중간 언어)인 추상적인 코드로 구현
    * Java 프로그램은 운영체제와 하드웨어에 맞게 개발된 Java 가상 머신(JVM) 상에서 실행
    * JVM, 표준 라이브러리 세트, 컴파일러 환경만 맞추면 모든 환경에서 동일하게 동작
* Java 언어 <sup>Java Language</sup>, Java 애플리케이션<sup>Java Application</sup>, JRE<sup>Java Runtime Environment</sup>, Java 가상 머신<sup>Java Virtual Machine</sup>, 모바일용 Java<sup>Java Micro Edition</sup>등과 함께 단순히 Java라 불리는 경우가 많음
------------------

Java는 단순히 프로그래밍 언어의 이름으로 사용되는 경우가 많지만, 보다 넓은 의미로 Java 프로그래밍 언어로 작성된 프로그램을 개발하고 실행할 수 있는 플랫폼의 총칭으로도 사용됩니다.

##### 바이트코드(Byte Code)  
바이트코드는 특정 하드웨어가 아닌 가상 컴퓨터(Virtual Machine)에서 동작하는 실행 프로그램을 위한 이진 표현법입니다. 가상 머신은 이 바이트 코드를 각각의 하드웨어 아키텍처에 맞는 기계어로 변환하여 실행합니다.   
Java에서 바이트코드는 Java 가상 머신이 이해할 수 있는 언어로 개발된 Java 소스 코드를 의미하며, Java 바이트코드는 .class 확장자를 가지는 파일입니다. Java 바이트코드는 Java 가상 머신만 있으면 어떤 운영체제 에서라도 실행될 수 있습니다.
##### Java 가상 머신(Java Virtual Machine)
가상 머신이란 물리적으로 존재하는 컴퓨터가 아닌, 다른 컴퓨터가 만들어내는 가상의 컴퓨터를 의미합니다.   
가상 머신은 크게 프로세스 가상 머신과 시스템 가상 머신으로 나눌 수 있습니다. 응용 프로그램 가상 머신이라고도 불리는 프로세스 가상 머신은 하나의 프로세스만을 위해 생성되고 그 프로세스가 끝나면 종료됩니다. 프로세스 가상 머신은 일반적으로 다양한 플랫폼에서 같은 프로그램을 동일한 방식으로 동작시키기 위해 사용됩니다.  
Java 가상 머신은 대표적인 프로세스 가상 머신이며, Java로 작성된 프로그램은 아래와 같은 형태로 실행됩니다.

```mermaid
graph LR
A[HelloWorld.java] -->|컴파일러 javac| B[HelloWorld.class]
B -->|인터프리터 jvm| C[Hello, World!]
```
이와 유사한 형태의 가상 머신은 Microsoft의 CLR(Command Language Runtime)등이 있습니다.

#### Java 플랫폼(Java Platfornm)
Java 플랫폼은 Java 프로그래밍 언어로 프로그램을 개발하고 빌드하며 실행하는 일을 할 수 있도록 하는 프로그램들의 모입입니다.
|플랫폼|설명|
|-----|----|
|Java SE(Java Standard Edition)|데스크톱, 서버, 고사양의 임베디드 시스템을 위한 표준 Java 플랫폼으로, 표준적인 컴퓨팅 환경을 지원하기 위한 Java 가상 머신 규격 및 API 집합을 포함합니다. Java SE는 Java 가상 머신 규격 전체를 지원하며 Java 가상 머신 규격의 변경이 필요한 부분은 일반적으로 Java SE에 먼저 제안되고 추후에 Java EE및 Java ME에 포함됩니다|
|Java ME(Java Micro Edition)|제한된 자원을 가진 휴대 전화, PDA, 셋톱 박스 등에서 Java 프로그래밍 언어를 지원하기 위해 만들어진 Java 플랫폼입니다. 각각 다른 특성을 가진 Java ME 플랫폼들이 존재하며 각각의 사용자 인터페이스, 보안, 네트워크 프로토콜 등이 포함됩니다.|
|Jakarta EE|이전의 Java EE(Enterprise Edition)이며, Java를 이용한 서버 개발을 위한 플랫폼입니다. Java EE는 데스크톱 등에서 동작하는 표준 플랫폼인 Java SE에 웹 애플리케이션 서버에서 동작하는 장애 복구 미 분산 아키텍처를 제공하는 기능을 추가한 서버를 위한 플랫폼입니다.|

<br />

### Java 프로그래밍 언어
* * *
* Sun Microsystems의 제임스 고슬링(James Gosling)이 1995년 개발한 객체지향 언어
* C/C++와는 다르게 처음부터 객체지향 언어로 개발됨
* Java 프로그래밍 언어의 5가지 핵심 목표
    * 객체 지향 방법론을 사용해야 한다.*
    * 같은 프로그램(바이트코드)이 여러 운영체제(마이크로프로세서)에 탑재되어야 한다.
    * 컴퓨터 네트워크 접근 기능이 기본적으로 탑재되어 있어야 한다.
    * 원격 코드를 안전하게 실행할 수 있어야 한다.
    * 다른 객체 지향 언어들의 좋은 부분만 가지고 와서 사용하기 편해야 한다.
```mermaid
graph LR
A[Java Source Code] --> B[Java Virtual Machine]
B --> C[실행]
```
* * *
Java는 Sun Microsystems의 제임스 고슬링과 연구원들이 개발해 1995년 발표한 객체 지향 프로그래밍 언어입니다. 처음에는 가전제품 내에 탑재해 동작하는 프로그램을 위해 개발했지만 현재 전체적으로 가장 많이 사용하는 프로그래밍 언어중의 하나가 되었으며 모바일 기기용 응용 프로그램 개발에도 많이 사용됩니다.

Java는 C에서 진화한 C++와는 다르게 초기 설계부터 객체 지향 언어로 설계되었으며, 같은 코드로 어떤 마이크로프로세서에서나 실행되는 것을 목표로 했습니다. 이 결과로 Java 소스코드를 컴파일하면 Java 실행 코드인 바이트코드가 생성되며, 생성된 바이트코드는 Java 가상 머신에 의해 실행됩니다. C/C++ 코드로 작성되어 중간 실행 과정이 없는 네이티브 프로그램보다는 실행속도가 느리지만, 같은 코드로 다양한 플랫폼이나 운영체제에서 실행될 수 있다는 장점이 있습니다.

Java의 개발사인 Sun Microsystems는 자바를 GPL 라이선스로 오픈하였으며, 대부분의 코어 부분을 오픈하였습니다. 2009년 Sun Microsystems가 Oracle과 인수 합병됨에 따라 Java에 대한 권리 및 유지보수는 Oracle이 가지고 있습니다.

<br />

### Write Once Run Anywhere
* * *
그림
* * *
Write Once Run Anywhere(WORA) 또는 Write Once, Run Everywhere(WORE)는 Java의 크로스 플랫폼에 의해 얻을 수 있는 이점을 한마디로 표현할 수 있는 표어입니다. 이는 Java가 어떤 장비에서도 개발될 수 있고, 표준 바이트코드로 컴파일되고, Java 가상 머신이 장착된 장비라면 어디에서도 실행될 수 있음을 의미합니다.

Java 프로그래밍 언어로 작성된 소스코드는 Java 컴파일러를 통해 Java 바이트코드(.class)로 컴파일되며, 바이트코드는 Java 가상 머신 상에서 실행됩니다. 이런 구조가 Write Once Run Anywhere를 가능하도록 만듭니다.

<br />
<br />
<br />
<br />
<br />

## Java 가상 머신
Java 가상 머신은 Java 바이트코드를 실행하는 실행하는 가상 머신이며, 인터프리터나 JIT 컴파일 방식으로 다른 컴퓨터에서 바이트코드를 실행하도록 구현된 Java의 실행 환경이자 개발 환경입니다. 이 장에서는 Java 가상 머신에 대해 알아봅니다.

#### Table of Contents
1. Java 가상 머신
2. Java 동작 원리
3. JDK와 JRE
4. JVM 언어

<br />

### Java 가상 머신
* * *
* Java 바이트코드를 실행할 수 있는 주체
* 인터프리터나 JIT 컴파일 방식으로 다른 컴퓨터에서 바이트코드를 구현할 수 있도록 구현됨
* 플랫폼에 독립적이며 모든 Java 가상 머신은 그 규격에 정의된 대로 Java 바이트코드를 실행
* 표준 Java API까지 동일한 동작으로 구현한 상태에서는 이론적으로 CPU나 운영체제의 종류에 상관없이 동일하게 동작할 것을 보장함
* * *

가상 머신(Virtual Machine)은 컴퓨팅 환경을 소프트웨어로 구현한 것을 말합니다. 컴퓨터 시스템을 에뮬레이션하는 소프트웨어는 모두 가상 머신으로 불릴 수 있습니다. 시스템상에서 운영체제를 설치하고 실행하거나 또는 단일 응용 프로그램을 실행할 수 있도록 만들어진 소프트웨어를 가상 머신이라고 합니다.

가상 머신은 하드웨어를 가상화 하는 시스템 가상 머신(System Virtual Machine) – 대표적으로 하이퍼바이저(Hypervisor)과 응용 프로그램을 가상화 하는 프로세스 가상 머신(Process Virtual Machine)으로 나눌 수 있으며, Java 가상 머신은 프로세스 가상 머신에 해당합니다.

프로세스 가상 머신(응용 프로그램 가상 머신이라고도 불립니다)은 운영체제 안에서 일반 응용 프로그램을 구동하고 단일 프로세스를 지원합니다. 프로세스 가상 머신의 주 목적은 작성된 프로그램이 모든 플랫폼에서 동일한 방식으로 실행되는 것을 허용하고 실행을 위한 하드웨어나 운영체제의 부분을 가져오는 독립적인 프로그래밍 환경을 제공하는 것입니다. 

Java 가상 머신은 Java 바이트코드를 실행하는 가상 머신이며, 여러 형태가 있으나 인터프리터나 JIT 컴파일 방식으로 다른 컴퓨터에서 바이트코드를 실행할 수 있도록 구현됩니다. 이러한 방식으로 구현된 가상 머신은 중간 언어(IL – Intermediate Language)를 실행하는 Microsoft의 CLR(Common Language Runtime)이 있습니다.

Java 가상 머신은 응용 프로그램 개발을 단순화하며, 보안을 강제하고 강화된 환경에서 응용 프로그램을 수행하고, 여러 언어로 만들어진 프로그램이 동작하도록 만들며 응용 프로그램의 배포와 관리를 쉽게 합니다. 또한 이 환경은 가비지 컬렉션과 같은 일반적인 서비스를 포함하여 관리되는 환경을 제공합니다.

<img src="images/image02.png" />

|구성요소|설명|
|-------|----|
|Class Loader|Java 컴파일러 소스를 컴파일해서 만들어 낸 바이트코드 클래스들을 엮어 Runtime Data Area 형태로 메모리에 적재하고 메타데이터를 관리합니다.|
|Execution Engine|메모리에 적재된 클래스들을 기계어로 번역하여 명령어 단위로 실행합니다.|
|Gabage Collector|객체의 생명주기를 관리합니다. Heap 메모리 영역에 생성된 객체들 중 유효한 참조가 없는 객체(unreachable)를 자동으로 탐색하고 제거합니다.|
|Method Area|클래스 멤버 변수, 메소드 정보, 타입 정보, 상수 풀, 정적 변수 등이 생성되는 영역입니다.|
|Heap Area|동적으로 생성된 객체와 배열이 저장되는 Garbage Collector의 대상이 되는 영역입니다.|
|JVM Language Stacks|지역 변수, 파라미터 등이 생성되는 영역입니다.|
|PC Register|현재 스레드가 실행되는 부분의 주소와 명령을 저장합니다.|
|Native Method Stack|자바 외의 언어로 작성된 Native 코드를 위한 메모리 영역입니다.|

<br />

### Java 동작 원리
* * *
<img src="images/image03.png" width="300"/>

* * *
 Java 실행 엔진의 동작 방식은 Java 가상 머신의 구현에 따라 다릅니다. Oracle의 Hotspot의 경우에는 아래와 같이 동작합니다.

* 일반적으로 인터프리터가 프로그램을 시작하는데 사용됩니다.
* Java 가상 머신은 성능 향상을 위해 코드의 성능에 중요한 부분을 컴파일하지만 거의 사용되지 않는 코드는 컴파일하지 않습니다.
* 코드를 컴파일하는 방법을 최적화하기 위해 라인별 adaptive compiler를 사용합니다.

Java 가상 머신은 라인별로 바이트 코드를 읽어 기계어로 변환해 실행하며 기본적으로는 인터프리터를 통해 실행을 하지만 자주 등장하는 바이트 코드일 경우 JIT 컴파일러로 컴파일하는 방법을 통해 실행 방법을 최적화합니다.

#### 인터프리터
바이트 코드를 하나씩 읽어서 해석하고 실행합니다. 한 줄 단위로 읽어서 해석하고 실행하기 때문에 바이트 코드 단위의 해석은 빠른 대신 인터프리팅 결과의 실행은 느리다는 단점을 가집니다. 바이트 코드는 기본적으로 인터프리터 방식으로 동작합니다.

#### JIT(Just-In-Time) 컴파일러
인터프리터의 단점을 보완하기 위해 도입되었으며, 인터프리터 방식으로 동작하다가 적절한 시점에 바이트코드 전체를 컴파일하여 네이티브 코드로 변경하고, 해당 메소드를 더 이상 인터프리팅 하지 않고 네이티브 코드로 직접 실행합니다. 네이티브 코드를 실행하는 것이 인터프리팅보다 빠르고, 네이티브 코드는 캐시에 보관하기 때문에 한 번 컴파일된 코드는 계속 빠르게 실행됩니다.

<br />

### JDK와 JRE
* * *
* JRE (Java Runtime Environment)
    * Java 가상 머신, Java 클래스 라이브러리, Java 명령 및 기타 인프라를 포함한 컴파일된 Java 프로그램을 실행하는데 필요한 패키지
    * Java 실행 환경이며, 기본적으로 Java 관련 파일이 있는 디렉터리 집합
        * bin/  Java 실행 프로그램(java 또는 javaw)과 keytool등의 유틸리티를 포함
        * conf/  사용자가 편집할 수 있는 구성 파일을 포함
        * lib/  모듈, jar 구성 파일, 속성 파일 등 Java 프로그램이 구동되는데 필요한 라이브러리를 포함
    * *JDK (Java Development Kit)
    * Java를 사용하기 위해 필요한 모든 기능을 갖춘 Java용 SDK(Software Development Kit)
    * JRE를 포함하며, 컴파일러(javac)와 jdb, javadoc과 같은 도구를 포함
    * JRE와 마찬가지로 디렉터리 집합
        * bin/  컴파일러(javac)를 비롯한 개발도구를 포함
        * jmods/  표준 라이브러리용 JMOD 파일을 포함
* * *
JRE(Java Runtime Library)는 클래스 라이브러리(Class Library)와 Java 응용 프로그램의 실행에 필요한 여러 리소스를 제공하는 소프트웨어 계층입니다. JRE는 작성된 Java 코드를 Java 가상 머신에서 실행하는데 필요한 라이브러리와 결합한 후 Java 가상 머신을 만들어 실행합니다.
JRE는 운영체제를 기반으로 실행되며 Java에 고유한 추가 리소스를 제공합니다. JRE는 운영체제를 추상화하며 Java 응용 프로그램을 실행하고 배포하는 일관된 플랫폼을 제공합니다. JRE 런타임 아키텍처의 주요 구성요소는 아래와 같습니다.

* 클래스 로더  
Java 응용 프로그램의 실행에 필요한 모든 클래스를 동적으로 로드합니다. Java 클래스는 필요할 때에만 메모리에 로드되는데, JRE는 클래스 로더를 사용하여 요청시에 이 프로세스를 자동화합니다.
* 바이트코드 검증기  
바이트코드 검증기는 인터프리터에 전달되기 전에 Java 코드의 형식과 정확성을 보장합니다. 코드가 시스템 무결성 또는 액세스 권한을 위반하는 경우 클래스를 로드하지 않습니다.
* 인터프리터
바이트코드의 로드에 성공한 후, Java 인터프리터는 Java 응용 프로그램이 기본 시스템에서 기본적으로 실행될 수 있도록 Java 가상 머신의 인스턴스를 생성합니다.

#### JRE의 동작
JRE는 Java 가상 머신 외에도 다양한 지원 소프트웨어 도구와 기능들로 구성되어 있습니다.
JRE는 운영체제를 기반으로 실행되며 Java에 고유한 추가 리소스를 제공합니다. JRE는 운영체제를 추상화하며 Java 응용 프로그램을 실행하고 배포하는 일관된 플랫폼을 제공합니다. JRE 런타임 아키텍처의 주요 구성요소는 아래와 같습니다.
* 배포 솔루션  
응용 프로그램의 활성화를 간소화하고 Java 업데이트를 위한 고급 지원을 제공하는 Java 플러그인 및 Java Web Start등과 같은 배포 기술들이 포함됩니다.
* 사용자 인터페이스 라이브러리  
JRE는 사용자 인터페이스 개발을 위한 툴킷을 포함합니다. 
    * Java 2D  
    Java 언어의 2차원 그래픽 작성에 사용되는 API로, 사용자 인터페이스, 애니메이션 등을 작성할 수 있음.
    * AWT(Abstract Window Toolkit)  
    객체, 버튼, 스크롤바 등 윈도우 작성에 사용되는 GUI(Graphic User Interface)
    * Swing
    풍부한 위젯을 사용하여 유연하고 사용자 친화적인 커스터마이징을 제공하는 경량 GUI
* 통합 라이브러리  
응용 프로그램과 서비스 간에 데이터 연결을 제공하는 라이브러리입니다.
    * IDL (CORBA)  
    공통 객체 요청 아키텍처를 사용하여 Java 프로그래밍 언어로 작성된 분산 객체
    * JDBC (Java Database Connectivity)  
    관계형 데이터베이스, 플랫 파일 및 스프레드시트에 대한 액세스를 제공
    * JNDI (Java Naming and Directory Interface)  
    이름 지정 규칙을 사용하여 데이터베이스 정보를 패치할 수 있는 프로그래밍 인터페이스 및 디렉터리 서비스
* 언어 및 유틸리티 라이브러리  
응용 프로그램 작성을 위한 언어 지원과 다양한 라이브러리를 지원합니다.
    * Collections  
    데이터의 저장과 처리를 개선하도록 설계된 자료구조, 인터페이스
    * Concurrency Utilities  
    고성능 스레딩 유틸리티 프레임워크
    * Preference API  
    동일 시스템에서 다수의 사용자가 응용 프로그램 환경 설정 그룹을 지정할 수 있는 API
    * Logging  
    추가 분석을 통해 로그 보고서를 생성
    * JAR (Java Archive)  
    다수의 파일을 JAR 형식으로 번들링 할 수 있게 하여 다운로드 속도를 개선하고 파일 크기를 줄일 수 있도록 하는 플랫폼 독립형 파일 형식

<img src="images/image04.png" />

<br />

### JVM 언어
* * *
* Java와 같이 Java 바이트 코드를 생성하지만 언어 규격이 다른 프로그래밍 언어
* ***Closure*** 함수형 언어로, Java 플랫폼에서 동작하는 LISP의 방언
* ***Groovy*** Java에 Python, Ruby, SmallTalk등의 특징을 버무린 동적 타입 언어
* ***JRuby*** Ruby를 Java로 구현
* ***Jython*** Python을 Java로 구현
* ***Kotlin*** JetBrains에서 개발한 JVM언어로, 안드로이드의 공식 언어
* ***Rhino*** 모질라 재단이 만든 JVM에서 동작하는 JavaScript 엔진
* ***Scala*** 객체지향 언어의 특징과 함수형 언어의 특징을 함께 가지는 다중 패러다임 언어
* * *
Java의 품질이 입증된 이후 많은 프로그래밍 언어들이 강력하고 이식성이 좋은 언어를 만들기 위해 Java 가상 머신을 사용하기 시작했으며 이후 Java 가상 머신에서 동작하는 많은 프로그래밍 언어들이 만들어졌습니다.

Java 가상 머신에서 실행될 수 있도록 바이트 코드를 생성하거나 Java 가상 머신에서 실행되는 인터프리터를 지원하는 언어를 Java 가상 머신 지원 언어라고 부릅니다.

|언어|설명|
|---|----|
|Alef|객체지향 프로그래밍 언어로 Perl과 LISP 문법을 따름|
|AspectJ|Java 프로그래밍 언어의 AOP 프로그래밍 확장|
|BeanShell|Java 문법을 따르는 동적 스크립트 언어|
|CAL|쿼크 프레임워크의 일부로 Haskell, Clean, Java에 영향받은 함수형 언어|
|Clojure|LISP의 방언으로 다중 스레드 프로그래밍을 쉽게 할 수 있는 특징을 가진 함수형 언어|
|Fantom|Java, C#과 유사한 언어로 Java 가상 머신과 .NET CLR, JavaScript 지원|
|Flink|슈퍼 컴퓨팅을 위한 언어|
|Groovy|Ruby, SmallTalk, Python등에 영향을 받아 설계된 동적 타임언어로, Gradle같은 빌드 도구, Grails 같은 엡 도구들이 이 언어로 작성됨|
|Hecl|Java ME를 위한 스크립트 언어|
|Jaskell|Haskell에서 영향을 받은 지연된 계산(Lazy evaluation)을 하는 스크립트 언어|
|Jelly|XML 문법을 사용한 스크립트 언어|
|JudoScript|함수형 언어로, JDBC, WSDL등 특정 영역을 위한 스크립팅 언어|
|Kotlin|JetBrains에서 개발한 정적 타입 언어로 Generics등의 유용한 특징을 가지면서도 단순한 문법을 가지는 객체지향 언어|
|Mirah|Ruby 문법을 기반으로 한 정적 타입 언어|
|Scala|함수형 프로그래밍과 객체지향 프로그래밍을 혼합한 언어로, Spark등에서 사용되어 Java 가상 기계 기반 언어 중 가장 주류로 편입된 언어로 평가받고 있음|

Java 가상 머신 지원 언어 이외에도 C, COBOL, JavaScriptr, Scheme등 많은 기존 언어들이 Java 가상 머신에서 동작하도록 구현되고 있습니다.

<br />
<br />
<br />
<br />
<br />

## Java의 역사
Java는 오픈소스와 상용 버전이 섞여 있으며 다양한 라이선스와 배포 형태를 가지고 있습니다. 이 장에서는 Java의 라이선스와 다양한 JVM 공급자를 이해하기 위해 Java의 역사에 대해 알아봅니다.

#### Table of Contents
1. java의 역사
2. JVM 언어

<br />

### Java의 역사
* * *
* 1991년 셋톰 프로젝트를 위해 개발
* 초창기 Oak, Green등으로 불렸으나 최종적으로 Java라는 이름이 선택됨\

|연도|내용|
|----|----|
|1995|JDK 1.0 발표|
|1998|J2SE(Java 2 Standard Edition) 발표|
|2004|J2SE 5 발표|
|2006|Java SE 6 발표, Sun Microsystems에서 대부분의 Java를 GPL 라이선스로 오픈|
|2009|Oracle이 Sun Microsystems인수, Java에 대한 권리와 유지보수를 Oracle에서 인수|
|2011|Java SE 7 발표|
|2018|Java SE 9 발표, 64비트 버전만 공식 지원하며 32비트 지원 종료|
|2018|Java SE 11 발표, Oracle JDK 유료 전환|
|2021|Java SE 17 발표|
* * *

1991년 Sun Microsystems에서 Green이라는 임베디드 시스템을 위한 플랫폼을 만들기 위한 프로젝트로 시작되었으며, 제임스 고슬링(James Gosling), 패트릭 노튼(Patrick Naughton), 크리스 와츠(Chris Warth), 에드 프랭크(Ed Frank), 마이크 쉐리던(Mike Sheridan)에 의해 개발되었습니다.

초기에는 Oak라 명명되었으나 1995년 Java로 이름이 최종 결정되었으며, 다양한 환경의 CPU에서 실행되는 코드를 생성할 수 있는 이식성이 뛰어난 Cross Platform은 이식 가능한 언어를 요구하는 웹의 출현으로 컴퓨터 언어 프로젝트에 잘 맞았으며, 이런 이유로 Java의 초점은 임베디드 시스템에서 인터넷으로 옮겨지게 되었고 이런 시도는 큰 성공을 거두었습니다.

2009년 Sun Microsystems를 Oracle이 인수하였고 Oracle의 독점적인 정책에 따라 JVM과 JDK는 많은 벤더와 오픈 소스 진영에서 여러 버전의 JDK와 JVM을 만들기 시작했습니다. 그에 따라 OpenJDK, Azul, Microsoft JDK등 많은 버전의 JDK를 사용할 수 있게 되었고, 2018년 Oracle JDK 독점 기능이 오픈 소스 버전인 OpenJDK에 이식되었으며, 2019년 Oracle JDK는 유료화 되었습니다.

Java는 많은 버전 업이 있었으며 버전이 변경될 때 마다 추가되는 요구사항을 반영하며 발전했습니다. 

|버전|연도|내용|
|----|----|----|
|JDK 1.0a2|1995|Oak 언어 발표|
|JDK1.0|1996|이름이 Java로 변경됨|
|JDK 1.1|1997|Inner Class, Java Beans, RMI, Reflection, Calendar 유니코드 지원 등이 추가|
|J2SE 1.2|1998|Swing, JIT, Collection Framework등이 추가|
|J2SE 1.3|1998|HotSpot VM, JNDI, JPDA, JavaSound 등이 추가|
|J2SE 1.4|2002|Assert, 정규 표현식, XML API등이 추가|
|J2SE 1.5|2004|Generics, Annotation, AutoBoxing/UnBoxing, Enumeration, 가변 길이 파라미터, static import, Concurrency API등이 추가|
|Java SE 6|2006|Java Compiler API, Pluggable Annotation등이 추가|
|Java SE 7|2011|Switch 문에서 String 사용, try-catch-resource, File NIO 라이브러리 등이 추가|
|Java SE 8|2014|Lambda Expression, 새로운 날짜와 시간, Interface default method, Stream API 등이 추가|
|Java SE 9|2017|JShell 추가|
|Java SE 10|2018|var 키워드를 시용한 지역 변수 타입 추론, 병렬 처리 가비지 컬렉션, stop-the-world 등이 추가|
|Java SE 11|2018|Hotspot/jvmti 등이 추가되었으며, 이클립스 재단으로 넘어간 Java EE가 JDK에서 삭제되고 JavaFX가 JDK에서 분리되어 별도의 모듈로 제공|
|Java SE 12|2019|Switch 문 확장|
|Java SE 13|2019|yield 추가|
|Java SE 14|2020|record라는 데이터 오브젝터 선언 기능 추가|
|Java SE 15|2020|sealed class 추가|
|Java SE 16|2020|OpenJDK 버전 관리가 Git으로 변경|
|Java SE 17|2021|의사 난수 생성기 API 추가, Java Applet이 deprecate 처리됨|

<br />

### JDK 공급자
* * *
|공급자|특징|버전|
|-----|----|----|
|Oracle|유료, TCK 인증|출시된 최신 버전만 일반 지원 기간 동안 제공하며, 그 외는 오라클 서비스 구독 고객에게 비 공개 제공|
|OpenJDK|기업무료, 테스트 버전 제공|출시된 최신 버전만 제공하며, 그 외 버전은 소스만 제공|
|Azul|기업무료, TCK 인증|6이후의 모든 버전을 제공하며, 기업 사용은 무료이며 기술지원은 유료|
|AdoptOpenJDK|기업무료, 테스트 버전 제공|LTS2 8, 11 버전 및 최신 버전 제공, 17 이후는 Adoptium에서 이관하여 Temurin으로 제공|
|Temurin|기업무료, TCK 인증, 테스트버전 제공|Eclipse 재단에서 제공, LTS 8, 11, 17 및 최신 버전 제공|
|Microsoft JDK|기업무료, TCK 인증, 테스트버전 제공|LTS 11, 17 제공, Azure 클라우드 환경을 위한 JDK로 제공|
|Bellsoft Liberica JDK|기업무료, TCK 인증|기업 사용은 무료이며 기술지원은 유료|
|IBM Semeru Runtime|TCK 인증|IBM 클라우드 전용으로 제공|
|Amazon Corretto|기업무료, TCK 인증|AWS 클라우드 환경을 위한 JDK로 제공|
|Alibaba Dragonwall|TCK 인증|중국 알라바바에서 만든 JDK|
|SapMachine|TCK 인증|SAP에서 만든 JDK로 SAP 전용|
|Red Hat OpenJDK|TCK 인증|레드햇에서 만든 JDK로 Red hat Linux및 CentOS에서 구동|
|GraalVM|유료, 무료, TCK 인증, 테스트 버전 제공|CLR과 같은 방식으로 JavaScript등의 폴리글랏 언어로 개발하여 네이티브에 구동할 수 있도록 개발환경을 제공하는 목표로 개발 중. 커뮤니티 에디션 무료, 기업버전 유료|
* * *

Java는 여러 방향으로 버전업하며 발전하고 있으며, JDK와 JVM은Microsoft, IBM, AWS등의 벤더와 Eclipse 재단 등에서 여러 목적과 버전에 맞게 개발하여 유료 또는 무료로 배포하고 있습니다.

Oracle은 많은 재단과 벤더에서 만들어지는 JDK가 Java의 목적에 맞게 완벽하게 동작하는지를 알 수 있도록 하기 위해 TCK(Technology Compatibility Kit)를 만들어 엄격하게 관리하고 있습니다.

<br />

