package org.unibl.etf.fitnessonline.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.unibl.etf.fitnessonline.exceptions.NotFoundException;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.dtos.UserDTO;
import org.unibl.etf.fitnessonline.models.requests.EditUserRequest;
import org.unibl.etf.fitnessonline.models.requests.RegisterRequest;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<ProgramDTO> getAllProgramsByUserId(Integer id);

    List<ProgramSimpleDTO> getAllParticipations(Integer id);
    UserDetails loadUserByUsername(String username);

    UserDTO findById(Integer id) throws NotFoundException;

    void insert(RegisterRequest request);


    void update(Integer id, EditUserRequest request);

    String verify(String userId, String token);

    void sendNewVerificationMail(String username);
}
