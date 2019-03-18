package com.example.cameragallery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageViewID);
        checkPermission();
    }

    public void captureImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }
    public void captureGallery(View view) {

        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,2);

    }
    public void checkPermission(){
        int permission = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA);
        if (permission!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      if (requestCode==1){
          if (data != null) {
              Bitmap bitmap = (Bitmap) data.getExtras().get("data");
              imageView.setImageBitmap(bitmap);
          }

      }
      if (requestCode==2){
          if (data!= null){


          Uri uri = data.getData();
          try {
              Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
              imageView.setImageBitmap(bitmap);
          } catch (IOException e) {
              e.printStackTrace();
          }

      }
      }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }
    }
}
