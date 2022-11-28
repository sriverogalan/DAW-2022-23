export class Programa {
    
  constructor(name, hour, program, age) {
    this.nom = name;
    this.hora = hour;
    this.programa = program;
    this.edat = age;
  }
  
  static fromJSON(json) {
    return new Programa(json.nom, json.hora, json.programa, json.edat);
  }
}