package cn.jc.utli;

import cn.jc.entity.Classes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultMap {
    private String msg;
    private Integer code;
    private Object data;



    public static ResultMap ok(Object data, Integer count){
        return  new ResultMap("成功",200,data);
    }

    public static ResultMap fail(Object data){
        return  new ResultMap("失败",500,data);
    }

    public static ResultMap msgOk(String msg, Object data) {
        return new ResultMap(msg, 200, data);
    }

    public static ResultMap msgLayuiOk(String msg, Object data) {
        return new ResultMap(msg, 0, data);
    }

    public static ResultMap msgFail(String msg, Object data) {
        return new ResultMap(msg, 500, data);
    }

    public static ResultMap ok(List<Classes> data) {
        return  new ResultMap("成功",200,data);
    }
    public static ResultMap fail(List<Classes> data, Integer count) {
        return  new ResultMap("失败",500,data);
    }
}
