package com.example.myusers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, pass, updateOld, updateNew, delete;
    myDbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (EditText) findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.password);
        updateOld = (EditText) findViewById(R.id.updateUserName);
        updateNew = (EditText) findViewById(R.id.newUserName);
        delete = (EditText) findViewById(R.id.deleteUser);

        helper = new myDbAdapter(this);
    }

    public void view(View view){
        String data = helper.getData();
        Message.message(this,data);
    }

    public void add(View view){
        String user = name.getText().toString();
        String pword = pass.getText().toString();
        if (user.isEmpty() || pword.isEmpty())
        {
            String tag = "Main Activity - add()";
            String message = "Either username or password not entered!";
            Log.i(tag, message);

            Message.message(getApplicationContext(), "Enter *both* Username and Password");
        }
        else
        {
            long insertSuccess = helper.insertData(user,pword);
            if (insertSuccess <= 0)
            {
                Message.message(getApplicationContext(),"Unsuccessful");
                name.setText("");
                pass.setText("");
            }else
            {
                Message.message(getApplicationContext(),"Added!");
                name.setText("");
                pass.setText("");
            }
        }
    }

    public void update(View view)
    {

        String uold = updateOld.getText().toString();
        String unew = updateNew.getText().toString();
        if (uold.isEmpty() || unew.isEmpty())
        {

            String tag = "Main Activity - update()";
            String message = "Missing Username!";
            Log.e(tag, message);

            Message.message(getApplicationContext(),"Enter Username");
        }else
        {
            int updateSuccess = helper.updateName(uold,unew);
            if (updateSuccess <= 0)
            {
                Message.message(getApplicationContext(),"Unsuccessful");
                updateOld.setText("");
                updateNew.setText("");
            }else
            {
                Message.message(getApplicationContext(), "Updated!");
                updateOld.setText("");
                updateNew.setText("");
            }
        }
    }

    public void delete(View view)
    {
        String uname = delete.getText().toString();
        if (uname.isEmpty())
        {

            String tag = "Main Activity - delete()";
            String message = "Missing username!";
            Log.w(tag,message);

            Message.message(getApplicationContext(), "Enter Username");
        }else
        {
            int deleteSuccess = helper.delete(uname);
            if (deleteSuccess <= 0)
            {
                Message.message(getApplicationContext(), "Unsuccessful");
                delete.setText("");
            }else
            {
                Message.message(getApplicationContext(), "Deleted!");
                delete.setText("");
            }
        }
    }
}










