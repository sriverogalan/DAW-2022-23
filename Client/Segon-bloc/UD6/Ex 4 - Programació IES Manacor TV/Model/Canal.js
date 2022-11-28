export class Canal {
  constructor(nom, descripcio) {
    this.nom = nom;
    this.descripcio = descripcio;
  }
  static fromJSON(json) {
    return new Canal(json.nom, json.descripcio);
  }
}
