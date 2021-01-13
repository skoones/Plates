<template>
  <div>
    <v-card>
      <v-card-title>
        {{ mealInfo.mealName }}
        <v-spacer></v-spacer>
        <diet-icon v-if="isVegetarian" :diet-type="vegetarian"></diet-icon>
        <diet-icon v-if="isVegan" :diet-type="vegan"></diet-icon>
        <diet-icon v-if="isLowCalorie" :diet-type="lowCalorie"></diet-icon>
      </v-card-title>
    </v-card>
  </div>
</template>

<script>
import DietIcon from "@/components/DietIcon";
import {LOW_CALORIE, VEGAN, VEGETARIAN} from "@/constants";

export default {
  name: "MealInList",
  components: {DietIcon},
  props: {
    mealInfo: {
      mealName: {
        type: String,
        required: true
      },
      dietTypes: {
        type: Array
      }
    }
  },

  data() {
    return {
      vegan: VEGAN,
      vegetarian: VEGETARIAN,
      lowCalorie: LOW_CALORIE
    }
  },

  computed: {
    isVegan() {
      return this.mealInfo.dietTypes.includes(VEGAN);
    },
    isVegetarian() {
      return this.mealInfo.dietTypes.includes(VEGETARIAN);
    },
    isLowCalorie() {
      return this.mealInfo.dietTypes.includes(LOW_CALORIE);
    }
  }
}
</script>

<style scoped>

</style>