package com.dashboardai.mapper;

import com.dashboardai.dto.AgentDto;
import com.dashboardai.entity.Agent;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AgentMapper {

    @Mapping(target = "userId", source = "user.id")
    AgentDto toDto(Agent agent);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "version", ignore = true)
    Agent toEntity(AgentDto agentDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "version", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(AgentDto agentDto, @MappingTarget Agent agent);
}
