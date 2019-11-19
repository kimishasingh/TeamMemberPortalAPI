package org.entelect.projects.teamMember.repository;

import org.entelect.projects.teamMember.model.TeamMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends ElasticsearchRepository<TeamMember, String> {

    List<TeamMember> findByName(String name);

    List<TeamMember> findByFunFact(String funFact);

    List<TeamMember> findByNameContaining(String name);

    List<TeamMember> findByFunFactContaining(String funFact);
}
