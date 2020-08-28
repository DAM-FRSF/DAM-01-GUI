package isi.dam.dam.gui01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton1;
    Button boton2;
    ImageButton boton3;
    ImageView imgCabecera;
    CheckBox cbOptA,cbOptB;
    TextView opcionesElegidas;
    Switch sw1;
    ToggleButton tg1;
    String estadoA,estadoB;
    RadioGroup rg1,rg2;
    RadioButton rb1,rb2,rb3,rb4;
    EditText texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // a nivel swing setContentPane
        // obtener referencias a los widgets
        boton1 = findViewById(R.id.btnEjemplo01);
        boton2 = findViewById(R.id.btnEjemplo02);
        boton3 = findViewById(R.id.imageButton);
        imgCabecera = findViewById(R.id.imgCabecera);
        cbOptA = findViewById(R.id.optA);
        cbOptB = findViewById(R.id.optB);
        opcionesElegidas = findViewById(R.id.tvDescOpc);
        sw1 = findViewById(R.id.switch1);
        tg1 = findViewById(R.id.toggleButton1);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        texto2 = findViewById(R.id.texto2);

        if(cbOptA.isChecked()){
            estadoA ="OPCION A ELEGIDA ! ";
        } else {
            estadoA ="OPCION A NO ELEGIDA ! ";
        }
        if(cbOptB.isChecked()){
            estadoB = "OPCION B ELEGIDA ! ";
        }else {
            estadoB = "OPCION B NO ELEGIDA!";
        }

        opcionesElegidas.setText(estadoA+" "+estadoB);

        CompoundButton.OnCheckedChangeListener listenerCB = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.optA:
                        if(isChecked) estadoA = "<<A>> ELEGIDO";
                        else  estadoA = "<<A>> NOOO ELEGIDO";
                        break;
                    case R.id.optB:
                        if(isChecked) estadoB = "<<B>> ELEGIDO";
                        else estadoB = "<<B>> NOOO ELEGIDO";
                        break;
                    case R.id.toggleButton1:
                        break;
                    case R.id.switch1:
                        sw1.setText(isChecked? "ACTIVADO ! ": "NO ACTIVO !?!");
                        break;
                }
                opcionesElegidas.setText(estadoA+" "+estadoB);
            }
        };

        cbOptA.setOnCheckedChangeListener(listenerCB);
        cbOptB.setOnCheckedChangeListener(listenerCB);
        sw1.setOnCheckedChangeListener(listenerCB);
        tg1.setOnCheckedChangeListener(listenerCB);

        // listener de RadioButton
        RadioGroup.OnCheckedChangeListener radioListenerRG1 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        //rb3.toggle();
                        texto2.requestFocus();
                        boton1.setEnabled(false);
                        break;
                    case R.id.radioButton2:
                        rg2.clearCheck();
                        boton1.setEnabled(true);

                        break;
                }
            }


        };

            RadioGroup.OnCheckedChangeListener radioListenerRG2 = new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.radioButton3:
                        case R.id.radioButton4:
                    }
                }


            };

        rg1.setOnCheckedChangeListener(radioListenerRG1);
        rg2.setOnCheckedChangeListener(radioListenerRG2);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"CLICK EN BOTON 1 CLASE ANONIMA",Toast.LENGTH_LONG).show();
                TextView tv = findViewById(R.id.textView1);
                tv.setVisibility(View.INVISIBLE);
            }
        });
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCabecera.setImageResource(R.drawable.logo_campus);
                TextView tv = findViewById(R.id.textView1);
                tv.setVisibility(View.GONE);
            }
        });

        if(System.currentTimeMillis()%2 == 2){
            boton1.setBackgroundColor(Color.parseColor("#FF0000"));
        } else {
            boton1.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        boton1.setText("NUEVO "+System.currentTimeMillis());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEjemplo01:
                Toast.makeText(this,"CLICK EN BOTON 1",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnEjemplo02:
                Toast.makeText(this,"CLICK EN BOTON 2",Toast.LENGTH_LONG).show();
                TextView tv = findViewById(R.id.textView1);
                tv.setVisibility(View.VISIBLE);
                cbOptA.toggle();
                cbOptB.toggle();
                break;
        }
    }
}