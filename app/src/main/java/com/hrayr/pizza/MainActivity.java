package com.hrayr.pizza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecycleAdapter recycleAdapter;
    List<Pizza> searchList;
    List<Pizza> initPizzaList;
    List<Pizza> pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addPizza();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pizza_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recycleAdapter = new RecycleAdapter(this, pizzas);
        recyclerView.setAdapter(recycleAdapter);
        SearchView search = ((android.support.v7.widget.SearchView)findViewById(R.id.m_search));
        if (search != null) {
            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (initPizzaList == null) {
                        initPizzaList = new ArrayList<>();
                        searchList = new ArrayList<>();
                        createPizzaList(initPizzaList);
                    }
                    if (TextUtils.isEmpty(newText)) {
                        restoreDefaultState();
                        return false;
                    }
                    changePizzaState(newText);
                    return false;
                }
            });
            search.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    restoreDefaultState();
                    return false;
                }
            });
        }
    }

    private void restoreDefaultState() {
        pizzas.clear();
        searchList.clear();
        pizzas.addAll(initPizzaList);
        recycleAdapter.notifyDataSetChanged();
    }

    private void changePizzaState(String newText) {
        searchList.clear();
        for (int i = 0; i < initPizzaList.size(); i++) {
            if (initPizzaList.get(i).getName().contains(newText))
                searchList.add(initPizzaList.get(i));
        }

        if (searchList.size() != 0) {
            pizzas.clear();
            pizzas.addAll(searchList);
            recycleAdapter.notifyDataSetChanged();
        }
    }


    private void addPizza() {
        pizzas = new ArrayList<>();
        createPizzaList(pizzas);
    }

    private void createPizzaList(List<Pizza> pizzas) {
        pizzas.add(new Pizza("Diabola", R.drawable.diablo, getString(R.string.diabola_description)));
        pizzas.add(new Pizza("Funghi", R.drawable.funghi, getString(R.string.funghi_description)));
        pizzas.add(new Pizza("Capricciosa", R.drawable.capricciosa, getString(R.string.capricciosa_description)));
        pizzas.add(new Pizza("Hawaii", R.drawable.hawaii, getString(R.string.hawaii_description)));
        pizzas.add(new Pizza("Aglio e olio", R.drawable.aglio_e_olio, getString(R.string.aglio_e_olio_description )));
        pizzas.add(new Pizza("Ai frutti di mare", R.drawable.ai_frutti_di_mare, getString(R.string.ai_frutti_di_mare_description)));
        pizzas.add(new Pizza("Al prosciutto", R.drawable.al_prosciutto, getString(R.string.al_prosciutto_description)));
        pizzas.add(new Pizza("Quattro stagioni", R.drawable.quattro_stagioni, getString(R.string.quattro_stagioni_description)));
    }
}
