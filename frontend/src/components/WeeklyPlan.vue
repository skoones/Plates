<template>
  <div>
    <v-container fluid>
      <!-- TODO - w jaki sposób reprezentować posiłki? form, button, nazwa posiłku + button?-->
      <v-layout justify-center row>
        <v-flex v-for="day in daysOfWeek" :key="day">
          <day-of-week :day-name="day"></day-of-week>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import DayOfWeek from "@/components/DayOfWeek";

export default {
  name: "WeeklyPlan",
  components: {
    'day-of-week': DayOfWeek
  },
  data: () => ({
    daysOfWeek: [
      'Monday',
      'Tuesday',
      'Wednesday',
      'Thursday',
      'Friday',
      'Saturday',
      'Sunday'
    ]
  })
}
</script>

<style scoped>

</style>