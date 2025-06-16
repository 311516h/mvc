# Spring MVC Basic Practice

Spring MVC의 흐름과 핵심 기능을 익히기 위한 학습형 미니 프로젝트입니다.  
**목표:** 서블릿부터 MVC 구조, 타임리프, 세션 기반 로그인 처리까지 단계별로 구현하며  
백엔드 웹 개발의 기초를 탄탄히 다지는 것.

---

## 🛠️ Tech Stack

- Java 21  
- Spring Boot 3.x  
- Spring MVC  
- JSP, Thymeleaf  
- Gradle  
- IntelliJ IDEA  

---

## 🎯 Features

### 1. 서블릿 & JSP  
- HttpServlet을 직접 구현하여 요청/응답 흐름 이해  
- JSP를 통해 동적 데이터 출력  

### 2. MVC 패턴 기반 회원 기능  
- Controller → Service → Repository 구조로 설계  
- 회원 CRUD 구현  
- 웹 폼과 REST API 방식 모두 지원  

### 3. 타임리프 적용  
- 타임리프를 이용한 회원 등록/수정 폼 및 목록 출력 화면 구성  
- 데이터 바인딩, 조건문 등 핵심 문법 실습  

### 4. 로그인 처리 (세션 기반)  
- 세션을 이용한 로그인/로그아웃 기능 구현  
- 인증이 필요한 기능에 인터셉터 적용  
- 현재는 로그인 기능을 REST API로만 제공  

---

## 📝 회고 & 학습 포인트

- 요청 → 컨트롤러 → 서비스 → 리포지토리 → 뷰로 이어지는 스프링 MVC 흐름을 직접 구현하며 체득
- View 기반 화면과 Rest API를 함께 구현해 다양한 방식의 데이터 처리 경험
- 세션과 인터셉터를 활용한 인증 흐름 제어 학습
- 기능을 작게 나누어 점진적으로 확장하며 학습의 깊이를 더함
