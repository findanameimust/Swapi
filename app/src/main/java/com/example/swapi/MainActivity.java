package com.example.swapi;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.PrecomputedText;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//    private PeopleResponse userList;
//    TextView fTextView;
//    List<Results> resultLists;
//   private static int FIRST_PAGE = 1;
////    List lame;
////    ListView listView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerView = findViewById(R.id.recyclerview);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
//
        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        final ItemAdapter adapter = new ItemAdapter(this);
//
        itemViewModel.itemPagedList.observe(this, adapter::submitList);
//
       recyclerView.setAdapter(adapter);
//    }

       // fTextView = findViewById(R.id.txt);
//       // listView=findViewById(R.id.list);
//
//
//        resultLists = new ArrayList<>();
  //      getPeople();
//
//
    }
//        public void getPeople() {
//            //Execute the Network request
//            Call<PeopleResponse> call = RetrofitClient.getInstance().getMyApi().getPeople(2);
//            //Execute the request in a background thread
//            call.enqueue(new Callback<PeopleResponse>() {
//                @Override
//                public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
//
//                    resultLists=response.body().getResults();
//                    for (int i = 0; i < resultLists.size(); i++){
//
//
//                        fTextView.append(resultLists.get(i).getName());
////                        resultLists = response.body().getResults().get(i).getBirthYear();
//                }
//                    Log.d("shit", "onResponse: parse" + resultLists);
//
//                }



                // List<Results> resultlist;
//                if(response.body().getNext() != null){
//
//                    for(int i=0;i<response.body().getResults().size();i++)
//                    resultLists =  response.body().getResults();
//
//                    FIRST_PAGE  +=1;


                //                //resultLists =  response.body().getResults();
//                 //userList =  response.body().getResults();

//                //fTextView.setText("Code: " + response.code());\
////                for (int i =0;i<resultLists.size();i++) {
////                    fTextView.append(resultLists.get(i).getName());
//////
////////                    lame.add(resultLists.get(i).getName());
//////
////                }
////                fTextView.setText("lame");
////                listView.setAdapter(ListAdapter.IGNORE_ITEM_VIEW_TYPE,lame);
//
//
//
//
////                adapter.notifyDataSetChanged();
////                adapter=new UsersAdapter(MainActivity.this, userList);
////
////                hList.setAdapter(adapter);
////                for(int i=0;i<userList.getResults().size();i++){
////                    fTextView.setText(userList.getResults().toString());
//
//
//
//               // Log.d("TAG", "onResponse: "+resultLists);
//
//
//
//
//
////
//            }
//                @Override
//                public void onFailure(Call<PeopleResponse> call, Throwable t) {
//                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//                    // fTextView.setText("Failure: " + t);
//                }
//            });
//        }


    }