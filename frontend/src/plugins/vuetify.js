import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: {
                    base: '#84d188',
                    darken1: '#72b877',
                    darken2: '#5c9661',
                    darken3: '#4d8051',
                    darken4: '#39603b'
                },
                secondary: '#85d1ae',
                accent: '#d185ce'
            }
        }
    }
});
