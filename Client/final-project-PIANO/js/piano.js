function Tecla(id, tecla, audio) {
    this.id = id;
    this.tecla = tecla;
    this.audio = audio;
}

function Piano() {
    this.teclas = [];
    this.teclaActual = null;
    this.teclaAnterior = null;
    this.teclaSiguiente = null;
    
 
}