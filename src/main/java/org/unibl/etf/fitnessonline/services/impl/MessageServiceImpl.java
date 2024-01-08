package org.unibl.etf.fitnessonline.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.dtos.MessageDTO;
import org.unibl.etf.fitnessonline.models.entities.MessageEntity;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.models.requests.MessageRequest;
import org.unibl.etf.fitnessonline.repositories.MessageEntityRepository;
import org.unibl.etf.fitnessonline.services.MessageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageEntityRepository repository;
    private final ModelMapper modelMapper;

    public MessageServiceImpl(MessageEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
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
        repository.saveAndFlush(messageEntity);
    }

    @Override
    public List<MessageDTO> getUnreadMessagesAndMarkAsRead(Integer recipientId) {
        List<MessageDTO> unreadMessages = repository.findByRecipientIdAndReadFalse(recipientId).stream().map(m -> modelMapper.map(m, MessageDTO.class)).collect(Collectors.toList());
        if (!unreadMessages.isEmpty()) {
            repository.markMessagesAsRead(recipientId);
        }
        return unreadMessages;
    }
}
