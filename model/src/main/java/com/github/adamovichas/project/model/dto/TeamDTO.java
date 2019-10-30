package com.github.adamovichas.project.model.dto;




public class TeamDTO {


    private Long idLeague;
    private String name;

    public TeamDTO(String name, Long idLeague) {

        this.idLeague = idLeague;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(Long idLeague) {
        this.idLeague = idLeague;
    }

    @Override
    public String toString() {
        return name;
    }
}
