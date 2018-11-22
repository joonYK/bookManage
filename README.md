# bookManage

* View

- 도서관리
  도서관
  도서관리를 한다.
  책을 검색한다.
  책을 등록한다.
  책을 삭제한다.

- 회원관리
  도서관
  회원관리를 한다.
  회원을 검색한다.
  회원을 등록한다.
  회원을 삭제한다.

- 대여관리
  도서관
  대여관리를 한다.
  책을 대여한다.
  책을 반납한다.

* Service

- 도서관
  책 리스트
  회원 리스트
  책을 등록한다.
  책을 삭제한다.
  책을 검색한다.
  책을 대여해준다.
  회원을 검색한다.
  회원을 생성한다.
  회원을 삭제한다.

* DTO

- 책
  ID
  이름
  대여 상태

- 회원
  ID
  이름
  빌린 책 리스트
  책을 빌린다.
  책을 반납한다.


11/21

도서관은 서비스로직만 담당한다.
유저 인터페이스(유저와 시스템의 중간에서 상호작용하는 역할) 
인 콘솔로직에서 결과를 출력하도록 한다.

등록이면 등록에 대한 수행만 역할하고, 그 결과여부만 준다.
검색이면, 검색에 대한 데이터리스트를 전달하고 어떻게 출력할지는 UI에서 전담한다.


11/22

Main 메소드에 모든 UI로직을 모듈로 분리 필요.
Main 메소드에서는 책,회원,대여 관리의 대분류의 분기만 태워 위임한다.
각 UI객체에서 소메뉴로 분기

모듈로 분리했을때의 문제점은 도서관 객체를 계속 넘겨주는문제, 데이터의 일관성이 있다.
이 문제를 고민해보자. (DI, 싱글톤의 개념을 적용?)
람다를 이용해서 모듈 로직을 간소화해보자.
