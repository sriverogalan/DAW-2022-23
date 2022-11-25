import { Programa } from "../Model/Programa";
import { Canal } from "../Model/Canal";

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
    const aeroportFetch = await fetch(this._URL + "/exercicis/programacio/info");
    const aerports = await aeroportFetch.json(); 
    return aerports.map((a) => Canal.fromJSON(a));
  }
}
