import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  server: {
    port: 3000,
    cors: false,
    proxy: {
      // Define a proxy for your API
      '/api': {
        target: 'http://localhost:8080/', // Replace with your target API
        changeOrigin: true,  // This changes the origin to the target API
        secure: false,       // Set to false if using self-signed certificates
        rewrite: (path) => path.replace(/^\/api/, ''), // Optional: remove `/api` from the path
      },
    },
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
})
