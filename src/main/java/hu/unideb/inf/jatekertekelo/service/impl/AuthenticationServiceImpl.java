package hu.unideb.inf.jatekertekelo.service.impl;

import hu.unideb.inf.jatekertekelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.jatekertekelo.data.entity.JogosultsagEntity;
import hu.unideb.inf.jatekertekelo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.jatekertekelo.data.repository.JogosultsagRepository;
import hu.unideb.inf.jatekertekelo.service.AuthenticationService;
import hu.unideb.inf.jatekertekelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.jatekertekelo.service.dto.RegisztracioDto;
import hu.unideb.inf.jatekertekelo.service.mapper.FelhasznaloMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final FelhasznaloMapper felhMapper;
    private final JogosultsagRepository jogRepo;
    private final FelhasznaloRepository felhRepo;

    public AuthenticationServiceImpl(FelhasznaloMapper felhMapper, JogosultsagRepository jogRepo, FelhasznaloRepository felhRepo) {
        this.felhMapper = felhMapper;
        this.jogRepo = jogRepo;
        this.felhRepo = felhRepo;
    }
    @Override
    public void bejelentkezes(BejelentkezesDto dto) {
    }

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity e = felhMapper.regisztracioToEntity(dto);
        e.setRegisztracioDatum(Date.from(Instant.now()));

        JogosultsagEntity jog = jogRepo.findByNev("FELHASZNALO");
        if(jog != null) {
            e.setJogosultsag(jog);
        } else {
            jog = new JogosultsagEntity();
            jog.setNev("FELHASZNALO");
            jog = jogRepo.save(jog);

            e.setJogosultsag(jog);
        }

        felhRepo.save(e);
    }
}
