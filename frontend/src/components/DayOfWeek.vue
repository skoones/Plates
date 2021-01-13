<template>
  <div>
    <v-layout column>
      <v-flex flat tile>
        <plan-cell :day-of-week="dayName" :is-meal="false"></plan-cell>
        <plan-cell v-for="meal in dailyMeals" :key="meal" :is-meal="true"
                   :meal-type="meal"></plan-cell>
      </v-flex>
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