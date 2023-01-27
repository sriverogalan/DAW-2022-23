<template>
    <input type="text" v-model="logo" @input="filtreUsuaris">
    <button @click="getLogo()">Get Icon</button>

    <h2 v-if="missatge">{{ missatge }}</h2>

    <div v-if="!missatge">
        <h2>{{ result.label }}</h2>
        <svg :style="`width:${result.width}; height:${result.height}`">
            <path :d="`${result.path}`"></path>
        </svg>
    </div>

    <table>
        <tr>
            <th>Nom</th>
            <th>Cognoms</th>
        </tr>

        <tr>
            <td>David</td>
            <td>Alonso</td>
        </tr>

        <tr>
            <td>Alvaro</td>
            <td>Alonso</td>
        </tr>
    </table>

    <button @click="loadUsuaris">Usuaris</button>

    <Taula nom="Taula 2" :usuaris="usuarisFilter" />
    <Taula nom="Taula 3" :usuaris="usuarisFilter" />

    <Taula nom="Taula Components">
        <Fila>
            <Columna :isHeader="true" :sorteable="true" @sort-asc="ordena('asc')" @sort-desc="ordena('desc')">Nom
            </Columna>
            <Columna :isHeader="true">Cognoms</Columna>
        </Fila>

        <Fila>
            <Columna>Sergi</Columna>
            <Columna>Rivero</Columna>
        </Fila>

        <Fila v-for="usuari in usuaris">
            <Columna>{{ usuari.nom }}</Columna>
            <Columna>{{ usuari.cognoms }}</Columna>
        </Fila>
    </Taula>


</template>

<script>

import Taula from '@/components/taula/Taula.vue'
import Fila from '@/components/taula/Fila.vue'
import Columna from '@/components/taula/Columna.vue'



export default {
    data() {
        return {
            message: 'Hello Vue!',
            logo: '',
            result: '',
            missatge: '',
            usuaris: [], //No se toca, lo unico que tiene que hacer es almacenar lo que trae de la api
            usuarisFilter: [] //Depues de mapear el array de usuaris, se guarda aqui y se filtra
        }
    },

    components: {
        Taula, Fila, Columna
    },

    methods: {
        async getLogo() {
            const fetchLogo = await fetch(`https://theteacher.codiblau.com/exercicis/other/icons/get?nom=${this.logo}`);
            if (fetchLogo.status === 200) {
                const logo = await fetchLogo.json();
                this.result = logo
                this.missatge = null;
            } else {
                this.missatge = await fetchLogo.text();
            }
        },

        async loadUsuaris() {
            const fetchUsuaris = await fetch('https://theteacher.codiblau.com/exercicis/other/usuaris/list');

            if (fetchUsuaris.status === 200) {
                const usuaris = await fetchUsuaris.json();
                console.log(usuaris);
                this.usuaris = usuaris.map(u => {
                    return {
                        nom: u.nom,
                        cognoms: u.cognom1 + ' ' + u.cognom2
                    }
                });

                this.usuarisFilter = this.usuaris;
            }
        },

        filtreUsuaris() {
            this.usuarisFilter = this.usuaris.filter(u => {
                return u.nom.toLowerCase().includes(this.logo.toLowerCase()) ||
                    u.cognoms.toLowerCase().includes(this.logo.toLowerCase());
            });
        },

        ordena(ordre) {

            if (ordre === 'asc') {
                this.usuaris.sort((a, b) => a.cognoms.localeCompare(b.cognoms))
            } else this.usuaris.sort((a, b) => b.cognoms.localeCompare(a.cognoms))
        }
    },

}

</script>



<style scoped>
.error {
    color: red;
}

.gran {
    font-size: 40pt;
}

.estilitzat {
    text-decoration: underline;
}

table {
    border: solid 1px red;
}

table th {
    text-transform: uppercase;
}

table td {
    color: blue;
}

button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
</style>