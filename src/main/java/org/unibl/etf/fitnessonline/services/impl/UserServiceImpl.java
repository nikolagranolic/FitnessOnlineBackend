package org.unibl.etf.fitnessonline.services.impl;

import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.services.ProgramService;
import org.unibl.etf.fitnessonline.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final ProgramService programService;

    public UserServiceImpl(ProgramService programService) {
        this.programService = programService;
    }

    public List<ProgramDTO> getAllProgramsByUserId(Integer id) {
        return programService.getAllProgramsByUserId(id);
    }
}
