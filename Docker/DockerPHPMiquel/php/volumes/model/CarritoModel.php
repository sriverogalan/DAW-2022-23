<?

namespace Model;

use Core\SPDO as SPDO;

class CarritoModel
{
    protected $db;

    public function __construct()
    {
        $this->db = SPDO::singleton();
    }

    public function selectCarritoList()
    {
        $consulta = $this->db->prepare('SELECT * FROM carrito');
        $consulta->execute();
        return $consulta;
    }

    public function insertProduct($product, $quantitat, $subtotal)
    {
        $consulta = $this->db->prepare('SELECT * FROM carrito WHERE id = :id');
        $consulta->bindParam(':id', $product['id']);
        $consulta->execute();
        $productExists = $consulta->fetch();
        if ($productExists) {
            $this->updateProduct($product, $quantitat);
            return;
        } else {
            $consulta = $this->db->prepare('INSERT INTO carrito (id, nom, descripcio, preu, quantitat, subtotal) VALUES (:id, :nom, :descripcio, :preu, :quantitat, :subtotal)');
            $consulta->bindParam(':id', $product['id']);
            $consulta->bindParam(':nom', $product['nom']);
            $consulta->bindParam(':descripcio', $product['descripcio']);
            $consulta->bindParam(':preu', $product['preu']);
            $consulta->bindParam(':quantitat', $quantitat);
            $consulta->bindParam(':subtotal', $subtotal);
            $consulta->execute();
        }
        return $consulta->fetch();
    }

    public function updateProduct($product,  $quantitat)
    {
        $quantitat = $quantitat + 1;
        $subtotal = $this->calculateSubtotal($product, $quantitat);
        $consulta = $this->db->prepare('UPDATE carrito SET quantitat = :quantitat, subtotal = :subtotal WHERE id = :id');
        $consulta->bindParam(':id', $product['id']);
        $consulta->bindParam(':quantitat', $quantitat);
        $consulta->bindParam(':subtotal', $subtotal);
        $consulta->execute();
    }



    public function calculateSubtotal($product, $quantitat)
    {
        return $product['preu'] * $quantitat;
    }
}
