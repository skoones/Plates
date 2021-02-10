<template>
  <v-tooltip top>
    <template #activator="{ on:tooltip }">
      <v-card-text slot="activator" v-on="{...tooltip}" class="text-h6">
        {{ mealName }}
        <v-btn icon @click="deleteMeal">
          <v-icon>
            mdi-trash-can
          </v-icon>
        </v-btn>
      </v-card-text>
    </template>
    <span>{{ meal.name }}</span>
  </v-tooltip>

</template>

<script>
export default {
  name: "MealInPlan",

  props: {
    meal: {
      name: {
        type: String,
        required: true
      },
      dietTypes: {
        type: Array
      }
    }
  },

  computed: {
    mealName() {
      let name;
      name = this.meal.name.slice(0, 10).trim();
      if (name.length < this.meal.name.length) {
        name += "...";
      }
      return name;
    }
  },

  methods: {
    deleteMeal() {
      this.$emit('deleteMeal', this.meal)
    }
  }
}
</script>

<style scoped>

</style>