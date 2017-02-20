package com.varsha.app1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;


public class Main3Activity extends AppCompatActivity {

    private TextView textView3, textView4, textView5, textView6, textView7, textView8, textView9;
    private TextView textView10, textView11, textView12, textView13, textView14, textView15;
    private TextView textView16, textView17, textView18, textView19, textView20, textView21, textView22;
    private TextView textView23, textView24, textView25, textView26, textView27;

    Intent intent;

    private Button button_signout;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth auth;

    private FirebaseAuth FireAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        FireAuth = FirebaseAuth.getInstance();

        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        textView18 = (TextView) findViewById(R.id.textView18);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView21 = (TextView) findViewById(R.id.textView21);
        textView22 = (TextView) findViewById(R.id.textView22);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView24 = (TextView) findViewById(R.id.textView24);
        textView25 = (TextView) findViewById(R.id.textView25);
        textView26 = (TextView) findViewById(R.id.textView26);
        textView27 = (TextView) findViewById(R.id.textView27);
        button_signout = (Button) findViewById(R.id.button_signout);
    }

    public void onStart() {
        super.onStart();

        button_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                async caller = new async();
                caller.execute();
            }
        });


    }

    public void onclick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.textView3:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView3.getText().toString());
                break;
            case R.id.textView4:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView4.getText().toString());
                break;
            case R.id.textView5:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView5.getText().toString());
                break;
            case R.id.textView6:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView6.getText().toString());
                break;
            case R.id.textView7:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView7.getText().toString());
                break;
            case R.id.textView8:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView8.getText().toString());
                break;
            case R.id.textView9:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView9.getText().toString());
                break;
            case R.id.textView10:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView10.getText().toString());
                break;
            case R.id.textView11:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView11.getText().toString());
                break;
            case R.id.textView12:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView12.getText().toString());
                break;
            case R.id.textView13:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView13.getText().toString());
                break;
            case R.id.textView14:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView14.getText().toString());
                break;
            case R.id.textView15:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView15.getText().toString());
                break;
            case R.id.textView16:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView16.getText().toString());
                break;
            case R.id.textView17:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView17.getText().toString());
                break;
            case R.id.textView18:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView18.getText().toString());
                break;
            case R.id.textView19:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView19.getText().toString());
                break;
            case R.id.textView20:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView20.getText().toString());
                break;
            case R.id.textView21:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView21.getText().toString());
                break;
            case R.id.textView22:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView22.getText().toString());
                break;
            case R.id.textView23:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView23.getText().toString());
                break;
            case R.id.textView24:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView24.getText().toString());
                break;
            case R.id.textView25:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView25.getText().toString());
                break;
            case R.id.textView26:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView26.getText().toString());
                break;
            case R.id.textView27:
                intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("id", textView26.getText().toString());
                break;
        }
        startActivity(intent);
    }


    class async extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
//            String recv[]=receiver[0];
            //System.out.println("receiver ="+ receiver[0]);
            final FirebaseAuth mUsername = FirebaseAuth.getInstance();
//            mUsername.signOut();
            flag.flagster=1;

            mAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    String user = firebaseAuth.getCurrentUser().getEmail();
                    if (user == null) {
                        System.out.println("Create new user");
                        // User is signed in
//                        startActivity(new Intent(Main3Activity.this, Main2Activity.class));
//                        finish();

                       // System.out.println( "onAuthStateChanged:signed_in:" + user.getUid());
                    } else {
//                        // User is signed out
//                        FirebaseAuth mUsername = FirebaseAuth.getInstance();
//                        mUsername.createUserWithEmailAndPassword(null,null);
//                        System.out.println("onAuthStateChanged:signed_out");
                        mUsername.signOut();
//                        startActivity(new Intent(Main3Activity.this, Main2Activity.class));
//                        finish();

                    }
                }
            };
            return null;
        }

        protected void onPostExecute(Boolean result) {
            startActivity(new Intent(Main3Activity.this, MainActivity.class));
            finish();
        }

    }
}