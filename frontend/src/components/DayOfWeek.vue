<template>
  <div>
    <v-layout column>
      <plan-cell :day-of-week="dayName" :is-meal="false" flat tile></plan-cell>
      <plan-cell v-for="meal in dailyMeals" :key="meal" :is-meal="true" :meal-type="meal" flat tile></plan-cell>
    </v-layout>
  </div>
</template>


<script>
import PlanCell from "@/components/PlanCell";
import {DAILY_MEALS} from "@/constants";

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
  },

  data() {
    return {
      dailyMeals: DAILY_MEALS
    }
  }
}
</script>

<style scoped>

</style>