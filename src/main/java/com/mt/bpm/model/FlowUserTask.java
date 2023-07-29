package com.mt.bpm.model;

import java.util.EnumSet;

import com.mt.bpm.model.enumtype.FormPrivilegeEnum;

import lombok.Data;

/**
 * 流程 task 被指派者的權限
 * 
 * @author Mueller Tsai
 */
@Data
public class FlowUserTask {

    // 被指派人員工號
    private String assignee;

    // 被指派人員姓名
    private String assigneeName;

    // Flowable user task ID
    private String taskId;

    // 使用者表單權限
    private EnumSet<FormPrivilegeEnum> formPrivileges;

    public static FlowUserTask mock(String assignee) {
        FlowUserTask userTask = new FlowUserTask();
        userTask.setAssignee(assignee);
        userTask.setFormPrivileges(
                EnumSet.of(
                        FormPrivilegeEnum.EDIT,
                        FormPrivilegeEnum.APPROVE));

        return userTask;
    }
}
