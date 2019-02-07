/**
 * MIT License
 *
 * Copyright (c) 2019 Henoc Sese
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package io.capsulo.quote;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Manage all the activity of the applications
 */
public class MainActivity extends AppCompatActivity {

    final String CHANNEL_ID = "10";                                     // The channel to which all notifications belong
    final String GROUP_VERSE = "io.capsulo.quote.VERSE";                // Unique identifier for notification for Verse's group
    final String GROUP_MOTIVATION = "io.capsulo.quote.MOTIVATION";      // Unique identifier for notification for Verse's group
    final String GROUP_FOCUS = "io.capsulo.quote.FOCUS";                // Unique identifier for notification for Verse's group

    private int countNotification = 0;                                  // counter for generating id of notifications

    private Quote[] messages = {
            new Quote("L'éternel est mon berger je ne manquerai de rien.", GROUP_VERSE) ,
            new Quote("Saint, Saint, Saint est l'éternel.", GROUP_VERSE) ,
            new Quote("Heureux les débonnaires, car ils hériteront de la terre.", GROUP_VERSE),
            new Quote("Heureux ceux qui ont faim est soif de justice car ils seront rassasiés", GROUP_VERSE),
            new Quote("Que la lumière soit et la lumière fut.", GROUP_VERSE),
            new Quote("Be Real", GROUP_MOTIVATION),
            new Quote("No days off", GROUP_MOTIVATION),
            new Quote("L'histoire y a ceux qui la lisent, ceux qui l'écrivent et ceux qui l'a font", GROUP_FOCUS)
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.createNotificationChannel();

       for(Quote quote : messages) {
            this.createNotification(quote);
        }
    }

    private void createNotificationChannel() {
        // Create a notification channel (only on API+
        // NotificationChannel class not available on the support library
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Name", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("No legend.");

            // Register the channel with the system
            NotificationManager notificationManager = super.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void createNotification(Quote quote) {
        // Increment identified for   notifications
        countNotification++;

        // Create a new Notification
        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.white_notification_default_icon)
                .setContentTitle(quote.getCategory())                                               // Quote's category
                .setContentText(quote.getText())                                                    // Quote text
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Show the notification
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(countNotification, builder.build());
    }

}
