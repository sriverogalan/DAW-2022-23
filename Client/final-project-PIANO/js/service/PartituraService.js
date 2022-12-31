import { Partitura } from "../model/Partitura.js";
export class PartituraService {
  _URL = "https://theteacher.codiblau.com";
  static _instance;

  _constructor() {}

  static getInstance() {
    if (!PartituraService._instance) {
      PartituraService._instance = new PartituraService();
    }
    return PartituraService._instance;
  }

  async getPartitures() {
    let response = await fetch(this._URL + "/piano/nologin/score/list", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
    let json = await response.json();
    const partitures = json.map((p) => Partitura.fromJSON(p));
    return partitures;
  }
  async addCerca() {}
  async cercador() {}
}
