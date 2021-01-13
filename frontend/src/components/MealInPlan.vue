<template>
    <v-card-text class="text-h6 text-wrap">
      {{ meal.mealName }}
      <v-btn icon @click="deleteMeal">
        <v-icon>
          mdi-trash-can
        </v-icon>
      </v-btn>
    </v-card-text>
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
  },

  methods: {
    deleteMeal() {
      this.$emit('deleteMeal', this.meal)
    }
  }
}
</script>

<style scoped>

</style>