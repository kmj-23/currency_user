# 환전 요청 CRUD_API 명세서

### 환전요청 CRUD

| 기능 | Method | URL | Request | Response | Status Code |
| --- | --- | --- | --- | --- | --- |
| 환전 요청 수행 | POST | /api/exchange | 요청 bdoy | 수행 결과 | 성공
_ 201 Created |
| 환전 요청 조회 | GET | /api/exchange |  | 조회 정보 | 성공
_ 200 OK |
| 환전 요청 취소
(상태변경) | PUT | /api/exchange/{id}   |  | 취소 성공 여부 | 성공
_200 OK
실패
_404 NotFound |
| 고객 데이터 삭제 | DELETE | /api/exchange/{id} |  |  | 성공
_ 200 OK
실패
_404 NotFound |

### 1. 환전요청 수행

º 요청

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| amount_in_krw | Decimal | 환전 전 금액(원) | O |

<aside>

{

“email”: “abc@naver.com”,

“amount_in_krw”: “10000.00”

}

</aside>

º 응답

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| amount_after_exchange | BigDecimal | 환전 후 금액(달러) | O |

<aside>

{

“amount_after_exchange”: “7.17”

}

</aside>

### 2. 환전 요청 기록 조회(특정 고객)

º 요청

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| name | String | 사용자 이름 | O |
| email | String | 사용자 이메일 | O |

<aside>

{

“name”: “000”,

“email”: “abc@naver.com”,

}

</aside>

º 응답

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| name | String | 사용자 이름 | O |
| amount_in_krw | Decimal | 환전 전 금액 | O |
| amount_after_exchange | Decimal | 환전 후 금액 | O |

<aside>

{

“name”: “000”,

“amount_in_krw”: “10000.00”,

“amount_after_exchange”: “7.17”

}

</aside>

### 3. 환전 요청 상태를 취소로 변경

**º 요청**

- Path Variable : id(통화 고유 식별자)

**º 응답**

- 200 OK

<aside>

{

“정상적으로 취소되었습니다.”

}

</aside>

**º 예외**

- 404 Not Found : 해당 식별자가 없는 경우

### 4. 고객 삭제(고객이 수행한 모든 환전 요청도 삭제)

**º 응답**

- 200 OK

<aside>

{

“정상적으로 삭제되었습니다.”

}

</aside>

**º 예외**

- 404 Not Found : 해당 식별자가 없는 경우

# ERD
# 환전 요청 CRUD_API 명세서

### 환전요청 CRUD

| 기능 | Method | URL | Request | Response | Status Code |
| --- | --- | --- | --- | --- | --- |
| 환전 요청 수행 | POST | /api/exchange | 요청 bdoy | 수행 결과 | 성공
_ 201 Created |
| 환전 요청 조회 | GET | /api/exchange |  | 조회 정보 | 성공
_ 200 OK |
| 환전 요청 취소
(상태변경) | PUT | /api/exchange/{id}   |  | 취소 성공 여부 | 성공
_200 OK
실패
_404 NotFound |
| 고객 데이터 삭제 | DELETE | /api/exchange/{id} |  |  | 성공
_ 200 OK
실패
_404 NotFound |

### 1. 환전요청 수행

º 요청

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| amount_in_krw | Decimal | 환전 전 금액(원) | O |

<aside>

{

“email”: “abc@naver.com”,

“amount_in_krw”: “10000.00”

}

</aside>

º 응답

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| amount_after_exchange | BigDecimal | 환전 후 금액(달러) | O |

<aside>

{

“amount_after_exchange”: “7.17”

}

</aside>

### 2. 환전 요청 기록 조회(특정 고객)

º 요청

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| name | String | 사용자 이름 | O |
| email | String | 사용자 이메일 | O |

<aside>

{

“name”: “000”,

“email”: “abc@naver.com”,

}

</aside>

º 응답

| 이름 | 타입 | 설명 | 필수 여부 |
| --- | --- | --- | --- |
| name | String | 사용자 이름 | O |
| amount_in_krw | Decimal | 환전 전 금액 | O |
| amount_after_exchange | Decimal | 환전 후 금액 | O |

<aside>

{

“name”: “000”,

“amount_in_krw”: “10000.00”,

“amount_after_exchange”: “7.17”

}

</aside>

### 3. 환전 요청 상태를 취소로 변경

**º 요청**

- Path Variable : id(통화 고유 식별자)

**º 응답**

- 200 OK

<aside>

{

“정상적으로 취소되었습니다.”

}

</aside>

**º 예외**

- 404 Not Found : 해당 식별자가 없는 경우

### 4. 고객 삭제(고객이 수행한 모든 환전 요청도 삭제)

**º 응답**

- 200 OK

<aside>

{

“정상적으로 삭제되었습니다.”

}

</aside>

**º 예외**

- 404 Not Found : 해당 식별자가 없는 경우

# ERD
![image](https://github.com/user-attachments/assets/5febb40e-a18f-47ca-bcf4-f6839c20f313)
