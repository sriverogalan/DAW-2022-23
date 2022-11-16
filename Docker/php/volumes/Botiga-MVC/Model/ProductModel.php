<?php
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
    public function obtenerProductoPorId($id)
    {
        $consulta = $this->db->prepare('SELECT * FROM articles where id = :id');
        $consulta->bindValue('id', $id);
        $consulta->execute();
        return $consulta;
    }
    public function insertarProducto($nom, $desc, $preu)
    { 
        $query = $this->db->prepare("INSERT INTO articles (nom, descripcio, preu) VALUES (:nom, :desc, :preu)");
        $query->bindValue('nom', $nom);
        $query->bindValue('desc', $desc);
        $query->bindValue('preu', $preu);
        $query->execute();
        $this->insertarFoto();
    }

    public function insertarFoto(){ 
        $insert = $this->db->lastInsertId();
        $target_dir = "View/img/";
        $target_file = $target_dir . $insert . ".jpg";
        $uploadOk = 1;
        $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

        if (isset($_POST["submit"])) {
            $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
            if ($check !== false) {
                echo "File is an image - " . $check["mime"] . ".";
                $uploadOk = 1;
            } else {
                echo "File is not an image.";
                $uploadOk = 0;
                return false;
            }
        }
        if (file_exists($target_file)) {
            echo "Sorry, file already exists.";
            $uploadOk = 0;
            return false;
        }
        if ($_FILES["fileToUpload"]["size"] > 500000) {
            echo "Sorry, your file is too large.";
            $uploadOk = 0;
            return false;
        }
        if ($imageFileType != "jpg") {
            echo "Sorry, only JPG files are allowed.";
            $uploadOk = 0;
            return false;
        }
        if ($uploadOk == 0) {
            echo "Sorry, your file was not uploaded.";
            return false;
        } else {
            if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
                echo "The file " . htmlspecialchars(basename($_FILES["fileToUpload"]["name"])) . " has been uploaded.";
            } else {
                echo "Sorry, there was an error uploading your file.";
                return false;
            }
        } 
        return true;
    }
}
