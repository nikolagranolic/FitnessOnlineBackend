package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.exceptions.NotFoundException;
import org.unibl.etf.fitnessonline.models.dtos.CommentDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.entities.CommentEntity;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;
import org.unibl.etf.fitnessonline.models.requests.CommentRequest;
import org.unibl.etf.fitnessonline.models.requests.FilterRequest;
import org.unibl.etf.fitnessonline.models.requests.ProgramRequest;
import org.unibl.etf.fitnessonline.models.specifications.ProgramSpecification;
import org.unibl.etf.fitnessonline.repositories.CommentEntityRepository;
import org.unibl.etf.fitnessonline.repositories.ProgramEntityRepository;
import org.unibl.etf.fitnessonline.services.ProgramService;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramServiceImpl implements ProgramService {
    private final ModelMapper modelMapper;
    private final ProgramEntityRepository repository;
    private final CommentEntityRepository commentRepository;

    public ProgramServiceImpl(ProgramEntityRepository repository, ModelMapper modelMapper, CommentEntityRepository commentRepository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<ProgramSimpleDTO> findAll() {
        return repository.findAll().stream().map(l -> modelMapper.map(l, ProgramSimpleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProgramSimpleDTO> findAll(FilterRequest filterRequest, int page, int size) {
        Specification<ProgramEntity> specification = ProgramSpecification.createSpecification(filterRequest);
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(specification, pageable)
                .stream()
                .map(programEntity -> modelMapper.map(programEntity, ProgramSimpleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramSimpleDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable)
                .stream()
                .map(programEntity -> modelMapper.map(programEntity, ProgramSimpleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public long countAll(FilterRequest filterRequest) {
        Specification<ProgramEntity> specification = ProgramSpecification.createSpecification(filterRequest);
        return repository.count(specification);
    }

    @Override
    public ProgramDTO findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), ProgramDTO.class);
    }

    @Override
    public CommentDTO findCommentById(Integer id) throws NotFoundException {
        return modelMapper.map(commentRepository.findById(id).orElseThrow(NotFoundException::new), CommentDTO.class);
    }

    @Override
    public List<ProgramDTO> getAllProgramsByUserId(Integer id) {
        return repository.getAllByUser_Id(id).stream().map(l -> modelMapper.map(l, ProgramDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProgramDTO insert(ProgramRequest programRequest) {
        ProgramEntity programEntity = modelMapper.map(programRequest, ProgramEntity.class);
        programEntity.setId(null);
        programEntity = repository.saveAndFlush(programEntity);
        return findById(programEntity.getId());
    }

    @Override
    public ProgramDTO update(Integer id, ProgramRequest programRequest) {
        ProgramEntity programEntity = modelMapper.map(programRequest, ProgramEntity.class);
        programEntity.setId(id);
        programEntity = repository.saveAndFlush(programEntity);
        return findById(programEntity.getId());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CommentDTO insertComment(CommentRequest commentRequest) {
        commentRequest.setTimestamp(new Timestamp(System.currentTimeMillis()));
        CommentEntity commentEntity = modelMapper.map(commentRequest, CommentEntity.class);
        commentEntity.setId(null);
        commentEntity = commentRepository.saveAndFlush(commentEntity);
        return findCommentById(commentEntity.getId());
    }


}
