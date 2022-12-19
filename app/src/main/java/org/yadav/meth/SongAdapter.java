package org.yadav.meth;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // define variables
    Context context;
    List<Song> songs;

    // constructor
    public SongAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the view from the viewholder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // bind the details of the song with the inflated view's attributes
        Song song = songs.get(position);
        SongViewHolder viewHolder = (SongViewHolder) holder;

        // set values to views
        viewHolder.titleHolder.setText(song.getTitle());
        viewHolder.durationHolder.setText(String.valueOf(song.getDuration()/(1000*60) + ":" + (song.getDuration()/1000)%60));

        // artwork
        Uri artworkUri = song.getArtworkUri();

        if (artworkUri != null){
            viewHolder.artworkHolder.setImageURI(artworkUri);

            if(viewHolder.artworkHolder.getDrawable() == null){
                viewHolder.artworkHolder.setImageResource(R.mipmap.treble);
            }
        }

        // on item click
        viewHolder.itemView.setOnClickListener(view -> Toast.makeText(context, song.getTitle(), Toast.LENGTH_SHORT).show());
    }

    // ViewHolder
    public static class SongViewHolder extends RecyclerView.ViewHolder{

        // Define some variables to connect the list item attributes
        ImageView artworkHolder;
        TextView titleHolder, durationHolder;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);

            // connect the list item attributes
            artworkHolder = itemView.findViewById(R.id.artworkView);
            titleHolder = itemView.findViewById(R.id.titleView);
            durationHolder = itemView.findViewById(R.id.durationView);
        }
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}
