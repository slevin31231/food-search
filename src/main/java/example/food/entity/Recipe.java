package example.food.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

	private String title;
	private String image;
	private String instructions;
	private List<Ingredient> extendedIngredients;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<Ingredient> getExtendedIngredients() {
		return extendedIngredients;
	}

	public void setExtendedIngredients(List<Ingredient> extendedIngredients) {
		this.extendedIngredients = extendedIngredients;
	}
}