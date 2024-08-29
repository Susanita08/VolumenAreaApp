package com.curso.android.volumeareaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

// the view for each item and binding data to it
class MyCustomAdapter(context: Context, shapesArrayList: ArrayList<Shape>) :
    ArrayAdapter<Shape>(context, R.layout.grid_item_layout, shapesArrayList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var viewHolder : ViewHolder = ViewHolder()
        var view : android.view.View

        val shape : Shape? = getItem(position)

        if(convertView == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.grid_item_layout, parent, false)

            viewHolder.shapeName = view.findViewById(R.id.textView) as TextView
            viewHolder.shapeImage = view.findViewById(R.id.imageView) as ImageView
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.shapeName?.text = shape?.shapeName
        viewHolder.shapeImage?.setImageResource(shape?.shapeImg!!)

        return view
    }

    class ViewHolder {
        var shapeName: TextView? = null
        var shapeImage: ImageView? = null
    }
}