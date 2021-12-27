package com.example.magicmamanapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.magicmamanapplication.R

class ExpandableListViewAdapter internal constructor(private val context: Context, private val itemList : List<String>,private val subItemList: HashMap<String, List<String>>):
    BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return itemList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.subItemList[this.itemList[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
       return itemList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
      return this.subItemList[this.itemList[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
       return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
       return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        var itemTitle = getGroup(groupPosition) as String

        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.item_list,null)
        }
        val itemTv = convertView!!.findViewById<TextView>(R.id.item_tv)
        itemTv.setText(itemTitle)
        return convertView

    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        var subItemTitle = getChild(groupPosition, childPosition) as String

        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.sub_item_list,null)
        }
        val subItemTv = convertView!!.findViewById<TextView>(R.id.sub_item_tv)
        subItemTv.setText(subItemTitle)
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}