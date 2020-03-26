package io.capsulo.quote

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

/**
 * Todo : Add class description
 */
class NotificationManager {



    companion object {

        private val CHANNEL_ID = "10" // The channel to which all notifications belong
        private var countNotification = 0

        fun createNotificationChannel(context: Context) {
            // Create a notification channel (only on API+
            // NotificationChannel class not available on the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel =
                    NotificationChannel(CHANNEL_ID, "Name", NotificationManager.IMPORTANCE_DEFAULT)
                channel.description = "No legend."

                // Register the channel with the system
                val notificationManager = context.getSystemService(
                    NotificationManager::class.java
                )
                notificationManager.createNotificationChannel(channel)
            }
        }

        fun createNotification(quote: Quote, context: Context) {
            // Increment identified for   notifications
            countNotification++

            // Create a new Notification
            val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle(quote.category) // Quote's category
                .setContentText(quote.sentence) // Quote text
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            // Show the notification
            val notificationManagerCompat: NotificationManagerCompat =
                NotificationManagerCompat.from(context)
            notificationManagerCompat.notify(countNotification, builder.build())
        }
    }

}