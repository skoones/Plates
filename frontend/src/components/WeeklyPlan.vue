<template>
  <div>
    <v-container fluid>
      <!-- TODO - w jaki sposób reprezentować posiłki? form, button, nazwa posiłku + button?-->
      <!--      <v-layout justify-center row>-->
      <!--        <v-flex :color="'grey darken-3'" class="d-flex flex-row mt-6" flat tile width="100%">-->
      <!--          <v-card v-for="day in daysOfWeek" :key="day" class="pt-3 pb-3" elevation="3"-->
      <!--                  outlined tile width="100%">-->
      <!--            <v-card-title class="text-h5 justify-center grey&#45;&#45;text text&#45;&#45;darken-4">{{ day }}</v-card-title>-->
      <!--          </v-card>-->
      <!--        </v-flex>-->
      <!--      </v-layout>-->
      <v-layout justify-center row>
        <v-flex>
          <day-of-week v-for="day in daysOfWeek" :key="day" :day-name="day"></day-of-week>
        </v-flex>
      </v-layout>


      <!--      <v-layout row>-->
      <!--        <plan-cell v-for="n in 7" :key="n" :meal-type="'breakfast'" :is-meal="true"></plan-cell>-->
      <!--      </v-layout>-->
      <!--      <v-layout row>-->
      <!--        <plan-cell v-for="n in 7" :key="n" :meal-type="'snack'" :is-meal="true"></plan-cell>-->
      <!--      </v-layout>-->
      <!--      <v-layout row>-->
      <!--        <plan-cell v-for="n in 7" :key="n" :meal-type="'lunch'" :is-meal="true"></plan-cell>-->
      <!--      </v-layout>-->
      <!--      <v-layout row>-->
      <!--        <plan-cell v-for="n in 7" :key="n" :meal-type="'snack'" :is-meal="true"></plan-cell>-->
      <!--      </v-layout>-->
      <!--      <v-layout row>-->
      <!--        <plan-cell v-for="n in 7" :key="n" :meal-type="'dinner'" :is-meal="true"></plan-cell>-->
      <!--      </v-layout>-->

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