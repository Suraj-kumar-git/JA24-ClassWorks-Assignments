package com.hexaware.cricket.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlayerDTO {

	private int playerId;
	
	@NotBlank(message = "Player name should be there")
	private String playerName;

	@Min(1)
	private int jerseyNumber;

	@NotEmpty(message = "Player Role should be assigned")
	private String role;

	@Max(500)
	private int totalMatches;

	@Size(min = 2, max = 40, message = "Team name must be greaterThan 4 characters and lessThan 40 characters")
	private String teamName;

	@NotNull(message = "For which country the player is playing")
	private String countryName;

	@Size(min = 15, max = 500, message = "Write a brief description about the player")
	private String playerDescription;

	public PlayerDTO() {
		super();
	}

	public PlayerDTO(int playerId,String playerName, int jerseyNumber, String role, int totalMatches, String teamName,
			String countryName, String playerDescription) {
		this.playerId=playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.countryName = countryName;
		this.playerDescription = playerDescription;
	}

	
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPlayerDescription() {
		return playerDescription;
	}

	public void setPlayerDescription(String playerDescription) {
		this.playerDescription = playerDescription;
	}

}
