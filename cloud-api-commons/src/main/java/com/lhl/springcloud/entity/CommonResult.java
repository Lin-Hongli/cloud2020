package com.lhl.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lhl
 * @create 2020/3/8 22:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/*@AllArgsConstructor  加在类上，可以生成含实体类全参数的构造方法。
@NoArgsConstructor  加在类上，可以生成无参构造方法。
@RequiredArgsConstructor  加在类上，配合@NonNull注解使用，生成指定参数的构造方法。比如在age属性前面加@NonNull注解，则User生成需要age参数的构造方法。
@Getter  加在类上，可以生成实体类所有属性的getter方法。
@Setter  加在类上，可以生成实体类所有属性的setter方法。
@ToString  加在类上，调用toString()方法，可以输出实体类中所有属性的值。*/
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
