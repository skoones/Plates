import http from "../http-common";

class MealDataService {
    getAllMeals() {
        return http.get('meals/');
    }

    getMealsOfType(type) {
        return http.get('meals/type/' + type)
    }
}

export default new MealDataService();