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
        if ($this->existsProduct($product) === true) {
            $product = $this->returnProduct($product);
            $this->updateProductInserted($product);
            return;
        } 
        $consulta = $this->db->prepare('INSERT INTO carrito (id, nom, descripcio, preu, quantitat, subtotal) VALUES (:id, :nom, :descripcio, :preu, :quantitat, :subtotal)');
        $consulta->bindParam(':id', $product['id']);
        $consulta->bindParam(':nom', $product['nom']);
        $consulta->bindParam(':descripcio', $product['descripcio']);
        $consulta->bindParam(':preu', $product['preu']);
        $consulta->bindParam(':quantitat', $quantitat);
        $consulta->bindParam(':subtotal', $subtotal);
        $consulta->execute();
        return $consulta->fetch();
    }

    public function existsProduct($product)
    { 
        $consulta = $this->db->prepare('SELECT * FROM carrito WHERE id = :id');
        $consulta->bindParam(':id', $product['id']);
        $consulta->execute();
        if ($consulta->rowCount() > 0) {
            return true;
        } else {
            return false;
        }
    } 

    public function returnProduct($product)
    {
        $consulta = $this->db->prepare('SELECT * FROM carrito WHERE id = :id');
        $consulta->bindParam(':id', $product['id']);
        $consulta->execute();  
        return $consulta->fetch(); 
    } 

    public function updateProductInserted($product)
    { 
        $quantitat = $product['quantitat']+1 ;
        $subtotal = $product['preu'] * $quantitat;
        $consulta = $this->db->prepare('UPDATE carrito SET quantitat = :quantitat, subtotal = :subtotal WHERE id = :id');
        $consulta->bindParam(':id', $product['id']);
        $consulta->bindParam(':quantitat', $quantitat);
        $consulta->bindParam(':subtotal', $subtotal);
        $consulta->execute();
    }

    public function updateProduct($id, $quantitat, $subtotal)
    {
        $consulta = $this->db->prepare('UPDATE carrito SET quantitat = :quantitat, subtotal = :subtotal WHERE id = :id');
        $consulta->bindParam(':id', $id);
        $consulta->bindParam(':quantitat', $quantitat);
        $consulta->bindParam(':subtotal', $subtotal);
        $consulta->execute();
    }

    public function deleteProduct($id)
    {
        $consulta = $this->db->prepare('DELETE FROM carrito WHERE id = :id');
        $consulta->bindParam(':id', $id);
        $consulta->execute();
    }
}
