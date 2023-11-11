package com.rockypatel.diplomazone.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rockypatel.diplomazone.PdfView;
import com.rockypatel.diplomazone.R;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    Context context;
    ArrayList<mModel> arrayList;

    public RecAdapter(Context context, ArrayList<mModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.model,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecAdapter.ViewHolder holder, int position) {
        mModel model=arrayList.get(position);
        holder.chapter.setText( model.getChapter());

        holder.itemView.setOnClickListener(v -> {

            try {
                Intent intent=new Intent(context, PdfView.class);
                intent.putExtra("pdflink",model.pdflink);
                intent.putExtra("chapter",model.chapter);
                context.startActivity(intent);
            }catch (Exception e){
                Toast.makeText(context, "error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        } else {
            return 0; // or handle it differently based on your use case
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView chapter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chapter=itemView.findViewById(R.id.txtchapter);
        }
    }
}
