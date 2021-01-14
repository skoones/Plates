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
        <!--       <v-container v-for="meal in mealsOfType.meals" :key="meal.mealName">-->
        <meal-details-popup v-for="meal in mealsOfType.meals" :key="meal.mealName" :meal-info="meal"
                            class="ma-3"></meal-details-popup>
        <!--       </v-container>-->
      </v-card-text>


    </v-card>
  </div>
</template>

<script>
import {DIETS, LOW_CALORIE, VEGETARIAN} from "@/constants";
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

  computed: {},

  data() {
    return {
      meals: [ // hardcoded for now
        {
          mealName: 'Scrambled eggs',
          dietTypes: [
            VEGETARIAN,
            LOW_CALORIE
          ]
        },
        {
          mealName: 'Salmon sandwiches',
          dietTypes: [
            LOW_CALORIE
          ]
        },
      ],
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