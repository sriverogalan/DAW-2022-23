<?php
$servername = "localhost";
$username = "root";
$password = "12345678";
$dbname = "Botiga";

// Create connection
$conn = new ($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

?>