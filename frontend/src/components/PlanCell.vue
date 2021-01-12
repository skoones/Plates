<template>
  <v-flex :color="'grey darken-3'" class="d-flex flex-row" flat tile>
    <v-card class="pt-3 pb-3" elevation="3" outlined tile width="100%">
      <v-card-title class="text-h5 justify-center grey--text text--darken-4">
        <v-btn :color="'primary darken-4'" elevation="3" icon outlined>
          <v-icon>
            {{ mealIcon }}
          </v-icon>
        </v-btn>
      </v-card-title>
    </v-card>
  </v-flex>
</template>

<script>
export default {
  props: {
    mealIcon: {
      type: String,
      required: true
    }
  },
  name: "PlanCell"
}
</script>

<style scoped>

</style>