import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.R

class ParkAdapter(private val parkList: List<String>) : RecyclerView.Adapter<ParkAdapter.ParkViewHolder>() {

    class ParkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.txtParkName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_park, parent, false)
        return ParkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        holder.textView.text = parkList[position]
    }

    override fun getItemCount(): Int = parkList.size
}
