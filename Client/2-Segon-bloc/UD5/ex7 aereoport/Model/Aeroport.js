export class Aeroport {
  constructor(codi, nom, latitud, longitud, ciutat) {
    this.codi = codi;
    this.nom = nom;
    this.latitud = latitud;
    this.longitud = longitud;
    this.ciutat = ciutat;
  }
  static fromJSON(json) {
    return new Aeroport(
      json.code,
      json.name,
      json.lat,
      json.lon,
      json.city
    );
  }
}
