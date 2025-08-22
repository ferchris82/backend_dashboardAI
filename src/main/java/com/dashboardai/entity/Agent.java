package com.dashboardai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agents")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Agent extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "workflow_id")
    private String workflowId;

    @Column(name = "n8n_url")
    private String n8nUrl;

    @Enumerated(EnumType.STRING)
    private AgentStatus status = AgentStatus.INACTIVE;

    @Column(columnDefinition = "TEXT")
    private String configuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public enum AgentStatus {
        ACTIVE, INACTIVE, ERROR, MAINTENANCE
    }
}
