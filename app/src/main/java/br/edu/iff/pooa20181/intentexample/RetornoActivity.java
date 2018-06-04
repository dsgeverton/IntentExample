package br.edu.iff.pooa20181.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RetornoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorno);

    }

    @Override

    public void finish(){
        Intent intent = new Intent ();
        EditText edtRetorno = (EditText) findViewById(R.id.edtRetorno);
        intent.putExtra("retorno", edtRetorno.getText().toString());
        setResult(RESULT_OK, intent);
        super.finish();

    }


}
