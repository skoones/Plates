<template>
  <div>
    <v-card-text>{{ meal.mealName }}</v-card-text>
  </div>
</template>

<script>
export default {
  name: "MealInPlan",

  props: {
    meal: {
      mealName: {
        type: String,
        required: true
      },
      dietTypes: {
        type: Array
      }
    }
  }
}
</script>

<style scoped>

</style>