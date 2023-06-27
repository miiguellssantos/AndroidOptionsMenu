package br.ifsp.ddm.av_options_giovanna_miguel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

// ALUNOS: MIGUEL SANTOS E CIOVANNA FERREIRA
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.activitymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Precisamos identificar qual item do menu foi clicado.
        // Fazemos isso recuperando o ID do item.
        if (item.getItemId() == R.id.menCalcMedia){
            // abrindo a activity CalcMedia:
            Intent i1 = new Intent(getApplicationContext(), CalcMedia.class);
            startActivity(i1);
            return true;
        }else if (item.getItemId() == R.id.menFinalizar){
            // criando o diálogo
            AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

            // definindo o título
            dialogo.setTitle("Fechando o app");

            // definindo o texto principal
            dialogo.setMessage("Deseja mesmo fechar o app?");

            // definindo a ação positiva
            dialogo.setPositiveButton("Fechar o app", new EscutadorDialogoOk());

            // definindo a ação negativa
            dialogo.setNegativeButton("Cancelar", new EscutadorDialogoCancela());

            // proibindo que o usuário clique fora da caixa
            dialogo.setCancelable(false);

            //criando e exibindo
            dialogo.create();
            dialogo.show();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }

    private class EscutadorDialogoCancela implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();

            Toast.makeText(MainActivity.this, "Cancelando...", Toast.LENGTH_SHORT).show();
        }
    }

    private class EscutadorDialogoOk implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();

            Toast.makeText(MainActivity.this, "Saindo...", Toast.LENGTH_SHORT).show();
        }
    }

    private class EscutadorBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }
}