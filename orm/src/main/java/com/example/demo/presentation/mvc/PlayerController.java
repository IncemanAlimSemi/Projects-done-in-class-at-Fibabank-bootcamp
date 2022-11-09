package com.example.demo.presentation.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.configuration.MyBean;
import com.example.demo.data.entity.Player;
import com.example.demo.data.repository.PlayerRepository;

@Controller
@RequestMapping("/sports")
public class PlayerController {
	
	private PlayerRepository playerRepository;
	
	private MyBean myBean;
	
	public PlayerController(PlayerRepository playerRepository, MyBean myBean) {
		this.playerRepository = playerRepository;
		this.myBean = myBean;
	}
	
	@GetMapping("/players/byteam")
	@ResponseBody
	public String getPlayersByTeam() {
		System.out.println("Çekirdek " + myBean.getMyLong() + " " + myBean.getMyString() + " " + myBean.getMyDouble());
		long teamId = 1;
		List<Player> players = playerRepository.findAllByTeamId(teamId);
		double totalScore = 0;
		for (Player player : players) {
			System.out.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
			totalScore += player.getAverageScore();
		}
		
		double averageScore = totalScore / players.size();
		return "Ortalama çentik: " + averageScore;
	}
	
}

