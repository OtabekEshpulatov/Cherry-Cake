<template>
  <div class="menu-submited__modal-win">
    <div class="menu-submited-content">
      <img src="@/assets/img/check.svg" alt="check image" />
      <span class="menu-submited-title"
        >ORder created <br />
        successfully !</span
      >
      <router-link to="/menu" class="menu-submited-btn">return to menu page</router-link>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
.menu-submited-content{
  width: 100%;
  height: 100%;
}
</style>