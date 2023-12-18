package com.dicoding.todoapp.ui.list

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.add.AddTaskActivity
import org.junit.After
import org.junit.Before

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
@RunWith(AndroidJUnit4::class)
class TaskActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(TaskActivity::class.java)

    @Before
    fun initIntents(){
        Intents.init()
    }

    @Test
    fun testTapAddTaskButtonShouldDisplayAddTaskActivity() {
        onView(withId(R.id.fab)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(AddTaskActivity::class.java.name))
    }
}