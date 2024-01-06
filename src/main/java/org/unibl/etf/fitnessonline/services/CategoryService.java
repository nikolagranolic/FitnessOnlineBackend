package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.CategorySimpleDTO;

import java.util.List;

public interface CategoryService {
    List<CategorySimpleDTO> findAll();
}
