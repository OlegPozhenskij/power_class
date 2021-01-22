<template>
  <div class="v-schedule">

    <div class="v-schedule-info">

      <v-schedule-info
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
import {mapActions} from "vuex";

export default {
name: "v-schedule-wrapper",
  components: {

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
  },
}
</script>

<style scoped>

</style>