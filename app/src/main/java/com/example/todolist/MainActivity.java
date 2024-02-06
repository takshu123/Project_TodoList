package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     private ArrayList<String> items;
     private ListView list;
      private Button button;
      private ArrayAdapter<String> itemsadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                additem(view);
            }


        });
      items=new ArrayList<>();
      itemsadapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
       list.setAdapter(itemsadapter);
    }

    private void additem(View view) {

        EditText input=findViewById(R.id.edit_text);
        String itemText=input.getText().toString();
        if(!(itemText.equals(""))){
            itemsadapter.add(itemText);
        }
        else{
            Toast.makeText(getApplicationContext(),"please enter text",Toast.LENGTH_SHORT).show();
        }
    }

}