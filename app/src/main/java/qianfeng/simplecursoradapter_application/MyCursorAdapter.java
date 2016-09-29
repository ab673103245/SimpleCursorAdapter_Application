package qianfeng.simplecursoradapter_application;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class MyCursorAdapter extends CursorAdapter {
    private LayoutInflater inflater;

    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c,CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        inflater = LayoutInflater.from(context);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View inflate = inflater.inflate(R.layout.item, parent, false);


        ViewHolder holder = new ViewHolder();

        holder.tv_username = ((TextView) inflate.findViewById(R.id.tv_username));
        holder.tv_nickname = ((TextView) inflate.findViewById(R.id.tv_nickname));

        inflate.setTag(holder);
        return inflate;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder holder = (ViewHolder) view.getTag();

        holder.tv_username.setText(cursor.getString(cursor.getColumnIndex("USERNAME")));
        holder.tv_nickname.setText(cursor.getString(cursor.getColumnIndex("NICKNAME")));

    }

    class ViewHolder
    {
        TextView tv_username,tv_nickname;
    }
}
