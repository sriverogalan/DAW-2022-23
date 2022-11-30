import { Canal } from "../model/Canal.js";
export class CanalService {
  _URL = "https://theteacher.codiblau.com";
  static _instance;

  _constructor() {}

  static getInstance() {
    if (!this._instance) {
      this._instance = new CanalService();
    }
    return this._instance;
  }

  async getCanals() {
    const canalsFetch = await fetch(this._URL + "/exercicis/programacio/info");
    const canals = await canalsFetch.json();
    const clau = Object.keys(canals);
    const valor = Object.values(canals);
    const canalsArray = [];
    for (let i = 0; i < clau.length; i++) {
      canalsArray.push(new Canal(clau[i], valor[i]));
    }
    return canalsArray;
  }

  async getProgramacio(canal, hour) {
    const programacioFetch = await fetch(
      this._URL + "/exercicis/programacio/tv",
      {
        method: "POST",
        headers: {
          "Content-type": "application/x-www-form-urlencoded; charset=UTF-8",
        },
        credentials: "include",
        body: `can=${canal}&hour=${hour}`,
      }
    );
    const programacio = await programacioFetch.json();  
    return programacio;
  }

  async getProgramacions(numCanal) { 
    const promises = [];
    for (let i = 0; i < 24; i++) {
      promises.push(this.getProgramacio(numCanal, i));
    } 
    const programacions = await Promise.all(promises);   
    return programacions;
  } 
}