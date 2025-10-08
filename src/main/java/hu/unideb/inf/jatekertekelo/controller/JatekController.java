package hu.unideb.inf.jatekertekelo.controller;

import hu.unideb.inf.jatekertekelo.service.JatekService;
import hu.unideb.inf.jatekertekelo.service.dto.JatekCardDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/jatek")
public class JatekController {

    final JatekService jatekService;

    public JatekController(JatekService jatekService) {
        this.jatekService = jatekService;
    }

    @PostMapping("/save")
    public JatekCardDto save(@RequestBody JatekCardDto jatek) {
        return jatekService.save(jatek);
    }
}
