package org.me.gcu.mvvtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel weViewModel;
    private TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating view model, i set owner as getActivity() when using with fragments
        weViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        helloTextView = findViewById(R.id.helloTextView);
        //getting variable from view model, use getters
        helloTextView.setText(String.valueOf(weViewModel.addNum()));


        //This observers when the live data changes
        final Observer<Boolean> getCurrentStateObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable final Boolean setState) {
                helloTextView.setText("hi");
            }
        };

        //setting observer
        weViewModel.getCurrentState().observe(this, getCurrentStateObserver);


        //this is changing the vlaue of the live data, so if uncomment "hi" will be displayed
        //weViewModel.getCurrentState().setValue(true);
    }



}
