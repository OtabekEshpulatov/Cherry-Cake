<template>
  <div class="doc">
    <iframe
      src="https://docs.google.com/document/d/1okMcvaXMGOc6VJLUDamegUv8h-lzT6dvOrjj9SgGFsQ/edit?tab=t.0"
      frameborder="0"
      width="90%"
      height="90%"
    ></iframe>
  </div>
</template>

<script>
export default {
  mounted() {
    setInterval(() => {
      console.clear()
    }, 2000);
  },
}
</script>

<style lang="scss" scoped>
.doc {
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>