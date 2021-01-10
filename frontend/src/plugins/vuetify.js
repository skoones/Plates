import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: '#84d188',
                secondary: '#85d1ae',
                accent: '#d185ce'
            }
        }
    }
});
