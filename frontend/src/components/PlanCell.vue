<template>
  <v-flex :color="'grey darken-3'" class="d-flex flex-row" flat tile>
    <v-card class="pt-3 pb-3" elevation="3" height="100%" outlined tile width="100%">
      <v-card-title class="text-h5 justify-center grey--text text--darken-4">
        {{ dayOfWeek }}
        <v-btn v-if="isMeal" :color="'primary darken-4'" elevation="3" icon outlined>
          <v-icon>
            {{ mealIcon }}
          </v-icon>
        </v-btn>
      </v-card-title>
    </v-card>
  </v-flex>
</template>

<script>
// import MEAL_TYPE_TO_ICON from '../constants'

export default {
  name: "PlanCell",

  props: {
    isMeal: {
      type: Boolean,
      required: true
    },
    dayOfWeek: {
      type: String
    },
    mealType: {
      type: String
    }
  },

  data() {
    return {
      MEAL_TYPE_TO_ICON: new Map([
        ['breakfast', 'mdi-toaster'],
        ['snack', 'mdi-food-apple'],
        ['lunch', 'mdi-pasta'],
        ['dinner', 'mdi-silverware']])
    }
  },

  created() {
    this.mealIcon = this.MEAL_TYPE_TO_ICON.get(this.mealType);
  }
}
</script>

<style scoped>

</style>