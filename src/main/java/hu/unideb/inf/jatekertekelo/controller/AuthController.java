package hu.unideb.inf.jatekertekelo.controller;

import hu.unideb.inf.jatekertekelo.service.AuthenticationService;
import hu.unideb.inf.jatekertekelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.jatekertekelo.service.dto.RegisztracioDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
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
    public void regisztracio(@RequestBody RegisztracioDto dto) {
        authService.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto dto) {
        return authService.bejelentkezes(dto);
    }
}
