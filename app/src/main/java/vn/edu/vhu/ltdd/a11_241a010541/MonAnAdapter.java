package vn.edu.vhu.ltdd.a11_241a010541;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonAnAdapter extends BaseAdapter {
    private final Context context;
    private final List<MonAn> danhSach;

    public MonAnAdapter(Context context, List<MonAn> danhSach) {
        this.context = context;
        this.danhSach = danhSach;
    }

    @Override
    public int getCount() {
        return danhSach.size();
    }

    @Override
    public Object getItem(int position) {
        return danhSach.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_mon_an, parent, false);
            holder = new ViewHolder();
            holder.imgHinh = convertView.findViewById(R.id.imgHinh);
            holder.tvTen = convertView.findViewById(R.id.tvTen);
            holder.tvMoTa = convertView.findViewById(R.id.tvMoTa);
            holder.tvGia = convertView.findViewById(R.id.tvGia);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MonAn monAn = danhSach.get(position);
        holder.imgHinh.setImageResource(monAn.getHinh());
        holder.tvTen.setText(monAn.getTen());
        holder.tvMoTa.setText(monAn.getMoTa());
        holder.tvGia.setText(MonAn.dinhDangGia(monAn.getGia()));

        return convertView;
    }

    private static class ViewHolder {
        ImageView imgHinh;
        TextView tvTen;
        TextView tvMoTa;
        TextView tvGia;
    }
}
