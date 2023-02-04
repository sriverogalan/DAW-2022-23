package com.example.demo;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@RestController
public class Oauth {
    @Value("${google.clientId}")
    private String clientId;


    @PostMapping("/auth/google")
    public ResponseEntity<String> loginGoogle(@RequestBody String token) throws GeneralSecurityException, IOException {
        System.out.println("Token: " + token);
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        GoogleIdTokenVerifier tokenVerifier = new GoogleIdTokenVerifier.Builder(
                HTTP_TRANSPORT,
                GsonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList(clientId))
                .build();

        GoogleIdToken idToken = tokenVerifier.verify(token);

        GoogleIdToken.Payload payload = idToken.getPayload();

        System.out.println("Subjet: " + payload.getSubject() + " Email: " + payload.getEmail());

        /*
        *  TODO: a partir del mail crear el TOKEN LOCAL
        * */
        String tokenLocal = "1234";


        return new ResponseEntity<>("Hola", HttpStatus.OK);
    }

    @GetMapping("/horari")
    public ResponseEntity<List<String>> getHorari(HttpRequest request) {
       /* String token = request.getHeaders().get("Authorization").toString();
         Rol[] rol = Token.getClaim("rols");
        if (rol == null || rol.length == 0)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if (rol[0] == Rol.ADMIN)
            return new ResponseEntity<>(horariService.getHorari(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.OK);*/
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
