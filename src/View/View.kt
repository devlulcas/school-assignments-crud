package View

import java.time.LocalDateTime
import Controller.SchoolTaskController
import Model.SchoolTask

class View {
    private val schoolTaskController = SchoolTaskController()

    // Create
    fun createSchoolTask() {
        println("\n---------------------\n")
        println("Título")
        val title = readLine()!!.trim().uppercase()

        // The date when the activity was created
        val now = LocalDateTime.now()
        val creationDate = "${now.dayOfMonth}/${now.month}"

        // The deliver date
        val deliverDate = getDeliverDate()

        println("Observação")
        val observation = readLine()!!.trim().replaceFirstChar { first -> first.uppercase() }

        // Uses the data to create an SchoolTask object then keeps it in an MutableList
        schoolTaskController.addTask(title, creationDate, deliverDate, observation)
    }

    // Read
    fun seeSchoolTask() {
        println("\n---------------------\n")
        println("Atividades:")
        for (index in schoolTaskController.taskList.indices) {
            val task = schoolTaskController.taskList.elementAt(index)
            println(
                """
                    
                Atividade Nº$index 
                >>> ${task.title}
                >>> ${task.creationDate}
                >>> ${task.deliverDate}
                >>> ${task.observation}
                
            """.trimIndent()
            )
        }
    }

    fun editSchoolTask() {
        println("\n---------------------\n")

        showResumedTasks()

        println("Digite o número da atividade que deseja modificar:")
        val taskIndex = readLine()!!.trim().toInt()

        println("Novo título")
        val title = readLine()!!.trim().uppercase()

        // The deliver date
        val deliverDate = getDeliverDate()

        println("Nova observação")
        val observation = readLine()!!.trim().replaceFirstChar { first -> first.uppercase() }

        schoolTaskController.updateTask(taskIndex, title, deliverDate, observation)
    }

    fun deleteSchoolTask() {
        println("\n---------------------\n")

        showResumedTasks()

        println("Digite o número da atividade que deseja deletar:")
        val taskIndex = readLine()!!.trim().toInt()

        schoolTaskController.deleteTask(taskIndex)
    }

    private fun getDeliverDate(): String {
        println("Mês de entrega")
        val deliverMonth = readLine()!!.trim()

        println("Dia de entrega")
        val deliverDay = readLine()!!.trim()

        return "$deliverDay/$deliverMonth"
    }

    private fun showResumedTasks() {
        val allSchoolTasks: MutableList<SchoolTask> = schoolTaskController.taskList
        for (index in allSchoolTasks.indices) {
            val task = allSchoolTasks.elementAt(index)
            println(
                """
                Atividade Nº$index 
                >>> ${task.title}
            """.trimIndent()
            )
        }
    }
}