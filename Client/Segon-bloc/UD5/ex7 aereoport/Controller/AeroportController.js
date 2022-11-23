import { Aeroport } from "../model/Aeroport.js";

export class AeroportController {
    _URL = "https://theteacher.codiblau.com"
    static _instance

    _constructor() {}

    static getInstance() {
        if (!this._instance) {
            this._instance = new AeroportController()
        }
        return this._instance
    }

    async getAeroports() {
        const aeroportFetch = await fetch(this._URL + "/exercicis/airports")
        const aerports = await aeroportFetch.json()

        return aerports.map((a) => Aeroport.fromJSON(a));
    }
}