package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.dtos.MessageDTO;
import org.unibl.etf.fitnessonline.models.entities.MessageEntity;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.models.requests.MessageRequest;
import org.unibl.etf.fitnessonline.repositories.MessageEntityRepository;
import org.unibl.etf.fitnessonline.services.LogService;
import org.unibl.etf.fitnessonline.services.MessageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageEntityRepository repository;
    private final ModelMapper modelMapper;
    private final LogService logService;

    public MessageServiceImpl(MessageEntityRepository repository, ModelMapper modelMapper, LogService logService) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.logService = logService;
    }

    @Override
    public void sendMessage(MessageRequest request) {
        MessageEntity messageEntity = modelMapper.map(request, MessageEntity.class);
        messageEntity.setId(null);
        UserEntity s = new UserEntity();
        s.setId(request.getSenderId());
        UserEntity r = new UserEntity();
        r.setId(request.getRecipientId());
        messageEntity.setRead(false);
        messageEntity = repository.saveAndFlush(messageEntity);
        logService.log("User with id " + request.getSenderId() + " sent a message with id " + messageEntity.getId() + " to a user with id " + request.getRecipientId());
    }

    @Override
    public List<MessageDTO> getUnreadMessagesAndMarkAsRead(Integer recipientId) {
        List<MessageDTO> unreadMessages = repository.findByRecipientIdAndReadFalse(recipientId).stream().map(m -> modelMapper.map(m, MessageDTO.class)).collect(Collectors.toList());
        if (!unreadMessages.isEmpty()) {
            repository.markMessagesAsRead(recipientId);
        }
        logService.log("User with id " + recipientId + " read all of his/her unread messages");
        return unreadMessages;
    }
}
