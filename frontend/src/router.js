import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path:'/week',
            name: 'weeklyPlan',
            component: () => import('./views/WeeklyPlan')
        }
    ]
})