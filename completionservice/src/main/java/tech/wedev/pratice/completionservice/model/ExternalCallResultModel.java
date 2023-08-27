package tech.wedev.pratice.completionservice.model;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExternalCallResultModel implements Serializable {
    private String idcard;
    private float score;
}
