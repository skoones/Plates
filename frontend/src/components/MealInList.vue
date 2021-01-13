<template>
  <div>
    <v-card>
      <v-card-title>
        {{ mealInfo.mealName }}
        <v-spacer></v-spacer>
        <v-tooltip top>
          <template v-slot:activator="{ on, attrs }">
            <v-icon v-if="mealInfo.isVegetarian" v-bind="attrs" v-on="on" right>
              {{ vegetarianIcon }}
            </v-icon>
          </template>
          <span>vegetarian</span>
        </v-tooltip>
        <v-tooltip top>
          <template v-slot:activator="{ on, attrs }">
            <v-icon v-if="mealInfo.isVegan" v-bind="attrs" v-on="on">
              {{ veganIcon }}
            </v-icon>
          </template>
          <span>vegan</span>
        </v-tooltip>
        <v-tooltip top>
          <template v-slot:activator="{ on, attrs }">
            <v-icon v-if="mealInfo.isLowCalorie" v-bind="attrs" v-on="on">
              {{ lowCalorieIcon }}
            </v-icon>
          </template>
          <span>low calorie</span>
        </v-tooltip>
      </v-card-title>
    </v-card>
  </div>
</template>

<script>
import {DIET_TYPE_TO_ICON} from "@/constants";

export default {
  name: "MealInList",

  props: {
    mealInfo: {
      mealName: {
        type: String,
        required: true
      },
      isVegetarian: {
        type: Boolean
      },
      isVegan: {
        type: Boolean
      },
      isLowCalorie: {
        type: Boolean
      }

    }
  },

  data() {
    return {
      vegetarianIcon: DIET_TYPE_TO_ICON.get('vegetarian'),
      veganIcon: DIET_TYPE_TO_ICON.get('vegan'),
      lowCalorieIcon: DIET_TYPE_TO_ICON.get('lowCalorie')
    }
  }
}
</script>

<style scoped>

</style>