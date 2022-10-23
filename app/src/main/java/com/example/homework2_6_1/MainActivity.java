package com.example.homework2_6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            final TextView enterTopCenter = findViewById(R.id.tv_enter_top_center);
            final TextView welcomeCenter = findViewById(R.id.tv_welcome_center);
            final TextView enterOrRegister = findViewById(R.id.tv_enter_or_register_center);
            final EditText etLogin = findViewById(R.id.et_enter_email_center);
            final EditText etPassword = findViewById(R.id.et_enter_password_center);
            final Button btnEnter = findViewById(R.id.btn_enter_bottom);
            final TextView forgetPassword = findViewById(R.id.tv_forget_password_bottom_start);
            final TextView clickHere = findViewById(R.id.tv_click_here_bottom_end);
            final TextView welcomeCenter2 = findViewById(R.id.tv_welcome_center_2);

            etPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (etLogin.getText().toString().length() == 0 && etPassword.getText().toString().length() == 0) {
                        btnEnter.setEnabled(false);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (etLogin.getText().toString().length() > 0 && etPassword.getText().toString().length() > 0) {
                        btnEnter.setEnabled(true);
                        btnEnter.setBackgroundColor(btnEnter.getContext().getResources().getColor(R.color.orange));
                    } else {
                        btnEnter.setBackgroundColor(btnEnter.getContext().getResources().getColor(R.color.gray));
                    }
                }
            });

            btnEnter.setOnClickListener(e -> {
                if (etLogin.getText().toString().equals("admin@gmail.com") && etPassword.getText().toString().equals("admin")) {
                    enterTopCenter.setVisibility(TextView.GONE);
                    welcomeCenter.setVisibility(TextView.GONE);
                    enterOrRegister.setVisibility(TextView.GONE);
                    etLogin.setVisibility(EditText.GONE);
                    etPassword.setVisibility(EditText.GONE);
                    btnEnter.setVisibility(Button.GONE);
                    forgetPassword.setVisibility(TextView.GONE);
                    clickHere.setVisibility(TextView.GONE);
                    welcomeCenter2.setVisibility(TextView.VISIBLE);
                    Toast.makeText(this, "Вы успешно зарегистрировались ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Не правильный логин или пароль ", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
