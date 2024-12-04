<template>
  <div class="menu-card">
    <!-- Modal Component: Accessible for screen readers -->
    <ModalComponent v-if="imageModalWin">
      <div
        class="menu-card__modal-win"
        role="dialog"
        aria-labelledby="modal-title"
        aria-describedby="modal-description"
      >
        <button
          @click="imageModalWin = !imageModalWin"
          class="arrow-back"
          aria-label="Close image modal"
        >
          <i class="fa-solid fa-arrow-left-long"></i>
        </button>
        <div class="modal-win__body">
          <div class="modal-win__img">
            <img
              :src="product.picture"
              :alt="product.imgDesc"
              :srcset="`${product.picture} 1200w, ${product.picture} 768w, ${product.picture} 320w`"
              sizes="(max-width: 320px) 320px, (max-width: 768px) 768px, 1200px"
            />
          </div>
          <h3 class="modal-win__title" id="modal-title">{{ product.name }}</h3>
          <div class="modal-win__text" id="modal-description">
            <div class="modal-win__left">
              <span>Description</span>
              <p class="modal-win__description">{{ product.description }}</p>
            </div>
            <div class="modal-win__right">
              <div class="modal-win-raiting" role="group" aria-label="Rating">
                <i
                  class="fa-regular fa-star"
                  v-for="star in Math.ceil(product.rating)"
                  :key="star"
                  aria-hidden="true"
                ></i>
              </div>
              <span class="modal-win__price">Price: {{ product.price }}$</span>
            </div>
          </div>
        </div>
      </div>
    </ModalComponent>

    <!-- Menu Card Content -->
    <div class="menu-card-content">
      <!-- Image button with accessible alt text and description for screen readers -->
      <button
        @click="imageModalWin = !imageModalWin"
        aria-label="View product image of {{ product.name }}"
      >
        <img
          :src="product.picture"
          :srcset="`${product.picture} 1200w, ${product.picture} 768w, ${product.picture} 320w`"
          sizes="(max-width: 320px) 320px, (max-width: 768px) 768px, 1200px"
          :alt="product.imgDesc"
        />
      </button>

      <div class="menu-card-body">
        <h3 class="menu-card__title">{{ product.name }}</h3>
        <div class="menu-card__price">
          <span>{{ product.price }}$</span>
        </div>
      </div>
    </div>

    <!-- Order Buttons with Accessible Interactions -->
    <div class="menu-order-btns">
      <!-- Order Button with Mouse and Keyboard Accessibility -->
      <button
        class="menu-btn"
        v-show="!isOrdering"
        @mouseenter="showOrderQuantity"
        @focus="showOrderQuantity"
        aria-label="Click to order {{ product.name }}"
      >
        Order
      </button>

      <!-- Order Quantity Buttons -->
      <div class="menu-order-quantity" v-show="isOrdering" @mouseleave="resetOrderView">
        <button
          class="menu-order-quantity__btn"
          @click="minusOrRemoveCart()"
          aria-label="Decrease quantity of {{ product.name }}"
        >
          <i class="fa-solid fa-minus"></i>
        </button>
        <span>{{ productAmount }}</span>
        <button
          class="menu-order-quantity__btn"
          @click="addToCart()"
          aria-label="Increase quantity of {{ product.name }}"
        >
          <i class="fa-solid fa-plus"></i>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import ModalComponent from '@/components/UI/ModalComponent.vue'
import { mapGetters, mapActions } from 'vuex'
export default {
  computed: {
    ...mapGetters(['getCartProducts']),
  },
  props: {
    product: {
      type: Object,
      require: true,
    },
  },
  components: { ModalComponent },
  data() {
    return {
      imageModalWin: false,
      isOrdering: false,
      productAmount: 0,
    }
  },
  methods: {
    ...mapActions(['addOrUpdateCart', 'minusorDeleteCart']),
    addToCart() {
      this.addOrUpdateCart(this.product)
      this.showOrderQuantity()
    },
    showOrderQuantity() {
      this.isOrdering = true
      const cartProduct = this.getCartProducts.find(
        (cartProduct) => cartProduct.id === this.product.id
      )
      if (cartProduct) {
        this.productAmount = cartProduct.quantity
      } else {
        this.productAmount = 0
      }
    },
    minusOrRemoveCart() {
      this.minusorDeleteCart(this.product)
      this.showOrderQuantity()
    },
    resetOrderView() {
      if (this.productAmount === 0) {
        this.isOrdering = false
      }
    },
  },
}
</script>
