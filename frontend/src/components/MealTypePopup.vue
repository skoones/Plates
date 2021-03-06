<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="800" scrollable>
      <template #activator="{ on:dialog }">
        <v-tooltip top>
          <template #activator="{ on:tooltip }">
            <v-btn slot="activator" v-blur v-on="{...tooltip, ...dialog}"
                   elevation="3"
                   :color="'primary darken-4'" icon outlined
                   @click="getMealsOfType(mealType)">
              <v-icon>
                {{ mealIcon }}
              </v-icon>
            </v-btn>
          </template>
          <span>add {{ mealType }}</span>
        </v-tooltip>
      </template>
      <v-card>
        <v-toolbar class="primary mb-1" elevation="3" height="70%">
          <v-toolbar-title>
            {{ mealGroup }}
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <v-select v-model="desiredDiets" :items="diets" class="mt-3" label="Diet type" multiple>
          </v-select>
          <v-btn icon @click="showSearchBar = !showSearchBar">
            <v-icon>mdi-magnify</v-icon>
          </v-btn>
          <v-text-field v-if="showSearchBar" v-model="search" class="mt-2" color="primary darken-3"
                        single-line></v-text-field>
        </v-toolbar>
        <v-card-text style="height: 500px;">
          <v-container v-for="meal in filteredMealsByName" :key="meal.name">
            <meal-in-list :meal-info="meal" @chooseMeal="chooseMeal($event)"></meal-in-list>
          </v-container>
        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn color="primary darken-2" text @click="isDialogOpen = false;">
            Close
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import {DIETS, MAP_MEAL_TYPE_TO_ENDPOINT, MEAL_TYPE_TO_GROUP_NAME, MEAL_TYPE_TO_ICON,} from '@/constants'
import MealInList from "@/components/MealInList";
import MealDataService from "@/services/MealDataService";

export default {
  name: "MealTypePopup",

  components: {MealInList},

  props: {
    mealType: {
      type: String,
      required: true
    }
  },

  data() {
    return {
      isDialogOpen: false,
      mealGroup: {
        type: String
      },
      showSearchBar: false,
      search: '',
      meals: [],
      desiredDiets: [],
      diets: DIETS
    }
  },

  computed: {
    filteredMealsByName() {
      return this.filteredMealsByDiet.filter(meal =>
          meal.name.toLowerCase().match(this.search.toLowerCase().trim())
      );
    },
    filteredMealsByDiet() {
      return this.meals.filter(meal => this.matchesAllDesiredDiets(meal));
    }
  },

  methods: {
    matchesAllDesiredDiets(meal) {
      return this.desiredDiets.every(diet => meal.dietType.includes(diet));
    },
    chooseMeal(meal) {
      this.isDialogOpen = false;
      this.$emit('chooseMeal', meal);
    },
    getMealsOfType(type) {
      MealDataService.getMealsOfType(MAP_MEAL_TYPE_TO_ENDPOINT.get(type))
          .then(response => {
            this.meals = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  created() {
    this.mealIcon = MEAL_TYPE_TO_ICON.get(this.mealType);
    this.mealGroup = MEAL_TYPE_TO_GROUP_NAME.get(this.mealType);
  },

  // TODO - optimize
  mounted() {
    this.getMealsOfType(this.mealType);
  },

}
</script>

<style scoped>

</style>