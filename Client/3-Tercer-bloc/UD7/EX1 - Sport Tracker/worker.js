setInterval(async () => {
  const animsFetch = await fetch(
    "https://theteacher.codiblau.com/exercicis/sporttracker/anims"
  );
  let anims = await animsFetch.json();
  postMessage(anims);
}, 10000);  