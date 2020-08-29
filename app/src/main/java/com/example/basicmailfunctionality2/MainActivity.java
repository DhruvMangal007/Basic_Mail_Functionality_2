package com.example.basicmailfunctionality2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter arrayAdapter;
    ArrayList<String> mails;
    SwipeMenuListView mailsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mails = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mails);
        mailsListView = (SwipeMenuListView) findViewById(R.id.mailsListView);

        mails.add("Hello");
        mails.add("Thank You");
        mails.add("Welcome");
        mails.add("Good Bye");

        mailsListView.setAdapter(arrayAdapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // open item
                SwipeMenuItem archiveItem = new SwipeMenuItem(
                        getApplicationContext());
                archiveItem.setBackground(new ColorDrawable(Color.rgb(0x80, 0xB3,
                        0xff)));
                archiveItem.setWidth(170);
                archiveItem.setTitle("Archive");
                archiveItem.setTitleSize(18);
                archiveItem.setIcon(R.drawable.ic_archive);
                archiveItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(archiveItem);

                // delete item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                deleteItem.setWidth(170);
                deleteItem.setTitle("Delete");
                deleteItem.setTitleSize(18);
                deleteItem.setTitleColor(Color.WHITE);
                deleteItem.setIcon(R.drawable.ic_delete);
                menu.addMenuItem(deleteItem);
            }
        };

        mailsListView.setMenuCreator(creator);

        mailsListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Archive Pressed", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Delete Pressed", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        mailsListView.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);

    }
}
