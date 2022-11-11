<!DOCTYPE html>
<html>
<head>
</head>
<body>
<?php
$servername = "mysql";
$username = "root";
$password = "root";
$dbname = "prova";

// Create connection
$conn = new mysqli($servename, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, nom, llinatges FROM persona";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "id: " . $row["id"]. " - Name: " . $row["nom"]. " " . $row["cognom"]. "<br>";
  }
} else {
  echo "0 results";
}
$conn->close();
?>


</body>
</html>