package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private int id;
    private String emp_umber;
    private String emp_name;
    private String sex;
    private int age;
    private String nation;
    private String identity_card;
    private String pay;
    private String phone;
    private String eme_contact;
    private String eme_phone;
    private int post_id;
    private String personal_profile;

}
