"use strict";
export class Partitura {
  constructor(codi, nom) {
    this.codi = codi;
    this.nom = nom;
  }
  static fromJSON(json) {
    return new Partitura(json.codi, json.nom);
  }
}
