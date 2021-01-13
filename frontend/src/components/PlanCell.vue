<template>
  <v-flex :color="'grey darken-3'" class="d-flex flex-row" flat tile>
    <v-card class="pt-3 pb-3" elevation="3" height="100%" outlined tile width="100%">
      <v-card-title class="text-h5 justify-center grey--text text--darken-4">
        {{ dayOfWeek }}
        <meal-type-popup v-if="isMeal" :meal-type="mealType"></meal-type-popup>
      </v-card-title>
    </v-card>
  </v-flex>
</template>

<script>
import MealTypePopup from "@/components/MealTypePopup";

export default {
  name: "PlanCell",

  components: {MealTypePopup},

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
    }
  }
}
</script>

<style scoped>

</style>