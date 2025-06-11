# K-FreeMarket-Server

- 작업자 : wjd15sheep@gmail.com
- 작업 기간 : 2025. 05. 27 ~

# ERD 작업
25.06.12 초기 작업
<image src="https://private-user-images.githubusercontent.com/52367807/453922868-3b5fc440-02c2-439a-b8f0-b99588daf1a9.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDk2NDk5NTMsIm5iZiI6MTc0OTY0OTY1MywicGF0aCI6Ii81MjM2NzgwNy80NTM5MjI4NjgtM2I1ZmM0NDAtMDJjMi00MzlhLWI4ZjAtYjk5NTg4ZGFmMWE5LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTA2MTElMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwNjExVDEzNDczM1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWQzNGUyY2ZiYWJiZjRhZDIzYzdlNjk2OWI3N2IzOTIxNTdkOWUzMDYxN2IyYzU4Y2ZhMzFiYzFmMjg0YjY3ZGUmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.Q6SyOvfMKy9hXY0UQ7qdZuIahiQ7ytdadIvIYna78wg" alt="K-FreeMarket-ERD" width="100%" hight="100%"/>

### 엔티티 관계
| 엔티티                       | 설명                       |
| ------------------------- | ------------------------ |
| **User (유저)**             | 개인 정보 및 계정 정보를 담당        |
| **CartItem (장바구니)**       | 유저가 담은 상품 정보 담당          |
| **Order (주문)**            | 결제 후 주문의 상태 및 정보 관리      |
| **OrderItem (주문 상세)**     | 주문에 포함된 각 상품의 상세 정보 담당   |
| **Payment (결제 내역)**       | 결제 수단, 상태, 결제 일시 등 관리    |
| **Product (상품)**          | 상품 기본 정보 관리              |
| **ProductImage (상품 이미지)** | 상품에 연결된 이미지 관리           |
| **Review (리뷰)**           | 유저가 남긴 상품 리뷰 담당          |
| **Question (질문)**         | 상품에 대해 유저가 남긴 질문 담당      |
| **Answer (답변)**           | 질문에 대한 관리자 또는 판매자의 응답    |
| **ErrorLog (로그)**              | 시스템 이벤트, 에러, 행동 기록 등 수집 **독립적인 엔티티**  |
| **Banner (배너)**           | 이벤트, 상품 홍보 등 메인 화면 배너 관리 |

---

