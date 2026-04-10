package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.DataUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping
    public ResponseEntity auth(@RequestBody @Valid DataUser dataUser){
        var token = new UsernamePasswordAuthenticationToken(dataUser.login(), dataUser.password());
        var authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok(authentication);
    }
}
