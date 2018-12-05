package id.sikogrup.level_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GmGuildDetail extends AppCompatActivity {
    private Button buttonListGuideBook, buttonListQuest, buttonCreateQuest, buttonCreateGuideBook;
    private TextView gm_guild_level, gm_guild_subject, gm_guild_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gm_guild_detail);

        buttonListGuideBook = (Button) findViewById(R.id.buttonListGuideBook);
        buttonCreateGuideBook = (Button) findViewById(R.id.buttonCreateGuideBook);
        buttonListQuest = (Button) findViewById(R.id.buttonListQuest);
        buttonCreateQuest = (Button) findViewById(R.id.buttonCreateQuest);


        gm_guild_level = (TextView) findViewById(R.id.gm_guild_level);
        gm_guild_subject = (TextView) findViewById(R.id.gm_guild_subject);
        gm_guild_name = (TextView) findViewById(R.id.gm_guild_name);

        Bundle bundle = getIntent().getExtras();
        if(getIntent().getExtras()!=null){
            gm_guild_name.setText(bundle.getString("name"));
            gm_guild_subject.setText(bundle.getString("sub"));
            gm_guild_level.setText(""+ bundle.getInt("level"));
        }


        buttonListGuideBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GmGuildDetail.this, "Under Construction", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(GmGuildDetail.this, CreateQuest.class);
//                startActivity(intent);
//                finish();
//                return;
            }
        });

        buttonCreateGuideBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GmGuildDetail.this, "Under Construction", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(GmGuildDetail.this, CreateQuest.class);
//                startActivity(intent);
//                finish();
//                return;
            }
        });

        buttonListQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GmGuildDetail.this, "Under Construction", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(GmGuildDetail.this, CreateQuest.class);
//                startActivity(intent);
//                finish();
//                return;
            }
        });

        buttonCreateQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GmGuildDetail.this, CreateQuest.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, GmGuildDetail.class);
    }
}
