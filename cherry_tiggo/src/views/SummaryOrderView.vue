<template>
  <div class="menu-submited__modal-win" role="dialog" aria-labelledby="dialog-title"
    aria-describedby="dialog-description" tabindex="-1" @keydown.esc="closeModal">
    <div class="menu-submited-content">
      <img src="@/assets/img/check.svg" alt="Order successfully created" />
      <h2 id="dialog-title">Order created successfully!</h2>
      <p id="dialog-description">
        Your order has been successfully created. You can return to the menu page.
      </p>
      <router-link to="/menu" class="btn white-btn" aria-label="Return to menu page"> Return to menu page </router-link>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
.white-btn{
  background: white;
  color: black;
  border-radius: 30px;
}
</style>
