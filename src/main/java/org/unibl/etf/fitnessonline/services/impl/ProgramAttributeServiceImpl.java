package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.entities.ProgramAttributeEntity;
import org.unibl.etf.fitnessonline.models.requests.ProgramAttributeRequest;
import org.unibl.etf.fitnessonline.repositories.ProgramAttributeEntityRepository;
import org.unibl.etf.fitnessonline.services.LogService;
import org.unibl.etf.fitnessonline.services.ProgramAttributeService;

@Service
public class ProgramAttributeServiceImpl implements ProgramAttributeService {
    private final ModelMapper modelMapper;
    private final ProgramAttributeEntityRepository repository;
    private final LogService logService;

    public ProgramAttributeServiceImpl(ModelMapper modelMapper, ProgramAttributeEntityRepository repository, LogService logService) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.logService = logService;
    }

    @Override
    public void addProgramAttribute(ProgramAttributeRequest request) {
        ProgramAttributeEntity programAttributeEntity = modelMapper.map(request, ProgramAttributeEntity.class);
        programAttributeEntity.setId(null);
        programAttributeEntity = repository.saveAndFlush(programAttributeEntity);
        logService.log("Program attribute with id " + programAttributeEntity.getId() + " was added to program with id " + request.getProgramId());
    }
}
