package com.unit.unit_SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.id_tv);

    }

    public void click(View view) {
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("smallData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username","wangdewei");
        editor.putString("age", "22");
        editor.commit();
        Toast.makeText(MainActivity.this, "sharedPreferences data is set ok and commit ok!!!", Toast.LENGTH_SHORT).show();

        SharedPreferences getsharedPreferences = MainActivity.this.getSharedPreferences("smallData",Context.MODE_PRIVATE);
        String localUsername = getsharedPreferences.getString("username", "");
        String localAge = getsharedPreferences.getString("age","");
        textView.setText(("localUsername is:"+localUsername+"; localAge is:"+localAge).toString());
        textView.setTextSize(20);
    }

}
