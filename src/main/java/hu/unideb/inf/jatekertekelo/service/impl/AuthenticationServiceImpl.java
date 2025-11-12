package hu.unideb.inf.jatekertekelo.service.impl;

import hu.unideb.inf.jatekertekelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.jatekertekelo.data.entity.JogosultsagEntity;
import hu.unideb.inf.jatekertekelo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.jatekertekelo.data.repository.JogosultsagRepository;
import hu.unideb.inf.jatekertekelo.service.AuthenticationService;
import hu.unideb.inf.jatekertekelo.service.TokenService;
import hu.unideb.inf.jatekertekelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.jatekertekelo.service.dto.RegisztracioDto;
import hu.unideb.inf.jatekertekelo.service.mapper.FelhasznaloMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final FelhasznaloMapper felhMapper;
    private final JogosultsagRepository jogRepo;
    private final FelhasznaloRepository felhRepo;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public String bejelentkezes(BejelentkezesDto dto) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getFelhasznalonev(),
                        dto.getJelszo()
                )
        );
        context.setAuthentication(auth);
        SecurityContextHolder.setContext(context);

        FelhasznaloEntity felh =
                felhRepo.findByFelhasznalonev(dto.getFelhasznalonev());
        return tokenService.generateToken(felh);
    }

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity e = felhMapper.regisztracioToEntity(dto);
        e.setRegisztracioDatum(Date.from(Instant.now()));
        e.setHash(passwordEncoder.encode(e.getHash()));


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
