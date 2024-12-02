<template>
  <div class="menu-grid">
    <Loader v-if="isLoading || getAllProducts.length == 0" class="loading-indicator"> </Loader>
    <div class="menu-grid-content" v-else>
      <CardItem v-for="product in getAllProducts" :key="product.id" :product="product" />
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import Loader from '../UI/LoaderComponent.vue'
import CardItem from './CardItem.vue'

export default {
  data() {
    return {
      isLoading: true,
    }
  },
  components: {
    CardItem,
    Loader,
  },
  computed: {
    ...mapGetters(['getAllProducts']),
  },
  methods: {
    ...mapActions(['fetchAllProducts']),
    async setAllProducts() {
      this.isLoading = true // Устанавливаем индикатор загрузки
      try {
        await this.fetchAllProducts() // Выполняем загрузку данных
      } catch (error) {
        console.error('Error fetching products:', error) // Логируем ошибку
      } finally {
        // Проверяем, загружены ли данные
        if (this.getAllProducts.length > 0) {
          this.isLoading = false // Отключаем индикатор загрузки
        } else {
          // Если данные ещё не загружены, повторяем попытку через 3 секунды
          setTimeout(() => {
            this.setAllProducts()
          }, 3000)
        }
      }
    },
  },
  mounted() {
    this.setAllProducts()
  },
}
</script>


