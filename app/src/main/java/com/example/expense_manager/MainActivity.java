package com.example.expense_manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseManager db = new DatabaseManager(this);
        ListView lv = findViewById(R.id.list);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        int[] amount_id = {R.id.amount};
        int[] category_id = {R.id.category};
        int[] date_id = {R.id.date_tv};
        String[] amount_col = new String[] {"amount"};
        String[] category_col = new String[] {"category"};
        String[] date_col = new String[] {"date"};
        Cursor c = db.getIncome();

      /*  SimpleCursorAdapter amount_adapter = new SimpleCursorAdapter(
                this,R.layout.list_item,c,amount_col,amount_id,0);
        SimpleCursorAdapter category_adapter = new SimpleCursorAdapter(
                this,R.layout.list_item,c,category_col,category_id,0);
        SimpleCursorAdapter date_adapter = new SimpleCursorAdapter(
                this,R.layout.list_item,c,date_col,date_id,0);
        lv.setAdapter(amount_adapter);
        lv.setAdapter(category_adapter);
        lv.setAdapter(date_adapter);*/

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_income_btn:
        }
        return true;
    }
}