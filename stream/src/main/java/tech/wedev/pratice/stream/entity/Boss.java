package tech.wedev.pratice.stream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Boss {
    // 姓名
    public String name;
    // 年龄
    public int age;
    // 身高
    public int height;
    // 性别(1.男，0.女)
    public int sex;

}

