<template>
  <div class="row">
    <div class="column left" style="background-color:#aaa;">
      <img alt="ol.jpg" :src="employee_data.image"/>
    </div>
    <div class="column middle" style="background-color:#bbb;">
      <h2>Student information</h2> <br>

      <div class="leftText">
          <p class="v-profile-id">Unique identity: {{employee_data.id}}</p>
          <p class="v-profile-name">Username: {{employee_data.username}}</p>
          <p class="v-profile-email">Email adress: {{employee_data.email}}</p>
          <p class="v-profile-phone">Phone number: {{employee_data.phone}}</p>
      </div>


    </div>
    <div class="column right" style="background-color:#ccc;">
      <h2>Links</h2> <br>

      <router-link :to="{name: 'newsPage'}">
        <div class="v-profile-link-to-news">News page</div>
      </router-link>

    </div>
  </div>
</template>

<script>


export default {
  name: "v-personal-info",
  components: {
  },
  props: { //здесь получаем что-то из верхнего компонента
    employee_data: { //наш employee
      type: Object, //тип объекта
      default() { // деволтное состояние
        return {

        }
      }
    }
  },
  data() {
    return {

    }
  },
  computed: {

  },
  methods: {

  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
}

.v-profile-photo {
  width: 220px;
  margin-top: 60px;
  display: block;
  margin-left: auto;
  margin-right: auto
}

.leftText {
  text-shadow: #2c3e50;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 280px;
  text-align: left;
}

/* Create three unequal columns that floats next to each other */
.column {
  float: left;
  padding: 60px;
  height: 525px; /* Should be removed. Only for demonstration */
}

.left, .right {
  width: 25%;
}

.middle {
  width: 50%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>