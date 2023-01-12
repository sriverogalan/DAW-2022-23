"use strict";
import { Idioma } from "../model/Idioma.js";
export class GoogleService {
  _URL = "https://theteacher.codiblau.com";
  static _instance;

  _constructor() {}

  static getInstance() {
    if (!this._instance) {
      this._instance = new GoogleService();
    }
    return this._instance;
  }

  async getIdiomes() {
    let response = await fetch(this._URL + "/piano/nologin/google/translate/languages", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
    let json = await response.json();
    let idiomes = [];
    for (let idioma of json) {
      idiomes.push(Idioma.fromJSON(idioma));
    }
    return idiomes;
  } 

  async translate(idiomaOrigen, texte) {
    let response = await fetch(this._URL + "/piano/nologin/google/translate", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        languageFrom: idiomaOrigen,
        languageTo: "ca",
        text: texte,
      }),
    }); 
    return await response.text(); 
  }
}
