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

import java.lang.Integer;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GuildCreate extends AppCompatActivity {
    //Declaration Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //Declaration EditTexts
    EditText editTextNameGuild;
    EditText editTextSubjectGuild;
    EditText editTextLevelGuild;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutNameGuild;
    TextInputLayout textInputLayoutSubjectGuild;
    TextInputLayout textInputLayoutLevelGuild;

    //Declaration Button
    Button buttonCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guild_create);

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
            // saat diklik create guild
            public void onClick(View v) {
                if(validate()){
                    // get attribut
                    String name = editTextNameGuild.getText().toString();
                    String subject = editTextSubjectGuild.getText().toString();
                    String slevel = editTextLevelGuild.getText().toString();
                    int level = Integer.parseInt(slevel);

                    // get gm
                    String gmKey = mAuth.getCurrentUser().getUid();
                    // get database guild by gm
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Guild").child(gmKey);
                    Guild guild = new Guild(gmKey,name,subject,level);
                    database.push().setValue(guild);

                    Toast.makeText(GuildCreate.this, "Create Guild Successful", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(GuildCreate.this, MainMenuGM.class);
                startActivity(intent);
                finish();
            }
        });
    }


    //this method is used to connect XML views to its Objects
    private void initViews() {
        //Declaration EditTexts
        editTextNameGuild = (EditText) findViewById(R.id.editTextNameGuild);
        editTextSubjectGuild = (EditText) findViewById(R.id.editTextSubjectGuild);
        editTextLevelGuild = (EditText) findViewById(R.id.editTextLevelGuild);

        //Declaration TextInputLayout
        textInputLayoutNameGuild = (TextInputLayout) findViewById(R.id.textInputLayoutNameGuild);
        textInputLayoutSubjectGuild = (TextInputLayout) findViewById(R.id.textInputLayoutSubjectGuild);
        textInputLayoutLevelGuild = (TextInputLayout) findViewById(R.id.textInputLayoutLevelGuild);

        buttonCreate = (Button) findViewById(R.id.buttonCreate);
    }

    private void resetView(){
        editTextNameGuild.setText("");
        editTextSubjectGuild.setText("");
        editTextLevelGuild.setText("");
    }

    public boolean validate() {
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;

        String name = editTextNameGuild.getText().toString();
        String subject = editTextNameGuild.getText().toString();
        String level = editTextLevelGuild.getText().toString();

        if (name.isEmpty()) {
            valid1 = false;
            textInputLayoutNameGuild.setError("Please enter valid guild name!");
        } else {
            if (name.length() > 5) {
                valid1 = true;
                textInputLayoutNameGuild.setError(null);
            } else {
                valid1 = false;
                textInputLayoutNameGuild.setError("Name is too short!");
            }
        }

        if (subject.isEmpty()) {
            valid2 = false;
            textInputLayoutSubjectGuild.setError("Please enter valid subject!");
        } else {
            valid2 = true;
            textInputLayoutSubjectGuild.setError(null);
        }

        if (level.isEmpty()){
            valid3 = false;
            textInputLayoutLevelGuild.setError("Please enter valid level!");
        } else {
            valid3 = true;
            textInputLayoutLevelGuild.setError(null);
        }

        return (valid1 && valid2 && valid3);
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
