document.querySelector("#jugar").addEventListener('click', function () {
    var joc = new Joc();
    joc.init();
});
document.querySelector('#ajuda').addEventListener('click', function () {
    openHelp();
});
document.querySelector('#tancarajuda').addEventListener('click', function () {
    closeHelp();
});
document.querySelector('#redirigir').addEventListener('click', function () {
    window.location.href = "https://www.iesmanacor.cat";
});

var Joc = function () {
    this.type = ["pedra", "paper", "tisores"];
    this.maJugador;
    this.maMaquina = new Ma(this.type[Math.floor(Math.random() * this.type.length)]);
    this.init = function () {
        this.comprobar();
        alert(this.resultat());
        this.pinta();
    }

    this.comprobar = function () {
        var eleccioJugador = prompt('Eligeix "pedra", "paper" o "tisores"');
        eleccioJugador = eleccioJugador.toLowerCase();
        while (eleccioJugador !== "pedra" && eleccioJugador !== "paper" && eleccioJugador !== "tisores") {
            alert("Error, has d'introduir 'pedra', 'paper' o 'tisores'");
            eleccioJugador = prompt('Eligeix "pedra", "paper" o "tisores"');
            eleccioJugador = eleccioJugador.toLowerCase();
        }
        this.maJugador = new Ma(eleccioJugador);
    }
    this.resultat = function () {
        if (this.maJugador.type === this.maMaquina.type) {
            return "Empat";
        } else if (this.maJugador.type === "pedra" && this.maMaquina.type === "tisores") {
            return "Has guanyat";
        } else if (this.maJugador.type === "paper" && this.maMaquina.type === "pedra") {
            return "Has guanyat";
        } else if (this.maJugador.type === "tisores" && this.maMaquina.type === "paper") {
            return "Has guanyat";
        } else {
            return "Has perdut";
        }
    }
    this.pinta = function () {
        document.querySelector("#hand1").innerHTML = "<img src='" + this.maJugador.src() + "' style='width=300px'>"
        document.querySelector("#hand2").innerHTML = "<img src='" + this.maMaquina.src() + "' style='width=300px'>";
        document.querySelector("#hand1").addEventListener('mouseover', function () {
            document.querySelector("#hand1").innerHTML = "<img src='images/hand5.png' style='width=300px'>";
        });
        document.querySelector("#hand2").addEventListener('mouseover', function () {
            document.querySelector("#hand2").innerHTML = "<img src='images/hand5.png' style='width=300px'>";
        });
    }
}

this.Ma = function (type) {
    this.type = type;
    this.src = function () {
        if (this.type === "pedra") {
            return "images/hand0.png";
        } else if (this.type === "paper") {
            return "images/hand5.png";
        } else if (this.type === "tisores") {
            return "images/hand2.png";
        }
    }
}

var myWindow;

var openHelp = function () {
    myWindow = window.open("ajuda.html", "", "width=600,height=400");
}

var closeHelp = function () {
    myWindow.close();
}

var redireccionar = function () {
    window.location.href = "https://www.iesmanacor.cat";
}
