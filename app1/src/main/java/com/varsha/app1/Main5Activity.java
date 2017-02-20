package com.varsha.app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    private TextView mtextviewname,mtextviewdepartment,mnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mtextviewname = (TextView)findViewById(R.id.mtextviewname);
        mtextviewdepartment = (TextView)findViewById(R.id.mtextviewdepartment);
        mnumber =(TextView)findViewById(R.id.mnumber);

        Intent intent = getIntent();

        String Professor = intent.getStringExtra("name");
        String Department = intent.getStringExtra("department");
        String Number = intent.getStringExtra("number");

        mtextviewname.setText(Professor);
        mtextviewdepartment.setText(Department);
        mnumber.setText(Number);

    }

    public void onClickappointment(View v) {
        Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
        intent.putExtra("name", mtextviewname.getText().toString());
        intent.putExtra("department", mtextviewdepartment.getText().toString());
        intent.putExtra("number", mnumber.getText().toString());
        Main5Activity.this.startActivity(intent);
    }

    public void onClickresearch(View v) {
        Intent intent = new Intent(Main5Activity.this, Main7Activity.class);
        intent.putExtra("name", mtextviewname.getText().toString());
        intent.putExtra("department", mtextviewdepartment.getText().toString());
        intent.putExtra("number", mnumber.getText().toString());
        Main5Activity.this.startActivity(intent);
    }
}
