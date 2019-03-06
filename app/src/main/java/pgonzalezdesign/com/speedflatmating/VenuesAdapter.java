package pgonzalezdesign.com.speedflatmating;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesAdapter.ViewHolder> {

    private List<Venue> venuesList;
    private Context context;

    public VenuesAdapter(List<Venue> venuesList, Context context) {

        this.venuesList = venuesList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venue_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Venue venue = venuesList.get(position);
        holder.name.setText(venue.getName());
        holder.location.setText(venue.getLocation());
        holder.date.setText(venue.getDate());
        holder.time.setText(venue.getTime());
        holder.cost.setText(venue.getCost());

        Picasso.with(context)
                .load(venue.getImageUrl())
                .into(holder.imageUrl);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return venuesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView name;
        public TextView location;
        public TextView date;
        public TextView time;
        public TextView cost;
        public ImageView imageUrl;
        public TextView html_url;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.venueName);
            location = (TextView) itemView.findViewById(R.id.location);
            date = (TextView) itemView.findViewById(R.id.eventDate);
            time = (TextView) itemView.findViewById(R.id.eventTime);
            cost = (TextView) itemView.findViewById(R.id.cost);
            imageUrl = (ImageView) itemView.findViewById(R.id.venueImage);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}

