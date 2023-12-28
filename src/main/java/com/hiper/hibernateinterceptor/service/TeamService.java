package com.hiper.hibernateinterceptor.service;

import com.hiper.hibernateinterceptor.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeamService {

    List<Team> getAllTeams();
    Team getTeamById(Long id);
    Team saveTeam(Team team);
    Team updateTeam(Team team);
    void deleteTeamById(Long id);

}
