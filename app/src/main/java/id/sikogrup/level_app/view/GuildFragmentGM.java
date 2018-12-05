package id.sikogrup.level_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class GuildFragmentGM extends Fragment {
    private Button buttonCreateGuild, buttonShowGuild;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gm_fragment_guild, container, false);

        buttonCreateGuild = (Button) view.findViewById(R.id.buttonCreateGuild);
        buttonShowGuild = (Button) view.findViewById(R.id.buttonShowGuild);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        buttonCreateGuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Under Construction", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),GuildCreate.class);
                startActivity(intent);
                return;
            }
        });


        buttonShowGuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShowGuildGM.class);
                startActivity(intent);
                return;
            }
        });
    }
}
