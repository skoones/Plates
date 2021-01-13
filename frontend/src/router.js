import Vue from 'vue'
import Router from 'vue-router'
import WeeklyView from "@/views/WeeklyView";
import MealsFullView from "@/views/MealsFullView";

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/week',
            name: 'weeklyView',
            component: WeeklyView
        },
        {
            path: '/browse',
            name: 'browseMeals',
            component: MealsFullView
        }

    ]
})