package com.cuntou.myspring;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class XMLDTO {
    private String id;
    private String clazz;
    private List<Map<String,String>> property;
}
