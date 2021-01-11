import Vue from 'vue'
import Router from 'vue-router'
import WeeklyView from "@/views/WeeklyView";

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/week',
            name: 'weeklyView',
            component: WeeklyView
        }

    ]
})