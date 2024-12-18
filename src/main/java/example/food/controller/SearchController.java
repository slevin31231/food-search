package example.food.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import example.food.entity.Recipe;
import example.food.entity.RecipeResponse;
import example.food.entity.RecipeSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Controller
public class SearchController {

	@Value("${api_key}")
	private String API_KEY;
	private static final String BASE_URL = "https://api.spoonacular.com/recipes";
	private final RestTemplate restTemplate;

	@Autowired
	public SearchController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/")
	public String home() {
		return "search";
	}

	@GetMapping("/search")
	public String getRecipeByIngredients(@RequestParam("query") String query, Model model) {
		if (query.isEmpty())
			return "redirect:/random";

		String[] words = query.replaceAll("[\\p{Punct}\\s]+", " ").trim().split("\\s+");
		String result = String.join(",", words);

		String url = String.format("%s/findByIngredients?ingredients=%s&number=100&apiKey=%s", BASE_URL, result, API_KEY);

		ResponseEntity<RecipeSearch[]> response = restTemplate.getForEntity(url, RecipeSearch[].class);

		if (response.getStatusCode().is2xxSuccessful() && response.hasBody() && response.getBody().length > 0) {
			int maxCount = response.getBody().length;
			RecipeSearch recipeSearch = response.getBody()[new Random().nextInt(maxCount)];
			model.addAttribute("recipeSearch", recipeSearch);
		} else {
			model.addAttribute("error", "Failed to find a recipe with the specified ingredient(s).");
		}

		return "search";
	}

	@GetMapping("/random")
	public String getRandomRecipe(Model model) throws JsonProcessingException {
		String url = String.format("%s/random?apiKey=%s", BASE_URL, API_KEY);

		ResponseEntity<RecipeResponse> response = restTemplate.getForEntity(url, RecipeResponse.class);

		if (response.getStatusCode().is2xxSuccessful() && response.hasBody()) {
			Recipe recipe = response.getBody().getRecipes().get(0);
			model.addAttribute("recipe", recipe);
		} else {
			model.addAttribute("error", "Failed to retrieve the recipe.");
			System.err.println("ALARM");
		}
		return "search";
	}
}
