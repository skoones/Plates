import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.config.productionTip = false

// fixes vuetify behavior of buttons not losing focus after closing popup
Vue.directive('blur', {
  inserted: function (el) {
    // noinspection JSUnresolvedFunction
    el.onfocus = (ev) => ev.target.blur()
  }
});

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
