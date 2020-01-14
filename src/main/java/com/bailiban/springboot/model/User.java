package com.bailiban.springboot.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class User {

    private Integer id;
    @NotEmpty(message = "名字不能为空。")
    private String name;
    @Size(min = 6, max = 20, message = "密码长度为6~20位。")
    private String password;
    private Integer sex;
    @Pattern(regexp = "^1[356789]\\d{9}$", message = "手机号码格式不正确。")
    private String phone;
    @Email(message = "邮箱格式不正确。")
    private String email;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "+8:00")
    private Date birthday;
}
