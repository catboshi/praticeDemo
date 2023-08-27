package tech.wedev.pratice.completionservice.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 险种信息
 **/
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Risk implements Serializable {
    private String riskcode;
    private String riskname;
    private BigDecimal premium;
    private int mainFlag;
}
