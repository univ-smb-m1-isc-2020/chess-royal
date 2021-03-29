package fr.univ_smb.isc.m1.chuck_facts.application;


public class ChessRoyale {

    private Long id;

    private String name;

    public ChessRoyale(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
