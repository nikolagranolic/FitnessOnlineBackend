package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.entities.ImageEntity;
import org.unibl.etf.fitnessonline.models.requests.ImageRequest;
import org.unibl.etf.fitnessonline.repositories.ImageEntityRepository;
import org.unibl.etf.fitnessonline.services.ImageService;
import org.unibl.etf.fitnessonline.services.LogService;

@Service
public class ImageServiceImpl implements ImageService {
    private final ModelMapper modelMapper;
    private final ImageEntityRepository repository;
    private final LogService logService;

    public ImageServiceImpl(ModelMapper modelMapper, ImageEntityRepository repository, LogService logService) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.logService = logService;
    }

    @Override
    public void insertImage(ImageRequest request) {
        ImageEntity imageEntity = modelMapper.map(request, ImageEntity.class);
        imageEntity.setId(null);
        imageEntity = repository.saveAndFlush(imageEntity);
        logService.log("An image with id " + imageEntity + " was added to a program with id " + request.getProgramId());
    }
}
