function Joc(){
    this.mans = ["pedra", "paper", "tisores"]; 
    this.maMaquina = this.mans[Math.floor(Math.random() * this.mans.length)];  
    this.maJugador= prompt('Introduir "pedra", "paper" o "tisores"');  
    this.init = function(){  
        this.maJugador = this.maJugador.toLowerCase();   
        console.log(this.maJugador);
        while(this.mans.indexOf(this.maJugador) === -1){ 
            this.maJugador = prompt('Introduir "pedra", "paper" o "tisores"')
            this.maJugador = this.maJugador.toLowerCase(); 
        }
        this.checkWin(); 
    }
    this.checkWin = function(){ 
        if (this.maMaquina === "pedra" && this.maJugador === "paper") {
            alert("Has guanyat!");
        } else if (this.maMaquina === "paper" && this.maJugador === "tisores") {
            alert("Has guanyat!");
        } else if (this.maMaquina === "tisores" && this.maJugador === "pedra") {
            alert("Has guanyat!");
        } else if (this.maMaquina === this.maJugador) {
            alert("Empat!");
        } else {
            alert("Has perdut!");
        }
    }
    this.pinta = function(){
        document.getElementById("hand1").innerHTML = this.maMaquina;
        document.getElementById("hand2").innerHTML = this.maJugador;
    }
} 

var joc = new Joc();
joc.init();