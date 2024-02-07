package com.hexaware.cricket.service;

import java.util.List;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;
import com.hexaware.cricket.exception.PlayerWithJerseyNumberAlreadyExistException;

public interface IPlayerService {
	
	List<Player> getAllPlayers();
	
	Player createNewPlayer(PlayerDTO player) throws PlayerWithJerseyNumberAlreadyExistException;
	
	Player getPlayerById(int playerId) throws PlayerNotFoundException;
	
	Player updatePlayerDetails(PlayerDTO player) throws PlayerNotFoundException;
	
	void deletePlayerById(int playerId) throws PlayerNotFoundException;
	
	List<Player> batsmanWithMaximumMatches();
	
	List<Player> bowlerWithMinimumMatches();
}
