"use strict";
export class Partitura {
  constructor(
    id,
    titol,
    idiomaOriginal,
    idiomaDesti,
    lletraOriginal,
    lletraDesti,
    notes
  ) {
    this.id = id;
    this.titol = titol;
    this.idiomaOriginal = idiomaOriginal;
    this.idiomaDesti = idiomaDesti;
    this.lletraOriginal = lletraOriginal;
    this.lletraDesti = lletraDesti;
    this.notes = notes;
  }
  static fromJSON(json) {
    return new Partitura(
      json.idpartitura,
      json.titol,
      json.idiomaoriginal,
      json.idiomatraduccio,
      json.lletraoriginal,
      json.lletratraduccio,
      json.notes
    );
  }
}
