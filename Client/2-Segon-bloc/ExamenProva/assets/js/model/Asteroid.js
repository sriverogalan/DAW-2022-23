export class Asteroid {
  constructor(nom, isPerillos, diametreMin, diametreMax, url) {
    this.nom = nom;
    this.isPerillos = isPerillos;
    this.diametreMin = diametreMin;
    this.diametreMax = diametreMax;
    this.url = url;
  }

  static fromJSON(json) {
    return new Asteroid(
      json.name,
      json.is_potentially_hazardous_asteroid,
      json.estimated_diameter.meters.estimated_diameter_min, 
      json.estimated_diameter.meters.estimated_diameter_max,
      json.nasa_jpl_url
    );
  }
}
