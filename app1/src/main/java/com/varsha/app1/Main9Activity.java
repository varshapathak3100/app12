package com.varsha.app1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main9Activity extends AppCompatActivity {

    private TextView flag1,flag2;
    private RadioButton radioButton4,radioButton5;
    String name,department,timeSlot,number;
    final Context context = this;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl(Constants.FIREBASE_URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton)findViewById(R.id.radioButton5);
        flag1 = (TextView) findViewById(R.id.flag1);
        flag2 = (TextView) findViewById(R.id.flag2);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        department = intent.getStringExtra("department");
        number = intent.getStringExtra("number");

    }


    protected void onStart() {
        super.onStart();

        ref.child(department).child(number).child("4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                radioButton4.setText(text);
                // System.out.print(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(department).child(number).child("5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                radioButton5.setText(text);
                System.out.print(text);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        ref.child(department).child(number).child("6").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                flag1.setText(text);
                // System.out.print(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
            ref.child(department).child(number).child("7").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String text = dataSnapshot.getValue(String.class);
                    flag2.setText(text);
                    // System.out.print(text);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        radioButton4.setOnClickListener(new View.OnClickListener() {

                                            @Override
                                            public void onClick(View v) {

                                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                                        context);


                                                // set title
                                                FirebaseAuth mUsername = FirebaseAuth.getInstance();

                                                if (radioButton4.getText().toString() != "Unavailable" && (mUsername.getCurrentUser().getEmail().equals(flag1.getText()))) {


                                                    alertDialogBuilder.setTitle("Appointment Delete Confirmation");

                                                    // set dialog message
                                                    alertDialogBuilder
                                                            .setMessage("Do you wish to Delete your appointment?")
                                                            .setCancelable(false)
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int id) {


                                                                    timeSlot = radioButton4.getText().toString();
                                                                    ref.child(department).child(number).child("1").setValue(timeSlot);
                                                                    ref.child(department).child(number).child("4").setValue("Unavailable");
                                                                    ref.child(department).child(number).child("6").setValue("empty");

                                                                    async caller = new async();
                                                                    caller.execute();
                                                                    //    textview28.setText("1");

                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int id) {

                                                                    dialog.cancel();
                                                                }
                                                            });

                                                    // create alert dialog
                                                    AlertDialog alertDialog = alertDialogBuilder.create();

                                                    // show it
                                                    alertDialog.show();
                                                    radioButton4.setChecked(false);

                                                } else {

                                                    alertDialogBuilder.setTitle("Appointment Status");

                                                    // set dialog message
                                                    alertDialogBuilder
                                                            .setMessage("No Appointment to delete");
                                                    AlertDialog alertDialog = alertDialogBuilder.create();
                                                    alertDialog.show();
                                                    radioButton4.setChecked(false);
                                                }
                                            }
                                        });
                radioButton5.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                context);


                        // set title
                        FirebaseAuth mUsername = FirebaseAuth.getInstance();

                        if (radioButton5.getText().toString() != "Unavailable" && (mUsername.getCurrentUser().getEmail().equals(flag2.getText()))) {


                            alertDialogBuilder.setTitle("Appointment Delete Confirmation");

                            // set dialog message
                            alertDialogBuilder
                                    .setMessage("Do you wish to Delete your appointment?")
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {


                                            timeSlot = radioButton5.getText().toString();
                                            ref.child(department).child(number).child("2").setValue(timeSlot);
                                            ref.child(department).child(number).child("5").setValue("Unavailable");
                                            ref.child(department).child(number).child("7").setValue("empty");
                                            async caller = new async();
                                            caller.execute();
                                            //    textview28.setText("1");

                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                            dialog.cancel();
                                        }
                                    });

                            // create alert dialog
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            // show it
                            alertDialog.show();
                            radioButton5.setChecked(false);

                        } else {

                            alertDialogBuilder.setTitle("Appointment Status");

                            // set dialog message
                            alertDialogBuilder
                                    .setMessage("No Appointment to delete");
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                            radioButton5.setChecked(false);
                        }

                    }
                });
            }

    class async extends AsyncTask<Void , Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
//            String recv[]=receiver[0];
            //System.out.println("receiver ="+ receiver[0]);
            FirebaseAuth mUsername = FirebaseAuth.getInstance();
            System.out.println(mUsername.getCurrentUser().getEmail());

            try {

                GMailSender sender = new GMailSender("spartaguidesjsu@gmail.com", "spartaguide123");
                sender.sendMail("Appointment Delete Confirmation with Professor\t" + name ,
                        "Dear Student, \n\n Your appointment is deleted for the Time Slot " + timeSlot + "\n\nThanks,\n\nSpartaGuide","spartaguidesjsu@gmail.com",mUsername.getCurrentUser().getEmail());
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }


            return null;
        }

        protected void onPostExecute(Boolean result) {
            Toast.makeText(Main9Activity.this, "Appointment Deleted", Toast.LENGTH_LONG).show();
        }

    }
}
