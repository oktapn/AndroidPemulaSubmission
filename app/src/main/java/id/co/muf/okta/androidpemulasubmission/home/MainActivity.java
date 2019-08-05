package id.co.muf.okta.androidpemulasubmission.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.co.muf.okta.androidpemulasubmission.R;
import id.co.muf.okta.androidpemulasubmission.about.AboutActivity;
import id.co.muf.okta.androidpemulasubmission.home.adapter.CardViewFoodsAdapter;
import id.co.muf.okta.androidpemulasubmission.home.model.Foods;
import id.co.muf.okta.androidpemulasubmission.home.model.FoodsData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFoods;
    private ArrayList<Foods> list = new ArrayList<>();
    private String title = "Food List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvFoods = findViewById(R.id.rv_foods);
        rvFoods.setHasFixedSize(true);
        list.addAll(FoodsData.getListData());
        setActionBarTitle(title);
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvFoods.setLayoutManager(new LinearLayoutManager(this));
        CardViewFoodsAdapter cardViewFoodsAdapter = new CardViewFoodsAdapter(list);
        rvFoods.setAdapter(cardViewFoodsAdapter);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //and this to handle actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
