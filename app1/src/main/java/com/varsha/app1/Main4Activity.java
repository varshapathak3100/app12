package com.varsha.app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main4Activity extends AppCompatActivity {

    private TextView textView1,mnumber;
    private static TextView mprof1,mprof2,mprof3,mprof4,mprof5,mprof6,mprof7,mprof8,mprof9,mprof10;
    private static TextView mprof11,mprof12,mprof13,mprof14,mprof15,mprof16,mprof17,mprof18,mprof19;

    /* Firebase Declarations*/
    // Firebase ref = new Firebase("https://checkdb-12940.firebaseio.com/");

    //  Firebase mref = ref.child("1");

    DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl(Constants.FIREBASE_URL);
    static String DepartmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView1 = (TextView) findViewById(R.id.textView1);
        mprof14 = (TextView) findViewById(R.id.mprof14);
        mprof17 = (TextView) findViewById(R.id.mprof17);
        mprof19 = (TextView) findViewById(R.id.mprof19);
        mprof1 = (TextView) findViewById(R.id.mprof1);
        mprof2 = (TextView) findViewById(R.id.mprof2);
        mprof3 = (TextView) findViewById(R.id.mprof3);
        mprof4 = (TextView) findViewById(R.id.mprof4);
        mprof5 = (TextView) findViewById(R.id.mprof5);
        mprof6 = (TextView) findViewById(R.id.mprof6);
        mprof7 = (TextView) findViewById(R.id.mprof7);
        mprof8 = (TextView) findViewById(R.id.mprof8);
        mprof9 = (TextView) findViewById(R.id.mprof9);
        mprof10 = (TextView) findViewById(R.id.mprof10);
        mprof11 = (TextView) findViewById(R.id.mprof11);
        mprof12 = (TextView) findViewById(R.id.mprof12);
        mprof13 = (TextView) findViewById(R.id.mprof13);
        mprof18 = (TextView) findViewById(R.id.mprof18);
        mprof15 = (TextView) findViewById(R.id.mprof15);
        mprof16 = (TextView) findViewById(R.id.mprof16);
        mnumber = (TextView) findViewById(R.id.mnumber);


        Intent intent = getIntent();

        DepartmentName = intent.getStringExtra("id");
        textView1.setText(DepartmentName);
    }

    protected void onStart() {
        super.onStart();
        ref.child(DepartmentName).child("1").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mprof1.setText(text);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("2").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text2 = dataSnapshot.getValue(String.class);
                mprof2.setText(text2);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("3").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text3 = dataSnapshot.getValue(String.class);
                mprof3.setText(text3);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("4").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text4 = dataSnapshot.getValue(String.class);
                mprof4.setText(text4);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("5").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text5 = dataSnapshot.getValue(String.class);
                mprof5.setText(text5);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("6").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text6 = dataSnapshot.getValue(String.class);
                mprof6.setText(text6);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("7").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text7 = dataSnapshot.getValue(String.class);
                mprof7.setText(text7);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("8").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text8 = dataSnapshot.getValue(String.class);
                mprof8.setText(text8);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("9").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text9 = dataSnapshot.getValue(String.class);
                mprof9.setText(text9);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("10").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text10 = dataSnapshot.getValue(String.class);
                mprof10.setText(text10);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("11").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text11 = dataSnapshot.getValue(String.class);
                mprof11.setText(text11);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("12").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text12 = dataSnapshot.getValue(String.class);
                mprof12.setText(text12);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("13").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text13 = dataSnapshot.getValue(String.class);
                mprof13.setText(text13);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("14").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text14 = dataSnapshot.getValue(String.class);
                mprof14.setText(text14);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("15").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text15 = dataSnapshot.getValue(String.class);
                mprof15.setText(text15);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("16").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text16 = dataSnapshot.getValue(String.class);
                mprof16.setText(text16);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("17").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text17 = dataSnapshot.getValue(String.class);
                mprof17.setText(text17);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("18").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text18 = dataSnapshot.getValue(String.class);
                mprof18.setText(text18);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(DepartmentName).child("19").child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text19 = dataSnapshot.getValue(String.class);
                mprof19.setText(text19);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
     //   System.out.println("oyeeeeeeeeeeeeeee  " + i );

    }

            public void onClick(View v) {
        Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
        switch (v.getId()) {
            case R.id.mprof1:
                mnumber.setText("1");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof1.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof2:
                mnumber.setText("2");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof2.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof3:
                mnumber.setText("3");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof3.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof4:
                mnumber.setText("4");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof4.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof5:
                mnumber.setText("5");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof5.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof6:
                mnumber.setText("6");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof6.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof7:
                mnumber.setText("7");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof7.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof8:
                mnumber.setText("8");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof8.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof9:
                mnumber.setText("9");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof9.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof10:
                mnumber.setText("10");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof10.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof11:
                mnumber.setText("11");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof11.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof12:
                mnumber.setText("12");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof12.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof13:
                mnumber.setText("13");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof13.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof14:
                mnumber.setText("14");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof14.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof15:
                mnumber.setText("15");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof15.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof16:
                mnumber.setText("16");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof16.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof17:
                mnumber.setText("17");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof17.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof18:
                mnumber.setText("18");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof18.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
            case R.id.mprof19:
                mnumber.setText("19");
                intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("name", mprof19.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department", textView1.getText().toString());
                break;
        }
        startActivity(intent);
    }
}
