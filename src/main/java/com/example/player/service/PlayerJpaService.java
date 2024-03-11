
package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import com.example.player.model.Player;
import com.example.player.repository.PlayerJpaRepository;
import com.example.player.repository.PlayerRepository;

@Service
public class PlayerJpaService implements PlayerRepository {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Override
    public Player getPlayerById(int playerId) {
        try {
            Player playerObj = playerJpaRepository.findById(playerId).get();
            return playerObj;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Player> getPlayers() {
        List<Player> playerList = playerJpaRepository.findAll();
        ArrayList<Player> playersObj = new ArrayList<>(playerList);
        return playersObj;

    }

    @Override
    public Player addPlayer(Player playerObj) {
        Player newPlayer = playerJpaRepository.save(playerObj);
        return newPlayer;
    }

    @Override
    public Player updatePlayer(int playerId, Player playerObj) {
        Player savedPlayer = playerJpaRepository.findById(playerId).get();

        if (playerObj.getPlayerName() != null) {
            savedPlayer.setPlayerName(playerObj.getPlayerName());
        }
        if (playerObj.getJerseyNumber() != 0) {
            savedPlayer.setJerseyNumber(playerObj.getJerseyNumber());
        }
        if (playerObj.getRole() != null) {
            savedPlayer.setRole(playerObj.getRole());
        }

        playerJpaRepository.save(savedPlayer);

        return savedPlayer;
    }

    @Override
    public void deletePlayer(int playerId) {
        try {
            playerJpaRepository.deleteById(playerId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}