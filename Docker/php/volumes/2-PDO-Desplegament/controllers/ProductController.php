<?php
require '../model/database.php';

function getProducts()
{
    try {
        $pdo = AccessDatabase::getInstance()->getConnection();
        $sql =  $pdo->prepare("SELECT * FROM articles");
        $sql->execute();
        $result = $sql->fetchAll(PDO::FETCH_ASSOC);
        $pdo = null;
        return $result;
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
}

function getProduct($id)
{
    try {
        $pdo = AccessDatabase::getInstance()->getConnection();
        $sql =  $pdo->prepare("SELECT * FROM articles WHERE id = :id");
        $sql->bindParam(':id', $id);
        $sql->execute();
        $result = $sql->fetch(PDO::FETCH_ASSOC);
        $pdo = null;
        return $result;
    } catch (PDOException $e) {
        echo $e->getMessage();
    } 
}

function insertProduct($nom, $descripcio, $preu)
{
    try {
        $pdo = AccessDatabase::getInstance()->getConnection();
        $sql =  $pdo->prepare("INSERT INTO articles (nom, descripcio, preu) VALUES (:nom, :descripcio, :preu)");
        $sql->bindParam(':nom', $nom);
        $sql->bindParam(':descripcio', $descripcio);
        $sql->bindParam(':preu', $preu);
        if(!insertProductPicture()){
            return;
        }
        $sql->execute(); 
        $pdo = null;
    } catch (PDOException $e) {
        echo $e->getMessage();
    } 
    echo "Success insert :)";
}

function insertProductPicture()
{ 
    $pdo = AccessDatabase::getInstance()->getConnection();
    $insert = $pdo->lastInsertId();
    $target_dir = "../img/";
    $target_file = $target_dir . $insert . ".jpg";
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
    
    if (isset($_POST["submit"])) {
        $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
        if ($check !== false) {
            echo "File is an image - " . $check["mime"] . ".";
            $uploadOk = 1;
        } else {
            echo "File is not an image.";
            $uploadOk = 0;
            return false;
        }
    }
    if (file_exists($target_file)) {
        echo "Sorry, file already exists.";
        $uploadOk = 0;
        return false;
    }
    if ($_FILES["fileToUpload"]["size"] > 500000) {
        echo "Sorry, your file is too large.";
        $uploadOk = 0;
        return false;
    }
    if ($imageFileType != "jpg") {
        echo "Sorry, only JPG files are allowed.";
        $uploadOk = 0;
        return false;
    }
    if ($uploadOk == 0) {
        echo "Sorry, your file was not uploaded.";
        return false;
    } else {
        if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
            echo "The file " . htmlspecialchars(basename($_FILES["fileToUpload"]["name"])) . " has been uploaded.";
        } else {
            echo "Sorry, there was an error uploading your file.";
            return false;
        }
    }
    $pdo = null;
    return true;
}

function updateProduct($id, $nom, $descripcio, $preu)
{
    try { 
        $pdo = AccessDatabase::getInstance()->getConnection();
        $sql = $pdo->prepare("UPDATE articles SET nom = :nom, descripcio = :descripcio, preu = :preu WHERE id = :id");
        $sql->bindParam(':id', $id);
        $sql->bindParam(':nom', $nom);
        $sql->bindParam(':descripcio', $descripcio);
        $sql->bindParam(':preu', $preu);
        $sql->execute();
        $pdo = null;
    } catch (PDOException $e) {
        echo $e->getMessage();
    }
    echo "Success update :)"; 
}

function deleteProduct($id)
{
    try {
        $pdo = AccessDatabase::getInstance()->getConnection();
        $sql = $pdo->prepare("DELETE FROM articles WHERE id = :id");
        $sql->bindParam(':id', $id);
        $sql->execute();
        $pdo = null;
    } catch (PDOException $e) {
        echo $e->getMessage();
    } 
    echo "Success delete :)";
} 
 