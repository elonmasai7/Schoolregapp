package com.elon.registermanagement

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.icons.Icons
import androidx.compose.material3.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.elon.featherandroidtasks.ui.theme.FeatherAndroidTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box {
                FeatherAndroidTasksTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        RegisterForm()
                    }
                }
            }
        }
    }
}

@Composable
fun RegisterForm() {
    var studentName by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val density = LocalDensity.current.density

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Masai School Form",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Student Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Student Name")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            onImeActionPerformed = { _, _ ->
                // Handle the action, for example, move focus to the next field
            }
        )

        OutlinedTextField(
            value = grade,
            onValueChange = { grade = it },
            label = { Text_btn(text = "Grade") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            onImeActionPerformed = {
                // Handle the action, for example, submit the form
                submitForm(studentName, grade, context)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle the button click, for example, submit the form
                submitForm(studentName, grade, context)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

fun submitForm(studentName: String, grade: String, context: Context) {
    // Implement the logic to submit the form data
    // You can use the provided values (studentName and grade) to perform further actions.
    // For example, you can show a toast message or send the data to a server.

    Toast.makeText(
        context,
        "Student Name: $studentName\nGrade: $grade\nForm submitted!",
        Toast.LENGTH_SHORT
    ).show()
}
