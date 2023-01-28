package com.example.novatersapi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
    public class PrintsAdapter
            extends RecyclerView.Adapter<PrintsAdapter.PrintsViewHolder> {

        ArrayList<Print> list;
        Context context;

        interface PrintsClickListener{
            void onPrintClicked(Print selectedPrint);
        }

        PrintsClickListener listener;


        public PrintsAdapter(ArrayList<Print> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public PrintsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater myInflater = LayoutInflater.from(context);
            View view = myInflater.inflate(R.layout.print_row,parent,false);

            return new PrintsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PrintsViewHolder holder, int position) {
            holder.urlText.setText(list.get(position).url + "");
            holder.categoryText.setText(list.get(position).category);


        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        //inner class
        public class PrintsViewHolder extends RecyclerView.ViewHolder{
            TextView urlText;
            TextView categoryText;
            public PrintsViewHolder(@NonNull View itemView) {
                super(itemView);
                urlText = itemView.findViewById(R.id.url);
                categoryText = itemView.findViewById(R.id.category);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        listener.onPrintClicked(list.get(getAdapterPosition()));
                    }
                });

            }
        }
    }


//}
