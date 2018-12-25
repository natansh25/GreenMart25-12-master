package infinity1087.android.com.examplehr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import infinity1087.android.com.examplehr.adapter.RecyclerItems;
import infinity1087.android.com.examplehr.model2uglyApi.ResponseDetail;

public class detailLayout extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,AdapterView.OnItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerItems mAdapter;
    private List<ResponseDetail> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layout);
        Intent i = getIntent();
        mData = (List<ResponseDetail>) i.getSerializableExtra("yyy");
        Log.d("ttt", String.valueOf(mData));
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
       // spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();

        categories.add("50g");
        categories.add("250g");
        categories.add("500g");
        categories.add("1Kg");

        @SuppressLint("ResourceType") ArrayAdapter<String> dataA = new ArrayAdapter<String>(this,R.id.spinner);
        mRecyclerView = findViewById(R.id.recycler_view_detail);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(detailLayout.this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(false);
        setUpRecyclerView(mData);

    }

    private void setUpRecyclerView(List<ResponseDetail> datumList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerItems(datumList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = String.valueOf(parent.getItemIdAtPosition(position));
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void btnAddtoCart(View view) {
        Intent i = new Intent(detailLayout.this,MyCart.class);
        startActivity(i);
    }
}
