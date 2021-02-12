<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="600px" persistent @keydown.enter="doAction()"
              @keydown.esc="isDialogOpen = false">
      <template v-slot:activator="{ on, attrs }">
        <v-btn v-if="action === 'Add'" v-bind="attrs" v-blur v-on="on" :class="buttonColor" class="mt-auto mb-auto ml-3"
               x-large @click="isDialogOpen = true">
          {{ action }} meal
        </v-btn>
        <v-btn v-else v-bind="attrs" v-blur v-on="on" :class="buttonColor"
               class="mt-auto mb-auto ml-3" @click="isDialogOpen = true">
          {{ action }} meal
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          {{ action }} meal
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-form>
                  <v-text-field ref="mealName" v-model="name" :rules="inputRules" label="Meal name"
                                required></v-text-field>
                </v-form>
              </v-col>
              <v-col cols="4">
                <v-form>
                  <v-select ref="meals" v-model="selectedTypes" :items="mealTypes" :rules="inputRules"
                            label="Meal types" multiple></v-select>
                </v-form>
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
              <v-btn class="primary" @click="doAction()">
                {{ action }} meal
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
import MealDataService from "@/services/MealDataService";

export default {
  name: "UpdateOrAddMealPopup",

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
      ],
    }
  },

  props: {
    action: {
      type: String,
      required: true
    },
    buttonColor: {
      type: String
    }
  },

  computed: {
    isCorrectMeal() {
      return this.$refs.mealName.validate() && this.$refs.meals.validate();
    }
  },

  methods: {
    doAction() {
      switch (this.action) {
        case 'Add':
          if (this.isCorrectMeal) {
            let meal = {
              name: this.name,
              description: this.description,
              recipeLink: this.recipeLink,
              mealType: this.selectedTypes,
              dietType: this.selectedDiets,
            };

            MealDataService.addMeal(meal)
                .catch(e => {
                  console.log(e);
                });
            this.$emit('changeMeal', this.selectedTypes);
            this.resetInput();
            this.isDialogOpen = false;
          } else {
            alert("Please fill out the required fields.");
          }
          break;
        case 'Update':
          break;
        default:
          console.log('Invalid action');
      }
    },
    resetInput() {
      this.name = '';
      this.selectedTypes = [];
      this.selectedDiets = [];
      this.recipeLink = '';
      this.description = '';
    }
  }
}
</script>

<style scoped>

</style>