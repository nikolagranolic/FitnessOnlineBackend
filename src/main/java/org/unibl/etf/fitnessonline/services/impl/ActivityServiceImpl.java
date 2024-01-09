package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.dtos.ActivityDTO;
import org.unibl.etf.fitnessonline.models.entities.ActivityEntity;
import org.unibl.etf.fitnessonline.models.requests.ActivityRequest;
import org.unibl.etf.fitnessonline.models.requests.ChartRequest;
import org.unibl.etf.fitnessonline.repositories.ActivityEntityRepository;
import org.unibl.etf.fitnessonline.services.ActivityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityEntityRepository repository;
    private final ModelMapper modelMapper;

    public ActivityServiceImpl(ActivityEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addActivity(ActivityRequest request) {
        ActivityEntity activityEntity = modelMapper.map(request, ActivityEntity.class);
        activityEntity.setId(null);
        repository.saveAndFlush(activityEntity);
    }

    @Override
    public List<ActivityDTO> findByUserId(Integer id) {
        return repository.findByUserIdOrderByDateAsc(id).stream().map(a -> modelMapper.map(a, ActivityDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActivityDTO> findActivitiesBetweenDates(Integer id, ChartRequest request) {
        return repository.findActivitiesBetweenDates(id, request.getBeginDate(), request.getEndDate()).stream().map(a -> modelMapper.map(a, ActivityDTO.class)).collect(Collectors.toList());
    }
}
