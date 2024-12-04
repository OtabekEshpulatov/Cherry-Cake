<template>
  <section class="login" aria-labelledby="login-title">
    <div class="login-content">
      <h2 id="login-title" class="reglog__title">CHERRY CAKE CAFE</h2>
      <p class="reglog__sub-title">Log in to your account</p>
      <form @submit.prevent class="reglog__form" aria-labelledby="login-title" novalidate>
        <p>Welcome back! Please enter your details.</p>

        <!-- Phone Number Input -->
        <div class="reglog__input">
          <label for="phone-number" class="sr-only">Phone Number</label>
          <v-text-field
            id="phone-number"
            label="Phone Number"
            v-model="phoneNumber"
            autocomplete="tel"
            :rules="[
              (v) => !!v || 'Error: This field is mandatory',
              (v) => /^(\+?\d{1,4}[\s\-]?)?(\(?\d{3}\)?[\s\-]?)?[\d\s\-]{7,15}$/.test(v) || 'Error: Invalid phone number Format: 998112223344',
            ]"
          ></v-text-field>
        </div>

        <!-- Password Input -->
        <div class="reglog__input password">
          <label for="password" class="sr-only">Password</label>
          <v-text-field
            id="password"
            label="Password"
            v-model="password"
            autocomplete="new-password"
            :type="isHidePass ? 'password' : 'text'"
            :rules="[
              (v) => !!v || 'Error: This field is mandatory',
              (v) => v.length >= 8 || 'Error: Minimum 8 characters required',
              (v) => /[A-Z]/.test(v) || 'Error: Password must contain at least one uppercase letter',
              (v) => /\d/.test(v) || 'Error: Password must contain at least one number',
              (v) => /[!@#$%^&*(),.?:{}|<>]/.test(v) || 'Error: Password must contain at least one special character',
            ]"
          ></v-text-field>
          <button
            class="show-pass"
            type="button"
            @click="isHidePass = !isHidePass"
            aria-label="Toggle password visibility"
          >
            <i :class="isHidePass ? 'fa-solid fa-eye' : 'fa-solid fa-eye-slash'" aria-hidden="true"></i>
          </button>
        </div>

        <!-- Submit Button -->
        <WhiteBtn class="submit" @click="loginUser()">
          <button
            type="submit"
            class="submit"
            aria-label="Log in to your account"
          >
            Continue Your Journey!
          </button>
        </WhiteBtn>
      </form>
    </div>
  </section>
</template>


<script>
import WhiteBtn from '@/components/UI/WhiteBtn.vue'
import router from '@/router'
import { mapActions } from 'vuex'
export default {
  components: {
    WhiteBtn,
  },
  data() {
    return {
      phoneNumber: null,
      password: null,
      isHidePass: true,
    }
  },
  methods: {
    ...mapActions(['sendLoginUser']),
    async loginUser() {
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

      const validateField = (value, rules) => {
        for (const rule of rules) {
          const error = rule(value)
          if (error !== true) {
            return error
          }
        }
        return true
      }

      const phoneNumberError = validateField(this.phoneNumber, phoneNumberRules)
      const passwordError = validateField(this.password, passwordRules)

      if (phoneNumberError !== true || passwordError !== true) {
        alert(
          [
            phoneNumberError !== true ? phoneNumberError : '',
            passwordError !== true ? passwordError : '',
          ]
            .filter(Boolean)
            .join('\n')
        )
        return
      }

      const sendData = {
        phoneNumber: this.phoneNumber.toString(),
        password: this.password,
      }

      try {
        await this.sendLoginUser(JSON.stringify(sendData))
        router.push({ path: '/' })
      } catch (error) {
        console.error('Error logging in:', error)
      }
    },
  },
}
</script>
