package xyz.yaroslav.scs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
    private List<TagItem> tagItems;

    public TagAdapter(List<TagItem> tagItems) {
        this.tagItems = tagItems;
    }

    @NonNull
    @Override
    public TagAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_tag, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagAdapter.ViewHolder holder, int position) {
        TagItem item = tagItems.get(position);

        holder.tagTitle.setText(item.getPayload());
        holder.tagTime.setText(convertTime(item.getsTime()));
    }

    @Override
    public int getItemCount() {
        return tagItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tagTitle, tagTime;

        ViewHolder(View view) {
            super(view);

            tagTitle = view.findViewById(R.id.tagItemTitle);
            tagTime = view.findViewById(R.id.tagItemTime);
        }
    }

    private String convertTime(String value) {
        if (value != null && !value.equals("")) {
            String template = "dd/MM/yyyy HH:mm:ss";
            DateFormat format = new SimpleDateFormat(template, Locale.GERMAN);
            long temp = Long.parseLong(value);
            Date date = new Date(temp);
            return format.format(date);
        } else {
            return "";
        }
    }
}
