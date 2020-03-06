package com.playmates.playmates.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class BoardGame{

	@JsonProperty("games")
	private List<GamesItem> games;

	public void setGames(List<GamesItem> games){
		this.games = games;
	}

	public List<GamesItem> getGames(){
		return games;
	}

	@Override
 	public String toString(){
		return 
			"BoardGame{" + 
			"games = '" + games + '\'' + 
			"}";
		}
	}