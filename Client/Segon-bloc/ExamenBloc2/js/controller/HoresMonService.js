import { Pais } from "../model/Pais.js";
export class HoresMonService {
  _URL = "https://theteacher.codiblau.com";
  static _instance;

  _constructor() {}

  static getInstance() {
    if (!this._instance) {
      this._instance = new CanalService();
    }
    return this._instance;
  }

  async getPais() {
    const paisosFetch = await fetch(this._URL + "/exercicis/data/paisos");
    const paisos = await paisosFetch.json();
    const clau = Object.keys(paisos);
    const valor = Object.values(paisos);
    const paisosArray = [];
    for (let i = 0; i < clau.length; i++) {
      paisosArray.push(new Pais(clau[i], valor[i]));
    }
    return paisosArray;
  }

  getPartHora(codi, tipus) {
    const horaFetch = fetch(this._URL + "/exercicis/data/worldtime", {
      method: "POST",
      headers: {
        "Content-type": "application/x-www-form-urlencoded; charset=UTF-8",
      },
      credentials: "include",
      body: `codi=${codi}&tipus=${tipus}`,
    }).then((response) => response.json()); 
    return horaFetch;
  }

  async getHora(codi) {
    const promises = [];
    promises.push(this.getPartHora(codi, "HOUR"));
    promises.push(this.getPartHora(codi, "MINUTE"));
    promises.push(this.getPartHora(codi, "SECOND"));
    const hora = await Promise.all(promises);
    return hora;
  }
}
