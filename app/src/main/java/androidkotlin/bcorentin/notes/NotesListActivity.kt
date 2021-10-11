package androidkotlin.bcorentin.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotesListActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        notes = mutableListOf<Note>()
        notes.add(Note("Note 1", "Description note n°1"))
        notes.add(Note("Note 2", "Description note n°2"))
        notes.add(Note("Note 3", "Description note n°3"))

        adapter = NoteAdapter(notes, this)
        val recyclerView = findViewById<RecyclerView>(R.id.notes_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onClick(view: View) {
        if (view.tag !== null) {
            Log.i("NotesListActivity", "click sur une note de la liste")
        }
    }
}