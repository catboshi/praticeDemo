package tech.wedev.pratice.design.combination.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wedev.pratice.design.combination.esquery.EsQueryProcessor;
import tech.wedev.pratice.design.combination.service.EsService;

import java.util.Map;
import java.util.stream.Stream;

@Service
public class EsServiceimpl implements EsService {

    @Autowired
    private EsQueryProcessor esQueryProcessor;
    
    public Boolean query(String query, Long fetchSize) {
        Stream<Map<String, Object>> mapStream = esQueryProcessor
                .scrollEsStream(query, fetchSize);
        mapStream.forEach(x -> System.out.println(x));
        return true;
    }
}
