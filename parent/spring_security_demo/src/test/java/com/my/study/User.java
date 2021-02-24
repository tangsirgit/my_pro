package com.my.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tanghuai
 * @date 2021/2/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private Integer age;
}
