package gwicks.com.a7cupstest;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import static gwicks.com.a7cupstest.R.id.imageView39;
import static gwicks.com.a7cupstest.R.id.imageView40;
import static gwicks.com.a7cupstest.R.id.profile_image;

/**
 * Created by gwicks on 20/01/2018.
 */

public class FaceDetect extends AppCompatActivity  {
//
    private static final String TAG = "MainActivity";



    public SharedPreferences photoTick;
    public static final String TICK = "MyPrefFile";

    ImageView button;
    ImageView button2;
    ImageView belowPic;

    TextView abovePic;

    boolean secondScreen = false;


    Bitmap editedBitmap;
    private Uri imageUri;
    private static final int REQUEST_WRITE_PERMISSION = 200;
    private static final int CAMERA_REQUEST = 101;

    private static final String SAVED_INSTANCE_URI = "uri";
    private static final String SAVED_INSTANCE_BITMAP = "bitmap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_six);
        Log.d(TAG, "onCreate: before set click");

        abovePic = (TextView)findViewById(R.id.aboveImage);


        button = (ImageView)findViewById(imageView40);
        button2 = (ImageView)findViewById(profile_image);
        belowPic = (ImageView)findViewById(imageView39);

        button.setOnClickListener(new View.OnClickListener(){
            

            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: Clicked");
                Log.d(TAG, "onClick: secondscreen = " + secondScreen);

                if(secondScreen == false){
                    Log.d(TAG, "onClick: in false");


                    ActivityCompat.requestPermissions(FaceDetect.this, new
                            String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);

                }
                Log.d(TAG, "onClick: second screen = " + secondScreen);
                if(secondScreen == true){
                    Log.d(TAG, "onClick: in true");
                    goToFinish();
                }






            }
        });
        Log.d(TAG, "onCreate: after onclick set");
        button2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: Clicked");

                ActivityCompat.requestPermissions(FaceDetect.this, new
                        String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);


            }
        });




    }
    
    private void goToFinish(){
        Log.d(TAG, "goToFinish: go to finish");
        Intent intent = new Intent(FaceDetect.this, StepSeven.class);
        FaceDetect.this.startActivity(intent);
    }

    private void initViews() {
        //imageView = (ImageView) findViewById(R.id.imageView);
        //imgTakePicture = (ImageView) findViewById(R.id.profile_image);
        //btnProcessNext = (Button) findViewById(R.id.btnProcessNext);
        //btnTakePicture = (ImageView) findViewById(imageView40);
        //txtSampleDesc = (TextView) findViewById(R.id.txtSampleDescription);
        //txtTakenPicDesc = (TextView) findViewById(R.id.textView);

        //processImage(imageArray[currentIndex]);
        //currentIndex++;

        //btnProcessNext.setOnClickListener(this);
        //btnTakePicture.setOnClickListener(this);
        //imgTakePicture.setOnClickListener(this);
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_WRITE_PERMISSION:
                startCamera();
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    startCamera();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Permission Denied!", Toast.LENGTH_SHORT).show();
//                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: this is resyult");
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Log.d(TAG, "onActivityResult: IMAGWURI = " + imageUri);
            Bundle extras  = data.getExtras();

            Bitmap bitmap = (Bitmap) extras.get("data");
            button.setImageResource(R.drawable.complete_install);
            button2.setImageBitmap(bitmap);
            abovePic.setText("Great! Are you good\n with your picture?");
            belowPic.setImageResource(R.drawable.take_a_different_pic);
            Log.d(TAG, "onActivityResult: chagning secondScreen to true!");

            secondScreen = true;
            Log.d(TAG, "onActivityResult: Now changed to True!!");

        }
    }

//    private void launchMediaScanIntent() {
//        Log.d(TAG, "launchMediaScanIntent: ");
//        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        mediaScanIntent.setData(imageUri);
//        this.sendBroadcast(mediaScanIntent);
//    }

    private void startCamera() {
        Log.d(TAG, "startCamera: ");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Log.d(TAG, "startCamera: 2");
        File photo = new File(getExternalFilesDir(null), "/videoDIARY/ReferencePic/referencePhoto.jpg");
        //Log.d(TAG, "startCamera: 3");
        //File photo = new File(Environment.getExternalStorageDirectory(), "/videoDIARY/ReferencePic/photo.jpg");

        try
        {
            if(photo.exists() == false)
                Log.d(TAG, "startCamera:2 ");
            {
                photo.getParentFile().mkdirs();
                Log.d(TAG, "startCamera: 1");
                photo.createNewFile();
            }
        }
        catch (IOException e)
        {
            Log.e(TAG, "Could not create file.", e);
        }
        imageUri = Uri.fromFile(photo);
        Log.d(TAG, "startCamera: image uri - " + imageUri);
        Log.d(TAG, "startCamera: 4");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        //intent.putExtra("android.intent.extras.CAMERA_FACING", android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT);
        //intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
        //intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        //intent.putExtra("android.intent.extras.CAMERA_FACING",1);
        Log.d(TAG, "startCamera: 5");
        startActivityForResult(intent, CAMERA_REQUEST);
        Log.d(TAG, "startCamera: 6");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        if (imageUri != null) {
            Log.d(TAG, "onSaveInstanceState: 1");
            outState.putParcelable(SAVED_INSTANCE_BITMAP, editedBitmap);
            Log.d(TAG, "onSaveInstanceState: 2");
            outState.putString(SAVED_INSTANCE_URI, imageUri.toString());
            Log.d(TAG, "onSaveInstanceState: 3");
        }
        Log.d(TAG, "onSaveInstanceState: 4");
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: 5");
    }










    @Override
    protected void onDestroy() {
        super.onDestroy();

    }




}
