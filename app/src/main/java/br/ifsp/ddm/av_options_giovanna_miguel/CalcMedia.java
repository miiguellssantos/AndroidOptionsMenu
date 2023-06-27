package br.ifsp.ddm.av_options_giovanna_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class CalcMedia extends AppCompatActivity {

    private EditText txtNota1, txtNota2;
    private TextView lblMedia;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_media);

        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lblMedia = (TextView) findViewById(R.id.lblMedia);

        btnCalcular.setOnClickListener(new EscutadorBtnCalcula());
    }

    private class EscutadorBtnCalcula implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            double nota1 = Double.parseDouble(txtNota1.getText().toString());
            double nota2 = Double.parseDouble(txtNota2.getText().toString());

            double media = (nota1 + nota2) / 2;

            lblMedia.setText(String.valueOf(media));
        }
    }
}