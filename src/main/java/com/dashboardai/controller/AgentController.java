package com.dashboardai.controller;

import com.dashboardai.dto.AgentDto;
import com.dashboardai.entity.Agent;
import com.dashboardai.service.AgentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
@RequiredArgsConstructor
@Tag(name = "Agents", description = "Agent management APIs")
public class AgentController {

    private final AgentService agentService;

    @GetMapping
    @Operation(summary = "Get all agents", description = "Retrieve all agents with pagination")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Page<AgentDto>> getAllAgents(Pageable pageable) {
        Page<AgentDto> agents = agentService.getAllAgents(pageable);
        return ResponseEntity.ok(agents);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get agents by user", description = "Retrieve all agents for a specific user")
    @PreAuthorize("hasRole('ADMIN') or (#userId == authentication.principal.id)")
    public ResponseEntity<List<AgentDto>> getAgentsByUserId(
            @Parameter(description = "User ID") @PathVariable Long userId) {
        List<AgentDto> agents = agentService.getAgentsByUserId(userId);
        return ResponseEntity.ok(agents);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get agent by ID", description = "Retrieve a specific agent by its ID")
    @PreAuthorize("hasRole('ADMIN') or @agentService.getAgentById(#id).userId == authentication.principal.id")
    public ResponseEntity<AgentDto> getAgentById(
            @Parameter(description = "Agent ID") @PathVariable Long id) {
        AgentDto agent = agentService.getAgentById(id);
        return ResponseEntity.ok(agent);
    }

    @PostMapping
    @Operation(summary = "Create new agent", description = "Create a new agent")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<AgentDto> createAgent(@RequestBody AgentDto agentDto) {
        AgentDto createdAgent = agentService.createAgent(agentDto);
        return new ResponseEntity<>(createdAgent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update agent", description = "Update an existing agent")
    @PreAuthorize("hasRole('ADMIN') or @agentService.getAgentById(#id).userId == authentication.principal.id")
    public ResponseEntity<AgentDto> updateAgent(
            @Parameter(description = "Agent ID") @PathVariable Long id,
            @RequestBody AgentDto agentDto) {
        AgentDto updatedAgent = agentService.updateAgent(id, agentDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete agent", description = "Delete an agent")
    @PreAuthorize("hasRole('ADMIN') or @agentService.getAgentById(#id).userId == authentication.principal.id")
    public ResponseEntity<Void> deleteAgent(
            @Parameter(description = "Agent ID") @PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Update agent status", description = "Update the status of an agent")
    @PreAuthorize("hasRole('ADMIN') or @agentService.getAgentById(#id).userId == authentication.principal.id")
    public ResponseEntity<AgentDto> updateAgentStatus(
            @Parameter(description = "Agent ID") @PathVariable Long id,
            @Parameter(description = "New status") @RequestParam Agent.AgentStatus status) {
        AgentDto updatedAgent = agentService.updateAgentStatus(id, status);
        return ResponseEntity.ok(updatedAgent);
    }
}
