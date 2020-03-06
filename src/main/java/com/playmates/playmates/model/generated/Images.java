package com.playmates.playmates.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Images{

	@JsonProperty("small")
	private String small;

	@JsonProperty("original")
	private String original;

	@JsonProperty("large")
	private String large;

	@JsonProperty("thumb")
	private String thumb;

	@JsonProperty("medium")
	private String medium;

	public void setSmall(String small){
		this.small = small;
	}

	public String getSmall(){
		return small;
	}

	public void setOriginal(String original){
		this.original = original;
	}

	public String getOriginal(){
		return original;
	}

	public void setLarge(String large){
		this.large = large;
	}

	public String getLarge(){
		return large;
	}

	public void setThumb(String thumb){
		this.thumb = thumb;
	}

	public String getThumb(){
		return thumb;
	}

	public void setMedium(String medium){
		this.medium = medium;
	}

	public String getMedium(){
		return medium;
	}

	@Override
 	public String toString(){
		return 
			"Images{" + 
			"small = '" + small + '\'' + 
			",original = '" + original + '\'' + 
			",large = '" + large + '\'' + 
			",thumb = '" + thumb + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}