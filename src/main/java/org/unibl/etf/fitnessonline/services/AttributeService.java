package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.AttributeDTO;

import java.util.List;

public interface AttributeService {
    List<AttributeDTO> getAllAttributesByCategoryId(Integer id);
}
