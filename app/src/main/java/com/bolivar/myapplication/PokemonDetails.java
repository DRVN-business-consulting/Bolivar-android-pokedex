package com.bolivar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bolivar.myapplication.model.pokemon;

import java.util.List;

public class PokemonDetails extends AppCompatActivity {

    private ImageView detailImageView;
    private TextView detailTextView;
    private TextView detailDescription;

    private List<pokemon> pokemonList = List.of(
            new pokemon(1,"Bulbasaur", R.drawable.balbausar, R.drawable.grasstype,"Grass Type","For some time after its birth, it uses the nutrients that are packed into the seed on its back in order to grow."),
            new pokemon(2,"Charmander", R.drawable.charmander,R.drawable.firetype, "Fire Type","The flame on its tail shows the strength of its life-force. If Charmander is weak, the flame also burns weakly."),
            new pokemon(3,"Squirtle", R.drawable.squirtle, R.drawable.watertype,"Water Type","After birth, its back swells and hardens into a shell. It sprays a potent foam from its mouth."),
            new pokemon(4,"Eevee", R.drawable.eevee, R.drawable.normaltype,"Normal Type","Its ability to evolve into many forms allows it to adapt smoothly and perfectly to any environment.")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        detailImageView = findViewById(R.id.detailImageView);
        detailTextView = findViewById(R.id.detailTextView);
        detailDescription = findViewById(R.id.detailDescription);

        ImageView clickableImage = findViewById(R.id.imageView);
        clickableImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PokemonDetails.this, Pokedex.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            int pokemonId = intent.getIntExtra("pokemonId", -1);

            // Find the Pokémon by
            pokemon selectedPokemon = null;
            for (pokemon p : pokemonList) {
                if (p.getId() == pokemonId) {
                    selectedPokemon = p;
                    break;
                }
            }

            if (selectedPokemon != null) {
                detailImageView.setImageResource(selectedPokemon.getImageResId());
                detailTextView.setText(selectedPokemon.getName());
                detailDescription.setText(selectedPokemon.getDescription());
            } else {
                detailImageView.setImageResource(R.drawable.ic_launcher_background);
                detailTextView.setText("Unknown Pokemon");
                detailDescription.setText("No Description Available");
            }
        }
    }
}
