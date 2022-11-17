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
    return animals.map((a) => Animal.fromJSON(a));
    //Return objectes Animal
    /* const resultat = [];
        for(let animalJSON of animals){
            const animalAux = Animal.fromJSON(animalJSON);
            resultat.push(animalAux);
        }
        return resultat; */
  }

  getAnimal() {}

  async save(nom, sexe, numregistre, tipus) {
    const saveFetch = await fetch(this._URL + "/vetplus/save", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        animal: {
          idanimal: null,
          nom: nom,
          sexe: sexe,
          numregistre: numregistre,
          tipus: tipus,
        },
      }),
    });
    const saved = await saveFetch.json();
    console.log(saved);
  }
}
