import { Animal } from "../model/Animal.js";

export class AnimalService {
  _URL = "https://theteacher.codiblau.com";
  static _instance;
  _constructor() {}
  static getInstance() {
    if (!this._instance) {
      this._instance = new AnimalService();
    }
    return this._instance;
  }
  async getAnimals() {
    const animalsFetch = await fetch(this._URL + "/vetplus/getAnimals");
    const animals = await animalsFetch.json();

    const resultat = [];
    for (let animalJSON of animals) {
      const animalAux = new Animal(
        animalJSON.id,
        animalJSON.nom,
        null,
        animalJSON.sexe,
        animalJSON.numregistre,
        animalJSON.tipus
      );
      resultat.push(animalAux);
    }
    return resultat;
  }
  getAnimal() {}
  async save(nom, sexe, numRegistre, tipus) {
    const saveFetch = await fetch(this._URL + "/vetplus/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        animal :{ 
            idanimal: null,
            nom: nom,
            sexe: sexe,
            numregistre: numRegistre,
            tipus: tipus,
        }
      }), });
      
      const saved = await saveFetch.json();
      console.log(saved);
  }
}
