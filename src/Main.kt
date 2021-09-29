import View.View

fun main() {
    val view = View()
    mainLoop(view)
}

fun menu(): Int {
    println(
        """
            ---------------------
            1 - Criar atividade
            2 - Ver atividade
            3 - Editar atividade
            4 - Deletar atividade
            5 - Sair
            ---------------------
        """.trimIndent()
    )
    val selectedOption = readLine()!!
    return selectedOption.toInt()
}

fun callToAction(menuOption: Int, view: View) {
    when (menuOption) {
        1 -> view.createSchoolTask()
        2 -> view.seeSchoolTask()
        3 -> view.editSchoolTask()
        4 -> view.deleteSchoolTask()
    }
}

fun mainLoop(view: View) {
    while (true) {
        val selectedOption = menu()
        if (selectedOption == 5) break
        callToAction(selectedOption, view)
    }
}