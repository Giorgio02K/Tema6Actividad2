package com.jordichorro.tema6actividad2.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jordichorro.tema6actividad2.R

class SpinnerAdapter(private val context: Context, private val items: ArrayList<*>?) : android.widget.BaseAdapter() {

    override fun getCount(): Int {
        return items?.size ?: 0
    }

    override fun getItem(position: Int): Any? {
        return items?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.movements_activity, parent, false)

        // Bind the item data to the view elements
        val item = getItem(position) as Any? // Cast item to the appropriate type
        // ... Populate view elements with item data

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}

