package facci.pm.ta2.poo.pra1;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import facci.pm.ta2.poo.datalevel.DataException;
import facci.pm.ta2.poo.datalevel.DataObject;
import facci.pm.ta2.poo.datalevel.DataQuery;
import facci.pm.ta2.poo.datalevel.GetCallback;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgMoto;
    private TextView textMarca;
    private TextView textModelo;
    private TextView textMatricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("PR1 :: Detail");


        // INICIO - CODE6

        // conectar diseño  con las variables ya creadas

        imgMoto = (ImageView) findViewById(R.id.imgmoto);
        textMarca = (TextView) findViewById(R.id.detallemarca);
        textModelo = (TextView) findViewById(R.id.detallemodelo);
        textMatricula = (TextView) findViewById(R.id.detallematricula);

        // vamos a extraer el parametro que se envio de la activity result

        String Objeto_id = getIntent().getStringExtra("IdObjeto");

        //objetner la informacion de la base de datos para mostrar

        DataQuery query = DataQuery.get("item");
        query.getInBackground(Objeto_id, new GetCallback<DataObject>() {
            @Override
            public void done(DataObject object, DataException e) {
                if (e == null){
                    imgMoto.setImageBitmap((Bitmap) object.get("image"));
                    textMarca.setText((String) object.get("Marca"));
                    textModelo.setText((String) object.get("Modelo"));
                    textMatricula.setText((String) object.get("Matricula"));

                } else {
                    //  error

                }
            }
        });

        // FIN - CODE6

    }

}
