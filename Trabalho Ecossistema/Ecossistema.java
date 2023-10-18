import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SerVivo {
    protected String nome;
    protected int idade;

    public SerVivo(String nome) {
        this.nome = nome;
        this.idade = 0;
    }

    public void envelhecer() {
        idade++;
    }

    public void mostrar() {
        System.out.println(nome + " é um ser vivo, que tem " + idade + " anos de idade.");
    }
}

class Animal extends SerVivo {
    protected String especie;
    protected List<SerVivo> presas;

    public Animal(String nome, String especie) {
        super(nome);
        this.especie = especie;
        this.presas = new ArrayList<>();
    }

    public void adicionarPresa(SerVivo presa) {
        presas.add(presa);
    }

    public void mover() {
        System.out.println(nome + " se movimentou.");
    }

    public void comer() {
        if (!presas.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(presas.size());
            SerVivo presa = presas.get(index);
            System.out.println(nome + " comeu " + presa.nome + " (" + presa.getClass().getSimpleName() + ").");
            presas.remove(presa);
        } else {
            System.out.println(nome + " não achou uma presa.");
        }
    }

    public void reprodução() {
        System.out.println(nome + " está em reprodução.");
    }
}

class Sapo extends Animal {
    public Sapo(String nome) {
        super(nome, "Sapo");
    }

    @Override
    public void mover() {
        System.out.println(nome + " pula alto como um sapo.");
    }
}

class Serpente extends Animal {
    public Serpente(String nome) {
        super(nome, "Serpente");
    }

    @Override
    public void mover() {
        System.out.println(nome + " rasteja lentamente.");
    }
}

class Planta extends SerVivo {
    protected String tipo;
    protected List<Animal> polinizadores;

    public Planta(String nome, String tipo) {
        super(nome);
        this.tipo = tipo;
        this.polinizadores = new ArrayList<>();
    }

    public void adicionarPolinizador(Animal animal) {
        polinizadores.add(animal);
    }

    public void crescer() {
        System.out.println(nome + " é uma planta " + tipo + " e se desenvolvendo.");
    }

    public void polinizar() {
        if (!polinizadores.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(polinizadores.size());
            Animal polinizador = polinizadores.get(index);
            System.out.println(polinizador.nome + " polinizou " + nome + " (" + nome + ").");
        } else {
            System.out.println(nome + " não conseguiu ser polinizada.");
        }
    }
}

class Mamifero extends Animal {
    public Mamifero(String nome, String especie) {
        super(nome, especie);
    }

    public void amamentar() {
        System.out.println(nome + " está amamentando seus filhotes.");
    }
}

class Ave extends Animal {
    public Ave(String nome, String especie) {
        super(nome, especie);
    }

    public void voar() {
        System.out.println(nome + " pode voar.");
    }
}

class Artropode extends Animal {
    public Artropode(String nome, String especie) {
        super(nome, especie);
    }

    public void exoesqueleto() {
        System.out.println(nome + " fez uma muda e trocou ser exoesqueleto.");
    }
}

class Rato extends Animal {
    public Rato(String nome) {
        super(nome, "Rato");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está se movendo.");
    }
}

class Arvore extends Planta {
    public Arvore(String nome, String tipo) {
        super(nome, tipo);
    }

    public void darFrutos() {
        System.out.println(nome + " deu frutos.");
    }
}

class Arbusto extends Planta {
    public Arbusto(String nome, String tipo) {
        super(nome, tipo);
    }

    public void florescer() {
        System.out.println(nome + " está florecendo.");
    }
}

class EcossistemaController {
    private List<SerVivo> seresVivos;

    public EcossistemaController() {
        seresVivos = new ArrayList<>();
    }

    public void adicionarSerVivo(SerVivo serVivo) {
        seresVivos.add(serVivo);
    }

    public void simularAno() {
        System.out.println("_____ Mais um Ano _____");
        for (SerVivo serVivo : seresVivos) {
            serVivo.envelhecer();
            serVivo.mostrar();
            if (serVivo instanceof Animal) {
                ((Animal) serVivo).mover();
                ((Animal) serVivo).comer();
                ((Animal) serVivo).reprodução();
            } else if (serVivo instanceof Planta) {
                ((Planta) serVivo).crescer();
                ((Planta) serVivo).polinizar();
            }
        }
    }
}

 class EcossistemaFloresta {
    public static void main(String[] args) {
        EcossistemaController ecossistema = new EcossistemaController();

        Arvore castanheira = new Arvore("Castanheira", "Que produz castanhas");
        Arvore cedro = new Arvore("Cedro", "Que tem uma madeira aromatica");
        Sapo sapo = new Sapo("Sapo");
        Serpente serpente = new Serpente("Serpente");
        Mamifero rato = new Mamifero("Rato", "Rato");
        Ave gaviao = new Ave("Gavião", "Gavião");
        Ave andorinha = new Ave("Andorinha Migrante", "Andorinha");
        Artropode gafanhoto = new Artropode("Gafanhoto Saltador","Gafanhoto");
        Artropode escorpiao = new Artropode("Escorpião Venonoso","Escorpião");
        Artropode besouroCarnivoro = new Artropode("Besouro Carnívoro Caçador","Besouro Carnívoro");
        Arbusto hibisco = new Arbusto("Hibisco", "Florido");
        Arbusto ipe = new Arbusto("Ipe", "Amarelo");
        
        castanheira.adicionarPolinizador(gaviao);
        castanheira.adicionarPolinizador(serpente);
        castanheira.adicionarPolinizador(andorinha);
        castanheira.adicionarPolinizador(sapo);
        castanheira.adicionarPolinizador(escorpiao);
        castanheira.adicionarPolinizador(besouroCarnivoro);
        castanheira.adicionarPolinizador(gafanhoto);
        castanheira.adicionarPolinizador(rato);
        cedro.adicionarPolinizador(gaviao);
        cedro.adicionarPolinizador(serpente);
        cedro.adicionarPolinizador(andorinha);
        cedro.adicionarPolinizador(sapo);
        cedro.adicionarPolinizador(escorpiao);
        cedro.adicionarPolinizador(besouroCarnivoro);
        cedro.adicionarPolinizador(gafanhoto);
        cedro.adicionarPolinizador(rato);
        
        gaviao.adicionarPresa(serpente);
        gaviao.adicionarPresa(sapo);
        gaviao.adicionarPresa(serpente);
        serpente.adicionarPresa(sapo);
        andorinha.adicionarPresa(besouroCarnivoro);
        sapo.adicionarPresa(gafanhoto);
        sapo.adicionarPresa(rato);
        escorpiao.adicionarPresa(besouroCarnivoro);
        escorpiao.adicionarPresa(gafanhoto);
        gafanhoto.adicionarPresa(hibisco);
        rato.adicionarPresa(ipe);

        ecossistema.adicionarSerVivo(castanheira);
        ecossistema.adicionarSerVivo(cedro);
        ecossistema.adicionarSerVivo(sapo);
        ecossistema.adicionarSerVivo(serpente);
        ecossistema.adicionarSerVivo(rato);
        ecossistema.adicionarSerVivo(gaviao);
        ecossistema.adicionarSerVivo(ipe);
        ecossistema.adicionarSerVivo(hibisco);
        ecossistema.adicionarSerVivo(gafanhoto);
        ecossistema.adicionarSerVivo(besouroCarnivoro);
        ecossistema.adicionarSerVivo(andorinha);

        for (int ano = 1; ano <= 5; ano++) {
            ecossistema.simularAno();
        }
    }
}