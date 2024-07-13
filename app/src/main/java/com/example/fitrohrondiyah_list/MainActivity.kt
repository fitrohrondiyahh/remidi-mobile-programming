package com.example.fitrohrondiyah_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitrohrondiyah_list.ui.theme.StudentListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentList(
                        students = getStudentList(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun getStudentList(): List<Student> {
        return listOf(
            Student("SSI202202858", "MUFTI FATMANINGRUM"),
            Student("SSI202202862", "PUTRI RAHAYU NINGSIH"),
            Student("SSI202202863", "RUCI SOFIAN PERMANA"),
            Student("SSI202202864", "SYARIFUL IQBAL NURIFAL"),
            Student("SSI202202951", "NUR KHASANAH"),
            Student("FITROH RONDIYAH", "SSI202202841"),
            Student("LEILA KANNA", "SSI202202843"),
            Student("WAHYU TRI HANAFI", " SSI202202840"),
            Student("ATIK NURHAENI", " SSI202203376"),
            Student("ERVINA MARESA", "SSI202203260"),
            Student("WARSIN", "SSI202203164")
        )
    }
}

@Composable
fun StudentList(students: List<Student>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(students) { student ->
            val color = when (students.indexOf(student) % 11) {
                0 -> Color.Red
                1 -> Color.Red
                2 -> Color.Red
                3 -> Color.Red
                4 -> Color.Red
                5 -> Color.Blue
                6 -> Color.Green
                7 -> Color.Green
                8 -> Color.Green
                9 -> Color.Green
                10 -> Color.Green
                else -> Color.Cyan
            }
            StudentItem(student, color)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun StudentItem(student: Student, color: Color, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = student.name, style = MaterialTheme.typography.headlineSmall, color = color)
        Text(text = student.id, style = MaterialTheme.typography.bodyMedium, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListPreview() {
    StudentListAppTheme {
        StudentList(
            students = listOf(
                Student("Sample Name", "Sample ID")
            )
        )
    }
}

data class Student(val name: String, val id: String)
