package com.example.curs2.week6;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.curs2.R;

import static com.example.curs2.week6.HelloFragment.EXTRA_KEY_INT;
import static com.example.curs2.week6.HelloFragment.EXTRA_KEY_STRING;

public class HelloFragmentDynamicActivity extends AppCompatActivity implements TheListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_fragment_dynamic);

        HelloFragment helloFragment = new HelloFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_KEY_INT, 1001);
        bundle.putString(EXTRA_KEY_STRING, "HelloFrament with bundle");

        helloFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder, helloFragment, "HelloFragment");
        fragmentTransaction.commit();

        findViewById(R.id.btn_show_in_fragment).setOnClickListener(v -> helloFragment.doSomethingInFragment());
    }

    @Override
    public void doSomeWork(String label) {
        Toast.makeText(this, "Recieved mess : \n"+label, Toast.LENGTH_SHORT).show();
    }
}
