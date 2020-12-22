package com.example.curs2.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.curs2.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mSpinnerAndroid;
    private List<String> mDataSourceSpinner;
    private ArrayAdapter<String> mAdapterSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        mSpinnerAndroid = findViewById(R.id.spinner_value);
        mDataSourceSpinner = getSource();
        mAdapterSpinner = getAdapter(mDataSourceSpinner);
        mSpinnerAndroid.setAdapter(mAdapterSpinner);
        mSpinnerAndroid.setOnItemSelectedListener(this);
    }
    private List<String> getSource() {
        List<String> androids = new ArrayList<String>();
        androids.add("Cupcake");
        androids.add("Donut");
        androids.add("Eclair");
        androids.add("KitKat");
        androids.add("Pie");
        return androids;
    }

    private ArrayAdapter<String> getAdapter(List<String> dataSourceSpinner) {
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSourceSpinner);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"You selected "+ mDataSourceSpinner.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}