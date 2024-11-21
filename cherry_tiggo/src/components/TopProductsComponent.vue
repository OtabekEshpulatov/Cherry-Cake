<template>
  <section class="top-products">
    <div class="top-products-content container">
      <h2 class="title top-products__title">POPULAR PRODUCTS</h2>
      <div class="top-products__row row">
      <top-product-card-component
      class="col-5"
        v-for="product in getTopProducts"
        :key="product.id"
        :product="product"
      ></top-product-card-component>
      </div>
      <WhiteBtn
      class="top-products__white-btn"
      placeholder="ALL Menu"
      />
    </div>
  </section>
</template>

<script>
import TopProductCardComponent from "@/components/TopProductCardComponent.vue";
import { mapGetters } from "vuex";
import WhiteBtn from './UI/WhiteBtn.vue';

export default {
  components: { TopProductCardComponent,WhiteBtn },
  computed: {
    ...mapGetters(["getTopProducts"]),
  },
};
</script>
