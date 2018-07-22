package com.example.student.appbarexample;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.content_main, new OneFragment()).addToBackStack(null).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                manager.beginTransaction().replace(R.id.content_main, new SettingsFragment()).addToBackStack(null).commit();

//                toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
//                toolbar.getMenu().findItem(R.id.action_user).setIcon(R.drawable.ic_face);
                return true;
            case R.id.action_user:
                manager.beginTransaction().replace(R.id.content_main, new UserFragment()).addToBackStack(null).commit();

                //              item.setIcon(R.drawable.ic_face);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
