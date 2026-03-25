package com.hfad.learncompose_02

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SurveyAnswerPreview() {
    SurveyAnswer(Answer("test", painterResource(R.drawable.ic_launcher_background), null))
}

@Composable
fun SurveyAnswer(answer: Answer, isSelected: Boolean) {
    Row {
        Image(answer.painter, answer.imageDescription)
        Text(answer.text)
        var selected = remember { mutableStateOf(isSelected) }
        RadioButton(isSelected, onClick = {
            selected = isSelected == true
        })
    }
}

@Composable
@Preview(showBackground = true)
fun SingleChoiceQuestionPreview() {
    SingleChoiceQuestion(
        listOf(
            Answer("test", painterResource(R.drawable.ic_launcher_background), null),
            Answer("test2", painterResource(R.drawable.ic_launcher_background), null),
            Answer("test3", painterResource(R.drawable.ic_launcher_background), null),
            Answer("test4", painterResource(R.drawable.ic_launcher_background), null)
        )
    )
}
// https://developer.android.com/courses/pathways/jetpack-compose-for-android-developers-1

@Composable
fun SingleChoiceQuestion(answers: List<Answer>) {
    var selectedAnswer: MutableState<Answer?> = remember { mutableStateOf(null)}
    LazyColumn {
        items(answers) { answer ->
            SurveyAnswer(answer, isSelected = (selectedAnswer.value == answer))
        }
    }
}


class Answer(val text: String, val painter: Painter, val imageDescription: String?)