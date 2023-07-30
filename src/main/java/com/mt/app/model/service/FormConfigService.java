package com.mt.app.model.service;

import org.springframework.stereotype.Service;

import com.mt.app.model.dao.FormConfigRepository;
import com.mt.app.model.dto.FormConfigDTO;
import com.mt.app.model.entity.FormConfig;
import com.mt.core.model.service.AbstractService;

@Service
public class FormConfigService extends AbstractService<FormConfig, Integer, FormConfigDTO, FormConfigRepository> {

}
