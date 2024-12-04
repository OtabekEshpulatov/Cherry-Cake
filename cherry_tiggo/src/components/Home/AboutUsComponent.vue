<template>
  <section class="about-us">
    <h2 id="about-us" class="about-us__title title">About Us</h2>
    <div class="about-us-content container">
      <div class="about-us__left col-5 align-self-end">
        <p class="about-us__text">
          At Cherry Cake Cafe, we’re passionate about baking and creating delicious treats that
          bring joy to our customers. Our journey began in 2020 with a simple dream: to share our
          love for baking with the community.
          <br /><br />
          We’re committed to using only the finest ingredients to create cakes, pastries, and other
          delectable treats. Each item is handcrafted with care and attention to detail.
          <br /><br />
          Our team of skilled bakers and baristas is dedicated to providing exceptional service and
          ensuring a memorable experience for every customer.
        </p>

        <!-- Social media links - desktop view -->
        <div class="about-us__social desktop">
          <span class="social__title">Social media links:</span>
          <div class="social-platform">
            <a
              href="https://twitter.com/cherrycakecafe"
              target="_blank"
              rel="noopener"
              aria-label="Cherry Cake Cafe Twitter Profile"
            >
              <i class="fa-brands fa-twitter"></i>
              <span>@cherrycakecafe</span>
            </a>
          </div>
          <div class="social-platform">
            <a
              href="https://instagram.com/cherrycakecafe"
              target="_blank"
              rel="noopener"
              aria-label="Cherry Cake Cafe Instagram Profile"
            >
              <i class="fa-brands fa-instagram"></i>
              <span>@cherrycakecafe</span>
            </a>
          </div>
        </div>
      </div>

      <!-- Image Section -->
      <div class="about-us__right col-xl-5">
        <img
          src="@/assets/img/about-us-1200.png"
          srcset="
            @/assets/img/about-us-1200.png 1200w,
            @/assets/img/about-us-768.png   768w,
            @/assets/img/about-us-320.png   320w
          "
          sizes="(max-width: 320px) 320px, (max-width: 768px) 768px, 1200px"
          alt="A photo showing the interior of Cherry Cake Cafe with cakes and pastries"
        />
      </div>

      <!-- Social media links - mobile view -->
      <div class="about-us__social mobile">
        <span class="social__title">Social media links:</span>
        <div class="social-platform">
          <a
            href="https://twitter.com/cherrycakecafe"
            target="_blank"
            rel="noopener"
            aria-label="Cherry Cake Cafe Twitter Profile"
          >
            <i class="fa-brands fa-twitter"></i>
            <span>@cherrycakecafe</span>
          </a>
        </div>
        <div class="social-platform">
          <a
            href="https://instagram.com/cherrycakecafe"
            target="_blank"
            rel="noopener"
            aria-label="Cherry Cake Cafe Instagram Profile"
          >
            <i class="fa-brands fa-instagram"></i>
            <span>@cherrycakecafe</span>
          </a>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
</style>