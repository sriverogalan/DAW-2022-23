export class Animal{
    constructor(id,name,age,gender,numregistre,type) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.numregistre=numregistre;
        this.type=type;
    }

    static fromJSON(json){
        return new Animal(
            json.idanimal,
            json.nom,
            null,
            json.sexe,
            json.numregistre,
            json.tipus
            )
    }
}