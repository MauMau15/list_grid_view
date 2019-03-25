package mau.train.com.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mau.train.com.list.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.list_view);

        this.names = new ArrayList<>();

        this.names.add("Clau");
        this.names.add("Mau");
        this.names.add("Carlitos");
        this.names.add("Frijolito");
        this.names.add("Clau");
        this.names.add("Mau");
        this.names.add("Carlitos");
        this.names.add("Frijolito");
        this.names.add("Clau");
        this.names.add("Mau");
        this.names.add("Carlitos");
        this.names.add("Frijolito");
        this.names.add("Clau");
        this.names.add("Mau");
        this.names.add("Carlitos");
        this.names.add("Frijolito");

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        //listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"You´ve clicked: " + names.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        MyAdapter myAdapter = new MyAdapter(MainActivity.this,R.layout.item_list,names);
        listView.setAdapter(myAdapter);
    }
}
