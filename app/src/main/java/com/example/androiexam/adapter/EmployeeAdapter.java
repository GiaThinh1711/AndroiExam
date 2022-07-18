package com.example.androiexam.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiexam.R;
import com.example.androiexam.data.Employee;
import com.example.androiexam.data.ItemClickListener;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Employee> employeeList;

    public EmployeeAdapter(Activity activity, List<Employee> employeeList) {
        this.activity = activity;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.itemlist,parent,false);
        EmployeeHolder holder = new EmployeeHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder hoder = (EmployeeHolder) holder;
        Employee model = employeeList.get(position);
        hoder.tvName.setText(model.Name);
        hoder.tvDes.setText(model.Destination);
        hoder.tvSalary.setText(""+ model.Salary);
        hoder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ItemClickListener itemClickListener;

        TextView tvName;
        TextView tvDes;
        TextView tvSalary;


        public EmployeeHolder (@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.itemName);
            tvDes = itemView.findViewById(R.id.itemDestination);
            tvSalary = itemView.findViewById(R.id.itemSalary);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),true);
            return true;
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
    }
}

