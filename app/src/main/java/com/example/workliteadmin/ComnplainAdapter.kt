import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workliteadmin.addCardModel
import com.example.workliteadmin.R
import com.example.workliteadmin.addComplainModel

class ComnplainAdapter(dataList1: Context, private val dataList: List<addComplainModel>) : RecyclerView.Adapter<ComnplainAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.findViewById(R.id.name)
        val address: TextView = itemView.findViewById(R.id.address)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.complainlayoutitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.taskTitle.text = item.Name
        holder.address.text = item.complain

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
