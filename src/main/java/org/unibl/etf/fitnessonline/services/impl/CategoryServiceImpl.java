package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.dtos.CategorySimpleDTO;
import org.unibl.etf.fitnessonline.repositories.CategoryEntityRepository;
import org.unibl.etf.fitnessonline.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryEntityRepository repository;

    public CategoryServiceImpl(ModelMapper modelMapper, CategoryEntityRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<CategorySimpleDTO> findAll() {
        return repository.findAll().stream().map(c -> modelMapper.map(c, CategorySimpleDTO.class)).collect(Collectors.toList());
    }
}
