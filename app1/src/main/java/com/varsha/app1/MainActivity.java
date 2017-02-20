package com.varsha.app1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private Button msubmit;
    private Button mLogin;

    private View mProgressView;
    private View mSignUpFormView;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private UserSignUpTask mSignupTask = null;
    //Firebase
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    //private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msubmit = (Button) findViewById(R.id.button);
        mLogin = (Button) findViewById(R.id.mLogin);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

        mAuth = FirebaseAuth.getInstance();
        mProgressView = findViewById(R.id.signup_progress);

        //Click Listener for button
        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSignUp();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(mAuthListener);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                async caller = new async();
//                caller.execute();
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                finish();

            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();
        /*
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }*/
    }

    private void attemptSignUp() {
        if (mSignupTask != null) {
            return;
        }
        // Reset errors.
        username.setError(null);
        password.setError(null);

        String email_entered = username.getText().toString();
        String password_entered = password.getText().toString();
        View focusView = null;
        boolean cancel = false;

        // Check for a valid email address.
        if (TextUtils.isEmpty(email_entered)) {
            username.setError("Email is Mandatory");
            focusView = username;
            cancel = true;
        } else if (!isEmailValid(email_entered)) {
            username.setError("Domain should be @sjsu.edu");
            focusView = username;
            cancel = true;
        }

        if (TextUtils.isEmpty(password_entered)) {
            password.setError("Password is mandatory");
            focusView = password;
            cancel = true;
        }
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mSignupTask = new UserSignUpTask(email_entered, password_entered);
            mSignupTask.execute((Void) null);
        }


    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@sjsu.edu");
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }

    public class UserSignUpTask extends AsyncTask<Void, Void, Boolean> {
        //private final String mEmail;
        private final String mEmail;
        private final String mPassword;
        boolean signUpFlag = false;
        boolean doneFlag = false;

        UserSignUpTask(String email, String password) {
            mEmail = email;

            mPassword = password;
        }

        public void updateSignUpFlag(boolean tflag) {
            signUpFlag = tflag;
        }

        public void updateDoneFlag(boolean dflag) {
            doneFlag = dflag;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            mAuth.createUserWithEmailAndPassword(mEmail, mPassword)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            System.out.println("createUserWithEmail:onComplete:" + task.isSuccessful());
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                System.out.println("Error Code: " + task.getException());
                                updateSignUpFlag(false);
                                /*System.out.println("Error : " + firebaseError.getMessage());
                                if (firebaseError.getCode() == -18) {
                                    editTextEmail.setError(getString(R.string.error_email_exists));
                                    editTextEmail.requestFocus();
                                } else {
                                    Toast.makeText(SignUpActivity.this, R.string.error_oops, Toast.LENGTH_LONG).show();
                                }*/
                                updateDoneFlag(true);
                            } else {
                                System.out.println("Successfully created user account with uid: " + mAuth.getCurrentUser().getUid());
                                Toast.makeText(MainActivity.this, "Account Created", Toast.LENGTH_LONG).show();
                                updateSignUpFlag(true);
                                updateDoneFlag(true);
                            }
                            // ...
                        }
                    });
            while (!doneFlag) {
            }
            if (signUpFlag) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            mSignupTask = null;
            showProgress(false);
            System.out.println("Async task complete");
            if (success) {
                System.out.println("Finishing the activity");
                startActivity(new Intent(MainActivity.this, Main2Activity.class));

                //finish();
            }
        }

    }

//    class async extends AsyncTask<Void, Void, Boolean> {
//
//        @Override
//        protected Boolean doInBackground(Void... params) {
////            mAuthListener = new FirebaseAuth.AuthStateListener() {
////                @Override
////                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
////                    FirebaseUser user = firebaseAuth.getCurrentUser();
////                    if (user != null) {
////                        // User is signed in
//            FirebaseAuth mUsername = FirebaseAuth.getInstance();
//            if (mUsername.getCurrentUser().getEmail() == null) {
////                startActivity(new Intent(MainActivity.this, Main2Activity.class));
////                finish();
//                System.out.println("onAuthStateChanged:signed_in");
//            }
//            else {
//                // User is signed out
//                System.out.println("onAuthStateChanged:signed_out");
//            }
//
//    return null;
//}
//
//    protected void onPostExecute(Boolean result) {
//        startActivity(new Intent(MainActivity.this, Main2Activity.class));
//    }
//
//}
}