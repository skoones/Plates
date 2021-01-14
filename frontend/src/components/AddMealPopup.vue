<template>
  <div>
    <v-dialog v-model="dialog" max-width="600px" persistent>
      <template v-slot:activator="{ on, attrs }">
        <v-btn v-bind="attrs" v-on="on" class="primary mt-auto mb-auto ml-3" x-large @click="dialog = true">
          Add meal
        </v-btn>
      </template>
      <v-card>
        <v-btn class="primary" @click="dialog = false">
          Close
        </v-btn>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {
  name: "AddMealPopup",

  data() {
    return {
      dialog: false
    }

  }
}
</script>

<style scoped>

</style>