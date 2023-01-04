"use strict";
export class Partitura {
  constructor(
    id,
    titol,
    lletraOriginal,
    lletraTraduccio,
    idiomaOriginal,
    idiomaDesti,
    notes
  ) {
    this.id = id;
    this.titol = titol;
    this.idiomaOriginal = idiomaOriginal;
    this.idiomaDesti = idiomaDesti;
    this.lletraOriginal = lletraOriginal;
    this.lletraTraduccio = lletraTraduccio;
    this.notes = notes;
  }
  static fromJSON(json) {
    return new Partitura(
        json.idpartitura,
        json.titol,
        json.lletraoriginal,
        json.lletratraduccio,
        json.idiomaoriginal,
        json.idiomatraduccio,
        json.notes
    );
  }
  // crear funció toJSON
  toJSON() {
    return {
      idpartitura: this.id,
      name: this.titol,
      idiomaoriginal: this.idiomaOriginal,
      idiomatraduccio: this.idiomaDesti,
      partituraoriginal: this.lletraOriginal,
      partituratraduccio: this.lletraTraduccio,
      notes: this.notes,
    };
  }
}
