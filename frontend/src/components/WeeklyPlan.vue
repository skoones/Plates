<template>
  <div>
    <v-container fluid>
      <!-- TODO - w jaki sposób reprezentować posiłki? form, button, nazwa posiłku + button?-->
      <v-layout justify-center row>
        <!--          <v-card v-for="day in daysOfWeek"-->
        <!--                  :key="day">-->
        <!--                    <div>{{ day }}</div>-->
        <!--          </v-card>-->
        <v-flex
            :color="'grey darken-3'"
            class="d-flex flex-row mt-6"
            flat
            tile
            width="100%"
        >
          <v-card
              v-for="day in daysOfWeek"
              :key="day"
              class="pt-3 pb-3"
              elevation="3"
              outlined
              tile
              width="100%"
          >
            <v-card-title class="text-h5 justify-center grey--text text--darken-4">{{ day }}</v-card-title>
          </v-card>
        </v-flex>
      </v-layout>

      <v-layout row>
        <v-flex
            :color="'grey darken-3'"
            class="d-flex flex-row"
            flat
            tile
            width="100%"
        >
          <v-card
              v-for="day in daysOfWeek"
              :key="day"
              class="pt-3 pb-3"
              elevation="3"
              outlined
              tile
              width="100%"
          >
            <v-card-title class="text-subtitle-1 grey--text text--darken-4">
              <v-btn elevation="3" outlined>
                <v-icon>
                  emoji_food_beverage
                </v-icon>
              </v-btn>
            </v-card-title>
          </v-card>
        </v-flex>
      </v-layout>

      <v-layout row>
        <v-flex
            :color="'grey darken-3'"
            class="d-flex flex-row"
            flat
            tile
            width="100%"
        >
          <v-card
              v-for="day in daysOfWeek"
              :key="day"
              class="pt-3 pb-3"
              elevation="3"
              outlined
              tile
              width="100%"
          >
            <v-card-title class="text-subtitle-1 grey--text text--darken-4">
              Snack
              <v-dialog max-width="600px">
                <v-btn slot="activator" class="secondary ml-5" fab flat small>
                  <v-icon>add</v-icon>
                </v-btn>
              </v-dialog>
            </v-card-title>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>

export default {
  name: "WeeklyPlan",

  data: () => ({
    daysOfWeek: [
      'Monday',
      'Tuesday',
      'Wednesday',
      'Thursday',
      'Friday',
      'Saturday',
      'Sunday'
    ]
  })
}
</script>

<style scoped>

</style>