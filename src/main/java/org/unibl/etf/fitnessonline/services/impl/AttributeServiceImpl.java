package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.dtos.AttributeDTO;
import org.unibl.etf.fitnessonline.repositories.AttributeEntityRepository;
import org.unibl.etf.fitnessonline.services.AttributeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl implements AttributeService {
    private final AttributeEntityRepository repository;
    private final ModelMapper modelMapper;

    public AttributeServiceImpl(AttributeEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AttributeDTO> getAllAttributesByCategoryId(Integer id) {
        return repository.getAllByCategory_Id(id).stream().map(a -> modelMapper.map(a, AttributeDTO.class)).collect(Collectors.toList());
    }
}
