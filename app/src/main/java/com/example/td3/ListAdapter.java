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
    private List<Monster> values;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public void add(int position, Monster item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Monster> myDataset, Context context) {
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

        final Monster currentMonster = values.get(position);
        holder.txtHeader.setText(currentMonster.getName());
        holder.txtFooter1.setText(currentMonster.getRarity());

        if (currentMonster.getCivilization().equals("Fire")){
            holder.CivPic.setImageResource(R.mipmap.fire1);
        }if (currentMonster.getCivilization().equals("Water")){
            holder.CivPic.setImageResource(R.mipmap.wave);
        }if (currentMonster.getCivilization().equals("Light")){
            holder.CivPic.setImageResource(R.mipmap.light);
        }if (currentMonster.getCivilization().equals("Darkness")){
            holder.CivPic.setImageResource(R.mipmap.night);
        }if (currentMonster.getCivilization().equals("Nature")){
            holder.CivPic.setImageResource(R.mipmap.forest);
        }if (currentMonster.getCivilization().equals("Special")){
            holder.CivPic.setImageResource(R.mipmap.special);
        }

        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, Info.class);
            intent.putExtra("name", currentMonster.getName());
            intent.putExtra("set", currentMonster.getSet());
            intent.putExtra("id", currentMonster.getID());
            intent.putExtra("civilization", currentMonster.getCivilization());
            intent.putExtra("rarity", currentMonster.getRarity());
            intent.putExtra("type", currentMonster.getType());
            intent.putExtra("cost", currentMonster.getCost());
            intent.putExtra("text", currentMonster.getText());
            intent.putExtra("flavor", currentMonster.getFlavor());
            intent.putExtra("illustrator", currentMonster.getIllustrator());
            intent.putExtra("race", currentMonster.getRace());
            intent.putExtra("power", currentMonster.getPower());
            intent.putExtra("picture", currentMonster.getpicture());
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
