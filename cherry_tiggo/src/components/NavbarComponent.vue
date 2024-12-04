<template>
  <nav class="navbar navbar-expand-lg container fixed-top desktop">
    <div class="container navbar-content">
      <router-link class="navbar-brand navbar-title" to="/" aria-label="Go to homepage"
        >Cherry cake CafE</router-link
      >
      <ul class="navbar-list">
        <li class="list-item">
          <router-link class="list-item__link" to="/menu" aria-label="Go to menu page"
            >menu</router-link
          >
        </li>
        <li class="list-item">
          <router-link
            href="#about-us"
            :to="{ path: '/', hash: '#about-us' }"
            aria-label="Learn more about us"
            >about us</router-link
          >
        </li>
        <li class="list-item">
          <router-link
            class="list-item__link"
            :to="{ path: '/', hash: '#contacts' }"
            aria-label="Contact us"
            >contacts</router-link
          >
        </li>
        <li class="list-item">
          <router-link class="list-item__link" :to="{ path: '/doc' }" aria-label="View reports"
            >reports</router-link
          >
        </li>
      </ul>
      <WhiteBtn v-show="!username">
        <router-link to="/register" aria-label="Sign up">Sign up</router-link>
      </WhiteBtn>
      <span v-show="username">Welcome! {{ username }}</span>
    </div>
  </nav>

  <nav class="navbar navbar-expand-lg container mobile">
    <div class="container-fluid">
      <router-link class="navbar-brand navbar-title" to="/" aria-label="Go to homepage"
        >Cherry cake CafE</router-link
      >

      <button
        class="navbar-toggler"
        type="button"
        @click="switchBurgerMenu()"
        aria-controls="offcanvasNavbar"
        aria-label="Toggle navigation menu"
      >
        <i class="fa-solid fa-bars"></i>
      </button>
      <div class="burger-menu" :class="isSidebar ? 'active' : ''">
        <div class="offcanvas-header">
          <button
            type="button"
            class="text-reset"
            @click="switchBurgerMenu()"
            aria-label="Close menu"
          >
            <i class="fa-solid fa-xmark"></i>
          </button>
        </div>
        <div class="offcanvas-body">
          <ul class="navbar-list">
            <li class="list-item">
              <router-link
                @click="switchBurgerMenu()"
                class="list-item__link"
                to="/menu"
                aria-label="Go to menu page"
                >menu</router-link
              >
            </li>
            <li class="list-item">
              <router-link
                @click="switchBurgerMenu()"
                :to="{ path: '/', hash: '#about-us' }"
                aria-label="Learn more about us"
                >about us</router-link
              >
            </li>
            <li class="list-item">
              <router-link
                @click="switchBurgerMenu()"
                class="list-item__link"
                :to="{ path: '/', hash: '#contacts' }"
                aria-label="Contact us"
                >contacts</router-link
              >
            </li>
            <li class="list-item">
              <router-link
                @click="switchBurgerMenu()"
                class="list-item__link"
                :to="{ path: '/doc' }"
                aria-label="View reports"
                >reports</router-link
              >
            </li>
          </ul>
          <WhiteBtn v-if="!username">
            <router-link @click="switchBurgerMenu()" to="/register" aria-label="Sign up"
              >Sign up</router-link
            >
          </WhiteBtn>
          <span v-if="username">Welcome! {{ username }}</span>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
import { mapGetters } from 'vuex'
import WhiteBtn from '@/components/UI/WhiteBtn.vue'
export default {
  computed: {
    ...mapGetters(['getUser']),
  },
  components: {
    WhiteBtn,
  },
  data() {
    return {
      username: null,
      isSidebar: false,
    }
  },
  mounted() {
    this.username = this.getUser.username
  },
  methods: {
    switchBurgerMenu() {
      this.isSidebar = !this.isSidebar
    },
  },
}
</script>
<style>
</style>
