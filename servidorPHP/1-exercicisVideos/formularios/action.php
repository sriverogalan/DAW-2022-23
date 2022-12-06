<?php

var_dump($_FILES);

$directorioSubida = 'uploads/';
$max_file_size = 1000000;
$extensionesValidas = array('jpg', 'jpeg', 'gif', 'png');

if (isset($_FILES['imagen'])){
    $errores = 0;
    $nombreArchivo = $_FILES['imagen']['name'];
    $filesize = $_FILES['imagen']['size'];
    $directorioSubida = $_FILES['imagen']['tmp_name'];
    $tipoArchivo = $_FILES['imagen']['type'];
    $arrayArchivo = pathinfo($nombreArchivo);
    var_dump($arrayArchivo);
    $extension = $arrayArchivo['extension'];

    if(!in_array($extension, $extensionesValidas)){
        echo 'La extension no es valida';
        $errores++;
    }

    if($filesize > $max_file_size){
        echo 'El archivo es demasiado grande';
        $errores++;
    }

    if($errores == 0){
        $nombreCompleto = $directorioSubida.$nombreArchivo;
        move_uploaded_file($directorioSubida,$nombreCompleto);
    }

}

?>