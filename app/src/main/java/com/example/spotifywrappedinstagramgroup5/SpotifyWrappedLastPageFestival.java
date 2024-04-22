package com.example.spotifywrappedinstagramgroup5;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spotifywrappedinstagramgroup5.databinding.SpotifyWrappedFestivalSlideBinding;

import java.util.List;

public class SpotifyWrappedLastPageFestival extends AppCompatActivity {
    SpotifyWrappedFestivalSlideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SpotifyWrappedFestivalSlideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve the data passed from the previous activity
        if (getIntent() != null) {
            String userId = getIntent().getStringExtra("userID");
            List<String> tracks = getIntent().getStringArrayListExtra("tracks");
            List<String> artists = getIntent().getStringArrayListExtra("artists");

            // Set the festival name
            binding.userFestivalName.setText(userId);

            // Set the favorite artists
            if (artists != null && !artists.isEmpty()) {
                binding.festArtist1.setText(artists.get(0));
                if (artists.size() > 1) {
                    binding.festArtist2.setText(artists.get(1));
                }
                if (artists.size() > 2) {
                    binding.festArtist3.setText(artists.get(2));
                }
            }

            // Set the favorite songs
            if (tracks != null && !tracks.isEmpty()) {
                binding.festSong1.setText(tracks.get(0));
                if (tracks.size() > 1) {
                    binding.festSong2.setText(tracks.get(1));
                }
                if (tracks.size() > 2) {
                    binding.festSong3.setText(tracks.get(2));
                }
            }
        }

        ImageView backButton = findViewById(R.id.escape);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // This will close the current activity and take you back to the previous one
            }
        });
    }
}