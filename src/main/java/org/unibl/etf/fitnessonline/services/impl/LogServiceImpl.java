package org.unibl.etf.fitnessonline.services.impl;

import org.springframework.stereotype.Service;
import org.unibl.etf.fitnessonline.models.entities.LogEntity;
import org.unibl.etf.fitnessonline.repositories.LogEntityRepository;
import org.unibl.etf.fitnessonline.services.LogService;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    private final LogEntityRepository repository;

    public LogServiceImpl(LogEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void log(String content) {
        Date currentDate = new Date();
        java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
        LogEntity logEntity = new LogEntity();
        logEntity.setId(null);
        logEntity.setContent(content);
        logEntity.setDate(sqlCurrentDate);
        repository.saveAndFlush(logEntity);
    }
}
