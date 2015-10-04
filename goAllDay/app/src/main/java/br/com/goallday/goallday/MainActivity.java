package br.com.goallday.goallday;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;

import android.widget.ImageView;
import android.content.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.lang.reflect.Array;
import java.sql.SQLData;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {
    public SQLiteDatabase meuBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meuBanco = openOrCreateDatabase( "goallday.db", SQLiteDatabase.CREATE_IF_NECESSARY,null);
        meuBanco.setVersion(1);
        meuBanco.setLocale(Locale.getDefault());
        String criaTabelaMeta = "CREATE TABLE IF NOT EXISTS metas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, hora INTEGER,previsao TEXT, data INTEGER,tempo REAL)";
        meuBanco.execSQL(criaTabelaMeta);

        ImageView minhasMetas = (ImageView)findViewById(R.id.minhas_metas);
        ImageView novaMeta = (ImageView)findViewById(R.id.nova_meta);
        ImageView compartilhar = (ImageView)findViewById(R.id.compartilhar);
        ImageView sobre = (ImageView)findViewById(R.id.sobre);

        minhasMetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  minhasMetasIntent = new Intent(getBaseContext(), minhasMetas_Activity.class);
                startActivity(minhasMetasIntent);
            }
        });

        novaMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  minhasMetasIntent = new Intent(getBaseContext(), minhasMetas_Activity.class);
                startActivity(minhasMetasIntent);
            }
        });

        compartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  minhasMetasIntent = new Intent(getBaseContext(), minhasMetas_Activity.class);
                startActivity(minhasMetasIntent);
            }
        });

        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  minhasMetasIntent = new Intent(getBaseContext(), AboutActivity.class);
                startActivity(minhasMetasIntent);
            }
        });

    }

    public Cursor ExecutaSqlBusca(String nomeTablela,String[] colunas,String condicao){
        Cursor cursor = meuBanco.query(nomeTablela, colunas, condicao, null, null, null, null);
        return  cursor;
    }

    public long ExecutaSqlInsert(ContentValues values,String tabela){
        return  meuBanco.insert(tabela,null,values);
    }

    public long ExecutaSqlUpdate(ContentValues values,String tabela,String where){
        return  meuBanco.update(tabela, values, where, null);
    }

    public long ExecutaSqlDelete(String tabela,String where){
        return  meuBanco.delete(tabela,where, null);
    }



    public  SQLiteDatabase getDb(){
        return meuBanco;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
