package hu.unideb.inf.jatekertekelo.controller;

import hu.unideb.inf.jatekertekelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.jatekertekelo.data.repository.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RestController
@RequestMapping("api/felhasznalo")
public class FelhasznaloController {

    private final FelhasznaloRepository felhasznaloRepository;

    public FelhasznaloController(FelhasznaloRepository felhasznaloRepository) {
        this.felhasznaloRepository = felhasznaloRepository;
    }

    @GetMapping("/init")
    public FelhasznaloEntity saveMock(){
        FelhasznaloEntity felhasznalo = new FelhasznaloEntity();
        felhasznalo.setFelhasznalonev("xy");
        felhasznalo.setHash("esfsf");
        felhasznalo.setNev("üoo");
        felhasznalo.setSzuletesiDatum(Date.from(Instant.now()));
        felhasznalo.setRegisztracioDatum(Date.from(Instant.now()));

        return felhasznaloRepository.save(felhasznalo);
    }
}
