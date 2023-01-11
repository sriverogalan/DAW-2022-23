import { Asteroid } from "../model/Asteroid.js";
export class AsteroidService {
  _URL = "https://theteacher.codiblau.com";
  static _instance;

  _constructor() {}

  static getInstance() {
    if (!this._instance) {
      this._instance = new CanalService();
    }
    return this._instance;
  }

  async getMeteorits(date) {
    const meteoritsFetch = await fetch(
      this._URL + "/exercicis/nasa?date=" + date
    );
    const meteorits = await meteoritsFetch.json();
    const meteoritsPromeses = [];
    for (let i = 0; i < meteorits.length; i++) {
      meteoritsPromeses.push(Asteroid.fromJSON(meteorits[i]));
    }
    const meteoritsArray = await Promise.all(meteoritsPromeses);
    return meteoritsArray;
  }

  async getAllMeteorits(dates) {
    const promises = [];
    for (const date of dates) {
      promises.push(this.getMeteorits(date));
    }
    const meteorits = await Promise.all(promises);
    return meteorits;
  }
}
