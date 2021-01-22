<template>
  <div class="v-profile">
    <h1>User Profile</h1>

    <div class="v-profile-info">

      <v-personal-info
        :employee_data="this.$store.state.employee"
      />

      <!-- должны указать примари кей-->
      <!-- связываем данные-->
<!--        v"employee = this.$store.state.employee"-->
<!--        :employee_data="employee"/>-->
<!--        :key="employee.id"-->
<!--        :employee_data="employee"-->

    </div>

  </div>
</template>

<script>
import vPersonalInfo from './v-personal-info'
import {mapActions} from 'vuex'

export default {
  name: "v-personal-account-page",
  components: {
    vPersonalInfo
  },
  props: {},
  data() {
    return {

    }
  },
  computed: {

  },
  methods: {
    ...mapActions([
        'GET_EMP_FROM_API'
    ])
  },
  mounted() {
    this.GET_EMP_FROM_API();
  }


}

</script>

<style scoped>

</style>