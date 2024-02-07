package com.hexaware.cricket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;
import com.hexaware.cricket.exception.PlayerWithJerseyNumberAlreadyExistException;
import com.hexaware.cricket.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PlayerController {
	
	Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	@Autowired
	IPlayerService service;
	
	@GetMapping("/players")
	public List<Player> getAllPlayers() {
		return service.getAllPlayers();
	}
	
	@PostMapping("/new-player")
	public Player createNewPlayer(@RequestBody @Valid PlayerDTO player) throws PlayerWithJerseyNumberAlreadyExistException {
//		if(isPlayerValid(player)) {
//			return service.createNewPlayer(player);
//		}
//		return null;
		return service.createNewPlayer(player);
	}
	
	@GetMapping("/findPlayerById/{playerId}")
	public Player findPlayerById(@PathVariable @Valid int playerId) throws PlayerNotFoundException {
		return service.getPlayerById(playerId);
	}
	
	@PutMapping("/updatePlayer")
	public Player updatePlayer(@RequestBody @Valid PlayerDTO player) throws PlayerNotFoundException {
//		if(isPlayerValid(player)) {
//			return service.updatePlayerDetails(player);
//		}
		return service.updatePlayerDetails(player);

//		return null;
	}
	
	@DeleteMapping("/deletePlayerById/{id}")
	public String deletePlayerById(@PathVariable(name="id") @Valid int playerId) throws PlayerNotFoundException {
		service.deletePlayerById(playerId);
		return "Player with id: "+playerId+" deleted";
	}
	
	@GetMapping("/batsman-with-max-matches")
	public List<Player> batsmanWithMaxMatches(){
		return service.batsmanWithMaximumMatches();
	}
	
	@GetMapping("/bowler-with-min-matches")
	public List<Player> bowlerWithMinMatches(){
		return service.bowlerWithMinimumMatches();
	}
	
	
	
	@ResponseStatus(value=HttpStatus.ALREADY_REPORTED,reason="Player with Jersey number already present")
	@ExceptionHandler({PlayerWithJerseyNumberAlreadyExistException.class})
	public void createPlayerException() {
		logger.warn("Exception occured while updatin the player details...");
	}
	
	@ExceptionHandler({PlayerNotFoundException.class})
	public ResponseEntity<String> updatePlayerException(PlayerNotFoundException e) {
		logger.warn("Updating or Deleting null user tried....");
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
//	boolean isPlayerValid(PlayerDTO player) {
//		if(player.getPlayerId()>0 && player.getJerseyNumber()>0 && !player.getRole().isEmpty() && player.getTotalMatches()>=0) {
//			return true;
//		}
//		return false;
//	}
}
