public abstract class Exportor {
	ParaCaCHE cache;
	private Exportor nextExportor;

	public Exportor(ParaCaCHE cache) {
		this.cache = cache;
	}

	public void setNext(Exportor nextExportor) {
		this.nextExportor = nextExportor;
	}

	public void execute() {
		// do something
	}

	public void doNext() {
		nextExportor.execute();
	}
}
