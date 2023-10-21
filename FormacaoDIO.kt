enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, var concluido: Boolean = false)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome.")
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEachIndexed { index, conteudo ->
            val status = if (conteudo.concluido) "Concluído" else "Pendente"
            println("${index + 1}. ${conteudo.nome} (${conteudo.duracao} minutos) - $status")
        }
    }

    fun marcarConteudoConcluido(usuario: Usuario, indiceConteudo: Int) {
        if (indiceConteudo >= 0 && indiceConteudo < conteudos.size) {
            conteudos[indiceConteudo].concluido = true
            println("${usuario.nome} marcou o conteúdo '${conteudos[indiceConteudo].nome}' como concluído.")
        } else {
            println("Índice de conteúdo inválido.")
        }
    }
}

fun main() {
    // Criação de alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 180)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android com Kotlin", 240)

    // Criação de uma formação
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2, conteudo3))

    // Criação de usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Listar conteúdos da formação
    formacaoKotlin.listarConteudos()

    // Alice marca o conteúdo 1 como concluído
    formacaoKotlin.marcarConteudoConcluido(usuario1, 0)

    // Listar conteúdos da formação após a marcação
    formacaoKotlin.listarConteudos()

    // Bob marca o conteúdo 2 como concluído
    formacaoKotlin.marcarConteudoConcluido(usuario2, 1)

    // Listar conteúdos da formação após a marcação
    formacaoKotlin.listarConteudos()
}
