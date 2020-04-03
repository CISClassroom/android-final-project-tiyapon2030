package th.ac.kku.cis.mobileapp.finalfood.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import th.ac.kku.cis.mobileapp.finalfood.Model.showfood
import th.ac.kku.cis.mobileapp.finalfood.R

class actfoodadapter (var mCtx: Context, var resource:Int, var item:List<showfood>)
    : ArrayAdapter<showfood>( mCtx , resource , item) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

            val view: View = layoutInflater.inflate(resource,null)
            var tv_nameAct : TextView = view.findViewById(R.id.food_act_name)
            var foodd: showfood = item[position]
            tv_nameAct.text = foodd.food
            return view
        }
    }