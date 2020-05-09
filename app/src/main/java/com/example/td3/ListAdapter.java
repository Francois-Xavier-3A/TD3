package com.example.td3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Pokemon> values;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public void add(int position, Pokemon item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Pokemon> myDataset, Context context) {
        values = myDataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Pokemon currentPokemon = values.get(position);
        holder.txtHeader.setText(currentPokemon.getName());
        holder.txtFooter1.setText(currentPokemon.getRarity());

        if (currentPokemon.getCivilization().equals("Fire")){
            holder.CivPic.setImageResource(R.mipmap.fire1);
        }if (currentPokemon.getCivilization().equals("Water")){
            holder.CivPic.setImageResource(R.mipmap.wave);
        }if (currentPokemon.getCivilization().equals("Light")){
            holder.CivPic.setImageResource(R.mipmap.light);
        }if (currentPokemon.getCivilization().equals("Darkness")){
            holder.CivPic.setImageResource(R.mipmap.night);
        }if (currentPokemon.getCivilization().equals("Nature")){
            holder.CivPic.setImageResource(R.mipmap.forest);
        }if (currentPokemon.getCivilization().equals("Special")){
            holder.CivPic.setImageResource(R.mipmap.special);
        }

        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Info.class);
                intent.putExtra("name", currentPokemon.getName());
                intent.putExtra("set", currentPokemon.getSet());
                intent.putExtra("id", currentPokemon.getID());
                intent.putExtra("civilization", currentPokemon.getCivilization());
                intent.putExtra("rarity", currentPokemon.getRarity());
                intent.putExtra("type", currentPokemon.getType());
                intent.putExtra("cost", currentPokemon.getCost());
                intent.putExtra("text", currentPokemon.getText());
                intent.putExtra("flavor", currentPokemon.getFlavor());
                intent.putExtra("illustrator", currentPokemon.getIllustrator());
                intent.putExtra("race", currentPokemon.getRace());
                intent.putExtra("power", currentPokemon.getPower());
                intent.putExtra("picture", currentPokemon.getpicture());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView txtHeader;
        ImageView CivPic;
        TextView txtFooter1;

        View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter1 = (TextView) v.findViewById(R.id.secondLine);

            CivPic = (ImageView) v.findViewById(R.id.icon);
        }
    }
}
