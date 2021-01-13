<template>
  <div>
    <v-card>
      <v-card-title>
        {{ mealInfo.mealName }}
        <v-spacer></v-spacer>
        <diet-icon v-if="mealInfo.isVegetarian" :diet-type="'vegetarian'"></diet-icon>
        <diet-icon v-if="mealInfo.isVegan" :diet-type="'vegan'"></diet-icon>
        <diet-icon v-if="mealInfo.isLowCalorie" :diet-type="'low calorie'"></diet-icon>
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
      isVegetarian: {
        type: Boolean
      },
      isVegan: {
        type: Boolean
      },
      isLowCalorie: {
        type: Boolean
      }
    }
  },

  data() {
    return {
    }
  }
}
</script>

<style scoped>

</style>