package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.entities.CategorySubscriptionEntity;
import org.unibl.etf.fitnessonline.models.requests.CategorySubscriptionRequest;
import org.unibl.etf.fitnessonline.repositories.CategoryEntityRepository;
import org.unibl.etf.fitnessonline.repositories.CategorySubscriptionEntityRepository;
import org.unibl.etf.fitnessonline.services.CategorySubscriptionService;
import org.unibl.etf.fitnessonline.services.LogService;

@Service
public class CategorySubscriptionServiceImpl implements CategorySubscriptionService {
    private final CategorySubscriptionEntityRepository repository;
    private final LogService logService;
    private final ModelMapper modelMapper;

    public CategorySubscriptionServiceImpl(CategorySubscriptionEntityRepository repository, CategoryEntityRepository categoryRepository, LogService logService, ModelMapper modelMapper) {
        this.repository = repository;
        this.logService = logService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCategorySubscription(CategorySubscriptionRequest request) {
        CategorySubscriptionEntity entity = modelMapper.map(request, CategorySubscriptionEntity.class);
        entity.setId(null);
        repository.saveAndFlush(entity);
        logService.log("User with id " + request.getUserId() + " subscribed to category with id " + request.getCategoryId());
    }

    @Override
    public void removeCategorySubscription(CategorySubscriptionRequest request) {
        repository.deleteByUser_IdAndCategory_Id(request.getUserId(), request.getCategoryId());
        logService.log("User with id " + request.getUserId() + " unsubscribed from category with id " + request.getCategoryId());
    }

    @Override
    public boolean checkIfSubscribed(CategorySubscriptionRequest request) {
        return repository.existsByUser_IdAndCategory_Id(request.getUserId(), request.getCategoryId());
    }
}
