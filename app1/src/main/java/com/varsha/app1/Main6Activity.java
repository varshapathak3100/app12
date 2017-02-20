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

//import com.firebase.client.ValueEventListener;
//import com.firebase.client.DataSnapshot;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.Firebase;


public class Main6Activity extends AppCompatActivity {

    private String timeSlot;
    private RadioButton mradioFirst;
    private RadioButton mradioSecond;
    private RadioButton mradioDelete;
    String name,department;
    private TextView textview28,textview29,mnumber;
    String number;
    /* For Alert Dialog Box */
    final Context context = this;


 //   Firebase ref = new Firebase("https://checkdb-12940.firebaseio.com/");
//    Firebase ref2 = new Firebase("https://checkdb-12940.firebaseio.com/");
   // Firebase mref,mref2,mref_1;
    //   Firebase mref2 = ref2.child("2");

    DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl(Constants.FIREBASE_URL);
   // String flag_1,flag_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        //  Firebase.setAndroidContext(this);

        textview28 = (TextView) findViewById(R.id.textView28);
        textview29 = (TextView) findViewById(R.id.textView29);
        mradioFirst = (RadioButton) findViewById(R.id.radioButton);
        mradioSecond = (RadioButton) findViewById(R.id.radioButton2);
        mradioDelete = (RadioButton) findViewById(R.id.radioButton3);
        mnumber =(TextView)findViewById(R.id.mnumber);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        department = intent.getStringExtra("department");
        number = intent.getStringExtra("number");


        textview28.setText(name);
        textview29.setText(department);
        mnumber.setText(number);

    }


    protected void onStart() {
        super.onStart();
        //  mRef = new Firebase("https://sample1-3ef67.firebaseio.com/");
        //  Firebase ch = mRef.child("1");

        //Firebase.setAndroidContext(this);
        // DatabaseReference mref_1 = ref.child(name);

        //mref = mref_1.child("1");
        // mref2 = mref_1.child("2");

            ref.child(department).child(number).child("1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String text = dataSnapshot.getValue(String.class);
                    mradioFirst.setText(text);
                // System.out.print(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        ref.child(department).child(number).child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text2 = dataSnapshot.getValue(String.class);
                mradioSecond.setText(text2);
                System.out.print(text2);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
//        ref.child(department).child(name).child("4").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String flag_1 = dataSnapshot.getValue(String.class);
//                textview28.setText(flag_1);
//                //System.out.print(text);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//
//
//        });

//        ref.child(department).child(name).child("5").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String flag_2 = dataSnapshot.getValue(String.class);
//                textview29.setText(flag_2);
//               // System.out.print(text);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//
//
//        });


        // if (textview28.getText()!= "unavailable") {
        mradioFirst.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.print("omomomomom" + textview28.getText());

//                if (textview28.getText()!= "unavailable") {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                //  Firebase.setAndroidContext(this);

                // set title

                if (mradioFirst.getText().toString() != "Unavailable") {


                    alertDialogBuilder.setTitle("Appointment Confirmation");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Do you wish to confirm your appointment?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, close
                                    // current activity
//                                    Intent intent = new Intent(Main6Activity.this, Main8Activity.class);
//                                    intent.putExtra("id", "1");
//                                    ref.child("1").setValue("Not Available");
//                                    startActivity(intent);
                                    timeSlot = mradioFirst.getText().toString();
                                    ref.child(department).child(number).child("4").setValue(timeSlot);
                                    ref.child(department).child(number).child("1").setValue("Unavailable");
                                    FirebaseAuth mUsername = FirebaseAuth.getInstance();
                                    ref.child(department).child(number).child("6").setValue(mUsername.getCurrentUser().getEmail());
                                    async caller = new async();
                                    caller.execute();
                                    //    textview28.setText("1");

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    //textview28.setText("available");
                                    //  ref.child(department).child(name).child("4").setValue("available");
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                    mradioFirst.setChecked(false);

                } else {
//            mradioFirst.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                            context);
//
                    alertDialogBuilder.setTitle("Appointment Status");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Already booked");
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    mradioFirst.setChecked(false);
//                    ref.child(department).child(name).child("4").setValue("unavailable");
                }
//
//            });
            }
        });
        mradioSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (textview29.getText()!= "unavailable") {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                //  Firebase.setAndroidContext(this);
                if (mradioSecond.getText() != "Unavailable") {
                    // set title
                    alertDialogBuilder.setTitle("Appointment Confirmation");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Do you wish to confirm your appointment?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, close
                                    // current activity
//                                    Intent intent = new Intent(Main6Activity.this, Main8Activity.class);
//                                    intent.putExtra("id", "1");
//                                    ref.child("1").setValue("Not Available");
//                                    startActivity(intent);
                                    timeSlot = mradioSecond.getText().toString();
                                    ref.child(department).child(number).child("5").setValue(timeSlot);
                                    ref.child(department).child(number).child("2").setValue("Unavailable");
                                    FirebaseAuth mUsername = FirebaseAuth.getInstance();
                                    ref.child(department).child(number).child("7").setValue(mUsername.getCurrentUser().getEmail());
                                    async caller = new async();
                                    caller.execute();

                                    //  textview29.setText("1");
//                                mradioSecond.setText("Not Available");

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    //  textview29.setText("available");
                                    dialog.cancel();
                                    //      ref.child(department).child(name).child("5").setValue("available");
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                    mradioSecond.setChecked(false);
                }
//         m       });
//           }
                else {
//                mradioSecond.setOnClickListener(new View.OnClickListener() {
//
//                                                    @Override
//                                                    public void onClick(View v) {
//                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                            context);

                    alertDialogBuilder.setTitle("Appointment Status");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Already booked");
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    mradioSecond.setChecked(false);
//                                                        ref.child(department).child(name).child("5").setValue("unavailable");
//
                }
            }
        });
//            }
        System.out.print("oyeeeeeeeeeeeeeeeeeeee"+ number);


        mradioDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mnumber.setText(number);
                Intent intent = new Intent(Main6Activity.this, Main9Activity.class);
                intent.putExtra("name", textview28.getText().toString());
                intent.putExtra("number", mnumber.getText().toString());
                intent.putExtra("department",textview29.getText().toString());

                Main6Activity.this.startActivity(intent);
                mradioDelete.setChecked(false);

                }

        });
//            }

    }


//    }


//
//    public void onClick(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        //  Firebase.setAndroidContext(this);
//
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radioButton:
//                if (checked)
//                //mbuttonalert.setOnClickListener(new View.OnClickListener() {
//                // @Override
//                {
//                    //            public void onRadioButtonClicked(View view {
////                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
////                            context);
////                    //  Firebase.setAndroidContext(this);
////
////                    // set title
////                    alertDialogBuilder.setTitle("Appointment Confirmation");
////
////                    // set dialog message
////                    alertDialogBuilder
////                            .setMessage("Do you wish to confirm your appointment?")
////                            .setCancelable(false)
////                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
////                                public void onClick(DialogInterface dialog, int id) {
////                                    // if this button is clicked, close
////                                    // current activity
//////                                    Intent intent = new Intent(Main6Activity.this, Main8Activity.class);
//////                                    intent.putExtra("id", "1");
//////                                    ref.child("1").setValue("Not Available");
//////                                    startActivity(intent);
////                                    timeSlot = mradioFirst.getText().toString();
////                                    async caller = new async();
////                                    caller.execute();
////                                }
////                            })
////                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
////                                public void onClick(DialogInterface dialog, int id) {
////                                    // if this button is clicked, just close
////                                    // the dialog box and do nothing
////                                    dialog.cancel();
////                                }
////                            });
////
////                    // create alert dialog
////                    AlertDialog alertDialog = alertDialogBuilder.create();
////
////                    // show it
////                    alertDialog.show();
//
//                    // });
//                    break;
//                }
//            case R.id.radioButton2:
//                if (checked)
//                {
//                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                            context);
//                    //  Firebase.setAndroidContext(this);
//
//                    // set title
//                    alertDialogBuilder.setTitle("Appointment Confirmation");
//
//                    // set dialog message
//                    alertDialogBuilder
//                            .setMessage("Do you wish to confirm your appointment?")
//                            .setCancelable(false)
//                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//
//                                    timeSlot = mradioSecond.getText().toString();
//                                    async caller = new async();
//                                    caller.execute();
//                                }
//                            })
//                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                }
//                            });
//
//                    // create alert dialog
//                    AlertDialog alertDialog = alertDialogBuilder.create();
//
//                    // show it
//                    alertDialog.show();
//
//                    // });
//                    break;
//                }
//
//        }
//        mradioFirst.setChecked(false);
//        mradioSecond.setChecked(false);
//    }

    class async extends AsyncTask<Void , Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            FirebaseAuth mUsername = FirebaseAuth.getInstance();
            System.out.println(mUsername.getCurrentUser().getEmail());

            try {

                GMailSender sender = new GMailSender("spartaguidesjsu@gmail.com", "spartaguide123");
                sender.sendMail("Appointment Confirmation with Professor\t" + name ,
                        "Dear Student, \n\n Your appointment is confirmed for the Time Slot " + timeSlot + "\n\nThanks,\n\nSpartaGuide","spartaguidesjsu@gmail.com",mUsername.getCurrentUser().getEmail());
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }
            return null;
        }
        protected void onPostExecute(Boolean result) {
            Toast.makeText(Main6Activity.this, "Appointment Booked", Toast.LENGTH_LONG).show();
        }

    }

}
