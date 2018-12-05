package id.sikogrup.level_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateQuest extends AppCompatActivity {
    //Declaration Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //Declaration EditTexts
    EditText editTextNameQuest;
    EditText editTextDescQuest;
    EditText editTextPointQuest;
    EditText editTextExpQuest;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutNameQuest;
    TextInputLayout textInputLayoutDescQuest;
    TextInputLayout textInputLayoutPointQuest;
    TextInputLayout textInputLayoutExpQuest;

    //Declaration Button
    Button buttonCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quest);

        initTextViewLogin();
        initViews();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            }
        };

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String name = editTextNameQuest.getText().toString();
                    String desc = editTextDescQuest.getText().toString();
                    String point = editTextPointQuest.getText().toString();
                    String exp = editTextExpQuest.getText().toString();
                    int point2 = Integer.parseInt(point);
                    int exp2 = Integer.parseInt(exp);

                    String gmKey = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Quest").child(gmKey);
                    Quest quest = new Quest(name,desc,point2,exp2,gmKey);
                    database.push().setValue(quest);

                    Toast.makeText(CreateQuest.this, "Create Quest Successful", Toast.LENGTH_SHORT).show();
                    resetView();
                }
            }
        });
    }

    //this method used to set Login TextView click event
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textBackToMain);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateQuest.this, MainMenuGM.class);
                startActivity(intent);
                finish();
            }
        });
    }


    //this method is used to connect XML views to its Objects
    private void initViews() {
        //Declaration EditTexts
        editTextNameQuest = (EditText) findViewById(R.id.editTextNameQuest);
        editTextDescQuest = (EditText) findViewById(R.id.editTextDescQuest);
        editTextPointQuest = (EditText) findViewById(R.id.editTextPointQuest);
        editTextExpQuest = (EditText) findViewById(R.id.editTextExpQuest);

        //Declaration TextInputLayout
        textInputLayoutNameQuest = (TextInputLayout) findViewById(R.id.textInputLayoutNameQuest);
        textInputLayoutDescQuest = (TextInputLayout) findViewById(R.id.textInputLayoutDescQuest);
        textInputLayoutPointQuest = (TextInputLayout) findViewById(R.id.textInputLayoutPointQuest);
        textInputLayoutExpQuest = (TextInputLayout) findViewById(R.id.textInputLayoutExpQuest);

        buttonCreate = (Button) findViewById(R.id.buttonCreate);
    }

    private void resetView(){
        editTextNameQuest.setText("");
        editTextDescQuest.setText("");
        editTextPointQuest.setText("");
        editTextExpQuest.setText("");
    }

    public boolean validate() {
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;
        boolean valid4 = false;

        String name = editTextNameQuest.getText().toString();
        String desc = editTextDescQuest.getText().toString();
        String point = editTextPointQuest.getText().toString();
        String exp = editTextExpQuest.getText().toString();

        if (name.isEmpty()) {
            valid1 = false;
            textInputLayoutNameQuest.setError("Please enter valid guild name!");
        } else {
            if (name.length() > 5) {
                valid1 = true;
                textInputLayoutNameQuest.setError(null);
            } else {
                valid1 = false;
                textInputLayoutNameQuest.setError("Name is too short!");
            }
        }

        if (desc.isEmpty()) {
            valid2 = false;
            textInputLayoutDescQuest.setError("Please enter valid subject!");
        } else {
            valid2 = true;
            textInputLayoutDescQuest.setError(null);
        }

        if (point.isEmpty()){
            valid3 = false;
            textInputLayoutPointQuest.setError("Please enter valid level!");
        } else {
            valid3 = true;
            textInputLayoutPointQuest.setError(null);
        }

        if (point.isEmpty()){
            valid4 = false;
            textInputLayoutExpQuest.setError("Please enter valid level!");
        } else {
            valid4 = true;
            textInputLayoutExpQuest.setError(null);
        }

        return (valid1 && valid2 && valid3 && valid4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}
