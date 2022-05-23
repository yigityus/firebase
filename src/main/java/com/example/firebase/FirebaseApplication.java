    package com.example.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;

@SpringBootApplication
public class FirebaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirebaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            FileInputStream serviceAccount =
                    new FileInputStream("/home/grand/dev/boot/firebase/src/main/resources/firebase-adminsdk.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://so1v3n-default-rtdb.europe-west1.firebasedatabase.app")
                    .build();

            FirebaseApp.initializeApp(options);
            // The topic name can be optionally prefixed with "/topics/".
/*
            String topic = "highScores";
*/

            // See documentation on defining a message payload.
/*
            Message message = Message.builder()
                    .putData("score", "850")
                    .putData("time", "2:45")
                    .setTopic(topic)
                    .build();
*/

            // Send a message to the devices subscribed to the provided topic.
/*
            String response = FirebaseMessaging.getInstance().send(message);
*/
            // Response is a message ID string.
/*
            System.out.println("Successfully sent message: " + response);
*/

            String send = FirebaseMessaging.getInstance()
                    .send(Message.builder()
                            .setToken("cVEeih3tQKOTBRfzJ5ev-V:APA91bHYbP5ZHZ-mBGTOgeSUkwle50Eh7ES90uoqo3WcIWHREhoAK-7Mta6BuVMgo882tUjAqrmOUPUp5nr9hT6QDMXKe90U6YJXk09_hUc0gC7zbhR6bEyjMyKAZugTg7q76bd8gWff")
                            .putData("TEST", "VALUE")
                            .build());

            System.out.println(send);

/*

            // This registration token comes from the client FCM SDKs.
            String registrationToken = "fQQpQOsEOM9m9xTOXY0n-P:APA91bE9nnNMKiDZRuJh1dEmImgd3mqhEGJyze-PCkePRtleDR6stG4tuTSn0S2Rb_Rn6TCxXiNYmUkaddBjyAGFYb2pYBP9BX9qt1yKewMpTwzTUOTvMzpv2hRDILQHzOhZxaQ-BUYv";

            // See documentation on defining a message payload.
            Message message1 = Message.builder()
                    .putData("score", "850")
                    .putData("time", "2:45")
                    .setToken(registrationToken)
                    .build();

            // Send a message to the device corresponding to the provided
            // registration token.
            String response1 = FirebaseMessaging.getInstance().send(message1);
            // Response is a message ID string.
            System.out.println("Successfully sent message: " + response1);
*/
        };
    }

}
