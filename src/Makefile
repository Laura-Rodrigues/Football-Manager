JFLAGS = -d .
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  View/IView.java \
		  View/Menu.java \
		  Controller/IController.java \
		  Controller/Interpretador.java \
		  Model/Jogadores.java \
		  Model/LinhaIncorretaException.java \
		  Model/Defesas.java \
		  Model/Avancados.java \
		  Model/Guarda_Redes.java \
		  Model/Medios.java \
		  Model/Laterais.java \
		  Model/Equipa.java \
		  Model/JogoFeito.java \
		  Model/Jogo.java \
		  programa.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) View/*.class Model/*.class Controller/*.class *.class
	
run:
	java programa