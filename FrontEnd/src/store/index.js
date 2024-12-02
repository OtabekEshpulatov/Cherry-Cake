// src/store/index.js

import axios from 'axios';
import { createStore } from 'vuex';
const store = createStore({
  state() {
    return {
      topProducts: [

      ],
      allProducts: [

      ],
      regions: [
        { id: 0, name: 'Uzbekistan', vat: 15, discount: 3, cost: 1.00 },
        { id: 1, name: 'Kazakhstan', vat: 20, discount: 5, cost: 5.00 },
        { id: 2, name: 'Georgia', vat: 12, discount: 7, cost: 7.00 },
        { id: 3, name: 'Ukraina', vat: 8, discount: 10, cost: 10.00 },
        { id: 4, name: 'China', vat: 18, discount: 15, cost: 50.00 },
      ],
      cart: [
      ],
      isAuth: false,
      response: null,
      userId: null
    };
  },
  mutations: {
    addToCart(state, product) {
      const existingProduct = state.cart.find(item => item.id === product.id);
      if (existingProduct) {
        existingProduct.quantity += 1; // Увеличиваем количество, если товар уже есть
      } else {
        state.cart.push({ ...product, quantity: 1 }); // Добавляем новый товар
      }
    },
    removeFromCart(state, productId) {
      const existingProduct = state.cart.find(item => item.id === productId);
      if (existingProduct) {
        if (existingProduct.quantity > 1) {
          existingProduct.quantity -= 1; // Уменьшаем количество
        } else {
          state.cart = state.cart.filter(item => item.id !== productId); // Удаляем товар из корзины
        }
      }
    },
    addQuantity(state, { productId }) {
      const product = state.cart.find(item => item.id === productId);
      if (product && product.quantity > 0) {
        product.quantity++
      } else if (product && product.quantity === 0) {
        state.cart = state.cart.filter(item => item.id !== productId);
      }
    },
    cleanCartMut(state) {
      state.cart = []
    },
    minusQuantity(state, { productId }) {
      const product = state.cart.find(item => item.id === productId);
      if (product && product.quantity > 0) {
        product.quantity--
      } else if (product && product.quantity === 0) {
        state.cart = state.cart.filter(item => item.id !== productId);
      }
    },
    setAllProducts(state, products) {
      state.allProducts = products
    },
    setTopProducts(state, products) {
      state.topProducts = products
    },
    setUserId(state, payload) {
      state.userId = payload
    }

  },
  actions: {
    cleanCartAct({ commit }) {
      commit('cleanCartMut');
    },
    addOrUpdateCart({ commit, state }, product) {
      // Проверяем, есть ли продукт в корзине
      const cartItem = state.cart.find(item => item.id === product.id);
      if (cartItem) {
        // Если товар есть, обновляем его количество
        commit('addQuantity', { productId: product.id });
      } else {
        // Если товара нет, добавляем в корзину
        commit('addToCart', product);
      }
    },
    minusorDeleteCart({ commit, state }, product) {
      const cartItem = state.cart.find(item => item.id === product.id);

      if (cartItem) { // Проверяем, существует ли товар в корзине
        if (cartItem.quantity > 0) {
          commit('minusQuantity', { productId: product.id });
        }
        // Проверяем количество товара и наличие id
        if (cartItem.quantity === 0 && cartItem.id) {
          commit('removeFromCart', cartItem.id);
        }
      }
    },
    async fetchAllProducts({ commit }) {
      axios.get('api/products/all',)
        .then(response => {
          commit('setAllProducts', response.data);
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        });

    },
    async fetchTopProducts({ commit }) {
      axios.get('api/products/top')
        .then(response => {
          commit('setTopProducts', response.data);
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        });
    },
    async createOrderDetails( {state},orderData) {

      try {
        const response = await axios.post('api/order/create', orderData, {
          headers: {
            'Content-Type': 'application/json' // Adjust if needed based on the expected content type
          }
        });
        state.response = response
      } catch (error) {
        console.error('Error creating order:', error);
        // Handle the error (e.g., show an error message)
      }
    },
    async sendNewUser({ commit }, newUserData) {
      try {
        const response = await axios.post('api/user/register', newUserData, {
          headers: {
            'Content-Type': 'application/json' // Adjust if needed based on the expected content type
          }
        });
        commit('setUserId', response.data)
      } catch (error) {
        console.error('Reg err:', error);
        // Handle the error (e.g., show an error message)
      }
    },
    async sendLoginUser({ commit }, userData) {

      try {
        const response = await axios.post('api/user/login', userData, {
          headers: {
            'Content-Type': 'application/json' // Adjust if needed based on the expected content type
          }
        });
        commit('setUserId', response.data)
      } catch (error) {
        console.error('Reg err:', error);
        // Handle the error (e.g., show an error message)
      }
    }
  },
  getters: {
    getUserId(state) {
      return state.userId
    },
    getIsAuth(state) {
      return state.isAuth
    },
    getCartProducts(state) {
      return state.cart
    },
    getTopProducts(state) {
      return state.topProducts
    },
    getRegions(state) {
      return state.regions
    },
    getAllProducts(state) {
      return state.allProducts
    }
  },
});

export default store;