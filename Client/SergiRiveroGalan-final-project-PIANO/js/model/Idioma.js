"use strict";
export class Idioma {
  constructor(id, nom) {
    this.id = id;
    this.nom = nom;
  }
  static fromJSON(json) {
    return new Idioma(json.code, json.name);
  }
}
