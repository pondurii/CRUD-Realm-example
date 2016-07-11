package com.brillio.realmnosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Index;

public class MainActivity extends AppCompatActivity {


    Realm myRealm;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRealm = Realm.getDefaultInstance();

         tv = (TextView) findViewById(R.id.txtCount);

        Button b = (Button) findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myRealm.beginTransaction();
                University university = myRealm.createObject(University.class); // Create a new object
                int i = new Random().nextInt();
                university.id = i;
                university.name = "uni" + i;
                myRealm.commitTransaction();


                RealmResults<University> results1 =
                        myRealm.where(University.class).findAll();
                tv.setText(""+results1.size());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
