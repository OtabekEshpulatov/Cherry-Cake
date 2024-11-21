<template>
  <nav class="navbar navbar-expand-lg container">
    <div class="container navbar-content">
      <router-link class="navbar-brand navbar-title" to="/">Cherry cake CafE </router-link>
      <ul class="navbar-list SMN_effect-6">
        <li class="list-item">
          <router-link class="list-item__link" to="/menu">menu</router-link>
        </li>
        <li class="list-item">
          <a href="#about-us">about us</a>
        </li>
        <li class="list-item">
          <a class="list-item__link" href="#contacts">contacts</a>
        </li>
      </ul>
      <WhiteBtn placeholder="Sign UP" />
    </div>
  </nav>
</template>

<script>
import WhiteBtn from './UI/WhiteBtn.vue'

export default {
  components: {
    WhiteBtn,
  },
}
</script>
