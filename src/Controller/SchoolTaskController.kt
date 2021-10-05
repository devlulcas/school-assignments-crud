package Controller

import Model.SchoolTask

class SchoolTaskController(
    var taskList: MutableList<SchoolTask> = mutableListOf()
) {

    fun addTask(title: String, creationDate: String, deliverDate: String, observation: String) {
        val task = SchoolTask(title, creationDate, deliverDate, observation)
        taskList.add(task)
    }

    fun updateTask(taskIndex: Int, newTitle: String, newDeliverDate: String, newObservation: String) {
        val oldTask: SchoolTask = taskList.elementAt(taskIndex)
        oldTask.title = newTitle
        oldTask.deliverDate = newDeliverDate
        oldTask.observation = newObservation
    }

    fun deleteTask(taskIndex: Int) {
        val dyingTask = taskList[taskIndex]
        taskList.remove(dyingTask)
    }
}