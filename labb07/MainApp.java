//Nu kan man spela en ton genom att anropa channel.noteOn(ton, styrka) där ton är ett heltal som anger vilken ton man vill spela och styrka är ett heltal som anger hur starkt den ska spelas.
//Ettstrukna C (i mitten på ett vanligt piano) har nummer 60 och 100 är en rimlig styrka. När man har tröttnat på ljudet anropar man channel.noteOff(ton).


import javax.sound.midi.*;

class MainApp{
	
	MidiChannel channel;
	Synthesizer synthesizer;

	public static void main(String[] args) {

		Piano piano = new Piano();
/*
		try {
    		synthesizer = MidiSystem.getSynthesizer();
    		synthesizer.open();
    		channel = synthesizer.getChannels()[0];
			} catch(Exception e){System.out.println(e);}*/
		
	}

}