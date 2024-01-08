package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.MessageDTO;
import org.unibl.etf.fitnessonline.models.requests.MessageRequest;

import java.util.List;

public interface MessageService {
    void sendMessage(MessageRequest request);
    List<MessageDTO> getUnreadMessagesAndMarkAsRead(Integer recipientId);
}
