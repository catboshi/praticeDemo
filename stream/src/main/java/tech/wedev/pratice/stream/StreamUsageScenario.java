package tech.wedev.pratice.stream;

import lombok.SneakyThrows;
import tech.wedev.pratice.stream.enums.StreamOperation;

public class StreamUsageScenario {

    @SneakyThrows
    public static void main(String[] args) {
//        DISTINCT.operate();
//        DATE_COMPARE.operate();
//        NATURAL_ORDER.operate();
//        MAX.operate();
//        MAX2.operate();
        StreamOperation.MAX3.operate();
//        NEWEST.operate();
    }
}