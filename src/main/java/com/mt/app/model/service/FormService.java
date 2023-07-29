package com.mt.app.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.app.model.dao.FormDAO;
import com.mt.app.model.dto.FormDTO;
import com.mt.app.model.entity.Form;

@Service("mtFormService")
public class FormService {

    @Autowired
    private FormDAO formDAO;

    @Autowired
    private ModelMapper modelMapper;

    public Form get(Integer id) {
        Form entity = formDAO.findById(id).orElse(null);
        return entity;
    }

    public Form save(FormDTO dto) {
        Form entity = modelMapper.map(dto, Form.class);
        entity = formDAO.save(entity);
        return entity;
    }
}
