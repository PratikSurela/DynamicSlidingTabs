package com.app.dynamicslidingtabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActorsItem{

	@SerializedName("country")
	@Expose
	private String country;

	@SerializedName("image")
	@Expose
	private String image;

	@SerializedName("children")
	@Expose
	private String children;

	@SerializedName("dob")
	@Expose
	private String dob;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("spouse")
	@Expose
	private String spouse;

	@SerializedName("height")
	@Expose
	private String height;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setChildren(String children){
		this.children = children;
	}

	public String getChildren(){
		return children;
	}

	public void setDob(String dob){
		this.dob = dob;
	}

	public String getDob(){
		return dob;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setSpouse(String spouse){
		this.spouse = spouse;
	}

	public String getSpouse(){
		return spouse;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"ActorsItem{" + 
			"country = '" + country + '\'' + 
			",image = '" + image + '\'' + 
			",children = '" + children + '\'' + 
			",dob = '" + dob + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",spouse = '" + spouse + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}