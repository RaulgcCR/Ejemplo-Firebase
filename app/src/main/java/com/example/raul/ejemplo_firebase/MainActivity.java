package com.example.raul.ejemplo_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference db = FirebaseDatabase.getInstance().getReference();

        Map<String, String> values = new HashMap<>();
        values.put("jedi", "Luke Skywalker");

        Log.i("HOLA","HOLA");

        db.push().setValue(values, new DatabaseReference.CompletionListener(){
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference){
                if(databaseError == null){
                    Log.i("Firebase","La info se guardo bien");
                }else{
                    Log.i("Firebase","Error al guardar la info");
                }
            }
        });
    }
}
