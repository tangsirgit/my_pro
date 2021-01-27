package com.my.study.excel.enetity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author : tanghuai
 * @date : 2021/1/8 13:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Excel(name = "姓名",orderNum = "0")
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
    private Integer sex;

    @Excel(name = "生日", orderNum = "2",importFormat = "yyyy-MM-dd")
    private String birthday;
}
