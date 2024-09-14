package com.bolivar.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bolivar.myapplication.PokemonDetails;
import com.bolivar.myapplication.R;
import com.bolivar.myapplication.model.pokemon;

import java.util.List;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.MyViewHolder> {

    private List<pokemon> pokemonList;
    private Context context;

    public PokedexAdapter(Context context, List<pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pokemon_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        pokemon pokemon = pokemonList.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPokemon;
        TextView tvPokemon;
        ImageView ivPokemonType;
        TextView tvPokemonType;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivPokemon = itemView.findViewById(R.id.ivPokemon);
            tvPokemon = itemView.findViewById(R.id.tvPokemon);
            ivPokemonType = itemView.findViewById(R.id.ivPokemonType);
            tvPokemonType = itemView.findViewById(R.id.tvPokemonType);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        pokemon selectedPokemon = pokemonList.get(position);
                        Intent intent = new Intent(context, PokemonDetails.class);
                        intent.putExtra("pokemonId", selectedPokemon.getId());
                        context.startActivity(intent);
                    }
                }
            });
        }

        public void bind(pokemon pokemon) {
            ivPokemon.setImageResource(pokemon.getImageResId());
            ivPokemonType.setImageResource(pokemon.getPokemonType());
            tvPokemon.setText(pokemon.getName());
            tvPokemonType.setText(pokemon.getType());
        }
    }
}
