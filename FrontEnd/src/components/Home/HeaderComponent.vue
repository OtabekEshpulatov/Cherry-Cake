<template>
  <section class="header-section">
    <div class="header-section-content container">
      <img
        src="@/assets/img/header-1200.jpg"
        srcset="
          @/assets/img/header-1200.jpg 1200w,
          @/assets/img/header-768.jpg   768w,
          @/assets/img/header-320.jpg   320w
        "
        sizes="(max-width: 320px) 320px,
         (max-width: 768px) 768px,
         1200px"
        alt="main poster with cakes"
      />
      <div class="header-section-text">
        <h1 class="header-section__title">CHERRY CAKE CAFE</h1>
        <span class="header-section__sub-title">Ready to order?</span>
      </div>
    </div>
  </section>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
</style>