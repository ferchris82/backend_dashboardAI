package com.dashboardai.service;

import com.dashboardai.dto.AgentDto;
import com.dashboardai.entity.Agent;
import com.dashboardai.entity.User;
import com.dashboardai.exception.ResourceNotFoundException;
import com.dashboardai.mapper.AgentMapper;
import com.dashboardai.repository.AgentRepository;
import com.dashboardai.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AgentService {

    private final AgentRepository agentRepository;
    private final UserRepository userRepository;
    private final AgentMapper agentMapper;

    public List<AgentDto> getAllAgents() {
        return agentRepository.findAll().stream()
                .map(agentMapper::toDto)
                .toList();
    }

    public Page<AgentDto> getAllAgents(Pageable pageable) {
        return agentRepository.findAll(pageable)
                .map(agentMapper::toDto);
    }

    public List<AgentDto> getAgentsByUserId(Long userId) {
        return agentRepository.findByUserId(userId).stream()
                .map(agentMapper::toDto)
                .toList();
    }

    public AgentDto getAgentById(Long id) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));
        return agentMapper.toDto(agent);
    }

    public AgentDto createAgent(AgentDto agentDto) {
        User user = userRepository.findById(agentDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + agentDto.getUserId()));

        Agent agent = agentMapper.toEntity(agentDto);
        agent.setUser(user);
        agent.setStatus(Agent.AgentStatus.INACTIVE);

        Agent savedAgent = agentRepository.save(agent);
        log.info("Created new agent with id: {}", savedAgent.getId());
        
        return agentMapper.toDto(savedAgent);
    }

    public AgentDto updateAgent(Long id, AgentDto agentDto) {
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));

        agentMapper.updateEntityFromDto(agentDto, existingAgent);
        Agent updatedAgent = agentRepository.save(existingAgent);
        log.info("Updated agent with id: {}", updatedAgent.getId());
        
        return agentMapper.toDto(updatedAgent);
    }

    public void deleteAgent(Long id) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));

        agentRepository.delete(agent);
        log.info("Deleted agent with id: {}", id);
    }

    public AgentDto updateAgentStatus(Long id, Agent.AgentStatus status) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + id));

        agent.setStatus(status);
        Agent updatedAgent = agentRepository.save(agent);
        log.info("Updated agent status for id: {} to: {}", id, status);
        
        return agentMapper.toDto(updatedAgent);
    }
}
