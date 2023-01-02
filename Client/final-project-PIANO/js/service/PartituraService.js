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

  async getPartituraById(id) {
    let response = await fetch(this._URL + "/piano/nologin/score/get", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ id: id }),
    });
    let json = await response.json();
    const partitura = Partitura.fromJSON(json);
    return partitura;
  }

  async savePartitura(
    idpartitura,
    name,
    idiomaoriginal,
    idiomatraduccio,
    partituraoriginal,
    partituratraduccio,
    notes
  ) {
    let a = new Partitura(idpartitura, name,idiomaoriginal,idiomatraduccio,partituraoriginal,partituratraduccio,notes);
    score = score.toJSON();
    let response = await fetch(this._URL + "/piano/nologin/score/save", {
      method: "POST", 
      body: {score: JSON.stringify(score)},
    });
    let json = await response.json();
    return json;
  }

  async deletePartitura(id) {
    let response = await fetch(this._URL + "/piano/nologin/score/delete", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ id: id }),
    });
    let json = await response.json();
    return json;
  }

  async addCerca() {}

  async cercador() {}
}
