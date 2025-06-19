## Look-and-Say Sequence - 가운데 두 자리 추출

### 문제 설명

양의 정수 `n`이 주어지면, `n`번째 항(`Ln`)의 자리수 중 **가운데 두 자리 수**(`m`)를 출력합니다.

* 첫 번째 항은 문자열 `"1"`입니다.
* 예시

    * 입력 `n = 5` → 출력 `12`
    * 입력 `n = 8` → 출력 `21`

> 조건: 입력값 `n`은 3보다 크고 100보다 작습니다.

---

## 실행 방법


### 1. 프로젝트 클론

```bash
git clone https://github.com/hobit22/LookAndSaySequence.git
cd LookAndSaySequence
```

### 12 실행

```bash
# V1String 예시
java ./src/main/java/team/sakak/version/LookAndSayV1String.java

```

또는 IDE에서 각 클래스를 실행해 원하는 n값을 직접 테스트할 수 있습니다.

---

## 풀이 방식 요약

### Look-and-Say 시칭을 구할 다양한 방식 구현:

| 버전     | 방식            | 설명                    |
| ------ | ------------- |-----------------------|
| **V1** | `String` 연결   | 가장 기본적인 문자열 덧셈 방식     |
| **V2** | `Regex`       | 정규표현식으로 반복 문자 그룹화     |
| **V3** | `Stream API`  | Java 8+의 스트림 기능 활용    |
| **V4** | `Two Pointer` | 투 포인터 방식으로 직접 그룹 파싱   |
| **V5** | `Queue`       | 문자 큐를 이용한 순차 처리       |
| **V6** | `Bit` 연산      | 비트 시뮬레이션 기반 최적화 시도    |
| **V7** | `Bit + long`  | `long` 타입 기반 고속 처리 시도 |

### 시간·공간 복잡도 분석
L = 실제로 n번째 항을 구할 때 다루는 문자열의 길이

| 버전    | 시간복잡도 | 공간복잡도 | 비고 |
| ----- |------|-------| -- |
| V1    | O(L) | O(L)  |StringBuilder 사용. 문자열 복사 비용 없음|
| V2    | O(L) | O(L)  |정규표현식 + StringBuilder. 그룹화는 정규식으로 처리되며 선형 처리|
| V3    | O(L) | O(L)  | |
| V4    | O(L) | O(L)  |투 포인터 방식. 빠르고 안정적|
| V5    | O(L) | O(L)  |Queue 사용. 투 포인터와 유사|
| V6/V7 | O(L) | O(1)  |비트 압축 처리로 내부 메모리 절약, 최종 출력은 O(L) 필요|

V6 까지 모두 n = 80 부근에서 OOM 이 발생했습니다.

---

## 테스트

JUnit5를 이용해 다양한 입력값에 대한 테스트를 작성하였습니다:

```java
@Test
void testGetNthTerm() {
    assertEquals("21", LookAndSayV1String.getNthTerm(3));
    assertEquals("1211", LookAndSayV1String.getNthTerm(4));
    assertEquals("111221", LookAndSayV1String.getNthTerm(5));
    assertEquals("312211", LookAndSayV1String.getNthTerm(6));
}

@Test
void testGetMiddleTwoDigits() {
    assertEquals("12", LookAndSayV1String.getMiddleTwoDigits(5));
    assertEquals("21", LookAndSayV1String.getMiddleTwoDigits(8));
}

@Test
void testLagreNumber() {
    assertEquals("21", LookAndSayV1String.getMiddleTwoDigits(50));
}


@Test
void testBiggestNumber() {
    assertEquals("21", LookAndSayV1String.getMiddleTwoDigits(99));
}
```

전체 테스트는 `src/test/java/sakak`에 있으며, 모든 구현 클래스에 대한 테스트가 포함되어 있습니다.

---

## 📁 프로젝트 구조

```
🔹 src
│   ├── main
│   │   └── java
│   │       └── team.sakak.version
│   │           ├── LookAndSayV1String.java
│   │           ├── LookAndSayV2Regex.java
│   │           └── ...
│   └── test
│       └── java
│           └── team.sakak
│               └── LookAndSayTest.java
└── build.gradle
└── README.md
```

---

## 풀이 후기
- Look-and-Say 수열은 이전 항의 전체 내용이 있어야만 다음 항을 만들 수 있는 점이 핵심입니다. 
- 중간값이나 특정 부분 정보만으로는 다음 항의 중간값을 예측할 수 없습니다. 
- 다음 항을 계속 만들어가면 된다고 생각하면 간단한 문자열 생성 문제처럼 보이지만, 구현 방식에 따라 성능 차이가 크게 나타날 수 있음을 보여주는 문제였습니다. 
- 다양한 접근을 시도하며 Java의 다양한 기능(Stream, Regex, Queue, 비트 연산)을 실험하고 비교해볼 수 있었습니다. 
- 가장 안정적이고 직관적인 방식은 Two Pointer 방식이었으며, 실무에 적용한다면 이 방식을 우선적으로 고려할 것 같습니다. 
- 비트 연산을 통해 압축 처리를 시도한 것도 흥미로웠지만, 가독성과 유지보수 측면을 함께 고려해야 할 필요가 있습니다.
---

## 기타

* Java 17 사용
* 테스트 프레임워크: JUnit5

