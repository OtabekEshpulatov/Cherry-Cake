<template>
  <HeaderComponent aria-labelledby="header-title" />
  <TopProducsComponent aria-labelledby="top-products-title" />
  <AboutUsComponent aria-labelledby="about-us-title" />
  <ContactsComponent aria-labelledby="contacts-title" />
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

