<template>
  <div>
    <v-card outline raised>
      <v-toolbar class="primary darken-1 font-weight-bold">
        <v-toolbar-title>
          {{ groupName }}
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
        <meal-details-popup v-for="meal in filteredMealsByName" :key="meal.name" :meal-info="meal"
                            class="ma-3" @deleteMeal="deleteMeal"></meal-details-popup>
      </v-card-text>


    </v-card>
  </div>
</template>

<script>
import {DIETS, MAP_FROM_GROUP_TO_MEAL_TYPE, MAP_TO_DTO_DIET_TYPE} from "@/constants";
import MealDetailsPopup from "@/components/MealDetailsPopup";
import MealDataService from "@/services/MealDataService";

export default {
  name: "MealsOfOneTypeList",

  components: {MealDetailsPopup},

  props: {
    groupName: {
      type: String,
      required: true
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
      return this.desiredDiets.every(diet => meal.dietType.includes(MAP_TO_DTO_DIET_TYPE.get(diet)));
    },
    getMealsOfType(type) {
      MealDataService.getMealsOfType(type)
          .then(response => {
            this.meals = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },
    deleteMeal() {
      this.$forceUpdate();
    },
    loadMealList() {
      this.getMealsOfType(this.mealType);
    }

  },

  data() {
    return {
      desiredDiets: [],
      search: '',
      diets: DIETS,
      showSearchBar: false,
      mealType: MAP_FROM_GROUP_TO_MEAL_TYPE.get(this.groupName),
      meals: []
    }
  },

  mounted() {
    this.loadMealList();
  },

  updated() {
    this.loadMealList();
  }
}
</script>

<style scoped>

</style>