package edu.unsam.algo3.poifinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
/**
 * Created by Javier on 12/11/2016.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final String BASE_URL = "http://http://localhost:9000";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PoiService service = retrofit.create(PoiService.class);

        Call<Poi> call = service.getPois();
        call.enqueue(new Callback<Poi>() {
            @Override
            public void onResponse(Response<Poi> response, Retrofit retrofit) {
                Poi poi = response.body();
                TextView poiIdText = (TextView) findViewById(R.id.lblId);
                TextView poiNombreText = (TextView) findViewById(R.id.lblContent);
                poiIdText.setText(poi.getId());
                poiNombreText.setText(poi.getNombre());
            }

            @Override
            public void onFailure(Throwable t) {
                //Log.e("HelloWorld", t.getMessage());
                Toast.makeText(MainActivity.this, "Ha ocurrido un error al llamar al servicio", Toast.LENGTH_LONG).show();
            }
        });
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
