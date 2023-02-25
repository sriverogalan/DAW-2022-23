// IMPORTANT!! NO TENIM ACCESS AL DOM

self.addEventListener("message",(ev) => {
    let x = ev.data.ini; 
    for (let i = 0; i < ev.data.fi; i++) {
      x++;
    }
    postMessage(x);
    
})