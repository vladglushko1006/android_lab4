package com.vladglush.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Pattern;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmitButtonClick(View v) {
        String firstName = ((EditText)findViewById(R.id.editTextFName)).getText().toString().trim();
        String lastName = ((EditText)findViewById(R.id.editTextLName)).getText().toString().trim();
        String email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString().trim();
        String phone = ((EditText)findViewById(R.id.editTextPhone)).getText().toString().trim();
        String password = ((EditText)findViewById(R.id.editTextPassword)).getText().toString().trim();
        String confirmPassword = ((EditText)findViewById(R.id.editTextConfirmPassword)).getText().toString().trim();

        String errorsString = "";

        if (firstName.isEmpty())
            errorsString += "- first name is required\n";

        if (lastName.isEmpty())
            errorsString += "- last name is required\n";

        if (email.isEmpty())
            errorsString += "- email is required\n";
        else if (!EmailValidator.getInstance().isValid(email))
            errorsString += "- email is invalid\n";

        if (phone.isEmpty())
            errorsString += "- phone is required\n";
        else if (!Patterns.PHONE.matcher(phone).matches())
            errorsString += "- phone is invalid\n";

        if (password.isEmpty())
            errorsString += "- password is required\n";

        if (confirmPassword.isEmpty())
            errorsString += "- password confirmation is required\n";
        else if (!password.equals(confirmPassword))
            errorsString += "- passwords do not match\n";

        // remove the last '\n'
        if (!errorsString.isEmpty())
            errorsString = errorsString.substring(0, errorsString.length() - 1);

        ((TextView)findViewById(R.id.textViewErrors)).setText(errorsString);
    }
}
