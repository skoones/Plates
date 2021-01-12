<template>
  <v-container class="mt-5">
    <h1 class="text-center text-h2 grey--text text--darken-3 mb-5">Weekly plan</h1>
    <v-divider class="mb-5"></v-divider>
    <weekly-plan></weekly-plan>
  </v-container>

</template>

<script>
import WeeklyPlan from "@/components/WeeklyPlan";

export default {
  name: "WeeklyView",

  components: {
    'weekly-plan': WeeklyPlan
  }
}
</script>

<style scoped>

</style>