package com.mt.app.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.mt.core.model.audit.AuditableDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class FormDTO extends AuditableDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String approvalStatus;

    private String jsonData;

    private String productCategory;

    private String productNo;

    private String orderNo;

    private String clientNo;

    private String clientName;

    private Date timestamp;

    public static FormDTO mock(Integer id) {
        FormDTO form = new FormDTO();
        form.setId(id);
        form.setTimestamp(new Date());
        return form;
    }
}
