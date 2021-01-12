<template>
  <div>
    <v-layout column>
      <v-flex flat tile>
        <plan-cell :day-of-week="dayName" :is-meal="false"></plan-cell>
        <plan-cell :is-meal="true" :meal-type="'breakfast'"></plan-cell>
        <plan-cell :is-meal="true" :meal-type="'snack'"></plan-cell>
        <plan-cell :is-meal="true" :meal-type="'lunch'"></plan-cell>
        <plan-cell :is-meal="true" :meal-type="'snack'"></plan-cell>
        <plan-cell :is-meal="true" :meal-type="'dinner'"></plan-cell>
      </v-flex>
    </v-layout>
  </div>
</template>

<script>
import PlanCell from "@/components/PlanCell";

export default {
  name: "DayOfWeek",

  props: {
    dayName: {
      type: String,
      required: true
    }
  },

  components: {
    'plan-cell': PlanCell
  }
}
</script>

<style scoped>

</style>