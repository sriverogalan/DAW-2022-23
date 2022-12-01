export class Programa {
    constructor(nom, canal, edat, horari) {
        this.nom = nom;
        this.canal = canal;
        this.edat = edat;
        this.horari = horari;
    }
    static fromJSON(json) {
        return new Programa(json.nom, json.canal, json.edat, json.horari);
    }
}