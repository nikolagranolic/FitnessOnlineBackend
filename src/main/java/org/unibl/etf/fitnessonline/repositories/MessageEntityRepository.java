package org.unibl.etf.fitnessonline.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.fitnessonline.models.entities.MessageEntity;

import java.util.List;

public interface MessageEntityRepository extends JpaRepository<MessageEntity, Integer> {
    List<MessageEntity> findByRecipientIdAndReadFalse(Integer recipientId);

    @Modifying
    @Transactional
    @Query("UPDATE MessageEntity SET read = true WHERE recipient.id = :recipientId AND read = false")
    void markMessagesAsRead(Integer recipientId);
}
