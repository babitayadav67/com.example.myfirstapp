import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBname="Login.db";

    public DBHelper( Context context) {
        super(context,"Login.db", null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table users(firstname TEXT primary key, lastname TEXT ,email TEXT,phoneno TEXT) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
MyDB.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String firstname, String Lastname, String email, String phoneno, byte[] lastname, String users){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("email",email);
        contentValues.put("phoneno",phoneno);
        long result=MyDB.insert(users,null,contentValues);
        if(result==1)
            return  false;
        else return true;
    }
    public Boolean checkfirstname(String firstname){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where firstname=?",new String[Integer.parseInt(firstname)]);
        if(cursor.getCount()>0)
            return  true;
        else return false;
    }
    public Boolean checklastname(String firstname,String lastname,String  email,String phoneno){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where firstname=? and lastname=?",new String[] {firstname,lastname});
if(cursor.getCount()>0)
    return false;
else return true;
    }
}
