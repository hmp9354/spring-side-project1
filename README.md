# 유비쿼터스 언어 - 공통
<p>해당 내용은 팀을 구성하는 멤버 전원이 특정 개념에 대해 언어로써 동일한 이해를 확립하는 것을 목적으로 한다.</p>
<p>특히, 해당 내용은 글로써 소통할 때 정확하게 사용되어야 한다.</p>
<p>개발자의 경우에는 메소드 혹은 메시지 등을 구성할 때 이를 참고한다.</p>
<br>

## 핵심 대상
<div>
  <b>조건</b>
  <p>이 대상들은 빈 값을 포함해서는 안 된다.</p>
  <p>이 대상들은 단순히 데이터를 옮기는 때를 제외하고는 생성될 때를 제외하고 수정되어서는 안 된다.</p>
  <b>테이블 항목 설명</b>
  <p>유일함은 다른 대상 간에 중복된 값이 허용되어서는 안 되는지에 대한 여부를 나타낸다.</p>
  <p>제한 사항은 해당 대상이 담을 수 있는 값에 대한 제한 사항을 의미한다.</p>
</div>
<br>

### 기사
| 한글 | 영문 | 설명 | 유일함 | 제한 사항 |
| --- | --- | --- | --- | --- |
| 기사 | Article | 기사 전반을 아우른다. | O | 오직 인터넷 상에 존재하는 기사만 허용된다. |
| 경제 기사 | Economy Article | 단일한 경제 기사의 세부 사항을 포함하는 대상이다. | O | 오직 인터넷 상에 존재하는 경제 기사만 허용된다. |
| 산업 기사 | Industry Article | 단일한 산업 기사의 세부 사항을 포함하는 대상이다. | O | 오직 인터넷 상에 존재하는 산업 기사만 허용된다. |
| 기업 기사 | Company Article | 단일한 기업 기사의 세부 사항을 포함하는 대상이다. | O | 오직 인터넷 상에 존재하는 기업 기사만 허용된다. |
| 기사 번호 | Article Number | 기사에게 순서대로 부여되는 번호이다. | O | 항상 증가하는 방향으로 설정되어야 한다. |
| 기사명 | Article Name | 기사의 제목이다. | O | 제목의 모든 문자는 전혀 훼손되지 않아야 한다. |
| 언론사 | Press | 기사를 작성한 언론사의 이름이다. | X | 같은 언론사에 대해서는 오직 한 가지의 정의된 이름만 사용되어야 한다. |
| 경제 내용 | Economy Content | 기사가 주로 다루는 경제 내용을 특정하며, 경제 기사에서와 관련된다. | X | 특정 내용을 검색할 때 관련한 폭넓은 기사가 검색되도록 다수의 값이 허용된다. |
| 대상 산업 | Subject Industry | 기사가 대상으로 하는 산업의 이름이며, 산업 기사와 관련된다. | X | 대상 산업에 대해서는 오직 한 가지의 정의된 명칭만 사용되어야 한다. |
| 대상 기업 | Subject Company | 기사가 대상으로 하는 기업의 이름이며, 기업 기사와 관련된다. | X | 대상 기업에 대해서는 오직 한 가지의 정의된 명칭만 사용되어야 한다. |
| 기사 링크 | Article Link | 기사의 외부 출처를 향하는 링크이다. | O | 출처로 나아가는 과정 및 출처 그 자체 모두 보안이 보장되어 있어야 한다. |
| 기사 입력일 | Article Date | 기사가 인터넷에 입력되어 대중에게 공개된 날짜이다. | X | 연, 월, 일을 포함한 날짜 형식으로 사용하며, 1960년 이후부터 현재까지로 제한한다. |
| 기사 중요도 | Article Importance | 기사가 얼마나 중요한지를 숫자로 제시하는 값이다. | X | 0과 1로만 구분하며, 1은 더욱 중요하다는 의미로 사용한다. 1이 부여되는 기사의 수는 최소화한다. |

<div>
  <b>기사를 구분하는 방법</b>
  <p>제목과는 관련 없이, 분량에서 가장 많은 요소를 차지하는 내용을 기준으로 한다.</p>
  <p>이 요소는 경제, 산업, 기업 중 하나만을 의미한다.</p>
  <b>기사 구분 조건</b>
  <p>산업 기사는 특정 산업에 대한 기사여야 하며, 두 개 이상의 산업을 다루는 경우 경제 기사로 분류한다.</p>
  <p>기업 기사는 특정 기업에 대한 기사여야 하며, 두 개 이상의 기업을 다루는 경우 산업 기사 또는 경제 기사로 분류한다.</p>
  <p>다루는 기업이 대부분 같은 산업에 속하면 산업 기사로 분류하며, 나머지는 경제 기사로 분류한다.</p>
</div>
<br>

### 기업
| 한글 | 영문 | 설명 | 유일함 | 제한 사항 | 
| --- | --- | --- | --- | --- |
| 기업 | Company | 단일한 기업의 세부 사항을 포함하는 대상이다. | O | 상장되어 있거나, 상장된 기업의 종속 회사만 대상으로 한정한다. |
| 기업 코드, 종목 코드 | Company Code | 기업을 가리키는 코드이다. | O | 코드는 6글자의 문자로 다뤄져야 한다. |
| 상장된 국가 | Country Being Listed | 기업이 상장된 국가이다. | X | 상장된 국가에 대해서는 오직 한 가지의 정의된 명칭만 사용되어야 한다. |
| 기업 규모 | Company Scale | 기업을 분류할 때 사용될 수 있는 기업 크기이다. | X | 대기업, 중견기업, 중소기업으로만 구분한다. |
| 기업명 | Company Name | 기업의 이름이다. | O | 이름에 대해서는 오직 한 가지의 정의된 명칭만 사용되어야 한다. |
| 1차 업종 | First Category | 기업을 분류할 때 사용될 수 있는 1차적인 업종이다. | X | 업종 이름은 컴퍼니가이드를 참고하며, 중복되는 분류가 없도록 한다. |
| 2차 업종 | Second Category | 기업을 분류할 때 사용될 수 있는 2차적인 업종이다. | X | 업종 이름은 컴퍼니가이드를 참고하며, 중복되는 분류가 없도록 한다. |

<div>
  <b>종속 회사의 활용</b>
  <p>종속 회사는 그 자체로 활용되지 않고, 상장되어 있는 모회사를 통해 다뤄져야 한다.</p>
</div>
<br>

### 회원
| 한글 | 영문 | 설명 | 유일함 | 제한 사항 | 
| --- | --- | --- | --- | --- |
| 회원 | Member | 단일한 회원의 세부 사항을 포함하는 대상이다. | O | 회원가입을 통해서 등록되어야 한다. |
| 회원 식별자 | Member Identifier | 회원에게 순서대로 부여되는 식별자이다. | O | 항상 증가하는 방향으로 설정되어야 한다. |
| 회원 아이디, 회원 ID | Member ID | 회원의 ID이다. | O | 아이디는 8 ~ 20자 사이의 문자이며, 영문, 숫자가 최소 하나씩 포함되어 있어야 하고 키보드 상에 존재하는 모든 특수 문자를 허용해야 한다. |
| 회원 패스워드, 회원 PW | Member Password | 회원의 PW이다. | X | 패스워드는 8 ~ 64자 사이의 문자이며, 영문, 숫자 및 특수 문자가 최소 하나씩 포함되어 있어야 하고 키보드 상에 존재하는 모든 특수 문자를 허용해야 한다. |
| 회원명 | Member Name | 회원의 이름이다. | X | 다양한 언어를 지원해야 한다. |
| 회원 생일 | Member Birth | 회원의 생일이다. | X | 연, 월, 일을 포함한 날짜 형식으로 사용하며, 현재를 포함한 과거만 허용된다. |
| 회원 휴대폰 번호 | Member Phone Number | 회원의 휴대폰 번호이다. | O | 휴대폰 번호는 010으로 시작하게 하며, 대시가 있는 버전과 없는 버전을 모두 지원한다. |
<br>

## 핵심 동작
| 한글 | 영문 | 설명 |
| --- | --- | --- |
| 과정 | Process | 단일한 기능을 처리하는 개별적인 단계를 의미하며, 컨트롤러로 구분한다. |
| 검증 | Validation | 특정 대상에 올바른 값이 들어왔는지 검사하는 작업을 의미한다. |
| 기능 | Function | 단일한 목적을 가진 일련의 프로그래밍 처리 동작을 의미한다. |
| 기입 | Filling In | 유저 인터페이스에서 특정한 양식에 값을 작성하는 모든 작업을 의미한다. |
| 생성 | Creation | 특정 대상을 새로 만드는 모든 작업을 의미한다. |
| 입력 | Input | 관리자 인터페이스에서 특정한 양식에 값을 작성하는 모든 작업을 의미한다. |
<br>

# 유비쿼터스 언어 - 개발자
<p>해당 내용은 팀을 구성하는 개발자 전원이 특정 개념에 대해 언어로써 동일한 이해를 확립하는 것을 목적으로 한다.</p>
<br>

## 핵심 도메인 클래스
<p>복수로써 클래스명을 사용할 때는 뒤에 복수형 표기(s)를 붙인다.</p>
<div>
  <li>CompanyArticle - 기업 기사</li>
  <li>IndustryArticle - 산업 기사</li>
  <li>EconomyArticle - 경제 기사</li>
  <li>Company - 기업</li>
  <li>Industry - 산업</li>
  <li>Economy - 경제</li>
  <li>Member - 회원</li>
</div>
<br>

## 핵심 기능

### DB - CRUD 관련 기능
| 한글 | 영문 | 계층 | 설명 | DB에서의 관련 명령어 | 
| --- | --- | --- | --- | --- |
| 보기 | Seeing | 컨트롤러 | 특정 객체를 볼 수 있도록 하는 작업을 의미한다. | SELECT |
| 조회 | Inquiry | 컨트롤러 | 특정 객체 전체를 한눈에 볼 수 있도록 하는 작업을 의미한다. | SELECT |
| 추가 | Addition | 컨트롤러 | 특정 객체를 대입하는 작업을 의미한다. | INSERT |
| 변경 | Modification | 컨트롤러 | 특정 객체를 바꾸는 작업을 의미한다. | UPDATE |
| 없앰 | Ridding | 컨트롤러 | 특정 객체를 지우는 작업을 의미한다. | DELETE |
| 찾기 | Finding | 서비스 | 특정 객체를 지정하는 작업을 의미한다. | SELECT |
| 등록 | Registration | 서비스 | 특정 객체를 대입하는 작업을 의미한다. | INSERT |
| 수정 | Correction | 서비스 | 특정 객체를 다른 객체로 바꾸는 작업을 의미한다. | UPDATE |
| 제거 | Removal | 서비스 | 특정 객체를 지우는 작업을 의미한다. | DELETE |
| 획득 | Getting | 리포지토리 | 특정 객체를 가져오는 작업을 의미한다. | SELECT |
| 저장 | Saving | 리포지토리 | 특정 객체를 대입하는 작업을 의미한다. | INSERT |
| 갱신 | Updating | 리포지토리 | 특정 객체를 바꾸는 작업을 의미한다. | UPDATE |
| 삭제 | Deletion | 리포지토리 | 특정 객체를 지우는 작업을 의미한다. | DELETE |
| 검색 | Searching | 컨트롤러 또는 서비스 | 보기 또는 찾기에 속하는 작업 중 특히 유저가 특정 대상을 알아보기 위한 목적으로 수행하는 경우를 따로 지칭하여 이른다. | SELECT |
<br>

### Library - Lombok 관련 기능
| 한글 | 영문 | 설명 | Lombok에서의 관련 어노테이션 | 
| --- | --- | --- | --- |
| 획득 | Getting | 자바빈즈 패턴에 포함되는 개념으로, 객체에서 특정 필드의 값을 가져오는 기능이다. | @Getter |
| 설정 | Setting | 자바빈즈 패턴에 포함되는 개념으로, 객체에서 특정 필드의 값을 다른 값으로 바꾸는 기능이다. | @Setter |
| 빌딩 | Building | 빌더 패턴에 포함되는 개념으로, 특정 객체를 새로 생성하는 기능이다. | @Builder |
<br>

### Pattern - PRG 패턴 관련 기능
| 한글 | 영문 | 설명 | HTTP 요청의 메소드 |
| --- | --- | --- | --- |
| 개시 | Initiation | 양식을 두 번 제출할 필요가 있는 기능에서 제출할 양식이 있는 첫 페이지를 렌더링하기까지의 과정을 지칭한다. | GET |
| 처리 | Processing | 이전에 제출된 양식이 있으면 이를 처리하고, 제출할 양식이 있는 마지막 페이지를 렌더링하기까지의 과정을 지칭한다. | GET 또는 POST |
| 제출 | Submission | 제출할 양식이 있는 마지막 페이지에서 제출된 양식을 처리하고 그 결과를 다른 URL로 리다이렉트하는 과정을 지칭한다. | POST |
| 완료 | Finishing | 마지막으로 제출된 양식에 대한 결과를 보여주는 페이지를 렌더링하기까지의 과정을 지칭한다. | GET |
<p>해당 용어는 PRG 패턴에서 뿐만 아니라 전 기능에 걸쳐 사용하도록 한다.</p>
<br>

# 코딩 스타일(Java)
<p>해당 내용은 팀을 구성하는 개발자 전원이 동일한 서식의 Java 코드를 작성함으로써 프로젝트의 가독성과 유지 보수성을 향상하는 것을 목적으로 한다.</p>
<div>
  <b>조건</b>
  <p>기본적으로 객체는 명사를, 동작은 동사를 사용하여 표현한다.</p>
  <p>관리자 전용 코드와 유저 전용 코드는 특정한 예외를 제외하고는 모두 분리한다.</p>
  <p>메소드명은 각 구분을 순서대로 합친 문자열을 채택한다.</p>
</div>
<br>

## 네이밍 컨벤션 

### 네이밍 컨벤션 - 메소드 - DB 관련 기능
<p>만약 가장 기본적인 형태의 핵심 기능을 사용하는 경우가 아니라면, 마지막 구분으로 다음과 같은 서식을 적용한다.</p>
<p><code>With + 활용되는 대상 식별자</code></p>
<br>

#### 컨트롤러
<div>
  <p>첫 번째 구분은 다음 PRG 패턴 관련 기능의 동사형 영문 중 하나를 사용한다.</p>
  <ul>
    <li>initiate</li>
    <li>process</li>
    <li>submit</li>
    <li>finish</li>
  </ul>
  <p>두 번째 구분은 다음 CRUD 관련 기능의 동사형 영문 중 하나를 사용한다.</p>
  <ul>
    <li>See</li>
    <li>Search</li>
    <li>Add</li>
    <li>Modify</li>
    <li>Rid</li>
  </ul>
  <p>세 번째 구분은 핵심 도메인 클래스명 중 하나를 사용한다.</p>
</div>
<br>

#### 서비스
<div>
  <p>첫 번째 구분은 다음 CRUD 관련 기능의 동사형 영문 중 하나를 사용한다.</p>
  <ul>
    <li>find</li>
    <li>search</li>
    <li>register</li>
    <li>correct</li>
    <li>remove</li>
  </ul>
  <p>두 번째 구분은 핵심 도메인 클래스명 중 하나를 사용한다.</p>
</div>
<br>

#### 리포지토리
<div>
  <p>첫 번째 구분은 다음 CRUD 관련 기능의 동사형 영문 중 하나를 사용한다.</p>
  <ul>
    <li>get</li>
    <li>save</li>
    <li>update</li>
    <li>delete</li>
  </ul>
  <p>두 번째 구분은 핵심 도메인 클래스명 중 하나를 사용한다.</p>
</div>
<br>

### 네이밍 컨벤션 - 메소드명 - 테스팅 관련 기능

#### 컨트롤러
<div>
  <div>
    <b>기본 - DB 관련 기능</b>
    <p>첫 번째 구분은 access로 한다.</p>
    <p>두 번째 구분은 핵심 도메인 클래스명 중 하나를 사용한다.</p>
    <p>세 번째 구분은 다음 CRUD 관련 기능의 동사형 영문 중 하나를 사용한다.</p>
    <ul>
      <li>See</li>
      <li>Search</li>
      <li>Add</li>
      <li>Modify</li>
      <li>Rid</li>
    </ul>
    <p>네 번째 구분으로, 만약 가장 기본적인 형태의 핵심 기능을 사용하는 경우가 아니라면 다음과 같은 서식을 사용하며, 그렇지 않은 경우 생략한다.</p>
    <p><code>With + 활용되는 대상 식별자</code></p>
    <p>다섯 번째 구분으로, 만약 해당 테스트가 "finish"를 포함하는 컨트롤러 메소드와 관련이 있는 경우 Finish를 사용하며, 그렇지 않은 경우 생략한다.</p>
  </div>
  <br>
  <div>
    <b>예외 - DB 관련 기능</b>
    <p>사용 조건으로, 양식을 두 번 제출할 필요가 있는 기능에서 중간 단계를 테스팅할 때 사용한다.</p>
    <p>사용 방법으로, 첫 번째 구분을 다음의 것으로 한다는 점 이외에는 기본 구문 사용법과 동일하게 사용하면 된다.</p>
    <p><code>search + 활용되는 대상 식별자</code></p>
  </div>
</div>
<br>

#### 서비스 및 리포지토리
<div>
  <b>DB 관련 기능</b>
  <p>이들은 서비스 계층 및 리포지토리 계층의 메소드명 뒤에 Test를 붙이는 것으로 통일한다.</p>
</div>
<br>

### 네이밍 컨벤션 - 메소드명 - 나머지 기능

#### 컨트롤러 - 유저 서비스
<div>
  <ul>
    <b>메인 소스 코드</b>
    <p>단일한 웹 페이지의 렌더링까지만 처리하면 되는 기능인 경우, 다음과 같은 서식을 사용한다.</b>
    <p><code>process + 기능 + Page</code></p>
    <p>기능이 세 과정으로 이루어져 있으며, 두 번째 과정이 양식 제출인 경우, 위의 서식과 동일하게 사용하되 맨 앞의 process만 다음과 같이 바꾼다.</p>
    <p><code>두 번째 단계: submit</code></p>
    <p><code>세 번째 단계: finish</code></p>
    <b>테스트 코드</b>
    <p>단일한 웹 페이지의 렌더링까지만 처리하면 되는 기능인 경우, 다음과 같은 서식을 사용한다.</p>
    <p><code>access + 기능</code></p>
    <p>기능이 세 과정으로 이루어져 있으며, 두 번째 과정이 양식 제출인 경우 다음과 같은 서식을 사용한다.</p>    
    <p><code>첫 번째 단계: access + 기능</code></p>
    <p><code>두 번째 단계: access + 기능 + Finish</code></p>
  </ul>
</div>
<br>

### 네이밍 컨벤션 - HTML 컨벤션
<div>
  <b>파일명</b>
  <p>Kebab Case를 사용한다.</p>
  <br>
  <b>클래스명</b>
  <p>형태는 한 단어로만 사용한다.</p>
  <p>특정한 블록에 속해 있는 경우 다음과 같은 서식을 사용한다.</p>
  <p><code>블록명 + 형태</code></p>
  <p>Kebab Case를 사용한다.</p>
  <p>해당 요소가 특정 요소의 항목이라면 맨 뒤에 item을 추가한다.</p>
  <p>해당 요소가 특정 블록에 속해 있지 않은 경우 다음과 같은 서식을 사용한다.</p>
  <p><code>형태 + 의미 또는 목적</code></p>
  <p>의미 또는 목적의 경우 Camel Case를 사용한다.</p>
  <b>ID명</b>
  <p>한 단어로 이뤄진 Camel Case를 사용한다.</p>
  <br>
</div>

## 검증

### 검증 - 검증자
| 이름(한글) | 이름(영문) | 설명 | 관련 오류 | 
| --- | --- | --- | --- |
| 기본 검증자 | Default Validator | 빈 검증에서 사용되는 검증자를 의미한다. | 빈 검증 어노테이션 관련 오류, typeMismatch 등 |
| 제약 조건 검증자 | Constraint Validator | 필드에 적용되는 의무적인 검증자를 의미한다. | Restrict, TypeButInvalid, typeMismatch.enum 등 |
| 필드 검증자 | Field Validator | 필드에 적용되는 선택적인 검증자를 의미한다. | Exist, NotFound 등 |
<br>

### 검증 - 메시지 
| 오류 코드 | 설명 |
| --- | --- |
| BeanValidation | 빈 검증에서 오류가 있음을 나타낸다. |
| Exist | 존재하지 않아야 하는 값이 이미 존재함을 나타낸다. |
| NotBlank | 허용되지 않은 공백이 있음을 나타낸다. |
| NotFound | 발견되어야 하는 값이 없음을 나타낸다. |
| NotNull | null이 있음을 나타낸다. |
| Pattern | 특정 패턴과 매칭되지 않음을 나타낸다. |
| URL | URL이 서식이 아님을 나타낸다. |
| Range | 값이 정의된 min과 max 사이를 벗어났음을 나타낸다. |
| Restrict | 사용자 지정 제약 조건을 위반했음을 나타낸다. |
| Size | 정의된 크기 안에 들어오지 않음을 나타낸다.
| TypeButInvalid | 타입은 올바르지만 값이 유효하지 않음을 나타낸다. |
| typeMismatch | 타입이 올바르지 않아 바인딩에 실패했음을 나타낸다. |
<br>

## HTML 코딩 컨벤션
<p>특정 블록에서의 경우, 최상단 태그에만 ID를 사용한다.</p>
<br>

## CSS 코딩 컨벤션
<div>
  <p>스타일은 다음의 순서대로 적용한다.</p>
  <p><code>display</code></p>
  <p><code>position</code></p>
  <p><code>z-index</code></p>
  <p><code>width</code></p>
  <p><code>max-width</code></p>
  <p><code>height</code></p>
  <p><code>max-height</code></p>
  <p><code>margin</code></p>
  <p><code>padding</code></p>
  <p><code>top</code></p>
  <p><code>left</code></p>
  <p><code>column-gap</code></p>
  <p><code>border</code></p>
  <p><code>border-collapse</code></p>
  <p><code>border-radius</code></p>
  <p><code>background</code></p>
  <p><code>box-shadox</code></p>
  <p><code>color</code></p>
  <p><code>font-size</code></p>
  <p><code>font-weight</code></p>
  <p><code>justify-content</code></p>
  <p><code>align-items</code></p>
  <p><code>text-align</code></p>
  <p>기타 플렉스, 그리드 등에 적용되는 속성은 맨 밑에 추가한다.</p>
</div>
