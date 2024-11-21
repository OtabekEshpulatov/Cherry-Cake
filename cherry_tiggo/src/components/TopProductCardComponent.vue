<template>
  <div class="top-card">
    <div class="top-card__left">
      <!-- Простой путь для доступа к изображениям в папке public -->
      <img
        :src="product.picture"
        alt="Product image"
      />
    </div>
    <div class="top-card__right">
      <div class="top-card__title">
        <h3 class="top-card__name">{{product.name}}</h3>
        <div class="top-card__price">
          <span>{{product.price}}$</span>
        </div>
      </div>
      <span class="top-card__size">{{product.size}}</span>
      <div class="top-card__description">
        <h4>DESCRIPTION</h4>
        <p>{{product.description}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    product: {
      type: Object,
      required: true,
    },
  },
}
</script>
