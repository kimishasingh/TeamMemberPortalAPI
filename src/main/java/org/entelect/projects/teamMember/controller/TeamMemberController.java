package org.entelect.projects.teamMember.controller;

import com.google.common.collect.Lists;
import org.entelect.projects.teamMember.model.TeamMember;
import org.entelect.projects.teamMember.service.TeamMemberServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class TeamMemberController {

    @Autowired
    TeamMemberServiceImplementation teamMemberServiceImplementation;

    /**
     * Method to save a new TeamMember to the db
     * @param teamMember
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public TeamMember save(@RequestBody TeamMember teamMember) {
        return teamMemberServiceImplementation.save(teamMember);
    }

    /**
     * Method to get a specific TeamMember from the db based on their id
     * @param id
     * @return
     */
    @RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
    public TeamMember get(@PathVariable String id) {
        return teamMemberServiceImplementation.findOne(id);
    }

    /**
     * Method to return all the TeamMembers from the db
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<TeamMember> getAll(){
        return Lists.newArrayList(teamMemberServiceImplementation.findAll());
    }

    /**
     * Method to delete a TeamMember from the db based on the id
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        teamMemberServiceImplementation.delete(id);
        return "Team member deleted!";
    }

    /**
     * Method to search for TeamMembers by name
     * @param searchValue
     * @param matchType - indicates if exact match or contained match
     * @return
     */
    @RequestMapping(value = "/search/name/{searchValue}", method = RequestMethod.GET)
    public List<TeamMember> searchByName(@PathVariable String searchValue, @RequestParam("matchType") String matchType) {
        return teamMemberServiceImplementation.findByName(searchValue, matchType);
    }

    /**
     * Method to search for TeamMembers by any field
     * @param searchValue
     * @return
     */
    @RequestMapping(value = "/search/any/{searchValue}", method = RequestMethod.GET)
    public List<TeamMember> openSearch(@PathVariable String searchValue, @RequestParam("matchType") String matchType) {
        return teamMemberServiceImplementation.openSearch(searchValue, matchType);
    }
}
