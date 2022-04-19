package com.example.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextView text,text_2;

    TextInputLayout uname,pwd;

    ImageView img;

    Animation top_animation;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        // Define Hooks

        uname = findViewById(R.id.user_name);

        pwd = findViewById(R.id.password);

        img = findViewById(R.id.logo_img);

        text = findViewById(R.id.textView4);

        text_2 = findViewById(R.id.textView5);

        top_animation  = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        // Assign Animations To Elements

        img.setAnimation(top_animation);

        text.setAnimation(top_animation);

        text_2.setAnimation(top_animation);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               function_simple();
            }
        });


    }

    public void function_simple()
    {
        String name = uname.getEditText().getText().toString();

        String password = pwd.getEditText().getText().toString();

        if(name.equals("root")&&password.equals("root"))
        {
            Intent intent = new Intent(Login.this,MainActivity3.class);

            startActivity(intent);

            finish();
        }
        else
        {
            if(name.equals("root"))
            {
                uname.setError("Incorrect Password");
            }
            else if(pwd.equals("root"))
            {
                pwd.setError("Incorrect Username");
            }
            else if(!name.equals("root") || !pwd.equals("root"))
            {
                pwd.setError("Incorrect Password and Username");

                uname.setError("Incorrect Password and Password");
            }
        }
    }
}