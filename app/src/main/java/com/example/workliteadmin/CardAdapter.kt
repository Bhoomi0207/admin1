import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workliteadmin.addCardModel
import com.example.workliteadmin.R

class CardAdapter(dataList1: Context, private val dataList: List<addCardModel>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.findViewById(R.id.name)
        val address: TextView = itemView.findViewById(R.id.address)
        val phoneNumber: TextView = itemView.findViewById(R.id.phonenumber)
        val charges: TextView = itemView.findViewById(R.id.charges)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tasklayoutitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.taskTitle.text = item.name
        holder.address.text = item.address
        holder.phoneNumber.text = item.phonenumber
        holder.charges.text = item.charges
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
