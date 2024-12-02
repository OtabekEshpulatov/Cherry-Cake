<template>
  <section class="registration">
    <div class="registration-content container">
      <h2 class="reglog__title">CHERRY CAKE CAFE</h2>
      <span class="reglog__sub-title">Create an account</span>
      <form @submit.prevent class="reglog__form">
        <div class="reglog__input">
          <v-text-field
            label="Full Name"
            v-model="username"
            :rules="[
              (v) => !!v || 'Error: This field is mandatory',
              (v) => v.length >= 5 || 'Error: Minimum 5 characters required',
              (v) => /^[a-zA-Z]+$/.test(v) || 'Error: Only Latin letters are allowed',
            ]"
          ></v-text-field>
        </div>
        <div class="reglog__input">
          <v-text-field
            label="Phone Number"
            v-model="phoneNumber"
            autocomplete="tel"
            :rules="[
              (v) => !!v || 'Error: This field is mandatory',
              (v) =>
                /^(\+?\d{1,4}[\s\-]?)?(\(?\d{3}\)?[\s\-]?)?[\d\s\-]{7,15}$/.test(v) ||
                'Error: Invalid phone number Format: 998112223344',
            ]"
          ></v-text-field>
        </div>
        <div class="reglog__input password">
          <v-text-field
            label="Create password"
            v-model="password"
            autocomplete="new-password"
            :type="isHidePass ? 'password' : 'text'"
            :rules="[
              (v) => !!v || 'Error: This field is mandatory',
              (v) => v.length >= 8 || 'Error: Minimum 8 characters required',
              (v) =>
                /[A-Z]/.test(v) || 'Error: Password must contain at least one uppercase letter',
              (v) => /\d/.test(v) || 'Error: Password must contain at least one number',
              (v) =>
                /[!@#$%^&*(),.?:{}|<>]/.test(v) ||
                'Error: Password must contain at least one special character',
            ]"
          ></v-text-field>
          <button class="show-pass" @click="isHidePass = !isHidePass">
            <i :class="isHidePass ? 'fa-solid fa-eye' : 'fa-solid fa-eye-slash'"></i>
          </button>
        </div>
        <div class="reglog__input password">
          <v-text-field
            label="Confirm Password"
            :type="isHideConfPass ? 'password' : 'text'"
            v-model="confirmPass"
            autocomplete="new-password"
            :rules="[
              (v) => !!v || 'Error: This field is mandatory',
              (v) => v === password || 'Error: Passwords do not match',
            ]"
          ></v-text-field>
          <button class="show-pass" @click="isHideConfPass = !isHideConfPass">
            <i :class="isHideConfPass ? 'fa-solid fa-eye' : 'fa-solid fa-eye-slash'"></i>
          </button>
        </div>
        <WhiteBtn class="submit"
          ><button @click="createNewUser()" type="submit" class="submit">
            Get Stated
          </button></WhiteBtn
        >
        <span>Already have an account? <router-link to="/login">Log in</router-link></span>
      </form>
    </div>
  </section>
</template>

<script>
import WhiteBtn from '@/components/UI/WhiteBtn.vue'
import router from '@/router'
import { mapActions, mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters(['getUserId']),
  },
  data() {
    return {
      username: null,
      phoneNumber: null,
      password: null,
      confirmPass: null,
      isHidePass: true,
      isHideConfPass: true,
    }
  },
  components: { WhiteBtn },
  methods: {
    ...mapActions(['sendNewUser']),
    async createNewUser() {
      // Проверяем, что поля соответствуют правилам
      const usernameRules = [
        (v) => !!v || 'Error: This field is mandatory',
        (v) => v.length >= 5 || 'Error: Minimum 5 characters required',
        (v) => /^[a-zA-Z]+$/.test(v) || 'Error: Only Latin letters are allowed',
      ]

      const phoneNumberRules = [
        (v) => !!v || 'Error: This field is mandatory',
        (v) =>
          /^(\+?\d{1,4}[\s-]?)?(\(?\d{3}\)?[\s-]?)?[\d\s-]{7,15}$/.test(v) ||
          'Error: Invalid phone number Format: 998112223344',
      ]

      const passwordRules = [
        (v) => !!v || 'Error: This field is mandatory',
        (v) => v.length >= 8 || 'Error: Minimum 8 characters required',
        (v) => /[A-Z]/.test(v) || 'Error: Password must contain at least one uppercase letter',
        (v) => /\d/.test(v) || 'Error: Password must contain at least one number',
        (v) =>
          /[!@#$%^&*(),.?:{}|<>]/.test(v) ||
          'Error: Password must contain at least one special character',
      ]

      const confirmPasswordRules = [
        (v) => !!v || 'Error: This field is mandatory',
        (v) => v === this.password || 'Error: Passwords do not match',
      ]

      const validateField = (value, rules) => {
        for (const rule of rules) {
          const error = rule(value)
          if (error !== true) {
            return error // Возвращаем первую ошибку
          }
        }
        return true // Если ошибок нет
      }

      // Проверяем каждое поле
      const usernameError = validateField(this.username, usernameRules)
      const phoneNumberError = validateField(this.phoneNumber, phoneNumberRules)
      const passwordError = validateField(this.password, passwordRules)
      const confirmPasswordError = validateField(this.confirmPass, confirmPasswordRules)

      if (
        usernameError !== true ||
        phoneNumberError !== true ||
        passwordError !== true ||
        confirmPasswordError !== true
      ) {
        alert(
          [
            usernameError !== true ? usernameError : '',
            phoneNumberError !== true ? phoneNumberError : '',
            passwordError !== true ? passwordError : '',
            confirmPasswordError !== true ? confirmPasswordError : '',
          ]
            .filter(Boolean)
            .join('\n')
        )
        return // Не выполняем метод, если есть ошибки
      }

      // Если всё корректно, отправляем данные
      const newUser = {
        fullName: this.username,
        phone: this.phoneNumber,
        password: this.password,
      }

      try {
        await this.sendNewUser(JSON.stringify(newUser))
        router.push({ path: '/' })
      } catch (error) {
        console.error('Error creating user:', error)
      }
    },
  },
}
</script>

<style lang="scss" scoped>
</style>