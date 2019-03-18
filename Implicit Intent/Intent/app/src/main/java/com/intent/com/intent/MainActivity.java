package com.intent.com.intent;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et = (EditText) findViewById(R.id.etNo);
        findViewById(R.id.btnDial).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+et.getText()));
                startActivity(i);

            }
        });

       /* findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);
            }
        });
        final EditText et = (EditText) findViewById(R.id.etNo);
//set click listener to Gallery button
        findViewById(R.id.btnGallery).setOnClickListener(new View.OnClickListener() {

            //perform Gallery open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(i);
            }
        });

//set click listener to CallLog button
        findViewById(R.id.btnCallLog).setOnClickListener(new View.OnClickListener() {

            //perform CallLog open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://call_log/calls/1"));
                startActivity(i);
            }

        });

//set click listener to Browser button
        findViewById(R.id.btnBrowser).setOnClickListener(new View.OnClickListener() {

            //perform Browser open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.google.com/"));
                startActivity(Intent.createChooser(i, "Title"));
            }
        });

//set click listener to Contact button
        findViewById(R.id.btnContact).setOnClickListener(new View.OnClickListener() {

            //perform Contact open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://contacts/people/"));
                startActivity(i);
            }
        });

//set click listener to Call button
        findViewById(R.id.btnCall).setOnClickListener(new View.OnClickListener() {

            //perform Call open action
            @Override
            public void onClick(View v) {

// AndroidManifest.xml -> Permissions -> Add ->
// Uses Permission -> android.permission.CALL_PHONE -> Save
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+et.getText()));
                startActivity(i);
            }
        });

//set click listener to Dial button
        findViewById(R.id.btnDial).setOnClickListener(new View.OnClickListener() {

            //perform Dial open action
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+et.getText()));
                startActivity(i);

                Intent I = new Intent(Intent.ACTION_DIAL, Uri
                        .parse("tel:" + et.getText()));
                startActivity(i);

                startActivity(new Intent(Intent.ACTION_DIAL, Uri
                        .parse("tel:" + et.getText())));

            }
        });*/

    }
}
