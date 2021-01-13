<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="600" scrollable>
      <template #activator="{ on:dialog }">
        <v-tooltip top>
          <template #activator="{ on:tooltip }">
            <v-btn slot="activator" v-on="{...tooltip, ...dialog}" :color="'primary darken-4'" class="btn-fix"
                   elevation="3" icon outlined>
              <v-icon>
                {{ mealIcon }}
              </v-icon>
            </v-btn>
          </template>
          <span>add {{ mealType }}</span>
        </v-tooltip>
      </template>
      <v-card>
        <v-toolbar class="primary mb-1" elevation="3">
          <v-toolbar-title>
            {{ mealGroup }}
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn icon @click="showSearchBar = !showSearchBar">
            <v-icon>mdi-magnify</v-icon>
          </v-btn>
          <v-text-field v-if="showSearchBar" class="mt-2" color="primary darken-3" single-line></v-text-field>
        </v-toolbar>
        <v-card-text style="height: 300px;">
          <v-container v-for="meal in meals" :key="meal.mealName">
            <meal-in-list :meal-info="meal"></meal-in-list>
          </v-container>

        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn color="primary darken-2" text @click="isDialogOpen = false">
            Close
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import {MEAL_TYPE_TO_GROUP_NAME, MEAL_TYPE_TO_ICON} from '@/constants'
import MealInList from "@/components/MealInList";

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
      meals: [
        {
          mealName: 'jajecznica',
          isVegetarian: true,
          isVegan: true,
          isLowCalorie: true
        },
        {
          mealName: 'jajecznica',
          isVegetarian: true,
          isVegan: false,
          isLowCalorie: true
        },
        {
          mealName: 'jajecznica',
          isVegetarian: true,
          isVegan: false,
          isLowCalorie: true
        },
        {
          mealName: 'jajecznica',
          isVegetarian: true,
          isVegan: false,
          isLowCalorie: true
        }
      ]
    }
  },

  created() {
    this.mealIcon = MEAL_TYPE_TO_ICON.get(this.mealType);
    this.mealGroup = MEAL_TYPE_TO_GROUP_NAME.get(this.mealType);
  }

}
</script>

<style scoped>
.btn-fix:focus::before {
  opacity: 0 !important;
}

/* solves vuetify bug with focus staying on button for too long */
.btn-fix:hover::before {
  opacity: 0.08 !important;
}
</style>