package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes {

    private int id;
    private String staffCode;
    private String designation;
    private String morningShift;
    private String afternoonTime;
    private String remark;

}
