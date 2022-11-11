<?php
class ProductModel
{
    protected $db;

    public function __construct()
    {
        //Traemos la única instancia de PDO
        $this->db = SPDO::singleton();
    }

    public function listadoTotal()
    {
        //realizamos la consulta de todos los items
        $consulta = $this->db->prepare('SELECT * FROM articles');
        $consulta->execute();
        //devolvemos la colección para que la vista la presente.
        return $consulta;
    }
}
