<template>
  <div class="top-card">
    <div class="top-card__left col-xl-6 col-md-6 col-sm-4 col-xs-4">
      <img
        :src="product.picture"
        :srcset="`${product.picture} 1200w, ${product.picture} 768w, ${product.picture} 320w`"
        sizes="(max-width: 320px) 320px,
         (max-width: 768px) 768px,
         1200px"
        alt="Product image"
      />
    </div>
    <div class="top-card__right col-xl-6 col-lg-6 col-md-5 col-sm-8 col-xs-8">
      <div class="top-card__title">
        <h3 class="top-card__name">{{ product.name }}</h3>
        <div class="top-card__price">
          <span>{{ product.price }}$</span>
        </div>
      </div>
      <span class="top-card__size">{{ product.size }}</span>
      <div class="top-card__description">
        <h4>DESCRIPTION</h4>
        <p>{{ product.description }}</p>
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
