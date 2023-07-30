package com.mt.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mt.core.model.audit.AuditableEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "form_config", catalog = "app")
@EqualsAndHashCode(callSuper = false)
@Data
public class FormConfig extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Boolean flowable = false;

    @Column(name = "flow_name")
    private String flowName;

    @Column
    private String privileges;

    @Column(name = "json_ui")
    private String jsonUI;
}
