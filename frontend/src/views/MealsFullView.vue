<template>
  <div>
    <v-container class="ml-5" fluid>
      <v-row>
        <v-col cols="1">
          <v-btn :to="'/week'" class="primary" x-large>Back</v-btn>
        </v-col>
        <v-col cols="11">
          <v-toolbar class="primary">
            <v-toolbar-title>All meals</v-toolbar-title>
          </v-toolbar>
        </v-col>
      </v-row>
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