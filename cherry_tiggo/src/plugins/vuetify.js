// plugins/vuetify.js
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import 'vuetify/styles'

export default createVuetify({
  ssr: true,
  components,
  directives,
  theme: {
    defaultTheme: 'light', // Можно установить 'dark' или 'light' как тему по умолчанию
    themes: {
      light: {
        // Переопределение переменной для ошибки
        variables: {
          '--v-theme-error': '#2a01e0', // Укажите нужный вам цвет для ошибок
        },
      },
      dark: {
        // Переопределение переменной для ошибки в темной теме
        variables: {
          '--v-theme-error': '#2a01e0', // Например, оранжевый для темной темы
        },
      },
    },
  },
})
