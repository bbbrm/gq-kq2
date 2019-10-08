package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private int id;
    private String staffCode;
    private String industryTitle;
    private String departmentHead;
    private String responsibility;
    private String superior;
    private String remark;
}
