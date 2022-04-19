package com.example.lesson2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity{
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnOshiru, btnPlusMinus,btnNukte;
    TextView tvSan;
    Button BtnOshiru, BtnPlusMinus, btnPlus, btnMinus, btnX, btnBolu, btnTen;
    TextView TvSan, tvZapis;
    String birinshiSan, ekinshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        sandarMethods();
        oshiruPlusMinusMethod();
        functionMethod();
    }
    public void initViews() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnOshiru = findViewById(R.id.btnOshiru);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnX = findViewById(R.id.btnX);
        btnBolu = findViewById(R.id.btnBolu);
        btnTen = findViewById(R.id.btnTen);
        btnNukte = findViewById(R.id.btnNukte);
        tvSan = findViewById(R.id.tv_san);
        tvZapis = findViewById(R.id.tv_zapis);
    }
    public void sandarMethods() {
        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aldyngySan = tvSan.getText().toString();
                String basylganSan = "";
                String songyResult = "";
                switch (view.getId()) {
                    case R.id.btn0:
                        basylganSan = "0";
                        break;
                    case R.id.btn1:
                        basylganSan = "1";
                        break;
                    case R.id.btn2:
                        basylganSan = "2";
                        break;
                    case R.id.btn3:
                        basylganSan = "3";
                        break;
                    case R.id.btn4:
                        basylganSan = "4";
                        break;
                    case R.id.btn5:
                        basylganSan = "5";
                        break;
                    case R.id.btn6:
                        basylganSan = "6";
                        break;
                    case R.id.btn7:
                        basylganSan = "7";
                        break;
                    case R.id.btn8:
                        basylganSan = "8";
                        break;
                    case R.id.btn9:
                        basylganSan = "9";
                        break;
                    case R.id.btnNukte:
                        if(aldyngySan.contains(".")){
                            basylganSan = "";
                        }else{
                            basylganSan=".";
                        }
                        break;
                }
                if (!aldyngySan.equals("0")) songyResult = aldyngySan + basylganSan;
                else songyResult = basylganSan;
                tvSan.setText(songyResult);
            }
        };
        btn0.setOnClickListener(buttonSandar);
        btn1.setOnClickListener(buttonSandar);
        btn2.setOnClickListener(buttonSandar);
        btn3.setOnClickListener(buttonSandar);
        btn4.setOnClickListener(buttonSandar);
        btn5.setOnClickListener(buttonSandar);
        btn6.setOnClickListener(buttonSandar);
        btn7.setOnClickListener(buttonSandar);
        btn8.setOnClickListener(buttonSandar);
        btn9.setOnClickListener(buttonSandar);
        btnNukte.setOnClickListener(buttonSandar);
    }
    public void oshiruPlusMinusMethod() {
        View.OnClickListener buttonOwiruPlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnOshiru:
                        tvSan.setText("0");
                        tvZapis.setText("");
                        break;
                    case R.id.btnPlusMinus:
                        String sanText = tvSan.getText().toString();
                        int san = Integer.parseInt(sanText);
                        if (san > 0) tvSan.setText("-" + sanText);
                        else {
                            san = san * (-1);
                            tvSan.setText("" + san);
                        }
                        break;
                }
            }
        };
        btnOshiru.setOnClickListener(buttonOwiruPlusMinus);
        btnPlusMinus.setOnClickListener(buttonOwiruPlusMinus);
    }
    public void functionMethod() {
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birinshiSan = tvSan.getText().toString();
                switch (view.getId()) {
                    case R.id.btnPlus:
                        znak = "+";
                        break;
                    case R.id.btnMinus:
                        znak = "-";
                        break;
                    case R.id.btnX:
                        znak = "*";
                        break;
                    case R.id.btnBolu:
                        znak = "/";
                        break;
                }
                zapisText = birinshiSan + znak;
                tvZapis.setText(zapisText);
                tvSan.setText("0");
            }
        };
        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnX.setOnClickListener(btnFunctions);
        btnBolu.setOnClickListener(btnFunctions);
        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekinshiSan = tvSan.getText().toString();
                double result=0;
                if(zapisText.contains(".")){
                    double san1 = Double.parseDouble(birinshiSan);
                    double san2 = Double.parseDouble(ekinshiSan);
                    if (znak.equals("+")) {
                        result = san1 + san2;
                    } else if (znak.equals("-")) {
                        result = san1 - san2;
                    } else if (znak.equals("*")) {
                        result = san1 * san2;
                    } else if (znak.equals("/")) {
                        result = san1 / san2;
                    }
                }else{
                    int san1 = Integer.parseInt(birinshiSan);
                    int san2 = Integer.parseInt(ekinshiSan);
                    int res = 0;
                    if (znak.equals("+")) {
                        res = san1 + san2;
                    } else if (znak.equals("-")) {
                        res = san1 - san2;
                    } else if (znak.equals("*")) {
                        res = san1 * san2;
                    } else if (znak.equals("/")) {
                        res = san1 / san2;
                    }
                    zapisText = birinshiSan + znak + ekinshiSan + " = " + res;
                    tvZapis.setText(zapisText);
                    tvSan.setText("" + res);
                }}
        });
    }
}