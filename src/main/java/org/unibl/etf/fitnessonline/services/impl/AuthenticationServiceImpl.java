package org.unibl.etf.fitnessonline.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.config.JwtService;
import org.unibl.etf.fitnessonline.exceptions.BadRequestException;
import org.unibl.etf.fitnessonline.models.dtos.JwtAuthDTO;
import org.unibl.etf.fitnessonline.models.requests.LoginRequest;
import org.unibl.etf.fitnessonline.repositories.UserEntityRepository;
import org.unibl.etf.fitnessonline.services.AuthenticationService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserEntityRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthDTO authenticate(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow(BadRequestException::new);
        var jwt = jwtService.generateToken(user);
        return JwtAuthDTO.builder().token(jwt).build();
    }
}
