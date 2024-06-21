package com.kh.openapiex.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiDataList {
    private int totalCount;
    private String Source;
    private List<ApiData> dataList;
}
