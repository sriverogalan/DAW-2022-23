export class Cronometro {
  constructor(tempsInterval, partitura) {
    this.tempsInterval = tempsInterval;
    this.partitura = partitura;
  }

  milisegonsCanso = () => {
    let temps = tempsInterval * partitures[partitura].length + tempsInterval;
    return temps;
  };

  init = () => {
    this.tempsIni = new Date();
    this.tempsIni = this.tempsIni.getTime();
    this.tempsFi = this.tempsIni + this.milisegonsCanso();
    this.tempsActual = this.tempsIni;

    this.interval = setInterval(() => {
      this.tempsActual = new Date();
      this.tempsActual = this.tempsActual.getTime();
      this.milisegons = this.tempsActual - this.tempsIni;
      this.pinta();
      if (this.tempsActual >= this.tempsFi) {
        clearInterval(this.interval);
      }
    }, 1);
  };

  pinta = () => {
    let temps = this.tempsActual - this.tempsIni;
    let hores = Math.floor(temps / 3600000);
    let minuts = Math.floor(temps / 1000 / 60);
    let segons = Math.floor((temps / 1000) % 60);
    let milisegons = Math.floor((temps % 1000) / 10);
    document.querySelector(
      "[name='" + this.partitura + "']"
    ).innerHTML = ` ${hores}:${minuts}:${segons}.${milisegons}  `;
    console.log(this.partitura);
  };
}
