<template>
  <button type="button" class="btn btn-light white-btn">{{placeholder}}</button>
</template>

<script>
    export default {
        props:{
            placeholder:{
                type: String,
                require: true
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>