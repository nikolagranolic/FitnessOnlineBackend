package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.entities.AdviceMessageEntity;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.models.requests.AdviceMessageRequest;
import org.unibl.etf.fitnessonline.repositories.AdviceMessageEntityRepository;
import org.unibl.etf.fitnessonline.services.AdviceMessageService;
import org.unibl.etf.fitnessonline.services.LogService;

@Service
public class AdviceMessageServiceImpl implements AdviceMessageService {
    private final AdviceMessageEntityRepository repository;
    private final LogService logService;
    private final ModelMapper modelMapper;

    public AdviceMessageServiceImpl(AdviceMessageEntityRepository repository, LogService logService, ModelMapper modelMapper) {
        this.repository = repository;
        this.logService = logService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void sendAdviceMessage(AdviceMessageRequest request) {
        AdviceMessageEntity adviceMessageEntity = modelMapper.map(request, AdviceMessageEntity.class);
        adviceMessageEntity.setId(null);
        UserEntity ue = new UserEntity();
        ue.setId(request.getSender());
        adviceMessageEntity.setSender(ue);
        adviceMessageEntity.setRead(false);
        adviceMessageEntity = repository.saveAndFlush(adviceMessageEntity);
        logService.log("User with id " + request.getSender() + " sent an advice message with id " + adviceMessageEntity.getId());
    }
}
