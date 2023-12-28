package com.hiper.hibernateinterceptor.service.impl;

import com.hiper.hibernateinterceptor.entity.Team;
import com.hiper.hibernateinterceptor.repository.TeamRepository;
import com.hiper.hibernateinterceptor.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        if (teamRepository.findById(team.getId()).isPresent()) {
            return teamRepository.save(team);
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }
}
