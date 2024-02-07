package com.hexaware.cricket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;
import com.hexaware.cricket.exception.PlayerWithJerseyNumberAlreadyExistException;
import com.hexaware.cricket.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	PlayerRepository repo;
	
	Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);
	
	@Override
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	@Override
	public Player createNewPlayer(PlayerDTO player) throws PlayerWithJerseyNumberAlreadyExistException {
		List<Player> players = getAllPlayers();
		for(Player p : players) {
			if(p.getJerseyNumber()==player.getJerseyNumber()) {
				throw new PlayerWithJerseyNumberAlreadyExistException("Player "+p.getPlayerName()+" has already got "+player.getJerseyNumber()+" as jersey number.");
			}
		}
		Player newPlayer = new Player();
		newPlayer.setCountryName(player.getCountryName());
		newPlayer.setJerseyNumber(player.getJerseyNumber());
		newPlayer.setPlayerDescription(player.getPlayerDescription());
		newPlayer.setPlayerName(player.getPlayerName());
		newPlayer.setRole(player.getRole());
		newPlayer.setTeamName(player.getTeamName());
		newPlayer.setTotalMatches(player.getTotalMatches());
		return repo.save(newPlayer);
	}

	@Override
	public Player getPlayerById(int playerId) throws PlayerNotFoundException {
		List<Player> players = getAllPlayers();
		boolean isPresent=false;
		for(Player p : players) {
			if(p.getPlayerId()==playerId) {
				isPresent=true;
				break;
			}
		}
		if(!isPresent) {
			throw new PlayerNotFoundException("Player "+playerId+" not found");
		}
		return repo.findById(playerId).orElse(null);
	}

	@Override
	public Player updatePlayerDetails(PlayerDTO player) throws PlayerNotFoundException {
		List<Player> players = getAllPlayers();
		boolean isPresent=false;
		for(Player p : players) {
			if(p.getPlayerId()==player.getPlayerId()) {
				isPresent=true;
				break;
			}
		}
		if(!isPresent) {
			logger.error("Player: "+player.getPlayerName()+" is not present.");
			throw new PlayerNotFoundException("Player "+player.getPlayerId()+" not found");
		}
		
		logger.warn("Player: "+player.getPlayerName()+" is being updated.");
		Player newPlayer = new Player();
		newPlayer.setPlayerId(player.getPlayerId());
		newPlayer.setCountryName(player.getCountryName());
		newPlayer.setJerseyNumber(player.getJerseyNumber());
		newPlayer.setPlayerDescription(player.getPlayerDescription());
		newPlayer.setPlayerName(player.getPlayerName());
		newPlayer.setRole(player.getRole());
		newPlayer.setTeamName(player.getTeamName());
		newPlayer.setTotalMatches(player.getTotalMatches());
		return repo.save(newPlayer);
	}

	@Override
	public void deletePlayerById(int playerId) throws PlayerNotFoundException {
		List<Player> players = getAllPlayers();
		boolean isPresent=false;
		for(Player p : players) {
			if(p.getPlayerId()==playerId) {
				isPresent=true;
				break;
			}
		}
		if(!isPresent) {
			throw new PlayerNotFoundException("Player "+playerId+" not found");
		}
		logger.warn("PlayerId: "+playerId+" is in danger.");
		logger.warn("PlayerId: "+playerId+" is deleted.");
		repo.deleteById(playerId);
	}

	@Override
	public List<Player> batsmanWithMaximumMatches() {
		return repo.getBatsmanWithMaximumMatches();
	}

	@Override
	public List<Player> bowlerWithMinimumMatches() {
		return repo.getBowlerWithMinimumMatches();
	}

}
