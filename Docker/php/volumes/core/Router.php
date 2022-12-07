<?

namespace Core;

class Router
{
  private $request;
  public function __construct()
  {
    $this->request = $_SERVER['REQUEST_URI'];
    switch ($this->request) {
      case '/':
        require __DIR__ . '/view/index.php';
        break;
      case '':
        require __DIR__ . '/view/index.php';
        break;
      case '/index':
        require __DIR__ . '/view/index.php';
        break;
      case 'afegir':
        require __DIR__ . '/view/afegir.php';
        break;
      case 'afegir/':
        require __DIR__ . '/view/afegir.php';
        break;
      case '/fitxa':
        require __DIR__ . '/view/fitxa.php';
        break;
      default:
        http_response_code(404);
        require __DIR__ . '/views/404.php';
        break;
    }
  }
}
