<template>
  <div>
    <v-container fluid>
      <v-row dense>
        <v-col cols="1">
          <v-btn :to="'/week'" class="primary mt-auto mb-auto" x-large>
            Back
          </v-btn>
        </v-col>
        <v-col align-self="center" cols="11">
          <v-toolbar class="primary">
            <v-spacer></v-spacer>
            <v-toolbar-title class="text-h5 font-weight-bold">
              All meals
            </v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
        </v-col>
      </v-row>
    </v-container>
    <meal-all-lists></meal-all-lists>
  </div>
</template>

<script>

import MealAllLists from "@/components/MealAllLists";

export default {
  name: "MealsFullView",

  components: {MealAllLists},

  data() {
    return {
      meals: {
        breakfasts: [],
        snacks: [],
        lunches: [],
        dinners: []
      }
    }
  }
}
</script>

<style scoped>

</style>