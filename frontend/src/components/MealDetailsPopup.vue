<template>
  <div>
    <v-dialog v-model="isDialogOpen" max-width="800px">
      <template v-slot:activator="{ on, attrs }">
        <v-card v-bind="attrs" v-on="on" class="btn-fix" @click="isDialogOpen = true">
          <v-card-title>
            {{ mealInfo.mealName }}
            <v-spacer></v-spacer>
            <diet-icon v-if="isVegetarian" :diet-type="vegetarian"></diet-icon>
            <diet-icon v-if="isVegan" :diet-type="vegan"></diet-icon>
            <diet-icon v-if="isLowCalorie" :diet-type="lowCalorie"></diet-icon>
          </v-card-title>
        </v-card>
      </template>
      <v-card>
        <v-card-title>
          {{ mealInfo.mealName }}
        </v-card-title>
        <v-divider></v-divider>
        <v-container>
          <v-row :justify="'center'">
            <v-col cols="12">
              <v-textarea readonly>
                {{ description }}
              </v-textarea>
            </v-col>
          </v-row>
        </v-container>
        <v-card-text>
          <v-btn class="primary" @click="isDialogOpen = false">
            Close
          </v-btn>
        </v-card-text>
      </v-card>
    </v-dialog>

  </div>
</template>

<script>
import DietIcon from "@/components/DietIcon";
import {LOW_CALORIE, VEGAN, VEGETARIAN} from "@/constants";

export default {
  name: "MealDetailsPopup",

  props: {
    mealInfo: {
      mealName: {
        type: String,
        required: true
      }
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
      dietTypes: [],
      mealTypes: [],
      description: 'asd'
    }
  },

  computed: {
    isVegan() {
      return this.mealInfo.dietTypes.includes(VEGAN);
    },
    isVegetarian() {
      return this.mealInfo.dietTypes.includes(VEGETARIAN);
    },
    isLowCalorie() {
      return this.mealInfo.dietTypes.includes(LOW_CALORIE);
    }
  },
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
</style>