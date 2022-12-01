import {URL} from "./UtilService.js"
import {Programa} from "../model/Programa.js";

export class ProgramaService{

    static async loadProgrames(canals){
        //Segons l'enunciat els canals van de 1 a 6, però no sabem quin canal és quin, per tant, farem el mapeig després.
        //Hores de 0 a 23
        const programes = [];
        for(let i = 1; i <= 6; i++){
            for(let j = 0; j <= 23; j++){
                const programa = fetch(URL + "/exercicis/programacio/tv",{
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: "can=" + i + "&hour=" + j
                }).then(response => response.json());

                programes.push(programa);
            }
        }
        const programesLoaded =  await Promise.all(programes)
        return programesLoaded.map(programa=>{
            const canal = canals.find(canal => canal.nom === programa.name);

            let edat = "S/C";
            if(programa.hasOwnProperty("age")){
                edat = programa.age;
            }

            return new Programa(programa.program,canal,edat,programa.hour);
        });
    }
}