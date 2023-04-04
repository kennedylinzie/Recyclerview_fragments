import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_fragments.*

class FragmentAdapter(private val containerIdList: List<Int>) : RecyclerView.Adapter<FragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val containerId = containerIdList[position]
        val fragment = when (containerId) {
            R.id.oneFragment -> oneFragment()
            R.id.twoFragment -> twoFragment()
            R.id.threeFragment -> threeFragment()
            R.id.fourFragment -> fourFragment()
            else -> throw IllegalArgumentException("Invalid container ID")
        }
        holder.container.id = containerId
        val transaction = (holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.commit()
    }

    override fun getItemCount(): Int {
        return containerIdList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: ViewGroup = itemView.findViewById(R.id.fragment_container)
    }
}
