package com.example.androiexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androiexam.adapter.EmployeeAdapter;
import com.example.androiexam.data.AppDataBase;
import com.example.androiexam.data.Employee;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText eName, eDestination, eSalary;
    Button btAdd, btUpdate, btDelete;
    AppDataBase db;
    RecyclerView List_item ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme);

        eName = findViewById(R.id.eName);
        eDestination = findViewById(R.id.eDestination);
        eSalary = findViewById(R.id.eSalary);
        List_item = findViewById(R.id.rcv_list);
        btAdd = findViewById(R.id.btnAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);

        db = AppDataBase.getAppDatabase(this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAdd();
            }
        });

        List<Employee> list = db.employeeDao().getAllEmployee();

        EmployeeAdapter adapter = new EmployeeAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        List_item.setLayoutManager(layoutManager);
        List_item.setAdapter(adapter);

    }

    private void onAdd(){
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
        Employee employee = new Employee();
        employee.Name = eName.getText().toString();
        employee.Destination = eDestination.getText().toString();
        employee.Salary = Integer.parseInt(eSalary.getText().toString());
        long id = db.employeeDao().insert_employee(employee);
        if (id>0){
            Toast.makeText(this,"Add Success",Toast.LENGTH_SHORT).show();
        }
    }

}