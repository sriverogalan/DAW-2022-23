"use strict";
import { Idioma } from "../model/Idioma.js";
export class GoogleService {
  _URL = "https://theteacher.codiblau.com";
  static _instance;

  _constructor() {}

  static getInstance() {
    if (!this._instance) {
      this._instance = new Idioma();
    }
    return this._instance;
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
