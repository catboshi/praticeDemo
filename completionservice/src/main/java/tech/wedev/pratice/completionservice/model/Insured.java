package tech.wedev.pratice.completionservice.model;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Insured implements Serializable {
    private String name;
    private String idcard;
}
