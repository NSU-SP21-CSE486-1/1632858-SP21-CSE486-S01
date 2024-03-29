package com.example.expandablemenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout expandableView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableView = findViewById(R.id.expandable2);
        cardView = findViewById(R.id.cardView);

//        arrowBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (expandableView.getVisibility()==View.GONE){
//                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
//                    expandableView.setVisibility(View.VISIBLE);
//                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
//                } else {
//                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
//                    expandableView.setVisibility(View.GONE);
//                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
//                }
//            }
//        });
    }

    public void expand(View view) {
        if (expandableView.getVisibility()==View.GONE){
//            TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
            TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
            expandableView.setVisibility(View.VISIBLE);
        }
        else {
            TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
            expandableView.setVisibility(View.GONE);
        }
    }

}