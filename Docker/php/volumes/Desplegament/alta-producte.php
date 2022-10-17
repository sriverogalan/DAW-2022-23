<?php 
include 'config-db.php';    
$nom = $_POST['nom'];
$descripcio = $_POST['descripcio'];
$preu = $_POST['preu'];
$sql = "INSERT INTO articles (nom, descripcio, preu) VALUES ('$nom', '$descripcio', '$preu')";

$target_dir = "uploads/";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 1;
$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
// Check if image file is a actual image or fake image
if(isset($_POST["submit"])) {
    $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
    if($check !== false) {
        echo "File is an image - " . $check["mime"] . ".";
        $uploadOk = 1;
    } else {
        echo "File is not an image.";
        $uploadOk = 0;
    } 
} 

if ($conn->query($sql) === TRUE) {
    echo "Se ha subido el producto correctamente";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}  
?>