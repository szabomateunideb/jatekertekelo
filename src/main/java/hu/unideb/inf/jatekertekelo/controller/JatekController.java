package hu.unideb.inf.jatekertekelo.controller;

import hu.unideb.inf.jatekertekelo.service.JatekService;
import hu.unideb.inf.jatekertekelo.service.dto.JatekCardDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/jatek")
public class JatekController {

    final JatekService jatekService;

    public JatekController(JatekService jatekService) {
        this.jatekService = jatekService;
    }

    @PostMapping("/save")
    public JatekCardDto save(@RequestBody JatekCardDto jatek) {
        System.out.println("save jatek "+jatek);
        return jatekService.save(jatek);
    }

    @GetMapping("/byId")
    public JatekCardDto getById(@RequestParam Long id) {
        return jatekService.getById(id);
    }

    @GetMapping("/byCim/{cim}")
    public JatekCardDto getByCim(@PathVariable String cim) {
        return jatekService.getByCim(cim);
    }
}
