package com.example.td3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.ClipData.newIntent;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Pokemon> values;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView txtHeader;
        ImageView Fire;
        TextView txtFooter1;
        TextView txtFooter2;
        TextView txtFooter3;
        TextView txtFooter4;
        TextView txtFooter5;
        TextView txtFooter6;
        View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter1 = (TextView) v.findViewById(R.id.secondLine);
            txtFooter2 = (TextView) v.findViewById(R.id.thirdLine);
            txtFooter3 = (TextView) v.findViewById(R.id.fourthLine);
            txtFooter4 = (TextView) v.findViewById(R.id.fithLine);
            txtFooter5 = (TextView) v.findViewById(R.id.sixthLine);
            txtFooter6 = (TextView) v.findViewById(R.id.seventhLine);

            Fire = (ImageView) v.findViewById(R.id.icon);

        }
    }

    public void add(int position, Pokemon item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Pokemon> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Pokemon currentPokemon = values.get(position);
        holder.txtHeader.setText(currentPokemon.getName());
        final Context finalContext = context;
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Info.class);
                intent.putExtra("rarity", currentPokemon.getRarity());
                context.startActivity(intent);
                                                }
                                            });
        holder.txtFooter1.setText(currentPokemon.getRarity());
        System.out.println(currentPokemon.getCivilization());
        if (currentPokemon.getCivilization().equals("Fire")){
            holder.Fire.setImageResource(R.mipmap.fire1);
        }if (currentPokemon.getCivilization().equals("Water")){
            holder.Fire.setImageResource(R.mipmap.wave);
        }if (currentPokemon.getCivilization().equals("Light")){
            holder.Fire.setImageResource(R.mipmap.light);
        }if (currentPokemon.getCivilization().equals("Darkness")){
            holder.Fire.setImageResource(R.mipmap.night);
        }if (currentPokemon.getCivilization().equals("Nature")){
            holder.Fire.setImageResource(R.mipmap.forest);
        }if (currentPokemon.getCivilization().equals("Special")){
            holder.Fire.setImageResource(R.mipmap.special);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
