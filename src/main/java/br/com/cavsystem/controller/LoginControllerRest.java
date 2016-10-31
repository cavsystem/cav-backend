package br.com.cavsystem.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.entity.dto.CondominioDTO;
import br.com.cavsystem.dominio.entity.dto.RetornoLoginDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.security.JwtAuthenticationRequest;
import br.com.cavsystem.security.JwtTokenUtil;
import br.com.cavsystem.security.JwtUsuario;
import br.com.cavsystem.security.service.JwtAuthenticationResponse;
import br.com.cavsystem.service.RetornaCondominioUsuario;

@RestController
public class LoginControllerRest {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private RetornaCondominioUsuario retornaCondominioUsuario;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<RetornoLoginDTO> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException, BusinessException {
    	
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);        
        final JwtUsuario user = (JwtUsuario) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());        
        final String token = jwtTokenUtil.generateToken(user, device); 
        
        String role = "";
                
        for (GrantedAuthority aut: user.getAuthorities()) {
		     	role = aut.getAuthority();
		}        
        CondominioDTO condominioDTO = retornaCondominioUsuario.condominio(role, user.getId());        
        RetornoLoginDTO dto = new RetornoLoginDTO(user, token, condominioDTO, user.getId());
              
        return new ResponseEntity<RetornoLoginDTO>(dto,HttpStatus.OK);
    }
    
   

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
            String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUsuario user = (JwtUsuario) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getUltimaDataSenhaReset())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    @RequestMapping(value = "usuario/logado", method = RequestMethod.GET)
    public JwtUsuario getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUsuario user = (JwtUsuario) userDetailsService.loadUserByUsername(username);
         return user;
    }

}
