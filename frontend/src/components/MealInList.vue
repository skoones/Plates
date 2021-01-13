<template>
  <div>
    <v-card>
      <v-card-title>
        {{ mealInfo.mealName }}
        <v-spacer></v-spacer>
        <diet-icon v-if="isVegetarian" :diet-type="'vegetarian'"></diet-icon>
        <diet-icon v-if="isVegan" :diet-type="'vegan'"></diet-icon>
        <diet-icon v-if="isLowCalorie" :diet-type="'low-calorie'"></diet-icon>
      </v-card-title>
    </v-card>
  </div>
</template>

<script>
import DietIcon from "@/components/DietIcon";

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
    return {}
  },

  computed: {
    isVegan() {
      return this.mealInfo.dietTypes.includes('vegan');
    },
    isVegetarian() {
      return this.mealInfo.dietTypes.includes('vegetarian');
    },
    isLowCalorie() {
      return this.mealInfo.dietTypes.includes('low-calorie');
    }
  }
}
</script>

<style scoped>

</style>