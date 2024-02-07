package com.hexaware.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.cricket.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	@Query("select p from Player p WHERE p.role = 'Batsman' and p.totalMatches = (select max(p1.totalMatches) from Player p1 where p1.role = 'Batsman')")
	List<Player> getBatsmanWithMaximumMatches();
	
	@Query("select p from Player p WHERE p.role = 'Bowler' and p.totalMatches = (select min(p1.totalMatches) from Player p1 where p1.role = 'Bowler')")
	List<Player> getBowlerWithMinimumMatches();
}
