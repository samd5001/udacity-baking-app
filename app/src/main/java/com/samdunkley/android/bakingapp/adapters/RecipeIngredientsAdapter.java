package com.samdunkley.android.bakingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samdunkley.android.bakingapp.R;
import com.samdunkley.android.bakingapp.model.RecipeIngredient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeIngredientsAdapter extends RecyclerView.Adapter<RecipeIngredientsAdapter.ViewHolder> {

    private final List<RecipeIngredient> ingredients;

    public RecipeIngredientsAdapter(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_ingredients_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        RecipeIngredient ingredient = ingredients.get(position);
        holder.quantityView.setText(holder.quantityView.getContext().getString(R.string.quantity_template, ingredient.getQuantity(), ingredient.getMeasure()));
        holder.nameView.setText(ingredient.getIngredient());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ingredient_quantity)
        TextView quantityView;
        @BindView(R.id.ingredient_name)
        TextView nameView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
