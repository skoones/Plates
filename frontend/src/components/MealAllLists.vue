<template>
  <v-container fluid>
    <v-row>
      <v-col v-for="mealType in allMeals" :key="mealType.groupName">
        <meals-of-one-type-list :group-name="mealType.groupName"></meals-of-one-type-list>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import MealsOfOneTypeList from "@/components/MealsOfOneTypeList";

export default {
  name: "MealAllLists",

  components: {MealsOfOneTypeList},

  data() {
    return {
      allMeals: [
        {
          groupName: 'Breakfasts',
        },
        {
          groupName: 'Snacks',
        },
        {
          groupName: 'Lunches',
        },
        {
          groupName: 'Dinners',
        }
      ],
    }
  },
}
</script>

<style scoped>

</style>