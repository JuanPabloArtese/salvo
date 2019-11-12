package com.codeoftheweb.salvo;

import com.codeoftheweb.salvo.models.Game;
import com.codeoftheweb.salvo.models.GamePlayer;
import com.codeoftheweb.salvo.models.Player;
import com.codeoftheweb.salvo.repository.GameRepository;
import com.codeoftheweb.salvo.repository.PlayerRepository;
import com.codeoftheweb.salvo.repository.gamePlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, gamePlayerRepository gamePlayerRepository) {
		return (args) -> {
			// save a couple of customers
			Player player1 = new Player("Jack");
			Player player2 = new Player("Chloe");
			Player player3 = new Player("Kim");
			Player player4 = new Player("David");
			Player player5 = new Player("Michelle");

			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);
			playerRepository.save(player5);

			Game game1 = new Game();


			GamePlayer gamePlayer1 = new GamePlayer(player1, game1);
			GamePlayer gamePlayer2= new GamePlayer(player2, game1);

			gameRepository.save(game1);
			gamePlayerRepository.save (gamePlayer1);
			gamePlayerRepository.save(gamePlayer2);

		};
	}
}
