package br.edu.iff.pooa20181.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda2);


        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");

        TextView tMsg = (TextView) findViewById(R.id.tMsg);
        tMsg.setText(msg);
    }
}
