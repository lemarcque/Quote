package io.capsulo.quote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Todo : Add class description
 */

class MainActivity : AppCompatActivity() {


    // Properties
    val GROUP_VERSE = "io.capsulo.quote.VERSE" // Unique identifier for notification for Verse's group
    val GROUP_MOTIVATION = "io.capsulo.quote.MOTIVATION" // Unique identifier for notification for Verse's group
    val GROUP_FOCUS = "io.capsulo.quote.FOCUS" // Unique identifier for notification for Verse's group

    val messages = arrayOf(
        Quote("L'éternel est mon berger je ne manquerai de rien.", GROUP_VERSE),
        Quote("Saint, Saint, Saint est l'éternel.", GROUP_VERSE),
        Quote("Heureux les débonnaires, car ils hériteront de la terre.", GROUP_VERSE),
        Quote("Heureux ceux qui ont faim est soif de justice car ils seront rassasiés", GROUP_VERSE),
        Quote("Que la lumière soit et la lumière fut.", GROUP_VERSE),
        Quote("Be Real", GROUP_MOTIVATION),
        Quote("No days off", GROUP_MOTIVATION),
        Quote("L'histoire y a ceux qui la lisent, ceux qui l'écrivent et ceux qui l'a font", GROUP_FOCUS)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(actionbar_quote_layout)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        textview_sentence_main.text = messages[0].sentence
        textview_author_main.text = "Unknown"

        // create notification
        NotificationManager.createNotificationChannel(this)

        for (quote in messages) {
            NotificationManager.createNotification(quote, this)
        }
    }
}