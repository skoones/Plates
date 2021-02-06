<template>
  <div>
    <v-card @click="chooseMeal">
      <v-card-title>
        {{ mealInfo.name }}
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
      name: {
        type: String,
        required: true
      },
      dietType: {
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
      return this.mealInfo.dietType.includes(VEGAN);
    },
    isVegetarian() {
      return this.mealInfo.dietType.includes(VEGETARIAN);
    },
    isLowCalorie() {
      return this.mealInfo.dietType.includes(LOW_CALORIE);
    }
  },

  methods: {
    chooseMeal() {
      this.$emit('chooseMeal', this.mealInfo);
    }
  }
}
</script>

<style scoped>

</style>