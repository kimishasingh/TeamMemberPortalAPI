package org.entelect.projects.teamMember.service;

import org.entelect.projects.teamMember.model.TeamMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface TeamMemberService {

    TeamMember save(TeamMember teamMember);

    void delete(String id);

    TeamMember findOne(String id);

    Iterable<TeamMember> findAll();

    List<TeamMember> findByName(String name, String matchType);

    List<TeamMember> openSearch(String searchValue, String matchType);
}
