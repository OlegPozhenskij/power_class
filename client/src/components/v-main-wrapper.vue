<template> <!--html-->
  <div class="v-main-wrapper">
    <router-view></router-view> <!--отвечает за переходы по старницам-->
  </div>
</template>

<script>

  export default { //экспортируем дефолтное состояние
    name: "v-main-wrapper", //это тоже обязательно! Имя компонента
    proms:{},
    data() { //дата должна что-то возвращать - эот перс данные нашего компонента
      return {
        title: "Main Wrapper"
      }
    },
    computed: {}, //вычислительные свойства компонента
    methods: {}, //отлавливают действия пользователя(клики и тд...)
    watch: {} //следят на изменениями в компоненте
  }
</script>

<style scoped>
  .v-main-wrapper {
    /*display: flex;*/
    justify-content: center;
    align-items: center;
    max-width: none;
    margin: 0 auto;
  }
</style>