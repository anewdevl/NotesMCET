package com.sdcproject.notesmcet

//noinspection SuspiciousImport
import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sdcproject.notesmcet.MainActivity3
import com.sdcproject.notesmcet.Subject
import com.sdcproject.notesmcet.SubjectAdapter
import com.sdcproject.notesmcet.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityMain2Binding
    private lateinit var filteredAdapter: SubjectAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val subj = arrayOf(
            Subject("Engineering Mathematics - 1 (M1)", "https://drive.google.com/drive/folders/13lN6jieLJUcs0A1GHCbFcakNUel8VrS8?usp=sharing"),
            Subject("Applied Physics", "https://drive.google.com/drive/folders/1L6evUca3yg4h3LYEpdjr9NiFrYj0ja8f?usp=sharing"),
            Subject("Engineering Physics", "https://drive.google.com/drive/folders/1V-nMJ4HCoLuM0zjP_O-68LgaeiUpeXlU?usp=drive_link"),
            Subject("Programming for Problem Solving (PPS)", "https://drive.google.com/drive/folders/1vA2MHCXONQj1DCuGWM8K1lUp37rQdMvs?usp=sharing"),
            Subject("Elements of Electrical and Electronics Engineering (EEEE/BEE)", "https://drive.google.com/drive/folders/1Kon0xpFLUT6zN0G9GzZQPdUQ_Pl-mO9H?usp=drive_link"),
            Subject("Environmental Science (ES)", "https://drive.google.com/drive/folders/1FacTnoRf898psu121uTTdcMT1UIHpoCH?usp=sharing"),
            Subject("Engineering Mathematics – II (M2)", "https://drive.google.com/drive/folders/1QUlLS4UqImEDtjs8l6RrE3c8TvnIUwlS?usp=sharing"),
            Subject("Chemistry", "https://drive.google.com/drive/folders/1u_o436kUHcxldhGh6pbIrY6qfXwYYjbu?usp=sharing"),
            Subject("English", "https://drive.google.com/drive/folders/1JUHYsGaSU90vQT67EmLan5CH9Wty9fq3?usp=sharing"),
            Subject("Data Structures (DS)", "https://drive.google.com/drive/folders/1FaTTnOsct_f4yJNcm3g3vv7aA7F8gxw2?usp=sharing"),
            Subject("Probability & Statistics", "https://drive.google.com/drive/folders/1W4f_CH5HHxwZ39HnUsChODJ3FxNJM1gy?usp=sharing"),
            Subject("Switching Theory and Logic Design", "https://drive.google.com/drive/folders/18lAm9LXjFKiQGxW6ohX84mMrdPsZuGJk?usp=sharing"),
            Subject("Database Management Systems", "https://drive.google.com/drive/folders/1OGZncQgMfr2FSz_X3WS3-d7rJ5fWrFpy?usp=sharing"),
            Subject("Discrete Mathematics", "https://drive.google.com/drive/folders/1J5W-yHW8qlTrJwxcVKh2hNSeKHjEw7Qu?usp=sharing"),
            Subject("Computer Organization and Microprocessor", "https://drive.google.com/drive/folders/1BI-q36K8RQ93B7Y3EgVs7IwBSpbhp4j7?usp=sharing"),
            Subject("Essence of Indian Traditional Knowledge", "https://drive.google.com/drive/folders/1WmujqMjNmE773H_AnPVWn08nOE_GPV9g?usp=sharing"),
            Subject("Optimization & Problem Solving Techniques", "https://drive.google.com/drive/folders/1SUnsqSxImzzhZr9JRmZhHRCwwJyPkaP-?usp=sharing"),
            Subject("Data Mining", "https://drive.google.com/drive/folders/1C0WlKEiRCr1NNAQXnNngJnsAsZZT_abq?usp=sharing"),
            Subject("Operating Systems", "https://drive.google.com/drive/folders/1qW4Y7PdBepReO8uU5C-Ms_-q-4KVvbHd?usp=sharing"),
            Subject("Computer Networks", "https://drive.google.com/drive/folders/18j_jEZbMKzaDXGY6z_CbGaiukLJqImjN?usp=sharing"),
            Subject("Human Values & Professional Ethics", "https://drive.google.com/drive/folders/1T2yp6qxcWK2lfaD0f87K1MJkZr_7c6Da?usp=sharing"),
            Subject("Artificial Intelligence", "https://drive.google.com/drive/folders/1bZm4EYeAq6dwaW8AGXlfPZz5toOP736f?usp=sharing"),
            Subject("Software Engineering", "https://drive.google.com/drive/folders/1kr0fMdhZE4FafdCOg8ne1Dj9_GINUMaR?usp=sharing"),
            Subject("Principle of Programming Language", "https://drive.google.com/drive/folders/17-7wwzqm0LM0eGubtPz-HIBtaxJfAr6p?usp=sharing"),
            Subject("Digital Image Processing", "https://drive.google.com/drive/folders/1Li1p-adcymJdG-XsyWTRkwlfU_wrQjI0?usp=sharing"),
            Subject("Indian Constitution", "https://drive" +
                    ".google.com/drive/folders/1AZNzLD2KdDhZe6Hb1OmaLwuremvaPiKP?usp=sharing"),
            // Add more subjects with their respective hyperlinks
        )


        filteredAdapter = SubjectAdapter(this,subj)

        binding.subjList.adapter = filteredAdapter



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                // Filter the data based on the search query
                val filteredSubjects = subj.filter { subject ->
                    subject.name.contains(newText ?: "", ignoreCase = true)
                }.toTypedArray()

                // Update the adapter with the filtered data
                val filteredAdapter = SubjectAdapter(this@MainActivity2, filteredSubjects)
                binding.subjList.adapter = filteredAdapter

                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })




        binding.subjList.setOnItemClickListener { parent, view, position, id ->
            val clickedSubject = (binding.subjList.adapter.getItem(position) as Subject)
            val intent = Intent(this, MainActivity3::class.java)

            intent.putExtra("name", clickedSubject.name)
            intent.putExtra("hyperlink", clickedSubject.hyperlink)
            startActivity(intent)
        }


    }

}
