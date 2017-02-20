package com.varsha.app1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//
//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.ValueEventListener;


public class Main7Activity extends AppCompatActivity {

    private TextView mTextViewDetail;
    private TextView mtextviewname, textView_query,textView_query2;
    String Professor, Department;
    private EditText editText_query;
    final Context context = this;
    String number;

//    Firebase ref = new Firebase("https://checkdb-12940.firebaseio.com/");
//    Firebase mref;
//    Firebase mref_1;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl(Constants.FIREBASE_URL);
    String query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        mTextViewDetail = (TextView) findViewById(R.id.mTextViewDetail);
        mtextviewname = (TextView) findViewById(R.id.mtextviewname);
        textView_query = (TextView) findViewById(R.id.textView_query);
        textView_query2 = (TextView) findViewById(R.id.textView_query2);
        editText_query = (EditText) findViewById(R.id.editText_query);

        Intent intent = getIntent();

        Professor = intent.getStringExtra("name");
        Department = intent.getStringExtra("department");
        number = intent.getStringExtra("number");

        mtextviewname.setText(Professor);
        //    System.out.println("oyeeeeeeeeeeeeeee" + Department);
    }

    protected void onStart() {
        super.onStart();
        //  mRef = new Firebase("https://sample1-3ef67.firebaseio.com/");
        //  Firebase ch = mRef.child("1");

        //Firebase.setAndroidContext(this);
//        mref_1 = ref.child(Professor);
//
//        mref = mref_1.child("3");



        ref.child(Department).child(number).child("3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mTextViewDetail.setMovementMethod(new ScrollingMovementMethod());
                mTextViewDetail.setText(text);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        textView_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                //  Firebase.setAndroidContext(this);
                alertDialogBuilder.setTitle("Query Confirmation");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Confirm your query for Professor")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                query = editText_query.getText().toString();
                                async1 caller = new async1(query);
                                caller.execute();


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();

                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }


        });




        textView_query2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                //  Firebase.setAndroidContext(this);
                alertDialogBuilder.setTitle("Email app");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Navigate to email app")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                query = editText_query.getText().toString();
                                async caller = new async(query);
                                caller.execute();


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();

                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }


        });



    }

    class async extends AsyncTask<Void, Void, Boolean> {

        public async(String query) {
            query = editText_query.getText().toString();
        }
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

       @Override
        protected Boolean doInBackground(Void... params) {
           /**************************************************************************************************************/

//            FirebaseAuth mUsername = FirebaseAuth.getInstance();
//            System.out.println(mUsername.getCurrentUser().getEmail());
//
//            try {
//
//                GMailSender sender = new GMailSender("spartaguidesjsu@gmail.com", "spartaguide123");
//                sender.sendMail("Student Query regarding Research\t",
//                        query + "\n\nStudent Email ID: " + mUsername.getCurrentUser().getEmail(), "spartaguidesjsu@gmail.com", mUsername.getCurrentUser().getEmail());
//            } catch (Exception e) {
//                Log.e("SendMail", e.getMessage(), e);
//            }
//
//
//            return null;
//        }

/* Fill it with Data */
           emailIntent.setType("plain/text");
           emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"varsha.pathak@sjsu.edu"});
           emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
           emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, query);
                      return null;

       }
/* Send it off to the Activity-Chooser */
        /**************************************************************************************************************/
        protected void onPostExecute(Boolean result) {
          //  Toast.makeText(Main7Activity.this, "Query Sent", Toast.LENGTH_LONG).show();
            context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));

        }


    }

    class async1 extends AsyncTask<Void, Void, Boolean> {

        public async1(String query) {
            query = editText_query.getText().toString();
        }
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        @Override
        protected Boolean doInBackground(Void... params) {

            FirebaseAuth mUsername = FirebaseAuth.getInstance();
            System.out.println(mUsername.getCurrentUser().getEmail());

            try {

                GMailSender sender = new GMailSender("spartaguidesjsu@gmail.com", "spartaguide123");
                sender.sendMail("Student Query regarding Research\t",
                        query + "\n\nStudent Email ID: " + mUsername.getCurrentUser().getEmail(), "spartaguidesjsu@gmail.com", mUsername.getCurrentUser().getEmail());
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }


            return null;
        }

        protected void onPostExecute(Boolean result) {
              Toast.makeText(Main7Activity.this, "Query Sent", Toast.LENGTH_LONG).show();
        }

    }



}

