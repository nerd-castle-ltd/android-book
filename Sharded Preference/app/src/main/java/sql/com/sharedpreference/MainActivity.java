package sql.com.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,emailET;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.nameETID);
        emailET = findViewById(R.id.EmailETID);
         sharedPreferences = getSharedPreferences("saveInfo",MODE_PRIVATE);
         editor = sharedPreferences.edit();
         gson = new Gson();

    }

    public void saveSharedPreference(View view) {

        String name = nameET.getText().toString();
        String email = emailET.getText().toString();
        User user = new User(name,email);
        String storeUser = gson.toJson(user);
        editor.putString("user",storeUser);
        editor.commit();


       /* editor.putString("name",name);
        editor.putString("email",email);
        editor.commit();*/

    }

    public void showFromSharedPreference(View view) {
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }

    public void deleteFromSharedPreference(View view) {
        //editor.clear();
       /* editor.remove("name");
        editor.commit();*/

    }
}
