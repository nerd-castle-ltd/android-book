package sql.com.sqlite;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,subjectET,IDET;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.nameETID);
        subjectET = findViewById(R.id.subjectETID);
        IDET = findViewById(R.id.IDETID);
        databaseHelper = new DatabaseHelper(this);
    }

    public void addToDatabase(View view) {

        String name = nameET.getText().toString();
        String subject = subjectET.getText().toString();

       long id = databaseHelper.insertData(name,subject);
        Toast.makeText(this, "Your id is:"+id, Toast.LENGTH_SHORT).show();
    }

    public void showFromDatabase(View view) {

        Cursor cursor = databaseHelper.show();
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()){
            stringBuffer.append("Name:"+cursor.getString(cursor.getColumnIndex(databaseHelper.COL_NAME))+"\n");
            stringBuffer.append("Subject:"+cursor.getString(cursor.getColumnIndex(databaseHelper.COL_SUBJECT))+"\n");

        }
        showMessage("Data",stringBuffer.toString());
    }

    private void showMessage(String title,String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void deleteFromDatabase(View view) {

        int show = databaseHelper.deleteData(IDET.getText().toString());
        Toast.makeText(this, String.valueOf(show), Toast.LENGTH_SHORT).show();
    }

    public void updateDatabase(View view) {

        databaseHelper.updateData(IDET.getText().toString(),nameET.getText().toString(),subjectET.getText().toString());

    }
}
