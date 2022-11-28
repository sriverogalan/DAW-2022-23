import { Canal } from '../Model/Canal.js';

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
    const canalsFetch = await fetch(this._URL + "/exercicis/programacio/info"  );
    const canals = await canalsFetch.json();  
    const clau = Object.keys(canals);
    const valor = Object.values(canals);
    const canalsArray = [];
    for (let i = 0; i < clau.length; i++) {
      canalsArray.push(new Canal(clau[i], valor[i]));
    } 
    return canalsArray;
  }
}
