package gwicks.com.a7cupstest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

/**
 * Created by gwicks on 20/01/2018.
 */

public class SetupStepThreeOne extends AppCompatActivity {
    private static final String TAG = "SetupStepThreeOne";

    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_three_one);

        button = (ImageView)findViewById(R.id.imageView25);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: Clicked");
                InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
                imeManager.showInputMethodPicker();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(SetupStepThreeOne.this, SetupStepThreeThree.class);
                        SetupStepThreeOne.this.startActivity(intent);
                    }
                }, 5000);

            }
        });

    }
}
