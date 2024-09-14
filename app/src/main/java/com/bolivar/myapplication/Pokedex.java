package com.bolivar.myapplication;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bolivar.myapplication.adapter.PokedexAdapter;
import com.bolivar.myapplication.model.pokemon;
import java.util.List;

public class Pokedex extends AppCompatActivity {
    RecyclerView recyclerView;
    PokedexAdapter PokedexAdapter;

    private List<pokemon> pokemonList = List.of(
            new pokemon(1,"Bulbasaur", R.drawable.balbausar, R.drawable.grasstype,"Grass Type","For some time after its birth, it uses the nutrients that are packed into the seed on its back in order to grow."),
            new pokemon(2,"Charmander", R.drawable.charmander,R.drawable.firetype, "Fire Type","The flame on its tail shows the strength of its life-force. If Charmander is weak, the flame also burns weakly."),
            new pokemon(3,"Squirtle", R.drawable.squirtle, R.drawable.watertype,"Water Type","After birth, its back swells and hardens into a shell. It sprays a potent foam from its mouth."),
            new pokemon(4,"Eevee", R.drawable.eevee, R.drawable.normaltype,"Normal Type","Its ability to evolve into many forms allows it to adapt smoothly and perfectly to any environment.")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        ImageView clickableImage = findViewById(R.id.imageView);
        clickableImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pokedex.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        PokedexAdapter = new PokedexAdapter(this, pokemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(PokedexAdapter);
    }
}
