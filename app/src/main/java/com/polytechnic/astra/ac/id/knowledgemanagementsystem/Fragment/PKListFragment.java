    package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Fragment;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageButton;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.PKModel;
    import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;

    import java.util.List;

    public class PKListFragment extends RecyclerView.Adapter<PKListFragment.PKViewHolder> {

        private List<PKModel> PKModelList;
        private Context context;

        public PKListFragment(List<PKModel> PKModelList, Context context) {
            this.PKModelList = PKModelList;
            this.context = context;
        }


        public void setPKModelList(List<PKModel> PKModelList) {
            this.PKModelList = PKModelList;
            notifyDataSetChanged();
        }
        @NonNull
        @Override
        public PKViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_pk, parent, false);
            return new PKViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PKViewHolder holder, int position) {
            if (PKModelList == null) return; // Null check to avoid NullPointerException

            PKModel PKModel = PKModelList.get(position);
            holder.titleTextView.setText(PKModel.getNamaKelompokKeahlian());
            holder.descriptionTextView.setText(PKModel.getDeskripsi());
            // Set other fields as necessary

            // You can handle click events here if needed
            holder.iconImageView.setOnClickListener(v -> {
                // Handle icon click
            });

            holder.itemView.setOnClickListener(v -> {
                // Handle item click
            });
        }

        @Override
        public int getItemCount() {
            return PKModelList != null ? PKModelList.size() : 0; // Return 0 if list is null
        }

        public static class PKViewHolder extends RecyclerView.ViewHolder {

            TextView titleTextView;
            TextView descriptionTextView;
            ImageButton iconImageView;

            public PKViewHolder(@NonNull View itemView) {
                super(itemView);
                titleTextView = itemView.findViewById(R.id.titleTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
                iconImageView = itemView.findViewById(R.id.iconImageView);
            }

        }
    }
