<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="600" scrollable>
      <template v-slot:activator="{ on }">
        <v-btn slot="activator" v-on="on" :color="'primary darken-4'" elevation="3" icon outlined>
          <v-icon>
            {{ mealIcon }}
          </v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          {{ mealGroup }}
        </v-card-title>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import {MEAL_TYPE_TO_GROUP_NAME, MEAL_TYPE_TO_ICON} from '@/constants'

export default {
  name: "MealTypePopup",

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
      }
    }
  },

  created() {
    this.mealIcon = MEAL_TYPE_TO_ICON.get(this.mealType);
    this.mealGroup = MEAL_TYPE_TO_GROUP_NAME.get(this.mealType);
  }

}
</script>

<style scoped>

</style>