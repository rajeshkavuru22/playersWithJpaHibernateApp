package com.example.player.model;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerid")
    private int playerId;

    @Column(name = "playername")
    private String playerName;

    @Column(name = "jerseynumber")
    private int jerseyNumber;

    @Column(name = "role")
    private String role;

    public Player() {
    }

    public Player(int id, String name, int jersey, String playerRole) {
        playerId = id;
        playerName = name;
        jerseyNumber = jersey;
        role = playerRole;
    }

    public void setPlayerId(int id) {
        playerId = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerName(String name) {
        playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setJerseyNumber(int jersey) {
        jerseyNumber = jersey;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setRole(String playerRole) {
        role = playerRole;
    }

    public String getRole() {
        return role;
    }

}