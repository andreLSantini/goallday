package br.com.goallday.goallday;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class minhasMetas_Activity extends ActionBarActivity {
    SQLiteDatabase meuBanco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_metas_);
        MainActivity mainActivity = new MainActivity();
        meuBanco = mainActivity.getDb();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_minhas_metas_, menu);
        return true;
    }

    public void getMetas(){
        final ListView listView = (ListView)findViewById(R.id.listView_metas);
        Cursor c = meuBanco.query("metas", null, null,null,null,null,null);
        ArrayList<String> metas = new ArrayList<>();
        while(c.moveToNext()){
            String meta = c.getString(c.getColumnIndex("nome"));
            int x = c.getInt(c.getColumnIndex("hora"));
            float y = c.getFloat(c.getColumnIndex("tempo"));
            float z = x/(y*100);
            meta +=" "+z+"%";
            metas.add(meta);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, metas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
