package example.food.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeSearch {

	private String title;
	private String image;
	private List<Ingredient> usedIngredients;
	private List<Ingredient> missedIngredients;

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

	public List<Ingredient> getUsedIngredients() {
		return usedIngredients;
	}

	public void setUsedIngredients(List<Ingredient> usedIngredients) {
		this.usedIngredients = usedIngredients;
	}

	public List<Ingredient> getMissedIngredients() {
		return missedIngredients;
	}

	public void setMissedIngredients(List<Ingredient> missedIngredients) {
		this.missedIngredients = missedIngredients;
	}
}