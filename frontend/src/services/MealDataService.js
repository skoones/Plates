import http from "../http-common";

class MealDataService {

    getMealsOfType(type) {
        return http.get('meals/type/' + type)
    }

    addMeal(meal) {
        return http.post('meals/', meal);
    }

    deleteMeal(id) {
        return http.delete('meals/' + id)
    }

    updateMeal(meal) {
        return http.put('meals/', meal);
    }
}

export default new MealDataService();