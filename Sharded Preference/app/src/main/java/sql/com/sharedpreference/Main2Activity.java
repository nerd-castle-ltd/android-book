package sql.com.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class Main2Activity extends AppCompatActivity {

    private TextView nameTV, emailTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameTV = findViewById(R.id.nameTV);
        emailTV = findViewById(R.id.emailTV);


        Gson gson = new Gson();

        SharedPreferences sharedPreferences = getSharedPreferences("saveInfo", MODE_PRIVATE);
        String user = sharedPreferences.getString("user","");
        User user1 = gson.fromJson(user,User.class);
        nameTV.setText(user1.getName());
        emailTV.setText(user1.getEmail());


        /*SharedPreferences sharedPreferences = getSharedPreferences("saveInfo", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");

        nameTV.setText(name);
        emailTV.setText(email);*/


    }
}
