<template>
  <div>
    <v-tooltip top>
      <template v-slot:activator="{ on, attrs }">
        <v-icon v-bind="attrs" v-on="on" right>
          {{ dietIcon }}
        </v-icon>
      </template>
      <span>{{ dietType }}</span>
    </v-tooltip>
  </div>
</template>

<script>
import {DIET_TYPE_TO_ICON} from "@/constants";

export default {
  name: "DietIcon",

  props: {
    dietType: {
      type: String,
      required: true
    }
  },

  data() {
    return {
      dietIcon: DIET_TYPE_TO_ICON.get(this.dietType)
    }
  }
}
</script>

<style scoped>

</style>