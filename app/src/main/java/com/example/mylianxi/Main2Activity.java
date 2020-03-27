package com.example.mylianxi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        expandableListView=findViewById(R.id.listview);

        //初始化数据
        initData();
        //自定义适配器
       Madapder madapder = new Madapder();
        expandableListView.setAdapter(madapder);
    }

    class Madapder extends BaseExpandableListAdapter {
        public void initData() {
            ArrayList<String>  allList=new ArrayList<String>();
            allList.add("列表①");
            allList.add("列表②");
            allList.add("列表③");
            ArrayList<List<com.example.mylianxi.Person>> list=new ArrayList<>();
            List<com.example.mylianxi.Person> list1=new ArrayList<>();
            list1.add(new com.example.mylianxi.Person(" 虞姬"));
            list1.add(new com.example.mylianxi.Person(" 甄姬"));
            list1.add(new com.example.mylianxi.Person(" 阿狸"));
            list1.add(new com.example.mylianxi.Person(" 狐狸"));
            List<com.example.mylianxi.Person> list2=new ArrayList<>();
            list2.add(new com.example.mylianxi.Person(" 李白"));
            list2.add(new com.example.mylianxi.Person(" 項羽"));
            list2.add(new com.example.mylianxi.Person(" 荊軻"));
            list2.add(new com.example.mylianxi.Person(" 曹操"));
            List<com.example.mylianxi.Person> list3=new ArrayList<>();
            list3.add(new com.example.mylianxi.Person(" 公孙离"));
            list3.add(new com.example.mylianxi.Person(" 孙尚香"));
            list3.add(new com.example.mylianxi.Person(" 狄仁杰"));
            list3.add(new com.example.mylianxi.Person(" 蔡文姬"));
            list.add(list1);
            list.add(list2);
            list.add(list3);
        }
        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return allList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            return list.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return allList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return list.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }


        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            GroupView groupView;
            if(convertView==null){
                groupView=new GroupView();
                //获取一级列表的布局
                convertView=View.inflate(Main2Activity.this,R.layout.listfu, null);
                //复用控件
                groupView.name=(TextView) convertView.findViewById(R.id.one_name);
                //绑定
                convertView.setTag(groupView);
            }else {
                groupView = (GroupView) convertView.getTag();
            }
            //给控件设置值
            groupView.name.setText(allList.get(groupPosition));
            return convertView;
        }
        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolder Holder;
            if(convertView==null){
                Holder=new ViewHolder();
                //获取二级列表的布局
                convertView=View.inflate(MainActivity.this,R.layout.item_2, null);
                //复用控件
                Holder.text_name=(TextView) convertView.findViewById(R.id.tow_name);
                //绑定
                convertView.setTag(Holder);
            }else {
                Holder = (ViewHolder) convertView.getTag();
            }
            //给控件设置值
            Holder.text_name.setText(list.get(groupPosition).get(childPosition).getName());
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return true;
        }
    }
    class ViewHolder{
        TextView text_name;
    }
    class GroupView{
        TextView name;
    }
}
}
