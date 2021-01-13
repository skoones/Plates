<template>
  <v-flex :color="'grey darken-3'" class="d-flex flex-row" flat tile>
    <v-card class="pt-3 pb-3" elevation="3" height="100%" outlined tile width="100%">
      <v-card-title class="text-h5 justify-center grey--text text--darken-4">
        {{ dayOfWeek }}
        <meal-type-popup v-if="isMeal && !isMealChosen" :meal-type="mealType"
                         @chooseMeal="setMeal($event)"></meal-type-popup>
        <meal-in-plan v-if="isMeal && isMealChosen" :meal="mealInfo" @deleteMeal="isMealChosen = false"></meal-in-plan>
      </v-card-title>
    </v-card>
  </v-flex>
</template>

<script>
import MealTypePopup from "@/components/MealTypePopup";
import MealInPlan from "@/components/MealInPlan";

export default {
  name: "PlanCell",

  components: {MealTypePopup, MealInPlan},

  props: {
    isMeal: {
      type: Boolean,
      required: true
    },
    dayOfWeek: {
      type: String
    },
    mealType: {
      type: String
    }
  },

  data() {
    return {
      isMealChosen: false,
      mealInfo: {
        mealName: {
          type: String,
          required: true
        },
        dietTypes: {
          type: Array
        }
      }
    }
  },

  methods: {
    setMeal(meal) {
      this.isMealChosen = true;
      this.mealInfo = meal;
      console.log(meal.mealName);
    }
  }
}
</script>

<style scoped>

</style>