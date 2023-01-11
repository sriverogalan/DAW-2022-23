"use strict";
export class Nota {
  constructor(id, nom, alteracio, ordre) {
    this.id = id;
    this.nom = nom;
    this.alteracio = alteracio;
    this.ordre = ordre;
  }
  static fromJSON(json) {
    return new Nota(json.idnota, json.nom, json.alteracio, json.ordre);
  }
   


}
