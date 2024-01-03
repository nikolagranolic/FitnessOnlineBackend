package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;

import java.util.List;

public interface UserService {
    List<ProgramDTO> getAllProgramsByUserId(Integer id);
}
