<template>
  <v-container fluid>
    <v-row>
      <v-col v-for="mealType in allMeals" :key="mealType.groupName">
        <meals-of-one-type-list :key="componentKey" :group-name="mealType.groupName"
                                @changeMeal="rerender"></meals-of-one-type-list>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import MealsOfOneTypeList from "@/components/MealsOfOneTypeList";
import {EventBus} from "@/constants";

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
      componentKey: 0
    }
  },

  methods: {
    rerender() {
      this.componentKey += 1;
    }
  },

  created() {
    EventBus.$on('reloadLists', () => {
      this.rerender();
    });
  }
}
</script>

<style scoped>

</style>