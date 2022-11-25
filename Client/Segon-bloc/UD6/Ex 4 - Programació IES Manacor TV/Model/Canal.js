export class Canal {
  constructor(nom) {
    this.nom = nom;
    this.programacio = [];
  }
  static fromJSON(json) {
    return new Canal(json.nom);
  }
}
