package com.devstudio.mlabsa.accom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.devstudio.mlabsa.accom.dto.AccommodationDTO;
import com.devstudio.mlabsa.accom.provider.AccommodationTable;

import java.util.List;

/**
 * Created by CodeTribe on 2015-04-12.
 */
public class AccommodationDTOAdapter extends BaseAdapter {

    Context aCtx;
    List<String> aList;
    List<AccommodationDTO> accommodationList;

    public AccommodationDTOAdapter(Context aCtx, List<AccommodationDTO> accommodationList) {
        this.aCtx = aCtx;
        this.accommodationList = accommodationList;
    }

    @Override
    public int getCount() {
        return accommodationList.size();
    }

    @Override
    public Object getItem(int position) {
        return accommodationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        holder h;
        //recycling the views

        if(convertView ==null){
            h = new holder();
            LayoutInflater inflater = (LayoutInflater) aCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
            h.fullname = (TextView) convertView.findViewById(R.id.fullname);
            convertView.setTag(h);
        }else{
            h = (holder) convertView.getTag();
        }
        String fullname = accommodationList.get(position).getFullName();
        h.fullname.setText(fullname);
        return convertView;
    }
    class holder{
        TextView fullname;
    }
}
