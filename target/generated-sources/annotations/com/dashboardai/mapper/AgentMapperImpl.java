package com.dashboardai.mapper;

import com.dashboardai.dto.AgentDto;
import com.dashboardai.entity.Agent;
import com.dashboardai.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-22T11:35:58-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
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
        agentDto.setId( agent.getId() );
        agentDto.setName( agent.getName() );
        agentDto.setDescription( agent.getDescription() );
        agentDto.setWorkflowId( agent.getWorkflowId() );
        agentDto.setN8nUrl( agent.getN8nUrl() );
        agentDto.setStatus( agent.getStatus() );
        agentDto.setConfiguration( agent.getConfiguration() );

        return agentDto;
    }

    @Override
    public Agent toEntity(AgentDto agentDto) {
        if ( agentDto == null ) {
            return null;
        }

        Agent agent = new Agent();

        agent.setName( agentDto.getName() );
        agent.setDescription( agentDto.getDescription() );
        agent.setWorkflowId( agentDto.getWorkflowId() );
        agent.setN8nUrl( agentDto.getN8nUrl() );
        agent.setStatus( agentDto.getStatus() );
        agent.setConfiguration( agentDto.getConfiguration() );

        return agent;
    }

    @Override
    public void updateEntityFromDto(AgentDto agentDto, Agent agent) {
        if ( agentDto == null ) {
            return;
        }

        if ( agentDto.getName() != null ) {
            agent.setName( agentDto.getName() );
        }
        if ( agentDto.getDescription() != null ) {
            agent.setDescription( agentDto.getDescription() );
        }
        if ( agentDto.getWorkflowId() != null ) {
            agent.setWorkflowId( agentDto.getWorkflowId() );
        }
        if ( agentDto.getN8nUrl() != null ) {
            agent.setN8nUrl( agentDto.getN8nUrl() );
        }
        if ( agentDto.getStatus() != null ) {
            agent.setStatus( agentDto.getStatus() );
        }
        if ( agentDto.getConfiguration() != null ) {
            agent.setConfiguration( agentDto.getConfiguration() );
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
