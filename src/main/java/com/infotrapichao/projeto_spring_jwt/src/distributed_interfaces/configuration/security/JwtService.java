package com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret; // Chave secreta para assinar o token

    @Value("${jwt.expiration}")
    private long expiration; // Tempo de expiração do token em milissegundos

    private String secret2 = "minhaChaveSecretaMuitoSeguraDemaisTaDoidoBizoinho123456789"; // Evite valores curtos!
    private long expiration2 = 1000 * 60 * 60 * 10; // Exemplo: 10 horas de validade

    // 1. Extrai o username (ou outro campo específico) do token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 2. Extrai uma claim específica do token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // 3. Gera um novo token para o usuário
    /*public String generateToken(String username, Map<String, Object> extraClaims) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration ))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }*/
    // 3. Gera um novo token para o usuário
    public String generateToken(String username, Map<String, Object> extraClaims) {
        // Cria uma chave baseada na string 'secret'
        Key key = Keys.hmacShaKeyFor(secret2.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration2))
                .signWith(key, SignatureAlgorithm.HS256) // Usando o método atualizado
                .compact();
    }

    // 4. Gera um token simples sem claims adicionais
    public String generateToken(String username) {
        return generateToken(username, new HashMap<>());
    }

    // 5. Valida o token (verifica a assinatura e a expiração)
    public boolean validateToken(String token, org.springframework.security.core.userdetails.UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // Verifica se o token está expirado
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extrai a data de expiração do token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extrai todas as claims do token
    public Claims extractAllClaims(String token) {
        Key key = Keys.hmacShaKeyFor(secret2.getBytes(StandardCharsets.UTF_8)); // Mesma chave usada na geração
        Claims claims = null;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("Erro ao validar token: " + e.getMessage());
        }
        return claims;
    }
}