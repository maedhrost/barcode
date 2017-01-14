package com.example.my_cse476_project;

import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
	private Context context;
	private List<String> mylist;
	private HashMap<String,List<String>> listDataChild;
	
	public ExpandableListAdapter (Context context, List<String> listDataHeader,HashMap<String, List<String>> listChildData) {
		this.context = context;
		this.listDataChild = listChildData;
		this.mylist = listDataHeader;
	}
	 @Override
	    public Object getChild(int groupPosition, int childPosititon) {
	        return this.listDataChild.get(this.mylist.get(groupPosition))
	                .get(childPosititon);
	    }

	    @Override
	    public long getChildId(int groupPosition, int childPosition) {
	        return childPosition;
	    }

	    @Override
	    public View getChildView(int groupPosition, final int childPosition,
	                             boolean isLastChild, View convertView, ViewGroup parent) {

	        final String childText = (String) getChild(groupPosition, childPosition);

	        if (convertView == null) {
	            LayoutInflater infalInflater = (LayoutInflater) this.context
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = infalInflater.inflate(R.layout.list_item, null);
	        }

	        TextView txtListChild = (TextView) convertView
	                .findViewById(R.id.lblListItem);

	        txtListChild.setText(childText);
	        return convertView;
	    }

	    @Override
	    public int getChildrenCount(int groupPosition) {
	        return this.listDataChild.get(this.mylist.get(groupPosition))
	                .size();
	    }

	    @Override
	    public Object getGroup(int groupPosition) {
	        return this.mylist.get(groupPosition);
	    }

	    @Override
	    public int getGroupCount() {
	        return this.mylist.size();
	    }

	    @Override
	    public long getGroupId(int groupPosition) {
	        return groupPosition;
	    }

	    @Override
	    public View getGroupView(int groupPosition, boolean isExpanded,
	                             View convertView, ViewGroup parent) {
	        String headerTitle = (String) getGroup(groupPosition);
	        if (convertView == null) {
	            LayoutInflater infalInflater = (LayoutInflater) this.context
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = infalInflater.inflate(R.layout.list_group, null);
	        }

	        TextView lblListHeader = (TextView) convertView
	                .findViewById(R.id.lblListHeader);
	        lblListHeader.setTypeface(null, Typeface.BOLD);
	        lblListHeader.setText(headerTitle);

	        return convertView;
	    }

	    @Override
	    public boolean hasStableIds() {
	        return false;
	    }

	    @Override
	    public boolean isChildSelectable(int groupPosition, int childPosition) {
	        return true;
	    }
	
}
