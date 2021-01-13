<template>
  <div>
    <v-container class="mx-5" fluid>
      <v-card class="d-flex flex-row" flat>
        <v-btn :to="'/week'" class="primary mt-auto mb-auto mx-5" left x-large>
          Back
        </v-btn>
        <v-toolbar class="primary">
          <v-toolbar-title>
            All meals
          </v-toolbar-title>
        </v-toolbar>
      </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "MealsFullView"
}
</script>

<style scoped>

</style>