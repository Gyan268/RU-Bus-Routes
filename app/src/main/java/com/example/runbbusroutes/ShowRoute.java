package com.example.runbbusroutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class ShowRoute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Enable the Up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get route name and detail from bundle
        Bundle bundle = getIntent().getExtras();
        String routeName = bundle.getString(Routes.ROUTE_NAME);
        String routeDetail = bundle.getString(Routes.ROUTE_DETAIL);

        // get the route name and detail view objects
        TextView routeNameView = findViewById(R.id.route_name);
        TextView routeDetailView = findViewById(R.id.route_detail);

        // set name and detail on the views
        routeNameView.setText(routeName);
        routeDetailView.setText(routeDetail);


    }
}