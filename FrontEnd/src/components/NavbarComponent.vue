<template>
  <nav class="navbar navbar-expand-lg container fixed-top desktop">
    <div class="container navbar-content">
      <router-link class="navbar-brand navbar-title" to="/">Cherry cake CafE </router-link>
      <ul class="navbar-list">
        <li class="list-item">
          <router-link class="list-item__link" to="/menu">menu</router-link>
        </li>
        <li class="list-item">
          <router-link href="#about-us" :to="{ path: '/', hash: '#about-us' }"
            >about us</router-link
          >
        </li>
        <li class="list-item">
          <router-link class="list-item__link" :to="{ path: '/', hash: '#contacts' }"
            >contacts</router-link
          >
        </li>
        <li class="list-item">
          <router-link class="list-item__link" :to="{ path: '/doc'}"
            >reports</router-link
          >
        </li>
      </ul>
      <WhiteBtn v-show="!isAuth">
        <router-link to="/register">Sign up</router-link>
      </WhiteBtn>
      <span v-show="isAuth">Welcome!</span>
    </div>
  </nav>
  <nav class="navbar navbar-expand-lg container  mobile">
    <div class="container-fluid">
      <router-link class="navbar-brand navbar-title" to="/">Cherry cake CafE </router-link>

      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="offcanvas"
        data-bs-target="#offcanvasNavbar"
        aria-controls="offcanvasNavbar"
      >
        <i class="fa-solid fa-bars"></i>
      </button>
      <div
        class="offcanvas offcanvas-end"
        tabindex="-1"
        id="offcanvasNavbar"
        aria-labelledby="offcanvasNavbarLabel"
      >
        <div class="offcanvas-header">
          <button
            type="button"
            class="btn-close text-reset"
            data-bs-dismiss="offcanvas"
            aria-label="Close"
          >
          </button>
        </div>
        <div class="offcanvas-body">
          <ul class="navbar-list">
            <li class="list-item">
              <router-link class="list-item__link" to="/menu">menu</router-link>
            </li>
            <li class="list-item">
              <router-link href="#about-us" :to="{ path: '/', hash: '#about-us' }"
                >about us</router-link
              >
            </li>
            <li class="list-item">
              <router-link class="list-item__link" :to="{ path: '/', hash: '#contacts' }"
                >contacts</router-link
              >
            </li>
            <li class="list-item">
              <router-link class="list-item__link" :to="{ path: '/doc'}"
                >reports</router-link
              >
            </li>
            
          </ul>
          <WhiteBtn v-show="!isAuth">
            <router-link to="/register">Sign up</router-link>
          </WhiteBtn>
          <span v-show="isAuth">Welcome!</span>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
import { mapGetters } from 'vuex'
import WhiteBtn from '@/components/UI/WhiteBtn.vue'
export default {
  components: {
    WhiteBtn,
  },
  data() {
    return {
      isAuth: this.$store.state.username,
      orderModalWin: false,
    }
  },
  computed: {
    ...mapGetters(['getIsAuth']), // Map Vuex getter to computed property
  },
}
</script>
