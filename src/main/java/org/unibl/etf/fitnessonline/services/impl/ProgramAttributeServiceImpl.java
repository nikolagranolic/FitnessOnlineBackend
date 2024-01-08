package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.entities.ProgramAttributeEntity;
import org.unibl.etf.fitnessonline.models.requests.ProgramAttributeRequest;
import org.unibl.etf.fitnessonline.repositories.ProgramAttributeEntityRepository;
import org.unibl.etf.fitnessonline.services.ProgramAttributeService;

@Service
public class ProgramAttributeServiceImpl implements ProgramAttributeService {
    private final ModelMapper modelMapper;
    private final ProgramAttributeEntityRepository repository;

    public ProgramAttributeServiceImpl(ModelMapper modelMapper, ProgramAttributeEntityRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public void addProgramAttribute(ProgramAttributeRequest request) {
        ProgramAttributeEntity programAttributeEntity = modelMapper.map(request, ProgramAttributeEntity.class);
        programAttributeEntity.setId(null);
        repository.saveAndFlush(programAttributeEntity);
    }
}
