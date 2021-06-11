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
		  Model/Exceptions/LinhaIncorretaException.java \
		  Model/Exceptions/InvalidExcepction.java \
		  Model/Defesas.java \
		  Model/Avancados.java \
		  Model/Guarda_Redes.java \
		  Model/Medios.java \
		  Model/Laterais.java \
		  Model/Equipa.java \
		  Parser/Loadable_Parser.java \
		  Parser/Parser.java \
		  Controller/SerializeData.java \
		  Model/Game/JogoFeito.java \
		  Model/Game/Jogo.java \
		  App.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	find . -name "*.class" -type f -delete
run:
	java App