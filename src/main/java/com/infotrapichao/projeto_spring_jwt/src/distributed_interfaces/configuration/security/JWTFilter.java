package com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.configuration.security;

public class JWTFilter //extends OncePerRequestFilter {
{
   /* @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //Obtem o token com AUTHORIZATION
        String token = request.getHeader(JWTCreator.HEADER_AUTHORIZATION);

        //esta implementacao so esta validando a integridade do token
        try{
            if(token != null && !token.isEmpty()){

                JWTObject tokenObject = JWTCreator.create(token, SecurityConfig.get, SecurityConfig.KEY);

                List<SimpleGrantedAuthority> authorities = authorities(tokenObject.getRoles());

                UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
                        tokenObject.getSubject(),
                        null,
                        authorities
                );

                SecurityContextHolder.getContext().setAuthentication(userToken);
            }

        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e){
            e.printStackTrace();
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
    }
    private List<SimpleGrantedAuthority> authorities(List<String> roles){
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }*/
}
