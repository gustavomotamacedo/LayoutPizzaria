package com.gustavomacedo.layoutpizzaria;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText edtCalabresa;
    private EditText edtChampion;
    private EditText edtMarguerita;
    private EditText edtNordestina;
    private EditText edtNapolitana;
    private EditText edtPeperoni;
    private TextView txtConta;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalcular = findViewById(R.id.btnCalcular);
        edtCalabresa = findViewById(R.id.edtCalabresa);
        edtChampion = findViewById(R.id.edtChampion);
        edtMarguerita = findViewById(R.id.edtMarguerita);
        edtNapolitana = findViewById(R.id.edtNapolitana);
        edtNordestina = findViewById(R.id.edtNordestina);
        edtPeperoni = findViewById(R.id.edtPeperoni);
        txtConta = findViewById(R.id.txtResposta);

        btnCalcular.setOnClickListener(v -> {
            try {
                int qtdCalabresa = (edtCalabresa.getText().toString().isEmpty()) ? 0 : Integer.parseInt(edtCalabresa.getText().toString());
                int qtdChampion = (edtChampion.getText().toString().isEmpty()) ? 0 : Integer.parseInt(edtChampion.getText().toString());
                int qtdMarguerita = (edtMarguerita.getText().toString().isEmpty()) ? 0 : Integer.parseInt(edtMarguerita.getText().toString());
                int qtdNapolitana = (edtNapolitana.getText().toString().isEmpty()) ? 0 : Integer.parseInt(edtNapolitana.getText().toString());
                int qtdNordestina = (edtNordestina.getText().toString().isEmpty()) ? 0 : Integer.parseInt(edtNordestina.getText().toString());
                int qtdPeperoni = (edtPeperoni.getText().toString().isEmpty()) ? 0 : Integer.parseInt(edtPeperoni.getText().toString());

                double valorFinal = 0.0;
                valorFinal += qtdCalabresa * 20.0;
                valorFinal += qtdChampion * 25.0;
                valorFinal += qtdMarguerita * 18.0;
                valorFinal += qtdNapolitana * 22.0;
                valorFinal += qtdNordestina * 73.0;
                valorFinal += qtdPeperoni * 21.0;

                txtConta.setText("VALOR A PAGAR: " + String.format(Locale.US, "R$ %.2f", valorFinal));
            } catch (IllegalArgumentException e) {
                Log.e("GUSTAVO MACEDO", String.valueOf(e));
                Toast.makeText(this, "ESCREVA APENAS INTEIROS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}