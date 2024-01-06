package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.JwtAuthDTO;
import org.unibl.etf.fitnessonline.models.requests.LoginRequest;

public interface AuthenticationService {
    JwtAuthDTO authenticate(LoginRequest request);
}
