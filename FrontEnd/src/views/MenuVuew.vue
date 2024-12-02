<template>
  <section class="menu">
    <h2 class="title">MENU</h2>
    <div class="menu-content container">
      <GridComponent />
      <button class="menu-btn submit-btn" @click="this.isCardConfirmed = !this.isCardConfirmed">
        Complete
      </button>
      <ModalComponent v-show="isCardConfirmed && getCartProducts.length > 0">
        <div class="menu-order__modal-win">
          <div class="menu-cart-content">
            <button class="menu-order__close" @click="isCardConfirmed = !isCardConfirmed">
              <i class="fa-solid fa-xmark"></i>
            </button>
            <ul class="menu-cart-items">
              <li class="menu-cart__item" v-for="item in getCartProducts" :key="item.id">
                <img :src="item.picture" alt="product image" />
                <div class="menu-cart__item-text">
                  <h3 class="menu-cart__item-title">
                    Product name: <span>{{ item.name }}</span>
                  </h3>
                  <span class="menu-cart__item-quantity"
                    >Quantity: <span>{{ item.quantity }}</span></span
                  >
                </div>
              </li>
            </ul>
            <button class="menu-cart__submit menu-btn" @click="switchModalWins">
              Submit order
            </button>
          </div>
        </div>
      </ModalComponent>
      <ModalComponent v-show="isOrderConfirmed">
        <div class="menu-order__modal-win">
          <div class="menu-order-content">
            <form class="menu-order__form" @submit.prevent>
              <div class="menu-order__form-head">
                <button class="menu-order__close" @click="switchModalWins">
                  <i class="fa-solid fa-xmark"></i>
                </button>
              </div>
              <div class="menu-order__dropdown">
                <label for="region" class="menu-order__label">pLEASE CHOOSE YOUR REGION:</label>
                <div class="dropdown">
                  <button
                    class="btn dropdown-toggle menu-order__input"
                    type="button"
                    id="dropdownMenuButton1"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    {{ currentRegion.name }}
                  </button>
                  <ul
                    class="dropdown-menu menu-order__regions"
                    aria-labelledby="dropdownMenuButton1"
                  >
                    <li v-for="region in getRegions" :key="region.id" @click="setRegion(region)">
                      <a class="dropdown-item menu-order__region">{{ region.name }}</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="menu-order__date-total">
                <div class="menu-order__date" v-show="Object.keys(currentRegion).length > 0">
                  <label class="menu-order__label">Choose date of order:</label>
                  <v-date-picker color="#d5621d" v-model="date" :allowed-dates="isDateAllowed">
                  </v-date-picker>
                </div>
                <div
                  class="menu-order__total"
                  v-show="Object.keys(currentRegion).length > 0 && date !== null"
                >
                  <div class="menu-order__total-price">
                    <h3 class="menu-order__total-price-title">ORDER PRICE</h3>
                    <div class="menu-order__total-price-desc">
                      <div class="price-text">
                        <span class="price-title">price: </span>
                        <span class="price-value">{{ totalCardPrice }}$</span>
                      </div>
                      <div class="price-text">
                        <span class="price-title">Discount: </span>
                        <span class="price-value">-{{ totalDiscount }}$</span>
                      </div>
                      <div class="price-text">
                        <span class="price-title">Tax: </span>
                        <span class="price-value">{{ totalTax }}$</span>
                      </div>
                      <div class="price-text">
                        <span class="price-title">Total: </span>
                        <span class="price-value">{{ totalPrice }}$</span>
                      </div>
                    </div>
                  </div>
                  <button class="menu-btn menu-order__submit" @click="submitForm" type="submit">
                    submit
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </ModalComponent>
    </div>
  </section>
</template>

<script>
import GridComponent from '@/components/Menu/GridComponent.vue'
import ModalComponent from '@/components/UI/ModalComponent.vue'
import router from '@/router'

import { mapGetters, mapActions } from 'vuex'
export default {
  computed: {
    ...mapGetters(['getRegions', 'getCartProducts', 'getUserId']),
  },
  components: {
    GridComponent,
    ModalComponent,
  },
  methods: {
    ...mapActions(['cleanCart', 'createOrderDetails','cleanCartAct']),
    resetData() {
      this.isCardConfirmed = false
      this.isOrderConfirmed = false
      this.currentRegion = {}
      this.totalDiscount = null
      this.totalQuantity = null
      this.totalTax = null
      this.totalCardPrice = null
      this.totalPrice = null
      this.date = null


      this.cleanCartAct()
    },
    async submitForm() {
      this.isOrderConfirmed = !this.isOrderConfirmed
      let totalQuantity = null
      for (let product = 0; product < this.getCartProducts.length; product++) {
        const element = this.getCartProducts[product]
        totalQuantity = totalQuantity + element.quantity
      }
      const submitData = {
        quantity: totalQuantity,
        region: this.currentRegion.name,
        date: this.formatDate(this.date),
        price: this.totalPrice.toString(),
        userid: `11`,
      }
      console.log(JSON.stringify(submitData))
      await this.createOrderDetails(JSON.stringify(submitData))
      this.resetData();
      router.push({ path: '/summary-order' })
    },
    setRegion(currentRegion) {
      this.currentRegion = currentRegion
      this.getTotalPrice()
    },
    formatDate(date) {
      return `${date.getFullYear()}/${String(date.getMonth() + 1).padStart(2, '0')}/${String(
        date.getDate()
      ).padStart(2, '0')}`
    },
    getTotalPrice() {
      this.totalCardPrice = this.getCartProducts.reduce((sum, item) => {
        return sum + item.price * item.quantity
      }, 0) // total Price From all cart Items

      this.totalTax = Math.ceil(
        (this.totalCardPrice / 100) * Number.parseFloat(this.currentRegion.vat)
      ) // Tax

      // Calculate discount based on the order cost
      let discountPercentage = 0
      if (this.totalCardPrice >= 50) {
        discountPercentage = 15
      } else if (this.totalCardPrice >= 10) {
        discountPercentage = 10
      } else if (this.totalCardPrice >= 7) {
        discountPercentage = 7
      } else if (this.totalCardPrice >= 5) {
        discountPercentage = 5
      } else if (this.totalCardPrice >= 1) {
        discountPercentage = 3
      }

      this.totalDiscount = Math.ceil((this.totalCardPrice / 100) * discountPercentage) // Discount

      this.totalPrice = this.totalCardPrice + this.totalTax - this.totalDiscount
    },
    switchModalWins() {
      this.isCardConfirmed = !this.isCardConfirmed
      this.isOrderConfirmed = !this.isOrderConfirmed
    },
    isDateAllowed(date) {
      const today = new Date()
      const selectedDate = new Date(date)
      return selectedDate >= today
    },
  },
  data() {
    return {
      isCardConfirmed: false,
      isOrderConfirmed: false,
      currentRegion: {},
      totalDiscount: null,
      totalQuantity: null,
      totalTax: null,
      totalCardPrice: null,
      totalPrice: null,
      date: null,
      locale: 'en',
      minDate: new Date().toISOString().split('T')[0],
    }
  },
}
</script>
