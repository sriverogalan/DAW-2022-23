import {pintarMeteorits} from './nasaView.js';
import {pintarMeteorits as consola} from './nasaView2.js';

export async function meteorits() {
  const data = document.querySelector("#data").value;
  const meteorFetch = await fetch(
    "https://theteacher.codiblau.com/exercicis/nasa?date=" + data
  );
  const meteorits = await meteorFetch.json();
  pintarMeteorits(meteorits);
  consola(meteorits);
}