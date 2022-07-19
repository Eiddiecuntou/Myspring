package com.cuntou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component(value = "abc")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Value("1")
    private Integer id;
    @Value("小明")
    private String name;
    @Value("33")
    private Integer age;
}
