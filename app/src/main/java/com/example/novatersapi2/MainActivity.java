package com.example.novatersapi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
implements NetworkingService.NetworkingListener, PrintsAdapter.PrintsClickListener{

    RecyclerView printList;
    PrintsAdapter adapter;
    ArrayList<Print> list = new ArrayList<>(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApp) getApplication()).networkingService.listener =this;
        printList = findViewById(R.id.prints_list);
        adapter = new PrintsAdapter(list,this); //1st list, then context
        adapter.listener = this;
        printList.setAdapter(adapter);
        printList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.print_search_menu,menu);
        MenuItem searchViewmenue = menu.findItem(R.id.searchview);

        SearchView searchView = (SearchView) searchViewmenue.getActionView();

        //String cityQuery = searchView.getQuery().toString();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Novaters3D app",  "Query " + query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              if (newText.length() >= 3){
                  //search for a print
                  ((MyApp) getApplication()).networkingService.getAllPrints(newText);
              }
              //update the adapter with empty list
              else {
                  adapter.list = new ArrayList<>(0);
                  adapter.notifyDataSetChanged();
              }
              return false;
            }
        });


        return true;
    }

    @Override
    public void gettingJsonIsCompleted(String json) {
        //This json is a string ==> Json array and every element is a list
        //[
        //   {
        //      "url":"https://3dprint.nih.gov/discover/3dpx-000914",
        //      "field_model_category_tag":"Proteins, Macromolecules and Viruses",
        //      "field_model_keywords":[
        //         "peptide",
        //         "secondary structure",
        //         "ALPHA HELIX",
        //         "beta sheet",
        //         "protein folding",
        //         "HYDROGEN BONDING",
        //         "Ramachandran plot",
        //         "dihedral angles"
        //      ],
        //      "field_model_3d_model_file":[
        //         "https://3dprint.nih.gov/sites/default/files/models/3d_model_files/Peppytide_Amide_Unit.stl",
        //         "https://3dprint.nih.gov/sites/default/files/models/3d_model_files/Peppytide_Alpha_Carbon_Unit.stl",
        //         "https://3dprint.nih.gov/sites/default/files/models/3d_model_files/Peppytide_Methyl_Group_Unit.stl",
        //         "https://3dprint.nih.gov/sites/default/files/models/3d_model_files/Peppytide_Helix_Template.stl"
        //      ],...
        // For RecyclerView view I need ArrayList <Print>
        list = JsonService.fromJSONToList(json); //converts from json to arrayList
        adapter.list = list;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPrintClicked(Print selectedPrint) {
        Intent i = new Intent(this, PrintActivity.class);
        i.putExtra("Print", list.add(selectedPrint));
    }
}