package com.example.runbbusroutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Routes extends AppCompatActivity {

    private ListView listView;
    private String[] routeNames;
    private String[] routeDetails;

    public static final String ROUTE_NAME = "route_name";
    public static final String ROUTE_DETAIL = "route_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routes_list);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        listView = findViewById(R.id.routes_list);
        routeNames = getResources().getStringArray(R.array.routes_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.route, routeNames);
        listView.setAdapter(adapter);

        InputStream is = getResources().openRawResource(R.raw.routes);
        Scanner sc = new Scanner(new InputStreamReader(is));
        routeDetails = new String[routeNames.length];

        for (int i = 0; i < routeNames.length; i++) {
            StringBuilder sb = new StringBuilder();
            String line = sc.nextLine();
            while (!line.startsWith("*")) {
                sb.append(line);
                sb.append("\n");
                line = sc.nextLine();
            }
            routeDetails[i] = sb.toString();
        }

        listView.setOnItemClickListener(
                (p,v,pos,id) -> showRoute(pos));

    }

    private void showRoute(int pos) {
        Bundle bundle = new Bundle();
        bundle.putString(ROUTE_NAME,routeNames[pos]);
        bundle.putString(ROUTE_DETAIL,routeDetails[pos]);
        Intent intent = new Intent(this, ShowRoute.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}