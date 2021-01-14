<template>
  <div>
    <v-card outline raised>
      <v-toolbar class="primary darken-1 font-weight-bold">
        <v-toolbar-title>
          {{ mealsOfType.groupName }}
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-col cols="4">
          <v-select v-model="desiredDiets" :items="diets" class="mt-3" label="Diet type" multiple>
          </v-select>
        </v-col>

        <v-btn icon @click="showSearchBar = !showSearchBar">
          <v-icon>mdi-magnify</v-icon>
        </v-btn>
        <v-text-field v-if="showSearchBar" v-model="search" class="mt-2" color="primary darken-3"
                      single-line></v-text-field>

      </v-toolbar>
      <v-card-text>
        <meal-details-popup v-for="meal in filteredMealsByName" :key="meal.mealName" :meal-info="meal"
                            class="ma-3"></meal-details-popup>
      </v-card-text>


    </v-card>
  </div>
</template>

<script>
import {DIETS} from "@/constants";
import MealDetailsPopup from "@/components/MealDetailsPopup";

export default {
  name: "MealsOfOneTypeList",

  components: {MealDetailsPopup},

  props: {
    mealsOfType: {
      type: Object,
      required: true
    }
  },

  computed: {
    filteredMealsByName() {
      return this.filteredMealsByDiet.filter(meal =>
          meal.mealName.toLowerCase().match(this.search.toLowerCase().trim())
      );
    },
    filteredMealsByDiet() {
      return this.mealsOfType.meals.filter(meal => this.matchesAllDesiredDiets(meal));
    }
  },

  methods: {
    matchesAllDesiredDiets(meal) {
      return this.desiredDiets.every(diet => meal.dietTypes.includes(diet));
    }
  },

  data() {
    return {
      desiredDiets: [],
      search: '',
      diets: DIETS,
      showSearchBar: false
    }
  }
}
</script>

<style scoped>

</style>