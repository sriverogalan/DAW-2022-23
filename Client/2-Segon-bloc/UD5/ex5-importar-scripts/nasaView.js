export function pintarMeteorits(meteorits) {
  let table = "";
  table = '<table id="taula">';
  //Capçalera
  table += "<tr>";
  table += "<th>Nom</th>";
  table += "<th>Potencialment perillos</th>";
  table += "<th>Distancia Terra</th>";
  table += "</tr>";
  for (let meteorit of meteorits) {
    table += "<tr>";
    table += "<td>" + meteorit.name + "</td>";
    table += "<td>" + meteorit.is_potentially_hazardous_asteroid + "</td>";
    table +=
      "<td>" +
      meteorit.close_approach_data[0].miss_distance.kilometers +
      "</td>";
  }
  table += "</table>";
  document.querySelector("#app").innerHTML = table;
}
