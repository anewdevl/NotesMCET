package com.sdcproject.notesmcet

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class SubjectAdapter(private val context: Context, private val subjects: Array<Subject>) : BaseAdapter() {

    override fun getCount(): Int {
        return subjects.size
    }

    override fun getItem(position: Int): Any {
        return subjects[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val subject = getItem(position) as Subject

        val textView = TextView(context)
        textView.text = "${subject.name}\n" // Display both name and hyperlink

        return textView
    }
}


data class Subject(val name: String, val hyperlink: String)



