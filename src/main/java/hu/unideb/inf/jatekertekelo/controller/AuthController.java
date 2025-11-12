package hu.unideb.inf.jatekertekelo.controller;

import hu.unideb.inf.jatekertekelo.service.AuthenticationService;
import hu.unideb.inf.jatekertekelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.jatekertekelo.service.dto.RegisztracioDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@Validated
public class AuthController {
    private final AuthenticationService authService;

    public AuthController(AuthenticationService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/regisztracio")
    public void regisztracio(@RequestBody @Valid RegisztracioDto dto) {
        authService.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto dto) {
        return authService.bejelentkezes(dto);
    }
}
