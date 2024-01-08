package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.entities.ImageEntity;
import org.unibl.etf.fitnessonline.models.requests.ImageRequest;
import org.unibl.etf.fitnessonline.repositories.ImageEntityRepository;
import org.unibl.etf.fitnessonline.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
    private final ModelMapper modelMapper;
    private final ImageEntityRepository repository;

    public ImageServiceImpl(ModelMapper modelMapper, ImageEntityRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public void insertImage(ImageRequest request) {
        ImageEntity imageEntity = modelMapper.map(request, ImageEntity.class);
        imageEntity.setId(null);
        repository.saveAndFlush(imageEntity);
    }
}
