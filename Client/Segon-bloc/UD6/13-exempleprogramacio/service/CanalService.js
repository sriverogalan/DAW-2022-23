import {URL} from "./UtilService.js"
import {Canal} from "../model/Canal.js";
export class CanalService{
    canals = [];

    constructor() {
    }

    static async loadCanals(){
        const canals = await fetch(URL + "/exercicis/programacio/info").then(response => response.json());
        this.canals = Object.entries(canals).map(entry => {
            const [key, value] = entry;
            return new Canal(null,key,value);
        });
        return this.canals;
    }

    afegirCanal(canal){
        this.canals.push(canal);
    }

}