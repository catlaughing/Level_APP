package id.sikogrup.level_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAdvRecyclerView extends RecyclerView.Adapter<AdapterAdvRecyclerView.ViewHolder> {
    private ArrayList<Guild> daftarGuild;
    private Context context;

    public AdapterAdvRecyclerView(ArrayList<Guild> daftarGuild, Context context) {
        this.daftarGuild = daftarGuild;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tv_namaGuild);
        }
    }

    @Override
    public AdapterAdvRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_guild, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        AdapterAdvRecyclerView.ViewHolder vh = new AdapterAdvRecyclerView.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterAdvRecyclerView.ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarGuild.get(position).getNameGuild();
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                Bundle bundle = new Bundle();
                bundle.putString("name",daftarGuild.get(position).getNameGuild());
                bundle.putString("sub",daftarGuild.get(position).getSubject());
                bundle.putInt("level",daftarGuild.get(position).getLevelRequirement());
                Intent intent = new Intent(context, AdvGuildDetail.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarGuild.size();
    }
}
