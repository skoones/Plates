<template>
  <v-card elevation="3" height="10vh" outlined tile>
    <v-card-title class="text-h5 justify-center">
      <div v-if="isMeal">
        <div v-if="isMealChosen">
          <meal-in-plan :meal="mealInfo" @deleteMeal="isMealChosen = false"></meal-in-plan>
        </div>
        <div v-else>
          <meal-type-popup :meal-type="mealType" class="pt-3 pb-3" @chooseMeal="setMeal($event)"></meal-type-popup>
        </div>
      </div>
      <div v-else>
        <span class="primary--text text--darken-3 font-weight-bold">{{ dayOfWeek }}</span>
      </div>
    </v-card-title>
  </v-card>
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
        name: {
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
    }
  }
}
</script>

<style scoped>

</style>