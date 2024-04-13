package com.example.hamburgueriaz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuantity;
    private TextView textViewSummary;
    private int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantity = findViewById(R.id.textView_quantity_value);
        textViewQuantity.setText("0");

        textViewSummary = findViewById(R.id.textView_total_price);

        Button buttonIncrease = findViewById(R.id.button_increase);
        Button buttonDecrease = findViewById(R.id.button_decrease);

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                somar();
                textViewQuantity.setText(String.valueOf(quantidade));
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtrair();
                textViewQuantity.setText(String.valueOf(quantidade));
            }
        });

        Button buttonPlaceOrder = findViewById(R.id.button_place_order);

        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextNome = findViewById(R.id.editText_nome);
                String nome = editTextNome.getText().toString();

                CheckBox checkBoxBacon = findViewById(R.id.checkBox_bacon);
                CheckBox checkBoxQueijo = findViewById(R.id.checkBox_queijo);
                CheckBox checkBoxOnionRing = findViewById(R.id.checkBox_onion_ring);

                boolean temBacon = checkBoxBacon.isChecked();
                boolean temQueijo = checkBoxQueijo.isChecked();
                boolean temOnionRing = checkBoxOnionRing.isChecked();

                int quantidade = Integer.parseInt(textViewQuantity.getText().toString());
                int precoBase = 20;
                int precoBacon = 2;
                int precoQueijo = 2;
                int precoOnionRing = 3;

                int precoFinal = precoBase * quantidade;
                if (temBacon) precoFinal += precoBacon * quantidade;
                if (temQueijo) precoFinal += precoQueijo * quantidade;
                if (temOnionRing) precoFinal += precoOnionRing * quantidade;

                StringBuilder summaryMessage = new StringBuilder();
                summaryMessage.append("Nome do cliente: ").append(nome).append("\n");
                summaryMessage.append("Tem Bacon? ").append(temBacon ? "Sim" : "Não").append("\n");
                summaryMessage.append("Tem Queijo? ").append(temQueijo ? "Sim" : "Não").append("\n");
                summaryMessage.append("Tem Onion Rings? ").append(temOnionRing ? "Sim" : "Não").append("\n");
                summaryMessage.append("Quantidade: ").append(quantidade).append("\n");
                summaryMessage.append("Preço final: R$ ").append(precoFinal);

                textViewSummary.setText(summaryMessage.toString());
            }
        });
    }

    private void somar() {
        quantidade++;
    }

    private void subtrair() {
        if (quantidade > 0) {
            quantidade--;
        }
    }
}