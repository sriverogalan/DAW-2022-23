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

    public function listadoCarrito()
    {
        $consulta = $this->db->prepare('SELECT * FROM carrito');
        $consulta->execute();
        return $consulta;
    }    

    public function obtenerConsultaProductoPorId($id)
    {
        $consulta = $this->db->prepare('SELECT * FROM carrito where id = :id');
        $consulta->bindValue('id', $id);
        $consulta->execute();
        return $consulta;
    }

    public function obtenerProductoPorId($id)
    {
        $consulta = $this->db->prepare('SELECT * FROM carrito where id = :id');
        $consulta->bindValue('id', $id);
        $consulta->execute();
        return $consulta->fetch();
    }

    public function insertarProducto($nom, $desc, $preu, $quantitat, $subtotal)
    {
        $query = $this->db->prepare("INSERT INTO carrito (nom, descripcio, preu, quantitat, subtotal) VALUES (:nom, :desc, :preu, :quantitat, :subtotal)");
        $query->bindValue('nom', $nom);
        $query->bindValue('desc', $desc);
        $query->bindValue('preu', $preu);
        $query->bindValue('quantitat', $quantitat);
        $query->bindValue('subtotal', $subtotal);
        $query->execute();
    }



}