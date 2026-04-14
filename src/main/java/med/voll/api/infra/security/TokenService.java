package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.voll.api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService{
    @Value("${app.jwt.expires-at}")
    private long expiresAt;
    @Value("${app.jwt.secret}")
    private String secret;


    public String generateToken(User user){

        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API voll")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);
        }
        catch(JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }
    public Instant dateExpiration(){
        return LocalDateTime.now().plusSeconds(expiresAt).toInstant(ZoneOffset.of("-03:00"));
    }
}
