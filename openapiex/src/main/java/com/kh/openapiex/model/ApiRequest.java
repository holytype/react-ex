package com.kh.openapiex.model;

import lombok.Data;

@Data
public class ApiRequest {
    private String ServiceKey;
    private String pageNo;
    private String numOfRows; // 한 페이지 결과 수
    private String sidoCd; // 시도코드
    private String sgguCd; // 시군구코드
    private String emdongNm; // 읍면동명
    private String yadmNm; // 병원명 (utf-8 인코딩 필요)
    private String zipCd; // 분류코드
    private String clCd; // 종별코드
    private String dgsbjtCd; // 진료과목코드
    private String xPos; // x좌표(소수점 15)
    private String yPos; // y좌표(소수점 15)
    private String radius; // 단위 : 미터(m)
}
