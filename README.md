# Food Search
An application for searching dishes by ingredients or finding random recipes.

Docker is required.

1. Clone the repository
2. Navigate to `src/main/resources/` and rename the file `application.properties.origin` to `application.properties`
3. Open this file and add your `api_key`, which can be obtained by visiting the link https://spoonacular.com/food-api/console#Profile (free registration allows up to 150 requests per day)
4. To create a Docker image, execute the following command:

```bash
docker build . -t food-search
```
5. To run the Docker image, execute the following command:

```bash
docker run -p 8080:8080 food-search
```
6. Go to the link http://localhost:8080.
7. Enter the ingredient name(s) in the search bar and click `Find`.
8. Refresh the page (`Ctrl + R`) to display the next dish.
9. To search for random recipes click `Find` without entering anything in the search bar.