package br.edu.iff.pooa20181.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;

public class PrimeiroActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_TERCEIRA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText edtURI = (EditText) findViewById(R.id.edtURI);
        Button btOk = (Button) findViewById(R.id.btnOK);

        final EditText edtMensagem = (EditText) findViewById(R.id.edtMensagem);
        Button btEnviar = (Button) findViewById(R.id.btnEnviar);

        Button btnRetorno = (Button) findViewById(R.id.btnRetorno);



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

        btnRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (PrimeiroActivity.this, RetornoActivity.class);
                startActivityForResult(intent, REQUEST_CODE_TERCEIRA);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE_TERCEIRA)
        {
            if(data.hasExtra("retorno"))
            {
                TextView tRetorno = (TextView) findViewById(R.id.tRetorno);
                tRetorno.setText(data.getStringExtra("retorno").toString());
            }
        }

    }
}
