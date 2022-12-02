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
}
