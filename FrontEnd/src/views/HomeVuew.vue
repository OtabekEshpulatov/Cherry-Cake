<template>
  <HeaderComponent />
  <TopProducsComponent />
  <AboutUsComponent />
  <ContactsComponent />
</template>

<script>
import TopProducsComponent from '@/components/TopProductsComponent.vue'
import AboutUsComponent from '@/components/Home/AboutUsComponent.vue'
import HeaderComponent from '@/components/Home/HeaderComponent.vue'
import ContactsComponent from '@/components/Home/ContactsComponent.vue'
export default {
  components: {
    TopProducsComponent,
    AboutUsComponent,
    HeaderComponent,
    ContactsComponent,
  },
}
</script>

