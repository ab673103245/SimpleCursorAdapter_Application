package qianfeng.simplecursoradapter_application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "qf.db";
    public static final String TABLENAME = "usertable";
    private static final int  DBVERSION = 1;

    public DBHelper(Context context) {
        super(context, DBNAME,null,DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLENAME + " (_id PRIMARY KEY,USERNAME,NICKNAME,AGE);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
