<template>
  <section class="contacts">
    <h2 id="contacts" class="contacts__title title">Contacts</h2>
    <div class="contacts-content container">
      <div class="contacts-content__left">
        <!-- Address Information -->
        <div class="contacts-adress">
          <h3 class="sub__title">ADDRESS</h3>
          <p class="contacts-sub-title" aria-label="Address">
            Набережная реки Фонтанки, <br />
            90 (вход в арке с белыми колоннами)
          </p>
        </div>

        <!-- Telephone Information -->
        <div class="contacts-adress">
          <h3 class="sub__title">TELEPHONE</h3>
          <p class="contacts-sub-title" aria-label="Phone Number">+7 (812) 713-1945</p>
        </div>

        <!-- Work Hours Information -->
        <div class="contacts-adress">
          <h3 class="sub__title">WORK HOURS</h3>
          <p class="contacts-sub-title" aria-label="Working Hours">Ежедневно с 12:00 до 06:00</p>
        </div>

        <!-- CEO Information -->
        <div class="contacts-adress">
          <h3 class="sub__title">CEO</h3>
          <p class="contacts-sub-title" aria-label="CEO Name">Лидия Эмильевна, +7(921) 963-55-50</p>
        </div>

        <!-- Art Director Information -->
        <div class="contacts-adress">
          <h3 class="sub__title">ART-DIRECTOR</h3>
          <p class="contacts-sub-title" aria-label="Art Director Name">
            Илиния Ионашко, +7(981) 989-43-30
          </p>
        </div>
      </div>

      <!-- Embedded Map -->
      <div class="contacts-content__right">
        <iframe
          class="contacts-map"
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d891.0363322024637!2d69.29214324996796!3d41.307187829984855!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x38aef57a3c146bbd%3A0xe9e97d7df649b5fb!2sDivan%20restaurant!5e0!3m2!1sru!2s!4v1731934902353!5m2!1sru!2s"
          loading="lazy"
          referrerpolicy="no-referrer-when-downgrade"
          title="Map location of Cherry Cake Cafe"
          aria-label="Map showing the location of the Cherry Cake Cafe"
        ></iframe>
      </div>

      <p class="contacts-copyright">Copyright © 2024. Все права защищены.</p>
    </div>
  </section>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
</style>