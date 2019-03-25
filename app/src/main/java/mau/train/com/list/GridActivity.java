package mau.train.com.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mau.train.com.list.adapters.MyAdapter;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;
    private MyAdapter myAdapter;

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        this.gridView = findViewById(R.id.grid_view);

        this.names = new ArrayList<>();

        this.names.add("Clau");
        this.names.add("Mau");
        this.names.add("Carlitos");
        this.names.add("Frijolito");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this,"You´ve clicked: " + names.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        myAdapter = new MyAdapter(GridActivity.this,R.layout.item_grid,names);
        gridView.setAdapter(myAdapter);

        registerForContextMenu(gridView);

    }

    //inflamos el menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

    //manejamos el evento lick en el menu de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                //agregamos
                this.names.add("Adde n°" + (++contador));
                //notificamos al adapter para refrescar
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //inflamos layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(this.names.get(info.position));

        inflater.inflate(R.menu.context_menu,menu);
    }

    //manejamos el click del context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.delete_item:
                //eliminamos objecto
                this.names.remove(info.position);
                //notificamos al adapter para refrescar
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
