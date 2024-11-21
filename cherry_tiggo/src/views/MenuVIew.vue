<template>
  <section class="menu">
    <h2 class="title">MENU</h2>
    <div class="menu-content container">
      <GridComponent />
    </div>
  </section>
</template>

<script>
import GridComponent from '@/components/Menu/GridComponent.vue'
export default {
  components: {
    GridComponent,
  },
}
</script>

<style lang="scss" scoped>
</style>