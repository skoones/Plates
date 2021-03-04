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
                                v-if="action === 'Add'" required></v-text-field>
                  <v-text-field v-else ref="mealName" v-model="name" label="Meal name"
                                required></v-text-field>
                </v-form>
              </v-col>
              <v-col cols="4">
                <v-form>
                  <v-select ref="meals" v-model="selectedTypes" :items="mealTypes" :rules="inputRules"
                            v-if="action === 'Add'" label="Meal types" multiple></v-select>
                  <v-select v-else ref="meals" v-model="selectedTypes" :items="mealTypes"
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
    mealInfo: {
      type: Object,
      required: false
    },
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
      let element;
      let meal = {
        name: this.name,
        description: this.description,
        recipeLink: this.recipeLink,
        mealType: this.selectedTypes,
        dietType: this.selectedDiets,
      };

      switch (this.action) {
        case 'Add':
          if (this.isCorrectMeal) {
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
          for (element in meal) {
            if (meal[element].length !== 0) {
              this.mealInfo[element] = meal[element];
              console.log(this.mealInfo);
            }
          }
          MealDataService.updateMeal(this.mealInfo)
              .catch(e => {
                console.log(e);
              });
          this.$emit('changeMeal', this.selectedTypes);
          this.resetInput();
          this.isDialogOpen = false;
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