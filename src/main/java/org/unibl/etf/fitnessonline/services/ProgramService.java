package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.exceptions.NotFoundException;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.requests.ProgramRequest;

import java.util.List;

public interface ProgramService {
    List<ProgramSimpleDTO> findAll();
    ProgramDTO findById(Integer id) throws NotFoundException;

    List<ProgramDTO> getAllProgramsByUserId(Integer id);

    ProgramDTO insert(ProgramRequest programRequest);
    ProgramDTO update(Integer id, ProgramRequest programRequest);
    void delete(Integer id);
}
