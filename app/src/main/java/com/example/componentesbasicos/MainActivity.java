package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button btnClean;
    private Button btnEnviar;
    private CheckBox checkBoxNaruto, checkBoxHunter, checkBoxTitan;
    private TextView txtRes;
    private EditText inputName;
    private EditText inputEmail;
    private RadioButton radioBtnMale;
    private RadioButton radioBtnFem;
    private RadioGroup radioGroup;
    private String nome;
    private String email;
    private String opcaoSex = "";
    private String sex = "";
    private String res = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewers();
        initListeners();
        radioBtn();
    }

    public void initViewers() {
        btnEnviar = findViewById(R.id.btnEnviar);
        txtRes = findViewById(R.id.txtRes);
        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        btnClean = findViewById(R.id.btnClean);
        checkBoxNaruto = findViewById(R.id.checkBoxNaruto);
        checkBoxHunter = findViewById(R.id.checkBoxHunter);
        checkBoxTitan = findViewById(R.id.checkBoxTitan);
        radioBtnMale = findViewById(R.id.radioBtnMale);
        radioBtnFem = findViewById(R.id.radioBtnFem);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void initListeners() {
        String no1 = inputName.getText().toString();
        String em1 = inputEmail.getText().toString();

        btnEnviar.setOnClickListener(v -> {
            Boolean validprogress = vFill(no1, em1);
            if (validprogress) {
                captureInput(v);
            } else {
                txtRes.setText("Nome e/ou Email inv??lidos!");
            }
        });

        btnClean.setOnClickListener(v ->
                cleanInput(v));
        radioBtnMale.setOnClickListener(v ->
                checkBox());
        radioBtnFem.setOnClickListener(v ->
                checkBox());
    }


    public void checkBox() {
        if (checkBoxHunter.isChecked()) {
            res = " Hunter x Hunter";
        }
        if (checkBoxTitan.isChecked()) {
            res = res + " Attack on Titan";
        }
        if (checkBoxNaruto.isChecked()) {
            res = res + " Naruto";
        }
    }

    private void radioBtn() {
        if (radioBtnFem.isChecked()) {
            sex = "Feminino";
        } else if (radioBtnMale.isChecked()) {
            sex = "Masculino";
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtnFem) {
                    txtRes.setText("Feminino");
                } else if (checkedId == R.id.radioBtnMale) {
                    txtRes.setText("Masculino");
                }
            }
        });
    }

    public Boolean vFill(String nome, String email) {
        Boolean validating = true;
        if (nome == null || nome.equals("")) {
            validating = false;
        } else if (email == null || email.equals("")) {
            validating = false;
        }
        return validating;
    }

    public void captureInput(View view) {
        nome = inputName.getText().toString();
        email = inputEmail.getText().toString();
        checkBox();
        radioBtn();

        txtRes.setText(nome + "\n" + email + "\n" + res + " \n " + sex);
    }

    public void cleanInput(View view) {
        txtRes.setText("");
        inputName.setText("");
        inputEmail.setText("");
        checkBoxTitan.setChecked(false);
        checkBoxNaruto.setChecked(false);
        checkBoxHunter.setChecked(false);
        radioBtnMale.setChecked(false);
        radioBtnFem.setChecked(false);
    }
}