package com.dashboardai.repository;

import com.dashboardai.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    List<Agent> findByUserId(Long userId);
    List<Agent> findByStatus(Agent.AgentStatus status);
    
    @Query("SELECT a FROM Agent a WHERE a.user.id = :userId AND a.status = :status")
    List<Agent> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") Agent.AgentStatus status);
}
