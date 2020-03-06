package com.playmates.playmates.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class HistoricalLowDate{

	@JsonProperty("$date")
	private String date;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"HistoricalLowDate{" + 
			"$date = '" + date + '\'' + 
			"}";
		}
}