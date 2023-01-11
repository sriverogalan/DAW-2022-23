export class Animal{
    constructor(idanimal,nom,sexe,numregistre,tipus) {
        this.idanimal=idanimal;
        this.nom=nom;
        this.sexe=sexe;
        this.numregistre=numregistre;
        this.tipus=tipus;
    }

    static fromJSON(json){
        return new Animal(
            json.idanimal,
            json.nom,
            json.sexe,
            json.numregistre,
            json.tipus
            )
    }
}