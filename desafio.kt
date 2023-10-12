// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

open class Usuario(var nome: String)

class Aluno(nome: String): Usuario(nome=nome){
    override fun toString() = nome
}

class Professor(nome: String): Usuario(nome=nome)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60){
    override fun toString() = "Aula: $nome - Duração: $duracao min."
}

data class Formacao(var nome: String, val nivel: Nivel, val conteudos: MutableList<ConteudoEducacional>, val professores: MutableList<Professor>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg alunos: Aluno) {
        for (aluno in alunos) inscritos.add(aluno)
    }
    
    fun listaDeMatriculados() {
        println("Matriculados: ${inscritos.sortedBy {it.nome}}")
    }
    
    fun ementa(){
        println("Ementa: $conteudos")
    }
}

fun main() {
    val aula1 = ConteudoEducacional("Introdução Prática" , 120)
    val aula2 = ConteudoEducacional("Estruturas de Controle de Fluxo")
    val aula3 = ConteudoEducacional("Coleções")
    val aula4 = ConteudoEducacional("Orientação a Objetos" , 120)
    
    val professores = mutableListOf(Professor("Elisa"), Professor("Renilda"))
    val bianca = Aluno("Bianca")
    
    val formacaoKotlin = Formacao("Kotlin", Nivel.INTERMEDIARIO, mutableListOf(aula1, aula2, aula3, aula4), professores)
    
    formacaoKotlin.matricular(bianca, Aluno("Pedro"), Aluno("Fabiano"), Aluno("Carolina"))
    
    formacaoKotlin.ementa()
    
    formacaoKotlin.listaDeMatriculados() 
    }