package com.example.minhasanotaoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";
    private SharedPreferences.Editor editor;

    public AnotacaoPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = preferences.edit();

    }


    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME,anotacao);
        editor.apply();
    }

    public String recuperarAnotacao(){

        return preferences.getString(CHAVE_NOME,"");
    }

}
