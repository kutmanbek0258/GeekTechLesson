package smanov.kutman.geektechlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email_et;
    private EditText password_et;
    private Button sign_in_bt;
    private LinearLayout sign_in_container;

    private String email = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_et = (EditText)findViewById(R.id.email_et);
        password_et = (EditText)findViewById(R.id.password_et);
        sign_in_bt = (Button)findViewById(R.id.sign_in_bt);
        sign_in_container = (LinearLayout)findViewById(R.id.sign_in_container);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );


        email_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                email = email_et.getText().toString();
                sign_in_bt.setClickable(checkCredentials(email, password));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                email = email_et.getText().toString();
                sign_in_bt.setClickable(checkCredentials(email, password));
            }
        });

        password_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                password = password_et.getText().toString();
                sign_in_bt.setClickable(checkCredentials(email, password));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                password = password_et.getText().toString();
                sign_in_bt.setClickable(checkCredentials(email, password));
            }
        });

        sign_in_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPassword(email, password);
            }
        });
        
    }

    private boolean checkCredentials(String email, String password){
        boolean fine = false;
        if(email.length() >= 5 && password.length() >= 5){
            fine = true;
        }

        return fine;
    }

    private void checkPassword(String email, String password){
        if(password.equals("superPassword")){
            Toast.makeText(this, "Fine password", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
        }
    }
}