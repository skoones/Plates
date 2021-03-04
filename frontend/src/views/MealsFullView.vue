<template>
  <div>
    <v-container fluid>
      <v-row dense>
        <v-col cols="1">
          <v-btn :to="'/week'" class="primary mt-auto mb-auto" x-large>
            Back
          </v-btn>
        </v-col>
        <v-col align-self="center" cols="10">
          <v-toolbar class="primary">
            <v-spacer></v-spacer>
            <v-toolbar-title class="text-h5 font-weight-bold">
              All meals
            </v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
        </v-col>
        <v-col :justify="'space-between'" cols="1">
          <update-or-add-meal-popup :action="'Add'" :button-color="'primary'"
                                    @changeMeal="changeLists($event)"></update-or-add-meal-popup>
        </v-col>
      </v-row>
    </v-container>
    <meal-all-lists ref="mealLists"></meal-all-lists>
  </div>
</template>

<script>

import MealAllLists from "@/components/MealAllLists";
import {EventBus} from "@/constants";
import UpdateOrAddMealPopup from "@/components/UpdateOrAddMealPopup";

export default {
  name: "MealsFullView",

  components: {UpdateOrAddMealPopup, MealAllLists},

  data() {
    return {
      meals: {
        breakfasts: [],
        snacks: [],
        lunches: [],
        dinners: []
      }
    }
  },

  methods: {
    changeLists(types) {
      EventBus.$emit('reloadLists', types);
    }
  }
}
</script>

<style scoped>

</style>