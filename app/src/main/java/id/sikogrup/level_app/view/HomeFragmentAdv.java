package id.sikogrup.level_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragmentAdv extends Fragment {
    //Declaration Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    private String user_id;

    private TextView user_profile_name, user_profile_short_bio, contactP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adv_fragment_home, container, false);

        user_profile_name = (TextView) view.findViewById(R.id.user_profile_name);
        user_profile_short_bio = (TextView) view.findViewById(R.id.user_profile_short_bio);
        contactP = (TextView) view.findViewById(R.id.contactP);

        return view;
    }

}
