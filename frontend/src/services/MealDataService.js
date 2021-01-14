import http from "../http-common";

class MealDataService {

    getMealsOfType(type) {
        return http.get('meals/type/' + type)
    }

}

export default new MealDataService();