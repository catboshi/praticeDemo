package tech.wedev.pratice.stream.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer personId;
    private String name;
}
