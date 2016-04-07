package rage7.dreendaosample.generator;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Generator {
    public static void main(String[] args) {
        Schema schema = new Schema(1,"rage7.greendaosample");

        Entity bike = schema.addEntity("Bike");
        bike.addIdProperty();
        bike.addStringProperty("modelname");
        bike.addStringProperty("modelLinkRewrite");
        bike.addStringProperty("popularity");
        bike.addStringProperty("exShowroomPrice");
        bike.addStringProperty("engineCapacity");

        try {
            DaoGenerator daoGenerator = new DaoGenerator();
            daoGenerator.generateAll(schema,"./app/src/main/java");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
