<template>
  <section class="top-products">
    <div class="top-products-content container">
      <h2 class="title top-products__title">POPULAR PRODUCTS</h2>
      <div class="top-products__row row">
        <top-product-card-component
          class="col-xl-5 col-lg-5 col-sm-12 col-xs-12"
          v-for="product in getTopProducts"
          :key="product.id"
          :product="product"
        ></top-product-card-component>
      </div>
      <WhiteBtn class="top-products__white-btn">
        <router-link to="/menu">All menu</router-link>
      </WhiteBtn>
    </div>
  </section>
</template>

<script>
import TopProductCardComponent from '@/components/TopProductCardComponent.vue'
import { mapGetters, mapActions } from 'vuex'
import WhiteBtn from './UI/WhiteBtn.vue'

export default {
  components: { TopProductCardComponent, WhiteBtn },
  methods:{
    ...mapActions(['fetchTopProducts'])
  },

  computed: {
    ...mapGetters(['getTopProducts']),
  },
  mounted() {
    this.fetchTopProducts()
  },
}
</script>
