package gwicks.com.a7cupstest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gwicks on 20/01/2018.
 */

public class SetupStepThreeThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_three_three);

        moveToNextStep();

    }

    public void moveToNextStep(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SetupStepThreeThree.this, SetupStepFour.class);
                SetupStepThreeThree.this.startActivity(intent);
            }
        }, 5000);

    }



}
