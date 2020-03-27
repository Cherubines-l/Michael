package com.example.mylianxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private String[] zhantai={"中医院站","联想大厦站"};
    private String[][] hao={{"1号","2号"},{"1号","2号"}};
    @Override
    public int getGroupCount() {

        return zhantai.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return hao[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return zhantai[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return hao[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            //获取一级列表的布局
            convertView=View.inflate(ExpandableListAdapter.this,R.layout.listfu, null);
            TextView tv_group = (TextView) convertView.findViewById(R.id.);
        tv_group.setText(groups[groupPosition]);
        return convertView;
    }

    //【重要】填充二级列表
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.item_child, null);
        }

        ImageView iv_child = (ImageView) convertView.findViewById(R.id.iv_child);
        TextView tv_child = (TextView) convertView.findViewById(R.id.tv_child);

        //iv_child.setImageResource(resId);
        tv_child.setText(childs[groupPosition][childPosition]);

        return convertView;
    }



    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
