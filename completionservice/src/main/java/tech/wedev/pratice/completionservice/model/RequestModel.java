package tech.wedev.pratice.completionservice.model;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestModel<T extends Object> implements Serializable {
    private String key;
    private T data;
}
