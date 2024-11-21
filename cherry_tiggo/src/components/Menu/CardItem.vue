<template>
  <div class="menu-card">
    <ModalComponent v-if="imageModalWin">
      <div class="menu-card__modal-win">
        <button @click="imageModalWin = !imageModalWin" class="arrow-back">
          <img src="@/assets/img/arrow_back.svg" alt="arrow-back" />
        </button>
        <div class="modal-win__body">
          <div class="modal-win__img">
            <img :src="product.picture" :alt="product.imgDesc" />
          </div>
          <h3 class="modal-win__title">{{ product.name }}</h3>
          <div class="modal-win__text">
            <div class="modal-win__left">
              <span>Description</span>
              <p class="modal-win__description">{{ product.description }}</p>
            </div>
            <div class="modal-win__right">
              <div class="modal-win-raiting">
                <img
                  src="@/assets/img/stars.svg"
                  alt="raiting stars"
                  v-for="star in product.raiting"
                  :key="star"
                />
              </div>
              <span class="modal-win__price">Price: {{ product.price }}$</span>
            </div>
          </div>
        </div>
      </div>
    </ModalComponent>
    <ModalComponent v-if="orderModalWin">
      <div class="menu-order__modal-win">
        <div class="menu-order-content">
          <form class="menu-order__form">
            <div class="menu-order__form-head">
              <label for="quantity" class="menu-order__label">ENTER ORDER quantity:</label>
              <button class="menu-order__close" @click="orderModalWin = !orderModalWin">
                <img src="@/assets/img/Close_Button.svg" alt="close_button" />
              </button>
            </div>
            <input
              type="number"
              class="menu-order__input"
              id="quantity"
              aria-describedby="basic-addon3"
            />
            <div class="menu-order__dropdown">
              <label for="region" class="menu-order__label">pLEASE CHOOSE YOUR REGION:</label>
              <select id="region" class="menu-order__input">
                <option value="" disabled selected class="d-none"></option>
                <option value="uzb">Uzbekistan</option>
                <option value="kaz">Kazakhstan</option>
                <option value="geo">Georgia</option>
                <option value="ukr">Ukraine</option>
                <option value="chn">China</option>
              </select>
            </div>
          </form>
        </div>
      </div>
    </ModalComponent>
    <div class="menu-card-content">
      <button @click="imageModalWin = !imageModalWin">
        <img :src="product.picture" :alt="product.imgDesc" />
      </button>
      <div class="menu-card-body">
        <h3 class="menu-card__title">{{ product.name }}</h3>
        <div class="menu-card__price">
          <span>{{ product.price }}</span
          >$
        </div>
      </div>
    </div>
    <button class="menu-btn" @click="orderModalWin = !orderModalWin">Order</button>
  </div>
</template>

<script>
import ModalComponent from '@/components/ModalComponent.vue'
export default {
  components: { ModalComponent },
  data() {
    return {
      imageModalWin: false,
      orderModalWin: false,
    }
  },
  props: {
    product: {
      type: Object,
      require: true,
    },
  },
}
</script>

<style lang="scss" scoped>
</style>