package rage7.greendaosample;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by root on 7/4/16.
 */
public class ApplicationController extends Application {


    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private BikeDao bikeDao;
    private SQLiteDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "bikes-db", null);
        db = openHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        bikeDao = daoSession.getBikeDao();
    }

    public BikeDao getBikeDao() {
        return bikeDao;
    }

    public void setBikeDao(BikeDao bikeDao) {
        this.bikeDao = bikeDao;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
