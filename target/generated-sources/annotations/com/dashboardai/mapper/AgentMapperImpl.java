package com.dashboardai.mapper;

import com.dashboardai.dto.AgentDto;
import com.dashboardai.entity.Agent;
import com.dashboardai.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-22T11:16:47-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class AgentMapperImpl implements AgentMapper {

    @Override
    public AgentDto toDto(Agent agent) {
        if ( agent == null ) {
            return null;
        }

        AgentDto agentDto = new AgentDto();

        agentDto.setUserId( agentUserId( agent ) );
        agentDto.setConfiguration( agent.getConfiguration() );
        agentDto.setDescription( agent.getDescription() );
        agentDto.setId( agent.getId() );
        agentDto.setN8nUrl( agent.getN8nUrl() );
        agentDto.setName( agent.getName() );
        agentDto.setStatus( agent.getStatus() );
        agentDto.setWorkflowId( agent.getWorkflowId() );

        return agentDto;
    }

    @Override
    public Agent toEntity(AgentDto agentDto) {
        if ( agentDto == null ) {
            return null;
        }

        Agent agent = new Agent();

        agent.setConfiguration( agentDto.getConfiguration() );
        agent.setDescription( agentDto.getDescription() );
        agent.setN8nUrl( agentDto.getN8nUrl() );
        agent.setName( agentDto.getName() );
        agent.setStatus( agentDto.getStatus() );
        agent.setWorkflowId( agentDto.getWorkflowId() );

        return agent;
    }

    @Override
    public void updateEntityFromDto(AgentDto agentDto, Agent agent) {
        if ( agentDto == null ) {
            return;
        }

        if ( agentDto.getConfiguration() != null ) {
            agent.setConfiguration( agentDto.getConfiguration() );
        }
        if ( agentDto.getDescription() != null ) {
            agent.setDescription( agentDto.getDescription() );
        }
        if ( agentDto.getN8nUrl() != null ) {
            agent.setN8nUrl( agentDto.getN8nUrl() );
        }
        if ( agentDto.getName() != null ) {
            agent.setName( agentDto.getName() );
        }
        if ( agentDto.getStatus() != null ) {
            agent.setStatus( agentDto.getStatus() );
        }
        if ( agentDto.getWorkflowId() != null ) {
            agent.setWorkflowId( agentDto.getWorkflowId() );
        }
    }

    private Long agentUserId(Agent agent) {
        if ( agent == null ) {
            return null;
        }
        User user = agent.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
