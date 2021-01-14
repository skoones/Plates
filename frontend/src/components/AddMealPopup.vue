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
              <v-col cols="12"> <!-- TODO - add checking if required is input -->
                <v-text-field label="Meal name" required></v-text-field>
              </v-col>
              <v-col cols="4">
                <v-select v-model="selectedTypes" :items="mealTypes" label="Meal types" multiple></v-select>
              </v-col>
              <v-col cols="4">
                <v-select v-model="selectedTypes" :items="dietTypes" label="Diet types" multiple></v-select>
              </v-col>
              <!--              <v-container>-->
              <!--                <v-row>-->
              <v-col cols="4">
                <v-text-field label="Recipe link"></v-text-field>
              </v-col>
              <!--                </v-row>-->
              <!--              </v-container>-->
              <v-col cols="12">
                <v-textarea v-model="recipeLink" label="Description"></v-textarea>
              </v-col>
            </v-row>
          </v-container>
          <v-container>
            <v-row :justify="'space-between'">
              <v-btn class="primary" @click="isDialogOpen = false">
                Close
              </v-btn>
              <v-btn class="primary" @click="isDialogOpen = false">
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
import {DIETS, MEAL_TYPES} from "@/constants";

export default {
  name: "AddMealPopup",

  data() {
    return {
      isDialogOpen: false,
      mealTypes: MEAL_TYPES,
      dietTypes: DIETS,
      recipeLink: '',
      selectedTypes: [],
      selectedDiets: []
    }
  }
}
</script>

<style scoped>

</style>