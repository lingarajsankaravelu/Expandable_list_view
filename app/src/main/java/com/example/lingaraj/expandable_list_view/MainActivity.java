package com.example.lingaraj.expandable_list_view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity implements ExpandableListView.OnChildClickListener {
    public myExpandableadapter adapter;
    public ExpandableListView myexpandable;
    public List<String> parent;
    public List<String> child;
    HashMap<String,List<String>> bind_and_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myexpandable=(ExpandableListView) findViewById(R.id.theexpandables);
        bind_and_display=new HashMap<String,List<String>>();
        parent = new ArrayList<String>();
        child=new ArrayList<String>();

        parent= Arrays.asList(getResources().getStringArray(R.array.Parent_head));
        //Adding string array element to the parent list
        // you can also add item one by one like the following
        //parent.add("Animals")
        //parent.add("Birds")


        bind_and_display.put(parent.get(0),Arrays.asList(getResources().getStringArray(R.array.Child_animals)));

        // Here we bind child list data under the particular heading
        // you can also bind data like this
        //List<String> anim= new ArrayList<String>();
        // anim.add("Lion");
        //anim.add("Tiger");
        // bind_and_display(Parent.get(0),anim);
        //so what happened now is "lion, tiger" is placed under heading "Animals"


        bind_and_display.put(parent.get(1),Arrays.asList(getResources().getStringArray(R.array.child_birds)));

        adapter = new myExpandableadapter(this, parent, bind_and_display);
        // passing our current application context , parent data, and child data to the custom adapter class

        myexpandable.setAdapter(adapter);
        //setting the Expandable listview with our custom adapter, which populates the data inside the Expandable Listview.

        myexpandable.setOnChildClickListener(this);
       //your class should implemet ExpandableListView.OnChildClickListener





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    //this where we will handle which item is pressed
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        int gposition=groupPosition;
        int cposition=childPosition;

        Displayitemclicked(gposition,cposition);
        //passing the integer value of grouposition and childposition to the above method when an item is clicked



        return false;
    }

    private void Displayitemclicked(int gposition, int cposition) {
        //Display a message with which item is clicked.
        if(gposition==0)
        {
            switch (cposition)
            {
                case 0:
                    Toast.makeText(this,"Lion",Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(this,"Tiger",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        else  if(gposition==1)
        {
            switch (cposition)
            {
                case 0:
                    Toast.makeText(this,"Parrot",Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(this,"Dove",Toast.LENGTH_SHORT).show();
                    break;
            }
        }


    }
}
