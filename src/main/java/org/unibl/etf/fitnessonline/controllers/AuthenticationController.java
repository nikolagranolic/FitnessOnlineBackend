package org.unibl.etf.fitnessonline.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.JwtAuthDTO;
import org.unibl.etf.fitnessonline.models.requests.LoginRequest;
import org.unibl.etf.fitnessonline.models.requests.RegisterRequest;
import org.unibl.etf.fitnessonline.services.AuthenticationService;
import org.unibl.etf.fitnessonline.services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        userService.insert(request);
    }

    @PostMapping("/login")
    public JwtAuthDTO register(@RequestBody LoginRequest request) {
        return authenticationService.authenticate(request);
    }

    @GetMapping("/verify")
    public String verify(@RequestParam String email, @RequestParam String token) {
        return userService.verify(email, token);
    }

    @CrossOrigin("*")
    @GetMapping("/sendNewVerificationEmail")
    public void sendNewVerificationEmail(@RequestParam String username) {
        userService.sendNewVerificationMail(username);
    }
}
