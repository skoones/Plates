<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="800px">
      <template v-slot:activator="{ on, attrs }">
        <v-card v-bind="attrs" v-on="on" class="card-fix" @click="isDialogOpen = true">
          <v-card-title>
            {{ mealInfo.name }}
            <v-spacer></v-spacer>
            <diet-icon v-if="isVegetarian" :diet-type="vegetarian"></diet-icon>
            <diet-icon v-if="isVegan" :diet-type="vegan"></diet-icon>
            <diet-icon v-if="isLowCalorie" :diet-type="lowCalorie"></diet-icon>
          </v-card-title>
        </v-card>
      </template>
      <v-card>
        <v-card-title>
          {{ mealInfo.name }}
        </v-card-title>
        <v-divider></v-divider>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="4">
                <v-card>
                  <v-list>
                    <v-list-group>
                      <template v-slot:activator>
                        <v-list-item-content>
                          <v-list-item-title v-text="'Meal types'"></v-list-item-title>
                        </v-list-item-content>
                      </template>
                      <v-list-item v-for="meal in mealInfo.mealType" :key="meal">
                        <v-list-item-content>
                          <v-list-item-title v-text="meal"></v-list-item-title>
                        </v-list-item-content>
                      </v-list-item>
                    </v-list-group>
                  </v-list>
                </v-card>
              </v-col>
              <v-col cols="4">
                <v-card>
                  <v-list>
                    <v-list-group v-if="mealInfo.dietType">
                      <template v-slot:activator>
                        <v-list-item-content>
                          <v-list-item-title v-text="'Diet types'"></v-list-item-title>
                        </v-list-item-content>
                      </template>
                      <v-list-item v-for="diet in mealInfo.dietType" :key="diet">
                        <v-list-item-content>
                          <v-list-item-title v-text="diet"></v-list-item-title>
                        </v-list-item-content>
                      </v-list-item>
                    </v-list-group>
                    <v-list-group v-else>
                      <template v-slot:activator>
                        <v-list-item-content>
                          <v-list-item-title v-text="'Diet types'"></v-list-item-title>
                        </v-list-item-content>
                      </template>
                    </v-list-group>
                  </v-list>
                </v-card>
              </v-col>
              <v-col cols="4">
                <v-card>
                  <v-list>
                    <v-list-group>
                      <template v-slot:activator>
                        <v-list-item-content>
                          <v-list-item-title v-text="'Recipe link'"></v-list-item-title>
                        </v-list-item-content>
                      </template>
                      <v-list-item>
                        <v-list-item-content>
                          <v-list-item-title class="list-wrap" v-html="linkToRecipe"></v-list-item-title>
                        </v-list-item-content>
                      </v-list-item>
                    </v-list-group>
                  </v-list>
                </v-card>
              </v-col>
            </v-row>
            <v-row :justify="'center'">
              <v-col cols="12">
                <v-card max-height="200px">
                  <v-card-text class="grey--text text--darken-3">
                    {{ mealInfo.description }}
                  </v-card-text>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
          <v-container>
            <v-row :justify="'space-between'">
              <v-btn class="primary" @click="isDialogOpen = false">
                Close
              </v-btn>
              <update-or-add-meal-popup :action="'Update'"
                                        :button-color="'primary darken-1'"
                                        :meal-info="mealInfo"></update-or-add-meal-popup>
              <v-btn class="alert white--text" @click="isDialogOpen = false; deleteMeal(mealInfo)">
                Delete meal
              </v-btn>
            </v-row>
          </v-container>
        </v-card-text>
      </v-card>
    </v-dialog>

  </div>
</template>

<script>
import DietIcon from "@/components/DietIcon";
import {LOW_CALORIE, VEGAN, VEGETARIAN} from "@/constants";
import MealDataService from "@/services/MealDataService";
import UpdateOrAddMealPopup from "@/components/UpdateOrAddMealPopup";

export default {
  name: "MealDetailsPopup",

  props: {
    mealInfo: {
      type: Object,
      required: true
    }
  },

  components: {UpdateOrAddMealPopup, DietIcon},

  // extract code below to mixin!!!
  data() {
    return {
      vegan: VEGAN,
      vegetarian: VEGETARIAN,
      lowCalorie: LOW_CALORIE,
      isDialogOpen: false,
      linkToRecipe: "<a href='" + this.mealInfo.recipeLink + "'>" + this.mealInfo.recipeLink + "</a>"
    }
  },

  computed: {
    isVegan() {
      return this.mealInfo.dietType.includes(VEGAN);
    },
    isVegetarian() {
      return this.mealInfo.dietType.includes(VEGETARIAN);
    },
    isLowCalorie() {
      return this.mealInfo.dietType.includes(LOW_CALORIE);
    }
  },

  methods: {
    deleteMeal(meal) {
      MealDataService.deleteMeal(meal.id)
          .catch(e => {
            console.log(e);
          });
      this.$emit('deleteMeal');
    }
  }
}
</script>

<style scoped>
/* solves vuetify bug with focus staying on card for too long */
.card-fix:focus::before {
  opacity: 0 !important;
}

.card-fix:hover::before {
  opacity: 0.08 !important;
}

.list-wrap {
  white-space: normal;
}

</style>