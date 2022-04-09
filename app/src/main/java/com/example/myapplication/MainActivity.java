package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.adapter.RecyclerViewAdapter;
import com.example.myapplication.callback.OnActionCallback;
import com.example.myapplication.model.FirstModel;
import com.example.myapplication.model.SecondModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnActionCallback {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<FirstModel> listFirstModel;
    private List<SecondModel> listSecondModel1 , listSecondModel2 , listSecondModel3 , listSecondModel4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(listFirstModel,this);
        recyclerViewAdapter.setOnCallback(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initData() {
        listSecondModel1 = new ArrayList<>();
        listSecondModel1.add(new SecondModel("Second 1", "Fragment Second 1"));
        listSecondModel1.add(new SecondModel("Second 2", "Fragment Second 2"));
        listSecondModel1.add(new SecondModel("Second 3", "Fragment Second 3"));
        listSecondModel1.add(new SecondModel("Second 4", "Fragment Second 4"));
        listSecondModel1.add(new SecondModel("Second 5", "Fragment Second 5"));

        listSecondModel2 = new ArrayList<>();
        listSecondModel2.add(new SecondModel("Second 6", "Fragment Second 6"));
        listSecondModel2.add(new SecondModel("Second 7", "Fragment Second 7"));
        listSecondModel2.add(new SecondModel("Second 8", "Fragment Second 8"));
        listSecondModel2.add(new SecondModel("Second 9", "Fragment Second 9"));
        listSecondModel2.add(new SecondModel("Second 10", "Fragment Second 10"));

        listSecondModel4 = new ArrayList<>();
        listSecondModel4.add(new SecondModel("Second 1", "Fragment Second 1"));
        listSecondModel4.add(new SecondModel("Second 2", "Fragment Second 2"));
        listSecondModel4.add(new SecondModel("Second 3", "Fragment Second 3"));
        
        listSecondModel3 = new ArrayList<>();
        listSecondModel3.add(new SecondModel("Second 1", "Fragment Second 1"));
        listSecondModel3.add(new SecondModel("Second 2", "Fragment Second 2"));
        listSecondModel3.add(new SecondModel("Second 3", "Fragment Second 3"));
        listSecondModel3.add(new SecondModel("Second 4", "Fragment Second 4"));
        listSecondModel3.add(new SecondModel("Second 5", "Fragment Second 5"));
        listSecondModel3.add(new SecondModel("Second 4", "Fragment Second 4"));
        listSecondModel3.add(new SecondModel("Second 5", "Fragment Second 5"));

        listFirstModel = new ArrayList<>();
        listFirstModel.add(new FirstModel("Michael Carrick" , listSecondModel1));
        listFirstModel.add(new FirstModel("David Silva" , listSecondModel2));
        listFirstModel.add(new FirstModel("Toni Kroos" , listSecondModel3));
        listFirstModel.add(new FirstModel("Luke Shaw" , listSecondModel4));

    }


    @Override
    public void onCallback(ArrayList<SecondModel> list) {
        Toast.makeText(this, ""+list.size(), Toast.LENGTH_SHORT).show();
    }
}