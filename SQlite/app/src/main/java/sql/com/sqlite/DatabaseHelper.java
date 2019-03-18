package sql.com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student_table";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "Name";
    public static final String COL_SUBJECT = "Subject";
    SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    public static final String CREATE_TABLE = "create table "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY, Name TEXT, Subject TEXT)";
    public  static  final String SHOW_ALL = "select * from "+TABLE_NAME;


    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public long insertData(String name, String subject){


        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_SUBJECT,subject);

        long id = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return  id;
    }

    public Cursor showByID(String id){
        String SHOW_DATA = "select * from "+TABLE_NAME+ " where ID= "+id;
        Cursor cursor = sqLiteDatabase.rawQuery(SHOW_DATA,null);
        return cursor;
    }
    public Cursor show(){
        String SHOW_DATA = "select * from "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(SHOW_DATA,null);
        return cursor;

    }
    public int deleteData(String id){
       int value = sqLiteDatabase.delete(TABLE_NAME,"ID = ?",new String[]{id});
       return value;
    }

    public void updateData(String id,String name,String subject){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_SUBJECT,subject);

        sqLiteDatabase.update(TABLE_NAME,contentValues," ID = ?",new String[]{id});

    }
}
