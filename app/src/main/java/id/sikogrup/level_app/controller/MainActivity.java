package id.sikogrup.level_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    //Declaration Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //Declaration Button
    private Button buttonGM, buttonAdv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is used to connect XML views to its Objects
        buttonGM = (Button) findViewById(R.id.buttonChooseGM);
        buttonAdv = (Button) findViewById(R.id.buttonChooseAdv);

        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    mAuth.signOut();
                }
            }
        };

        buttonGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginGM.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        buttonAdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //For Under construction
//                Snackbar.make(buttonAdv, "Under construction", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,LoginAdv.class);
                startActivity(intent);
                finish();
                return;
            }
        });
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

//For Under construction
//Snackbar.make(buttonAdv, "Under construction", Snackbar.LENGTH_LONG).show();
