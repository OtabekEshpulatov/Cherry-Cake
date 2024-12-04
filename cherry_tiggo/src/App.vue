<template>
  <Navbar v-if="!$route.meta.hideNavigation" />
  <div v-if="isLoading" aria-busy="true" role="status">
      <LoaderComponent />
    </div>
  <router-view v-else></router-view>
</template>

<script>
import Navbar from '@/components/NavbarComponent.vue'
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import LoaderComponent from './components/UI/LoaderComponent.vue';
export default {
  components: {
    Navbar,
    LoaderComponent
  },
  data(){
    return{
      isLoading: true
    }
  },
  mounted(){
    setTimeout(() => {

      this.isLoading = false
    }, 2500);
  },
  setup() {
    const route = useRoute()

    const showNavigation = computed(() => {
      return !['/login', '/register'].includes(route.path)
    })

    return { showNavigation }
  },
}
</script>
