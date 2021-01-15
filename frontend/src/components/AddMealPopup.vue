<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="600px" persistent>
      <template v-slot:activator="{ on, attrs }">
        <v-btn v-bind="attrs" v-on="on" class="primary mt-auto mb-auto ml-3" x-large @click="isDialogOpen = true">
          Add meal
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          Add meal
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field v-model="name" :rules="inputRules" label="Meal name" required></v-text-field>
              </v-col>
              <v-col cols="4">
                <v-select v-model="selectedTypes" :items="mealTypes" :rules="inputRules" label="Meal types"
                          multiple></v-select>
              </v-col>
              <v-col cols="4">
                <v-select v-model="selectedDiets" :items="dietTypes" label="Diet types" multiple></v-select>
              </v-col>
              <v-col cols="4">
                <v-text-field v-model="recipeLink" label="Recipe link"></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-textarea v-model="description" label="Description"></v-textarea>
              </v-col>
            </v-row>
          </v-container>
          <v-container>
            <v-row :justify="'space-between'">
              <v-btn class="primary" @click="isDialogOpen = false">
                Close
              </v-btn>
              <v-btn class="primary" @click="saveMeal(); isDialogOpen = false">
                Add meal
              </v-btn>
            </v-row>
          </v-container>


        </v-card-text>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import {DIETS, MAP_TO_DTO_DIET_TYPE, MAP_TO_DTO_MEAL_TYPE, MEAL_TYPES} from "@/constants";
import MealDataService from "@/services/MealDataService";

export default {
  name: "AddMealPopup",

  data() {
    return {
      isDialogOpen: false,
      mealTypes: MEAL_TYPES,
      dietTypes: DIETS,
      recipeLink: '',
      selectedTypes: [],
      selectedDiets: [],
      description: '',
      name: '',
      inputRules: [
        input => input.length > 0 || 'This field can\'t be empty.'
      ]
    }
  },

  methods: {
    saveMeal() {
      this.createDtoDietTypes();
      this.createDtoMealTypes();
      let meal = {
        name: this.name,
        description: this.description,
        recipeLink: this.recipeLink,
        mealType: this.selectedTypes,
        dietType: this.selectedDiets,
      };

      MealDataService.addMeal(meal)
          .then(response => {
            console.log(response.data)
          })
          .catch(e => {
            console.log(e);
          });
    },
    createDtoMealTypes() {
      this.selectedTypes = this.selectedTypes.map(type => MAP_TO_DTO_MEAL_TYPE.get(type));
    },
    createDtoDietTypes() {
      this.selectedDiets = this.selectedDiets.map(diet => MAP_TO_DTO_DIET_TYPE.get(diet));
    }
  }
}
</script>

<style scoped>

</style>