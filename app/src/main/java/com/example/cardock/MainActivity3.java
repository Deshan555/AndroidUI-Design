package com.example.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class MainActivity3 extends AppCompatActivity
{
    TextInputLayout brand,model,register_no,mileage,capacity,fuel,transmission,number,price;

    Button button;

    TextView view;

    ArrayList<String> Car_Register = new ArrayList<>();

    String car_brand;

    String model_name;

    String register_number;

    String mileage_km;

    String capacity_cc;

    String fuel_type;

    String transmission_type;

    String mobile_no;

    String car_price;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        // hooks

        view = findViewById(R.id.textView8);

        brand = findViewById(R.id.car_brand);

        model = findViewById(R.id.model);

        register_no = findViewById(R.id.reg_No);

        mileage = findViewById(R.id.mileage);

        capacity = findViewById(R.id.capacity);

        fuel = findViewById(R.id.fuel);

        transmission = findViewById(R.id.transmission);

        number = findViewById(R.id.num);

        price = findViewById(R.id.price);

        button = findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Validation_fields(view);
            }
        });
    }

    public void Validation_fields(View view)
    {
        car_brand = brand.getEditText().getText().toString();

        model_name = model.getEditText().getText().toString();

        register_number = register_no.getEditText().getText().toString();

        mileage_km = mileage.getEditText().getText().toString();

        capacity_cc = capacity.getEditText().getText().toString();

        fuel_type = fuel.getEditText().getText().toString();

        transmission_type = transmission.getEditText().getText().toString();

        mobile_no = number.getEditText().getText().toString();

        car_price = price.getEditText().getText().toString();


        System.out.println(car_brand+" "+model_name+" "+register_number);


        if(!validation_Brand() | !Validation_Model_Name() | !Validation_reg_number() | !validation_mileage() | !validation_capacity() | !validation_price() |  !validation_mobile() | !validation_fuel() |  !validation_transmission())
        {
            return;
        }
        else
        {
            data_enter();
        }



    }

    private Boolean validation_Brand()
    {
        if(car_brand.isEmpty())
        {
            brand.setError("Field Cannot Be Empty");

            return false;
        }
        else
        {
            brand.setError(null);

            return true;
        }
    }


    private Boolean Validation_Model_Name()
    {
        if(model_name.matches("^[0-9A-Z]*$"))
        {
            model.setError(null);

            return true;
        }
        else
        {
            model.setError("Invalid Characters");

            return false;
        }

    }


    private Boolean Validation_reg_number()
    {
        if(register_number.isEmpty())
        {
            register_no.setError("Field Cannot Be Empty");

            return false;
        }
        else if(!register_number.matches("^[0-9A-Za-z]+$"))
        {
            register_no.setError("Invalid Characters");

            return false;
        }
        else
        {
            register_no.setError(null);

            return true;
        }
    }


    private Boolean validation_mileage()
    {
        if(mileage_km.isEmpty())
        {
            mileage.setError("Field Cannot Be Empty");

            return false;
        }
        else if(!mileage_km.matches("^[0-9]+$"))
        {
            mileage.setError("Mileage Value Must Be Numerical");

            return false;
        }
        else
        {
            mileage.setError(null);

            return true;
        }
    }


    private Boolean validation_capacity()
    {
        if(capacity_cc.isEmpty())
        {
            capacity.setError("Field Cannot Be Empty");

            return false;
        }
        else if(!capacity_cc.matches("^[0-9]*$"))
        {
            capacity.setError("Vehicle Capacity Value Must Be Numerical");

            return false;
        }
        else
        {
            capacity.setError(null);

            return true;
        }
    }


    private Boolean validation_price()
    {
        if(car_price.isEmpty())
        {
            price.setError("Field Cannot Be Empty");

            return false;
        }
        else if(!car_price.matches("^[0-9.]+$"))
        {
            price.setError("Price Must Be Numerical");

            return false;
        }
        else
        {
            price.setError(null);

            return true;
        }
    }


    private Boolean validation_mobile()
    {
        if(mobile_no.isEmpty())
        {
            number.setError("Field Cannot Be Empty");

            return false;
        }
        else if((!Pattern.matches("^[0-9]*$",mobile_no))&&(mobile_no.length() == 10))
        {
            number.setError("Invalid Mobile Number");

            return false;
        }
        else
        {
            number.setError(null);

            return true;
        }
    }


    private Boolean validation_fuel()
    {
        if(fuel_type.isEmpty())
        {
            fuel.setError("Field Cannot Be Empty");

            return false;
        }
        else if(!fuel_type.matches("^[A-Za-z]+$"))
        {
            fuel.setError("Invalid Characters");

            return false;
        }
        else
        {
            fuel.setError(null);

            return true;
        }
    }


    private Boolean validation_transmission()
    {
        if(transmission_type.isEmpty())
        {
            transmission.setError("Field Cannot Be Empty");

            return false;
        }
        else if(!transmission_type.matches("^[A-Za-z]+$"))
        {
            transmission.setError("Invalid Characters");

            return false;
        }
        else
        {
            transmission.setError(null);

            return true;
        }
    }


    public void data_enter()
    {
        Car_Register.add(car_brand);

        Car_Register.add(model_name);

        Car_Register.add(register_number);

        Car_Register.add(mileage_km);

        Car_Register.add(capacity_cc);

        Car_Register.add(fuel_type);

        Car_Register.add(transmission_type);

        Car_Register.add(mobile_no);

        Car_Register.add(car_price);

        Intent intent = null;

        intent = new Intent(MainActivity3.this, allDone.class);

        startActivity(intent);

        finish();
    }


}