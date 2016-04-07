package rage7.greendaosample;

import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    private EditText modelName, modelLinkRewrite, engine, popularity, exShowroomPrice;
    private ApplicationController applicationController;
    private BikeDao bikeDao;
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationController = (ApplicationController) getApplication();
        bikeDao = applicationController.getBikeDao();
        initViews();
    }

    private void initViews() {
        modelName = (EditText) findViewById(R.id.modelName);
        modelLinkRewrite = (EditText) findViewById(R.id.modelLinkRewrite);
        engine = (EditText) findViewById(R.id.engine);
        popularity = (EditText) findViewById(R.id.popularity);
        exShowroomPrice = (EditText) findViewById(R.id.exShowroomPrice);
    }

    public void addBike(View view) {

        Bike bike = new Bike();
        bike.setModelname(modelName.getText().toString().trim());
        bike.setModelLinkRewrite(modelLinkRewrite.getText().toString().trim());
        bike.setEngineCapacity(engine.getText().toString().trim());
        bike.setExShowroomPrice(exShowroomPrice.getText().toString().trim());
        bike.setPopularity(popularity.getText().toString().trim());
        bikeDao.insert(bike);
        clearViews();
        Log.d(TAG, "Record inserted with id " + bike.getId());
    }

    public void showList(View view) {
        Intent intent = new Intent(this, BikeListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void clearViews() {
        modelName.setText("");
        modelLinkRewrite.setText("");
        engine.setText("");
        exShowroomPrice.setText("");
        popularity.setText("");
    }

    public void clearData(View view) {
        bikeDao.deleteAll();
    }
}
