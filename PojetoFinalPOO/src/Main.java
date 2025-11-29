public class Main {
    public static void main(String[] args) {
        // 3 disciplinas
        Disciplina d1 = new Disciplina("D012501", "Disciplina1", "2025.1");
        Disciplina d2 = new Disciplina("D022501", "Disciplina2", "2025.1");
        Disciplina d3 = new Disciplina("D032501", "Disciplina3", "2025.1");

        // 3 alunos
        Regular aluno1 = new Regular("Levi", "111.111.111-1", 20, "2501001");
        Regular aluno2 = new Regular("Beatriz", "222.222.222-2", 22, "2501002");
        Bolsista aluno3 = new Bolsista("Livia", "333.333.333-3", 25, "2501003");

        // 1 professor
        Professor professor = new Professor("Danilo", "999.999.999-9", 47, "Centro Tecnológico");

        // 2 visitantes
        Visitante v1 = new Visitante("Guilherme", "444.444.444-4", 25);
        Visitante v2 = new Visitante("João", "555.555.555-5", 24);

        // 3 turmas
        Turma t1 = new Turma("T001", d1, professor);
        Turma t2 = new Turma("T002", d2, professor);
        Turma t3 = new Turma("T003", d3, professor);

        // Usando os métodos de adicionar alunos
        // na tuma 1
        t1.adicionaAluno(aluno1);
        t1.adicionaAluno(aluno2);
        t1.adicionaAluno(aluno3);

        // na turma 2
        t2.adicionaAluno(aluno1);
        t2.adicionaAluno(aluno2);
        t2.adicionaAluno(aluno3);

        // na turma 3
        t3.adicionaAluno(aluno1);
        t3.adicionaAluno(aluno2);
        t3.adicionaAluno(aluno3);

        // Apresentando as Turma
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    } 
}
