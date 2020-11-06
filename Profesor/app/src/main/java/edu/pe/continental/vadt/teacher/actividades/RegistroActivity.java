package edu.pe.continental.vadt.teacher.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.pe.continental.vadt.teacher.R;
import edu.pe.continental.vadt.teacher.models.User;
import edu.pe.continental.vadt.teacher.providers.AuthProvider;
import edu.pe.continental.vadt.teacher.providers.UsersProvider;

public class RegistroActivity extends AppCompatActivity {


    CircleImageView mCircleImageViewBack;
    TextInputEditText mTextInputUsername;
    TextInputEditText mTextInputEmail;
    TextInputEditText mTextInputPassword;
    TextInputEditText mTextInputPhone;
    TextInputEditText mTextInputConfirmPassword;
    Button mButtonRegister;
    AuthProvider mAuthProvider;
    UsersProvider mUsersProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //mCircleImageViewBack = findViewById(R.id.circleImageBack);
        mTextInputEmail = findViewById(R.id.textInputEmail);
        mTextInputUsername = findViewById(R.id.textInputUsername);
        mTextInputPhone = findViewById(R.id.textInputPhone);
        mTextInputPassword = findViewById(R.id.textInputPassword);
        mTextInputConfirmPassword = findViewById(R.id.textInputConfirmPassword);
        mButtonRegister = findViewById(R.id.btnRegister);

        mAuthProvider = new AuthProvider();
        mUsersProvider = new UsersProvider();

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

    }

    private void register() {
        String username = mTextInputUsername.getText().toString();
        String email = mTextInputEmail.getText().toString();
        String phone = mTextInputPhone.getText().toString();
        String password  = mTextInputPassword.getText().toString();
        String confirmPassword = mTextInputConfirmPassword.getText().toString();

        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
            if (isEmailValid(email)) {
                if (password.equals(confirmPassword)) {
                    if (password.length() >= 6) {
                        createUser(username, phone,  email, password);
                    }
                    else {
                        Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(this, "Las contraseña no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "Insertaste todos los campos pero el correo no es valido", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Para continuar inserta todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void createUser(final String username, String phones,  final String email,  final String password) {
        mAuthProvider.register(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = mAuthProvider.getUid();

                    User user = new User();
                    user.setId(id);
                    user.setEmail(email);
                    user.setPhone(phones);
                    user.setUsername(username);


                    mUsersProvider.create(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                               // Intent i = new Intent(RegistroActivity.this, HomeActivity.class);
                               // startActivity(i);
                                Toast.makeText(RegistroActivity.this, "El usuario se almaceno correctamente en la base de datos", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(RegistroActivity.this, "No se pudo almacenar el usuario en la base de datos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(RegistroActivity.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
     * VERIFICAR QUE SEA UN EMAIL VALIDO
     */
    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}