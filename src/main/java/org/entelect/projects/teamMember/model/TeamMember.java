package org.entelect.projects.teamMember.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "members", type = "teamMember")
public class TeamMember {

    @Id
    private String id;
    private String name;
    private String funFact;
    private String photo;

    public TeamMember() {
    }

    public TeamMember(String id, String name, String funFact, String photo) {
        this.id = id;
        this.name = name;
        this.funFact = funFact;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", funFact='" + funFact + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
