export class Programa {
    
  constructor(arrayString) {
    this.nom = arrayString;
  }
  
  static fromJSON(json) {
    return new Programa(json);
  }
}