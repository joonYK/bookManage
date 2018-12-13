# bookManage

### * view, controller
#### - 도서관리
도서관
도서관리를 한다.
책을 검색한다.
책을 등록한다.
책을 삭제한다.

#### - 회원관리
도서관
회원관리를 한다.
회원을 검색한다.
회원을 등록한다.
회원을 삭제한다.

#### - 대여관리
도서관
대여관리를 한다.
책을 대여한다.
책을 반납한다.

#

### * Service
#### - 도서서비스
책 리스트
책을 등록한다.
책을 삭제한다.
책을 검색한다.
책을 대여해준다.

#### - 회원서비스
회원 리스트
회원을 검색한다.
회원을 생성한다.
회원을 삭제한다.

#### - 대여서비스
대여/반납 로그리스트
도서를 대여해준다.
도서를 반납받는다.

#

### * DTO
#### - 책
  ID
  이름
  대여 상태

#### - 회원
  ID
  이름
  빌린 책 리스트
  책을 빌린다.
  책을 반납한다.

#

### * 11/21

###### 도서관은 서비스로직만 담당한다.
###### 유저 인터페이스(유저와 시스템의 중간에서 상호작용하는 역할)인 콘솔로직에서 결과를 출력하도록 한다.

###### 등록이면 등록에 대한 수행만 역할하고, 그 결과여부만 준다.
###### 검색이면, 검색에 대한 데이터리스트를 전달하고 어떻게 출력할지는 UI에서 전담한다.

#

### * 11/22

###### Main 메소드에 모든 UI로직을 모듈로 분리 필요.
###### Main 메소드에서는 책,회원,대여 관리의 대분류의 분기만 태워 위임한다.
###### 각 UI객체에서 소메뉴로 분기

###### 모듈로 분리했을때의 문제점은 도서관 객체를 계속 넘겨주는문제, 데이터의 일관성이 있다.
###### 이 문제를 고민해보자. (DI, 싱글톤의 개념을 적용?)
###### 람다를 이용해서 모듈 로직을 간소화해보자.

###### 추상화를 통해 만들었던 객체의 여러 기능들을 각 공통된 기능별로 모듈화를 통해 잘게 쪼개고 모듈의 연계와 조립을 통해 하나의 어플리케이션을 만들어나간다.

#

### * 11/23

###### 대여,반납에 대한 로그를 만들어보자.
###### 기존 도서관 객체 하나에 몰려있던 서비스 로직 모듈화가 필요. (책, 회원, 대여)

###### 서비스 로직 실행의 여러 실패 원인을 Exception 객체를 만들어 enum 타입을 이용해 구분하여 잡을 수 있다.
###### 중간 로직에 대한 에러 처리는 서비스로직에서 처리하는게 맞지만 사용자에게 알려줘야할 필요가 있는 에러는 모두 컨트롤러로 던진다. (모듈과 환###### 경의 결합도를 낮춘다. 서비스 로직 모듈은 콘솔기반의 어플리케이션인지, 웹기반인지 신경쓸 필요가 없다. 어디서든 가져다 쓰되 처리는 각 환경에서 알아서 하도록 한다.)

###### 체크에 대한 로직은 따로 모듈화한다.
###### 기존에 대여, 반납 로직은 체크로직을 포함했었지만, 체크로직을 따로 분리하여 코드의 간소화와 중복을 없애고 응집도를 높여 필요한곳에서 재활용하여 가져다 쓸 수있는 하나의 공통 모듈로 만들 수 있다. 

###### 모듈로 분할할 수 있는지 아닌지 항상 확인하며 작성해보자

#

### * 11/26

###### 링크드 리스트를 직접 구현해보자.
###### 단순 CRUD 작업보다는 도서관에 관한 기능 로직을 구현해보자. (연체일에 따른 연체료 지불 등)

#

### * 12/07

###### 데이터들을 파일에서 읽어오고 저장하도록 해보자. (직렬화 or 직렬화 X)

### * 12/13
###### 파일의 데이터는 바이너리 (2진) 데이터로 저장됨. 파일을 읽을때는 1바이트 단위로 바이너리 데이터를 읽어들이며,
###### 이 데이터 자체로는 아무것도 하지 못함. 이 데이터는 UTF-8, EUC-KR등등에 대한 표현이다라는 것을 명시해서 디코딩을 해야 비로소 데이터로서의 가치가 생김.
###### UTF-8, EUC-KR등은 바이트를 가변형으로 쓰는데 영어같은 경우는 1바이트로 모든것을 표현(아스키)할 수 있기 때문에 인코딩와 디코딩의 포맷이 다르더라도 아스키를 내장하고 있어서 깨지지 않지만 한글이나 다른 언어는 2바이트 이상이므로 포맷이 다를경우 깨짐.
