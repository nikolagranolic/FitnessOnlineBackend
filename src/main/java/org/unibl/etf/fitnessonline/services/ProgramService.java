package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.exceptions.NotFoundException;
import org.unibl.etf.fitnessonline.models.dtos.CommentDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramParticipationDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.requests.CommentRequest;
import org.unibl.etf.fitnessonline.models.requests.FilterRequest;
import org.unibl.etf.fitnessonline.models.requests.ParticipationRequest;
import org.unibl.etf.fitnessonline.models.requests.ProgramRequest;

import java.util.List;

public interface ProgramService {
    List<ProgramSimpleDTO> findAll();
    List<ProgramSimpleDTO> findAll(FilterRequest filterRequest, int page, int size);
    List<ProgramSimpleDTO> findAll(int page, int size);
    long countAll();

    long countAll(FilterRequest specification);

    ProgramDTO findById(Integer id) throws NotFoundException;

    CommentDTO findCommentById(Integer id) throws NotFoundException;

    List<ProgramDTO> getAllProgramsByUserId(Integer id);

    ProgramDTO insert(ProgramRequest programRequest);
    ProgramDTO update(Integer id, ProgramRequest programRequest);
    void delete(Integer id);

    CommentDTO insertComment(CommentRequest request);

    ProgramParticipationDTO checkIfParticipant(Integer userId, Integer programId);

    void insertParticipation(ParticipationRequest participationRequest);

    boolean checkIfOwner(Integer userId, Integer programId);
}
