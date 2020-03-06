package com.playmates.playmates.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class GamesItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("thumb_url")
	private String thumbUrl;

	@JsonProperty("developers")
	private List<Object> developers;

	@JsonProperty("num_user_ratings")
	private int numUserRatings;

	@JsonProperty("description")
	private String description;

	@JsonProperty("discount")
	private String discount;

	@JsonProperty("min_players")
	private int minPlayers;

	@JsonProperty("spec")
	private List<SpecItem> spec;

	@JsonProperty("artists")
	private List<String> artists;

	@JsonProperty("price")
	private String price;

	@JsonProperty("msrp")
	private String msrp;

	@JsonProperty("reddit_all_time_count")
	private int redditAllTimeCount;

	@JsonProperty("reddit_week_count")
	private int redditWeekCount;

	@JsonProperty("publishers")
	private List<String> publishers;

	@JsonProperty("matches_specs")
	private Object matchesSpecs;

	@JsonProperty("id")
	private String id;

	@JsonProperty("max_playtime")
	private int maxPlaytime;

	@JsonProperty("categories")
	private List<CategoriesItem> categories;

	@JsonProperty("year_published")
	private int yearPublished;

	@JsonProperty("min_playtime")
	private int minPlaytime;

	@JsonProperty("historical_low_price")
	private double historicalLowPrice;

	@JsonProperty("images")
	private Images images;

	@JsonProperty("designers")
	private List<String> designers;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("mechanics")
	private List<MechanicsItem> mechanics;

	@JsonProperty("primary_publisher")
	private String primaryPublisher;

	@JsonProperty("url")
	private String url;

	@JsonProperty("historical_low_date")
	private HistoricalLowDate historicalLowDate;

	@JsonProperty("names")
	private List<String> names;

	@JsonProperty("reddit_day_count")
	private int redditDayCount;

	@JsonProperty("official_url")
	private String officialUrl;

	@JsonProperty("rules_url")
	private String rulesUrl;

	@JsonProperty("max_players")
	private int maxPlayers;

	@JsonProperty("min_age")
	private int minAge;

	@JsonProperty("description_preview")
	private String descriptionPreview;

	@JsonProperty("average_user_rating")
	private double averageUserRating;

	@JsonProperty("size_depth")
	private int sizeDepth;

	@JsonProperty("size_units")
	private String sizeUnits;

	@JsonProperty("size_width")
	private double sizeWidth;

	@JsonProperty("size_height")
	private double sizeHeight;

	@JsonProperty("weight_amount")
	private int weightAmount;

	@JsonProperty("weight_units")
	private String weightUnits;

	public void setThumbUrl(String thumbUrl){
		this.thumbUrl = thumbUrl;
	}

	public String getThumbUrl(){
		return thumbUrl;
	}

	public void setDevelopers(List<Object> developers){
		this.developers = developers;
	}

	public List<Object> getDevelopers(){
		return developers;
	}

	public void setNumUserRatings(int numUserRatings){
		this.numUserRatings = numUserRatings;
	}

	public int getNumUserRatings(){
		return numUserRatings;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setDiscount(String discount){
		this.discount = discount;
	}

	public String getDiscount(){
		return discount;
	}

	public void setMinPlayers(int minPlayers){
		this.minPlayers = minPlayers;
	}

	public int getMinPlayers(){
		return minPlayers;
	}

	public void setSpec(List<SpecItem> spec){
		this.spec = spec;
	}

	public List<SpecItem> getSpec(){
		return spec;
	}

	public void setArtists(List<String> artists){
		this.artists = artists;
	}

	public List<String> getArtists(){
		return artists;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setMsrp(String msrp){
		this.msrp = msrp;
	}

	public String getMsrp(){
		return msrp;
	}

	public void setRedditAllTimeCount(int redditAllTimeCount){
		this.redditAllTimeCount = redditAllTimeCount;
	}

	public int getRedditAllTimeCount(){
		return redditAllTimeCount;
	}

	public void setRedditWeekCount(int redditWeekCount){
		this.redditWeekCount = redditWeekCount;
	}

	public int getRedditWeekCount(){
		return redditWeekCount;
	}

	public void setPublishers(List<String> publishers){
		this.publishers = publishers;
	}

	public List<String> getPublishers(){
		return publishers;
	}

	public void setMatchesSpecs(Object matchesSpecs){
		this.matchesSpecs = matchesSpecs;
	}

	public Object getMatchesSpecs(){
		return matchesSpecs;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMaxPlaytime(int maxPlaytime){
		this.maxPlaytime = maxPlaytime;
	}

	public int getMaxPlaytime(){
		return maxPlaytime;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public void setYearPublished(int yearPublished){
		this.yearPublished = yearPublished;
	}

	public int getYearPublished(){
		return yearPublished;
	}

	public void setMinPlaytime(int minPlaytime){
		this.minPlaytime = minPlaytime;
	}

	public int getMinPlaytime(){
		return minPlaytime;
	}

	public void setHistoricalLowPrice(double historicalLowPrice){
		this.historicalLowPrice = historicalLowPrice;
	}

	public double getHistoricalLowPrice(){
		return historicalLowPrice;
	}

	public void setImages(Images images){
		this.images = images;
	}

	public Images getImages(){
		return images;
	}

	public void setDesigners(List<String> designers){
		this.designers = designers;
	}

	public List<String> getDesigners(){
		return designers;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setMechanics(List<MechanicsItem> mechanics){
		this.mechanics = mechanics;
	}

	public List<MechanicsItem> getMechanics(){
		return mechanics;
	}

	public void setPrimaryPublisher(String primaryPublisher){
		this.primaryPublisher = primaryPublisher;
	}

	public String getPrimaryPublisher(){
		return primaryPublisher;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHistoricalLowDate(HistoricalLowDate historicalLowDate){
		this.historicalLowDate = historicalLowDate;
	}

	public HistoricalLowDate getHistoricalLowDate(){
		return historicalLowDate;
	}

	public void setNames(List<String> names){
		this.names = names;
	}

	public List<String> getNames(){
		return names;
	}

	public void setRedditDayCount(int redditDayCount){
		this.redditDayCount = redditDayCount;
	}

	public int getRedditDayCount(){
		return redditDayCount;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOfficialUrl(String officialUrl){
		this.officialUrl = officialUrl;
	}

	public String getOfficialUrl(){
		return officialUrl;
	}

	public void setRulesUrl(String rulesUrl){
		this.rulesUrl = rulesUrl;
	}

	public String getRulesUrl(){
		return rulesUrl;
	}

	public void setMaxPlayers(int maxPlayers){
		this.maxPlayers = maxPlayers;
	}

	public int getMaxPlayers(){
		return maxPlayers;
	}

	public void setMinAge(int minAge){
		this.minAge = minAge;
	}

	public int getMinAge(){
		return minAge;
	}

	public void setDescriptionPreview(String descriptionPreview){
		this.descriptionPreview = descriptionPreview;
	}

	public String getDescriptionPreview(){
		return descriptionPreview;
	}

	public void setAverageUserRating(double averageUserRating){
		this.averageUserRating = averageUserRating;
	}

	public double getAverageUserRating(){
		return averageUserRating;
	}

	public void setSizeDepth(int sizeDepth){
		this.sizeDepth = sizeDepth;
	}

	public int getSizeDepth(){
		return sizeDepth;
	}

	public void setSizeUnits(String sizeUnits){
		this.sizeUnits = sizeUnits;
	}

	public String getSizeUnits(){
		return sizeUnits;
	}

	public void setSizeWidth(double sizeWidth){
		this.sizeWidth = sizeWidth;
	}

	public double getSizeWidth(){
		return sizeWidth;
	}

	public void setSizeHeight(double sizeHeight){
		this.sizeHeight = sizeHeight;
	}

	public double getSizeHeight(){
		return sizeHeight;
	}

	public void setWeightAmount(int weightAmount){
		this.weightAmount = weightAmount;
	}

	public int getWeightAmount(){
		return weightAmount;
	}

	public void setWeightUnits(String weightUnits){
		this.weightUnits = weightUnits;
	}

	public String getWeightUnits(){
		return weightUnits;
	}

	@Override
 	public String toString(){
		return 
			"GamesItem{" + 
			"thumb_url = '" + thumbUrl + '\'' + 
			",developers = '" + developers + '\'' + 
			",num_user_ratings = '" + numUserRatings + '\'' + 
			",description = '" + description + '\'' + 
			",discount = '" + discount + '\'' + 
			",min_players = '" + minPlayers + '\'' + 
			",spec = '" + spec + '\'' + 
			",artists = '" + artists + '\'' + 
			",price = '" + price + '\'' + 
			",msrp = '" + msrp + '\'' + 
			",reddit_all_time_count = '" + redditAllTimeCount + '\'' + 
			",reddit_week_count = '" + redditWeekCount + '\'' + 
			",publishers = '" + publishers + '\'' + 
			",matches_specs = '" + matchesSpecs + '\'' + 
			",id = '" + id + '\'' + 
			",max_playtime = '" + maxPlaytime + '\'' + 
			",categories = '" + categories + '\'' + 
			",year_published = '" + yearPublished + '\'' + 
			",min_playtime = '" + minPlaytime + '\'' + 
			",historical_low_price = '" + historicalLowPrice + '\'' + 
			",images = '" + images + '\'' + 
			",designers = '" + designers + '\'' + 
			",image_url = '" + imageUrl + '\'' + 
			",mechanics = '" + mechanics + '\'' + 
			",primary_publisher = '" + primaryPublisher + '\'' + 
			",url = '" + url + '\'' + 
			",historical_low_date = '" + historicalLowDate + '\'' + 
			",names = '" + names + '\'' + 
			",reddit_day_count = '" + redditDayCount + '\'' + 
			",name = '" + name + '\'' + 
			",official_url = '" + officialUrl + '\'' + 
			",rules_url = '" + rulesUrl + '\'' + 
			",max_players = '" + maxPlayers + '\'' + 
			",min_age = '" + minAge + '\'' + 
			",description_preview = '" + descriptionPreview + '\'' + 
			",average_user_rating = '" + averageUserRating + '\'' + 
			",size_depth = '" + sizeDepth + '\'' + 
			",size_units = '" + sizeUnits + '\'' + 
			",size_width = '" + sizeWidth + '\'' + 
			",size_height = '" + sizeHeight + '\'' + 
			",weight_amount = '" + weightAmount + '\'' + 
			",weight_units = '" + weightUnits + '\'' + 
			"}";
		}
}