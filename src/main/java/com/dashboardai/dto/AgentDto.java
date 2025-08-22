package com.dashboardai.dto;

import com.dashboardai.entity.Agent;
import lombok.Data;

@Data
public class AgentDto {
    private Long id;
    private String name;
    private String description;
    private String workflowId;
    private String n8nUrl;
    private Agent.AgentStatus status;
    private String configuration;
    private Long userId;
}
