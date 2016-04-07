package rage7.greendaosample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

public class BikeListActivity extends AppCompatActivity {

    ListView listView;
    ApplicationController applicationController;
    BikeDao bikeDao;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_list);
        listView = (ListView) findViewById(R.id.bikeList);
        applicationController = (ApplicationController) getApplication();
        db = applicationController.getDb();
        bikeDao = applicationController.getBikeDao();
        Cursor cursor = db.query(false, bikeDao.getTablename(), null, null, null, null, null, null, null);
        String[] from = {BikeDao.Properties.ModelLinkRewrite.columnName, BikeDao.Properties.Modelname.columnName};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from,
                to);
        listView.setAdapter(adapter);
    }
}
