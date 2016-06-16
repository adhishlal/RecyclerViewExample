package lal.adhish.com.recycle;

/**
 * Created by Adhish on 03/11/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    Context context;


    public class PersonViewHolder extends RecyclerView.ViewHolder{


        CardView cv;
        TextView tvTitle;
        TextView tvSource;
        TextView tvDate;
        Button btnView;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            tvTitle=(TextView)itemView.findViewById(R.id.tvTitle);
            tvSource=(TextView)itemView.findViewById(R.id.tvSource);
            tvDate=(TextView)itemView.findViewById(R.id.tvDate);
            btnView=(Button) itemView.findViewById(R.id.btnView);

            context=itemView.getContext();
        }
    }


    List<FreePerson> persons;


    RVAdapter(List<FreePerson> persons){
        this.persons = persons;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }




    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mycard, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);


        return pvh;
    }


    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, final int i) {


        personViewHolder.tvTitle.setText(persons.get(i).myTitle);
        personViewHolder.tvDate.setText(persons.get(i).myDate);
        personViewHolder.tvSource.setText(persons.get(i).mySource);

        personViewHolder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MyWebView.class);
                intent.putExtra("link",persons.get(i).myLink);
                context.startActivity(intent);

            }
        });



    }


    @Override
    public int getItemCount() {
        return persons.size();
    }
}
