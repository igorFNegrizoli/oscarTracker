package com.example.oscartracker.categories;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.oscartracker.R;

public class CardCategories extends AppCompatActivity {
    LinearLayout hiddenView, hiddenView2;
    CardView cardView, cardView2;
    Button buttonView, buttonView2;
    //private ModelCategories categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_card);

        cardView = findViewById(R.id.base_cardview);
        hiddenView = findViewById(R.id.hidden_view);
        buttonView = findViewById(R.id.cat_button2);
        //categories = new ModelCategories(this);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                }

                else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                }
            }
        });

        cardView2 = findViewById(R.id.base_cardview2);
        hiddenView2 = findViewById(R.id.hidden_view3);
        buttonView2 = findViewById(R.id.cat_button3);
        //categories = new ModelCategories(this);

        buttonView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView2.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    hiddenView2.setVisibility(View.GONE);
                }

                else {
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    hiddenView2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}