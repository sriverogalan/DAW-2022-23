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
        $consulta = $this->db->prepare('SELECT * FROM articles where id = ' . $id);
        $consulta->execute(); 
        return $consulta;
    }
    public function insertarProducto($name, $desc, $price)
    {
        $query = $this->db->prepare("INSERT INTO articles (nom, descripcio, preu) VALUES ('$name', '$desc', '$price')");
        $query->execute();
    }
}
