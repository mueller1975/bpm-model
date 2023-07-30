package com.mt.app.model.dto;

import com.mt.core.model.audit.AuditableDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FormConfigDTO extends AuditableDTO {

    private Integer id;

    private String name;

    private Boolean flowable = false;

    private String flowName;

    private String privileges;

    private String jsonUI;
}
