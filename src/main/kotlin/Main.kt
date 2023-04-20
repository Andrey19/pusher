package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream
import token
import java.util.Scanner


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    println("Введите : \n 1 для отправки Like \n 2 Для отправки New Post \n 3 Для отправки Несушествуюшего Action \n 0 Для завершения ")
    val scanner = Scanner(System.`in`)
    var x = -1
    while (x != 0) {
        x = scanner.nextInt()
        when (x) {
            1 -> {
                val message = Message.builder()
                    .putData("action", "LIKE")
                    .putData(
                        "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent()
                    )
                    .setToken(token)
                    .build()

                FirebaseMessaging.getInstance().send(message)
            }

            2 -> {
                val message = Message.builder()
                    .putData("action", "NEW_POST")
                    .putData(
                        "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology",
          "content": "There are two kinds of innovation: new perspectives that changes how we look at things and pragmatic improvements that changes how we do things. Kotlin is full of these pragmatic improvements, getting its user a language that just feel good to use. One of the most useful improvement, especially if you come from Java, is the when construct. "
        }""".trimIndent()
                    )
                    .setToken(token)
                    .build()

                FirebaseMessaging.getInstance().send(message)
            }

            3 -> {
                val message = Message.builder()
                    .putData("action", "LIKE2")
                    .putData(
                        "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent()
                    )
                    .setToken(token)
                    .build()

                FirebaseMessaging.getInstance().send(message)
            }

        }
    }

}
