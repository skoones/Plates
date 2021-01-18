<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="800px">
      <template v-slot:activator="{ on, attrs }">
        <v-card v-bind="attrs" v-on="on" class="btn-fix" @click="isDialogOpen = true">
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
                    <v-list-group v-if="mealInfo.dietTypes">
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
                          <v-list-item-title class="list-wrap" v-text="mealInfo.recipeLink"></v-list-item-title>
                        </v-list-item-content>
                      </v-list-item>
                    </v-list-group>
                  </v-list>
                </v-card>
              </v-col>
            </v-row>
            <v-row :justify="'center'">
              <v-col cols="12">
                <v-card class="scroll" max-height="200px">
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
import {LOW_CALORIE, MAP_TO_DTO_DIET_TYPE, VEGAN, VEGETARIAN} from "@/constants";
import MealDataService from "@/services/MealDataService";

export default {
  name: "MealDetailsPopup",

  props: {
    mealInfo: {
      type: Object,
      required: true
    }
  },

  components: {DietIcon},

  // extract code below to mixin!!!
  data() {
    return {
      vegan: VEGAN,
      vegetarian: VEGETARIAN,
      lowCalorie: LOW_CALORIE,
      isDialogOpen: false,
    }
  },

  computed: {
    isVegan() {
      return this.mealInfo.dietType.includes(MAP_TO_DTO_DIET_TYPE.get(VEGAN));
    },
    isVegetarian() {
      return this.mealInfo.dietType.includes(MAP_TO_DTO_DIET_TYPE.get(VEGETARIAN));
    },
    isLowCalorie() {
      return this.mealInfo.dietType.includes(MAP_TO_DTO_DIET_TYPE.get(LOW_CALORIE));
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
/* solves vuetify bug with focus staying on button for too long */
.btn-fix:focus::before {
  opacity: 0 !important;
}

.btn-fix:hover::before {
  opacity: 0.08 !important;
}

.list-wrap {
  white-space: normal;
}

/* TODO - maybe find a nicer way of doing this */
.scroll {
  overflow-y: scroll
}
</style>