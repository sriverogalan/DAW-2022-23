<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        $miarchivo = fopen("archivo.txt", "r+"); // fopen() abre un archivo
        // modos de apertura
        // r: solo lectura
        // w: escritura
        // a: agregar
        // r+: lectura y escritura
        // w+: escritura y lectura
        // a+: agregar y lectura
        // x: crear y escribir
        // x+: crear y escribir y leer
        // b: binario
        // t: texto
        // +: lectura y escritura

        if ($miarchivo === false){
            echo "Error al abrir el archivo";
        } else {
            $contenido = fread($miarchivo, filesize("archivo.txt")); // fread() lee un archivo filesize() devuelve el tamaño del archivo
            echo $contenido;
        }


        rewind($miarchivo); // rewind() mueve el puntero al principio del archivo
        echo "<br><br>";

        while (feof($miarchivo) == false){ // feof() devuelve true si el puntero esta al final del archivo
            echo fgets($miarchivo) . "<br>"; // fgets() lee una linea del archivo
        }
        $todo = file_get_contents("archivo.txt"); // file_get_contents() lee todo el archivo
        echo "<br><br>";
        echo $todo;

        $arraya = file("archivo.txt"); // file() devuelve un array con las lineas del archivo
        echo "<br><br>";
        var_dump($arraya);

        $miarchivo2 = fopen("archivo2.txt", "a+"); // fopen() abre un archivo

        fwrite($miarchivo2, "Hola mundo"); // fwrite() escribe en un archivo
        fflush($miarchivo2); // fflush() vacia el buffer de escritura
echo "<br><br>";
        $arrayinfo = stat("archivo3.txt"); // stat() devuelve informacion sobre un archivo
        var_dump($arrayinfo);

    ?>
</body>
</html>
