package io.capsulo.quote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Activity
 * @author Henoc Sese
 */
public class QuoteActivity extends AppCompatActivity {


    // Android Views' components
    private TextView txtSentence;
    private TextView txtAuthor;
    private Toolbar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.quote_layout);
        this.init();
    }

    /**
     * Initialization of the user interface
     */
    private void init() {
        // Basics View
        txtSentence = findViewById(R.id.txt_sentence_quote_layout);
        txtAuthor = findViewById(R.id.txt_author_quote_layout);

        // ActionBar
        actionBar = findViewById(R.id.actionbar_quote_layout);
        super.setSupportActionBar(actionBar);
        super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
