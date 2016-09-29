package qianfeng.simplecursoradapter_application;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private SQLiteDatabase db;

    private String[] n1 = new String[]{"赵", "钱", "孙", "李", "周", "吴", "郑",
            "王", "冯", "陈", "楚", "魏", "蒋", "沈", "韩", "杨"};
    private String[] n2 = new String[]{"功", "阳", "会", "豪", "文", "杰", "悠",
            "强", "建", "依", "腾", "凯", "涛", "桓", "林", "潇"};

    private Random r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = new DBHelper(this).getReadableDatabase();

        r1 = new Random();

        for (int i = 0; i < 100; i++) {
            String st = n1[r1.nextInt(16)] + n2[r1.nextInt(15)] + n2[r1.nextInt(15)];
            ContentValues values = new ContentValues();
            values.put("username",new ChineseToPinyinHelper().getPinyin(st));
            values.put("nickname",st);
            values.put("age",r1.nextInt(99));
            db.insert(DBHelper.TABLENAME,null, values);
        }// 这已经是完成数据的插入数据了

        // 现在是从cursor中把数据放进listView中显示

        // 插入了数据之后呢，就把这些数据放入ListView中，用simpleCursorAdapter
        Cursor cursor = db.rawQuery("select * from " + DBHelper.TABLENAME, null);
//        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.item, cursor, new String[]{"USERNAME", "NICKNAME"}, new int[]{R.id.tv_username, R.id.tv_nickname});
        ListView lv = (ListView) findViewById(R.id.lv);
//        lv.setAdapter(simpleCursorAdapter);

        MyCursorAdapter myCursorAdapter = new MyCursorAdapter(this, cursor);
        lv.setAdapter(myCursorAdapter);


    }
}
