package org.unibl.etf.fitnessonline.controllers;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.exceptions.BadRequestException;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.dtos.UserDTO;
import org.unibl.etf.fitnessonline.models.dtos.UserSuperSimpleDTO;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.models.requests.EditUserRequest;
import org.unibl.etf.fitnessonline.services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/programs")
    public List<ProgramDTO> getAllProgramsByUserId(Authentication authentication, @PathVariable Integer id) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        id = user.getId();
        return userService.getAllProgramsByUserId(id);
    }

    @GetMapping("/{id}/participations")
    public List<ProgramSimpleDTO> getAllParticipations(Authentication authentication, @PathVariable Integer id) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        id = user.getId();
        return userService.getAllParticipations(id);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public void editUser(Authentication authentication, @PathVariable Integer id, @RequestBody @Valid EditUserRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException();
        }
        UserEntity user = (UserEntity) authentication.getPrincipal();
        id = user.getId();
        userService.update(id, request);
    }

    @GetMapping("/{id}/all-possible-recipients")
    public List<UserSuperSimpleDTO> getAllPossibleRecipients(Authentication authentication, @PathVariable Integer id) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        id = user.getId();
        return userService.getAllPossibleRecipients(id);
    }
}
