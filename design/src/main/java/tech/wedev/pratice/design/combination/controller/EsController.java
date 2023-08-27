package tech.wedev.pratice.design.combination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wedev.pratice.design.combination.service.EsService;

@RestController
public class EsController {
    @Autowired
    private EsService esService;

    @PostMapping("es")
    public Boolean query(@RequestParam String query, Long fetchSize) {

        return esService.query(query, fetchSize);
    }

}
