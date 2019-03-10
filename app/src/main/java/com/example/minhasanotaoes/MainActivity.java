package com.example.minhasanotaoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        editAnotacao = findViewById(R.id.editAnotacao);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Validar se foi digitado algo
                String textorecuperado = editAnotacao.getText().toString();

                if (textorecuperado.equals("")){
                    Snackbar.make(view, "Digite uma anotaçao", Snackbar.LENGTH_LONG).show();


                }else {
                    preferencias.salvarAnotacao(textorecuperado);
                    Snackbar.make(view, "Anotaçao Salvo", Snackbar.LENGTH_LONG).show();
                }


            }
        });

        //Recuperar anotacao
        String anotacao = preferencias.recuperarAnotacao();

        if (!anotacao.equals("")){
           editAnotacao.setText(anotacao);
        }

    }



}
