import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";

Vue.use(Vuex);

//глобальный контейнер
let store = new Vuex.Store({
    state: {
        employee: {},
        days: {}
    }, // тут данные
    mutations: {
        SET_EMPLOYEE_TO_STATE: (state, employee) => {
            state.employee = employee;
        },
        SET_DAYS_TO_STATE: (state, days) => {
            state.days = days;
        }
    }, //с помощью них меняем банные в state
    actions: {
        GET_EMP_FROM_API({commit}) {
            return axios('https://appxo.herokuapp.com/api/users/1', {
                method: "GET"
            }).then((employee) => {
                commit('SET_EMPLOYEE_TO_STATE', employee.data);
                return employee;
            }).catch((error) => {
                console.log(error)
                return error;
            })
        }
    },
    getters: {
        EMP(state) {
            return state.employee;
        }
    }
});

export default store;