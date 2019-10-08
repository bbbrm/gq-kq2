package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    private int id;
    private String staffCode;
    private String post;
    private String department;
    private String superior;
    private String jobCategory;
    private String describe;
}
