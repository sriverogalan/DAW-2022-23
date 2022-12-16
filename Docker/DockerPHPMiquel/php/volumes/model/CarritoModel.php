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
     
    
}
