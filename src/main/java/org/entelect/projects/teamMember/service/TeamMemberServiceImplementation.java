package org.entelect.projects.teamMember.service;

import org.entelect.projects.teamMember.repository.TeamMemberRepository;
import org.entelect.projects.teamMember.model.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TeamMemberServiceImplementation implements TeamMemberService{

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public TeamMember save(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    public void delete(String id) {
        teamMemberRepository.delete(id);
    }

    public TeamMember findOne(String id) {
        return teamMemberRepository.findOne(id);
    }

    public Iterable<TeamMember> findAll() {
        return teamMemberRepository.findAll();
    }

    public List<TeamMember> findByName(String name, String matchType) {
        if(matchType.equals("exact")) {
            return teamMemberRepository.findByName(name);
        } else {
            return teamMemberRepository.findByNameContaining(name);
        }

    }

    public List<TeamMember> openSearch(String searchValue, String matchType) {

        List<TeamMember> nameList = new ArrayList<>();
        List<TeamMember> funFactList = new ArrayList<>();

        if(matchType.equals("exact")) {
            nameList = teamMemberRepository.findByName(searchValue);
            funFactList = teamMemberRepository.findByFunFact(searchValue);
        } else {
            nameList = teamMemberRepository.findByNameContaining(searchValue);
            funFactList = teamMemberRepository.findByFunFactContaining(searchValue);
        }

        List<TeamMember> finalList = Stream.concat(nameList.stream(), funFactList.stream())
                .collect(Collectors.toList());
        return finalList;
    }
}
