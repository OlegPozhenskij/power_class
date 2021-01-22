import Vue from 'vue'
import Router from 'vue-router'

import vPersonalAccount from '../components/v-personal-account'
import vNewsPage from  '../components/v-news-page'

 Vue.use(Router);

let router = new Router({
    routes: [
        {
            path: '/news',
            name: 'newsPage',
            component: vNewsPage
        },
        {
            path: '/account',
            name: 'personalAccount',
            component: vPersonalAccount
        }
    ]
});

export default router;