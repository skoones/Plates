<template>
  <v-container fluid>
    <v-row>
      <v-col v-for="mealType in allMeals" :key="mealType.groupName">
        <meals-of-one-type-list :meals-of-type="mealType"></meals-of-one-type-list>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import {LOW_CALORIE, VEGAN, VEGETARIAN} from "@/constants";
import MealsOfOneTypeList from "@/components/MealsOfOneTypeList";

export default {
  name: "MealAllLists",

  components: {MealsOfOneTypeList},

  data() {
    return {
      allMeals: [
        {
          groupName: 'Breakfasts',
          meals: [ // hardcoded for now, will be obtained via http request
            {
              mealName: 'Scrambled eggs',
              dietTypes: [
                VEGETARIAN,
                LOW_CALORIE
              ]
            },
            {
              mealName: 'Salmon sandwiches',
              dietTypes: [
                LOW_CALORIE
              ]
            },
            {
              mealName: 'Spaghetti with spinach',
              dietTypes: [
                VEGETARIAN
              ]
            },
            {
              mealName: 'Cappricciosa omelette',
              dietTypes: []
            }
          ],

        },
        {
          groupName: 'Snacks',
          meals: [
            {
              mealName: 'Peanut butter balls',
              dietTypes: [
                VEGETARIAN,
                VEGAN
              ]
            },
            {
              mealName: 'Smoothie',
              dietTypes: [
                VEGETARIAN,
                VEGAN
              ]
            },
          ]
        },
        {
          groupName: 'Lunches',
          meals: []
        },
        {
          groupName: 'Dinners',
          meals: []
        }
      ]
    }
  }

}
</script>

<style scoped>

</style>