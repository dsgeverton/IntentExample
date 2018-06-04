package br.edu.iff.pooa20181.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;
import java.net.URL;

public class PrimeiroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText edtURI = (EditText) findViewById(R.id.edtURI);
        Button btOk = (Button) findViewById(R.id.btnOK);

        final EditText edtMensagem = (EditText) findViewById(R.id.edtMensagem);
        Button btEnviar = (Button) findViewById(R.id.btnEnviar);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(String.format("http://%s", edtURI.getText().toString()));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                startActivity(intent);

            }
        });

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimeiroActivity.this, SegundaActivity.class);
                intent.putExtra("msg", edtMensagem.getText().toString());
                startActivity(intent);

            }
        });
    }
}
