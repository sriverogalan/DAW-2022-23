<?php
namespace Model;
use Core\SPDO as SPDO;
class ProductModel
{
    protected $db;

    public function __construct()
    {
        $this->db = SPDO::singleton();
    }

    public function listadoTotal()
    {
        $consulta = $this->db->prepare('SELECT * FROM articles');
        $consulta->execute();
        return $consulta;
    }

    public function obtenerConsultaProductoPorId($id)
    {
        $consulta = $this->db->prepare('SELECT * FROM articles where id = :id');
        $consulta->bindValue('id', $id);
        $consulta->execute();
        return $consulta;
    }


    public function obtenerProductoPorId($id)
    {
        $consulta = $this->db->prepare('SELECT * FROM articles where id = :id');
        $consulta->bindValue('id', $id);
        $consulta->execute();
        return $consulta->fetch();
    }

    public function insertarProducto($nom, $desc, $preu)
    {
        $query = $this->db->prepare("INSERT INTO articles (nom, descripcio, preu) VALUES (:nom, :desc, :preu)");
        $query->bindValue('nom', $nom);
        $query->bindValue('desc', $desc);
        $query->bindValue('preu', $preu);
        $query->execute();
    } 
    public function insertarFoto($image, $name, $size, $tmp, $file)
    {
        $directorioSubida = "./View/img/";
        $max_file_size = "512000";
        $extensionesValidas = array("jpg");

        if (isset($image)) {
            $errores = 0;
            $nombreArchivo = $name;
            $filesize = $size;
            $directorioTemp = $tmp;
            $tipoArchivo = $file;
            $arrayArchivo = pathinfo($nombreArchivo);
            $extension = $arrayArchivo['extension'];
        }

        if (!in_array($extension, $extensionesValidas)) {
            echo "Extension no valida";
            $errores = 1;
        }

        if ($errores == 0) {    
            $nombreArchivo =  $this->db->getLastIdTableArticles()["MAX(id)"]+1 .  ".jpg";
            $nombreCompleto = $directorioSubida . $nombreArchivo;
            move_uploaded_file($directorioTemp, $nombreCompleto);
            echo "Archivo subido correctamente";
        }
        return $errores;
    }
}
