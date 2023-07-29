package com.mt.bpm.model;

import java.io.Serializable;

import com.mt.app.model.dto.FormDTO;
import com.mt.bpm.model.dto.NoticeDTO;
import com.mt.bpm.model.enumtype.FlowActionEnum;

import lombok.Data;

@Data
public class FlowActionRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private FlowActionEnum action;

    private String flowTaskId;

    private Object comments;

    private NoticeDTO notice;

    private FormDTO form;

    private boolean formUpdateNeeded;
}
