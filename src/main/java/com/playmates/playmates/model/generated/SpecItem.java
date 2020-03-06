package com.playmates.playmates.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SpecItem{

	@JsonProperty("id")
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"SpecItem{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}