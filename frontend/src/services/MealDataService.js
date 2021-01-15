import http from "../http-common";

class MealDataService {

    getMealsOfType(type) {
        return http.get('meals/type/' + type)
    }

    addMeal(meal) {
        return http.post('meals/', meal);
    }

}

export default new MealDataService();