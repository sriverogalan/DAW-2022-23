<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        //Arrays
    echo "<br><br>";
    echo "<br><br>";
        echo "Array 1";
        echo "<br><br>";

        $numeros1 = array(11,22,33);
        $numeros2 = array(11,33,55);

        $colores1 = array("color1" => "rojo", "color2" => "verde", "color3" => "azul", "color4" => "naranja");
        $colores2 = array("color1" => "verde", "color2" => "azul", "color3" => "amarillo");

        $diferencias1 = array_diff($numeros1, $numeros2); // array_diff() devuelve un array con las diferencias entre los arrays
        var_dump($diferencias1); // var_dump() muestra el contenido de una variable y su tipo de dato (array, string, int, etc)
        echo "<br><br>";

        $diferencias2 = array_diff($colores1, $colores2);
        var_dump($diferencias2);

        // Array 2
    echo "<br><br>";
    echo "<br><br>";
        echo "<br><br>";
        echo "Array 2 <br><br>";

        $a1 = array("rojo", "verde", "azul", "naranja");
        $a2 = array("rosa", "lila", "gris");

        $juntar = array_merge($a1, $a2); // array_merge() une dos arrays
        var_dump($juntar);

        // Array 3
    echo "<br><br>";
    echo "<br><br>";
        echo "<br><br><br>";
        echo "Array 3<br><br>";
        $dias = array("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo");
        var_dump($dias);
        echo "<br><br>";
        echo sort($dias); // sort() ordena un array alfabeticamente
        var_dump($dias);
        echo "<br><br>";
        echo rsort($dias); // rsort() ordena un array alfabeticamente de forma inversa
        var_dump($dias);
        echo "<br><br>";
        echo asort($dias); // asort() ordena un array alfabeticamente manteniendo los indices
        var_dump($dias);


        // Array 4
    echo "<br><br>";
    echo "<br><br>";
    echo "Array 4<br><br>";
        echo "<br><br><br>";
        $arraynombres= array("JAVIER" => "29", "PATRICIA" => "30", "JUAN" => "31", "MARIA" => "32");

        var_dump($arraynombres);
        ksort($arraynombres); // ksort() ordena un array alfabeticamente manteniendo los indices
        echo "<br><br>";
        var_dump($arraynombres);
        echo "<br><br>";
        $dias2 = array("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo");
        shuffle($dias2); // shuffle() mezcla los elementos de un array aleatoriamente
        var_dump($dias2);
        //Arrays 5
    echo "<br><br>";
    echo "<br><br>";
        echo "Array 5";
        echo "<br><br>";

        $frutas = array("manzana", "pera", "naranja", "uva", "fresa");
        var_dump($frutas);
        echo "<br><br>";
        $eliminado = array_shift($frutas); // array_shift() elimina el primer elemento de un array y lo devuelve
        echo "El elemento eliminado es: $eliminado<br>";
        var_dump($eliminado);
        echo "<br><br>";
        array_unshift($frutas, "sandia"); // array_unshift() añade un elemento al principio de un array
        var_dump($frutas);
        echo "<br><br>";

        // frutas2
        $frutas2 = array("manzana", "pera", "naranja", "uva", "fresa");
        var_dump($frutas);
        echo "<br><br>";

        $eliminado2 = array_pop($frutas2); // array_pop() elimina el ultimo elemento de un array y lo devuelve
        echo "El elemento eliminado es: $eliminado2<br>";
        var_dump($eliminado2);
        echo "<br><br>";
        array_push($frutas2, "sandia"); // array_push() añade un elemento al final de un array
        var_dump($frutas2);
        echo "<br><br>";

    // Arrays 6
    echo "<br><br>";
    echo "Array 6";
    echo "<br>";

    $frutas = array("manzana", "pera", "naranja", "uva" );

    $elementos = count($frutas); // count() cuenta los elementos de un array
    var_dump($elementos);
    echo "<br><br>";
    $elementos2 = current($frutas); // current() devuelve el elemento actual del array
    var_dump($elementos2);
    echo "<br><br>";
    end($frutas); // end() mueve el puntero al ultimo elemento del array
    $elementos3 = current($frutas);
    var_dump($elementos3);
    echo "<br><br>";

    $meses = array(0 => "Enero", 1 => "Febrero", 2 => "Marzo", 3 => "Abril" );

    $clave = array_search("Abril", $meses); // array_search() busca un elemento en un array y devuelve su clave
    if ($clave){
        echo "La clave es: $clave";
    } else {
        echo "No se ha encontrado Marzo";
    }

    ?>
</body>
</html>
