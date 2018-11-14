package cl.cutiko.fragmentexperiment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragmentContainer, DynamicMainFragment.newInstance());
        transaction.disallowAddToBackStack();
        transaction.commitNowAllowingStateLoss();

        final ViewGroup viewGroup = findViewById(R.id.root);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewIterator.printStart(this.getClass().getName());
                ViewIterator.viewInfo(viewGroup, MainActivity.this);
                ViewIterator.traverseChilds(viewGroup);
            }
        });
    }
}
