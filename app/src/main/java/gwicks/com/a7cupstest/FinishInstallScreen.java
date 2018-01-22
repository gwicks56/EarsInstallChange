package gwicks.com.a7cupstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by gwicks on 21/01/2018.
 */

public class FinishInstallScreen extends AppCompatActivity {

    private static final String TAG = "FinishInstallScreen";

    ImageView needToTalkClosed;
    ImageView needToTalkOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completed_base);

        needToTalkClosed = (ImageView)findViewById(R.id.imageView6);


        needToTalkClosed.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: Clicked");

                needToTalkClosed.setImageResource(R.drawable.need_to_talk_open);
                //needToTalkClosed.setImageResource(R.drawable.notif);



            }
        });
    }

}
