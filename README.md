# bookManage

-책
ID
이름
대여 상태

-도서관
책 리스트
회원 리스트
책을 등록한다.
책을 삭제한다.
책을 검색한다.
책을 대여해준다.
회원을 검색한다.
회원을 생성한다.
회원을 삭제한다.

-회원
ID
이름
빌린 책 리스트
책을 빌린다.
책을 반납한다.


도서관은 서비스로직만 담당한다.
유저 인터페이스(유저와 시스템의 중간에서 상호작용하는 역할) 
인 콘솔로직에서 결과를 출력하도록 한다.

등록이면 등록에 대한 수행만 역할하고, 그 결과여부만 준다.
검색이면, 검색에 대한 데이터리스트를 전달하고 어떻게 출력할지는 UI에서 전담한다.
