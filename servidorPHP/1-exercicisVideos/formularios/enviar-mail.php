<html>
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        $to = "sriverogalan@gmail.com";
        $subject = "Test mail";
        $message = "Hello! This is a simple email message.";
        $from = "adminuser@dominio.com";
        $headers = "From:" . $from;
        mail($to,$subject,$message,$headers);
        echo "Mail Sent.";
    ?>
</body>
</html>
