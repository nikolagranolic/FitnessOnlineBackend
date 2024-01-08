package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.dtos.UserDTO;
import org.unibl.etf.fitnessonline.models.dtos.UserSuperSimpleDTO;
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
    public List<ProgramDTO> getAllProgramsByUserId(@PathVariable Integer id) {
        return userService.getAllProgramsByUserId(id);
    }

    @GetMapping("/{id}/participations")
    public List<ProgramSimpleDTO> getAllParticipations(@PathVariable Integer id) {
        return userService.getAllParticipations(id);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable Integer id, @RequestBody EditUserRequest request) {
        userService.update(id, request);
    }

    @GetMapping("/{id}/all-possible-recipients")
    public List<UserSuperSimpleDTO> getAllPossibleRecipients(@PathVariable Integer id) {
        return userService.getAllPossibleRecipients(id);
    }
}
