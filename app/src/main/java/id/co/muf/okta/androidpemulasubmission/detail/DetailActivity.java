package id.co.muf.okta.androidpemulasubmission.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.co.muf.okta.androidpemulasubmission.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "NAMA";
    public static final String EXTRA_DESC = "DESC";
    public static final String EXTRA_IMG = "IMG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView TVFood = findViewById(R.id.TVFood);
        ImageView IVFood = findViewById(R.id.IVFood);
        TextView TVDesc = findViewById(R.id.TVDesc);
        setActionBarTitle("Detail Food");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String name = getIntent().getStringExtra(EXTRA_NAMA);
        String desc = getIntent().getStringExtra(EXTRA_DESC);
        String img = getIntent().getStringExtra(EXTRA_IMG);
        TVFood.setText(name);
        TVDesc.setText(desc);
        Glide.with(getApplicationContext())
                .load(img)
                .into(IVFood);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
