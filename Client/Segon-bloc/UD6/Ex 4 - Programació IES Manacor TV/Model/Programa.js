export class Programa {
  constructor(name, hour, program, age) {
    this.name = name;
    this.hour = hour;
    this.program = program;
    this.age = age;
  }

  static fromJSON(json) {
    return new Programa(json.name, json.hour, json.program, json.age);
  }
}
