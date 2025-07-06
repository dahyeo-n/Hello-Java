# Hello-Java

- Java 언어의 기본 문법, 객체지향 프로그래밍, 컬렉션 및 간단한 CLI 애플리케이션 설계까지 **체계적으로 학습하고 실습한 내용**을 정리한 저장소입니다.
- 주차별로 디렉토리를 구분하여 학습 내용을 단계적으로 정리하였습니다.

## 🧩 학습 목차 및 내용 요약

| 디렉토리                         | 주요 학습 주제                          |
| ---------------------------- | ------------------------------------- |
| `chapter_01_20250125`        | Java 시작, `System.out` 출력, 프로젝트 구조 |
| `chapter_02_20250201`        | 변수, 상수, 자료형, 형 변환, 입력 처리(Scanner) |
| `chapter_03_20250208`        | 연산자 실습, 간단한 계산 로직 구현 |
| `chapter_04_20250222`        | 조건문, 반복문, 간단한 게임 (숫자 맞추기, 가위바위보 등) |
| `chapter_04_method_20250315` | 메서드 분리, 리팩토링, 구조화된 코드 작성 연습 |
| `chapter_05_20250322`        | 배열과 2차원 배열, 간단한 게임 (숫자야구), 성적 관리 |
| `chapter_06_20250412`        | 클래스와 객체 설계, 버전별 객체 구조 실습 |
| `chapter_07_20250503`        | 상속, 다형성, 인터페이스 구조 설계 연습 |
| `chapter_08_20250607`        | 제네릭(Generic), 컬렉션 기초 |
| `student-management/`        | MVC 패턴 기반의 CLI 학생 관리 시스템 구현 |
| `study-community-program/`   | 커뮤니티 프로그램 구현 (Docker, MySQL 포함) |

## 🛠️ 실행 환경

* Java 17.0.10
* IDE: Visual Studio Code
* 일부 프로젝트(`study-community-program`)는 Docker 사용

## 🫟 실행 방법

### (1) 일반 실행

1. 각 `chapter_XX_xxxxxxxx` 디렉터리로 이동
2. `src` 디렉터리 내 `.java` 파일을 IDE 또는 CLI로 실행

### (2) Docker 예제 실행 (`study-community-program`)

```bash
cd study-community-program/docker
docker-compose up -d
```

## ✨ 주요 특징

* **실제 주차별 학습 흐름을 따라가기 쉬운 구조**
* 실습 예제 코드 + 각 주제별 README 정리
* 간단한 게임/애플리케이션 예제로 개념 응용
* 점진적으로 객체지향 구조까지 발전
* 실제 객체 설계 및 서비스 구성 연습 (`student-management/`)
