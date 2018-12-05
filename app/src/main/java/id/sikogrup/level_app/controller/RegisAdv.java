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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RegisAdv extends AppCompatActivity {

    //Declaration Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //Declaration EditTexts
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextFullName;
    EditText editTextPhone;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    TextInputLayout textInputLayoutFullName;
    TextInputLayout textInputLayoutPhone;

    //Declaration Button
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_adv);

        initTextViewLogin();
        initViews();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            }
        };

        //set click event of Resgister button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    final String UserName = editTextUserName.getText().toString();
                    final String Email = editTextEmail.getText().toString();
                    final String Password = editTextPassword.getText().toString();
                    final String fullName = editTextFullName.getText().toString();
                    final String phone = editTextPhone.getText().toString();

                    Query usernameQuery = FirebaseDatabase.getInstance().getReference().child("Users").child("Adventurer").orderByChild("username").equalTo(UserName);
                    usernameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.getChildrenCount()>0){
                                Toast.makeText(RegisAdv.this, "Choose a different Username!", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                //Check in the database is there any user associated with  this email
                                mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(RegisAdv.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(!task.isSuccessful()){
                                            Toast.makeText(RegisAdv.this, "Register Failed= "+task.getException(), Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            String user_id = mAuth.getCurrentUser().getUid();
                                            DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child("Adventurer").child(user_id);
                                            Adventurer user = new Adventurer(UserName,Email,fullName,phone,user_id,0,0);
                                            database.setValue(user);

                                            Toast.makeText(RegisAdv.this, "Register Successful", Toast.LENGTH_SHORT).show();
                                            resetView();
                                            FirebaseAuth.getInstance().signOut();
                                        }
                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
            }
        });
    }


    //this method used to set Login TextView click event
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisAdv.this, LoginGM.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextFullName = (EditText) findViewById(R.id.editTextFullName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        textInputLayoutFullName = (TextInputLayout) findViewById(R.id.textInputLayoutFullName);
        textInputLayoutPhone = (TextInputLayout) findViewById(R.id.textInputLayoutPhone);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
    }

    //this method is used to reset XML views to its Objects
    private void resetView(){
        editTextEmail.setText("");
        editTextPassword.setText("");
        editTextUserName.setText("");
        editTextFullName.setText("");
        editTextPhone.setText("");
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;
        boolean valid4 = false;
        boolean valid5 = false;

        //Get values from EditText fields
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();
        String fullName = editTextFullName.getText().toString();
        String phone = editTextPhone.getText().toString();


        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid1 = false;
            textInputLayoutUserName.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 5) {
                valid1 = true;
                textInputLayoutUserName.setError(null);
            } else {
                valid1 = false;
                textInputLayoutUserName.setError("Username is too short!");
            }
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid2 = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid2 = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid3 = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid3 = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid3 = false;
                textInputLayoutPassword.setError("Password is too short!");
            }
        }

        //Handling validation for Fullname field
        if (fullName.isEmpty()) {
            valid4 = false;
            textInputLayoutFullName.setError("Please enter valid name!");
        } else {
            if (fullName.length() > 0) {
                valid4 = true;
                textInputLayoutFullName.setError(null);
            } else {
                valid4 = false;
                textInputLayoutFullName.setError("Name is too short!");
            }
        }

        //Handling validation for Phone field
        if (phone.isEmpty()) {
            valid5 = false;
            textInputLayoutPhone.setError("Please enter valid phone number!");
        } else {
            if (phone.length() > 5) {
                valid5 = true;
                textInputLayoutPhone.setError(null);
            } else {
                valid5 = false;
                textInputLayoutPhone.setError("Phone number is too short!");
            }
        }

        return (valid1 && valid2 && valid3 && valid4 && valid5);
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
