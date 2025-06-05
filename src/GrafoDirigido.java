import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, LinkedList<Arco<T>>>grafo;
	public GrafoDirigido() {
		this.mapeo=new HashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		this.grafo.put(verticeId,new linkedList<Arco<T>>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.grafo.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> arco=new Arco(verticeId1,verticeId2,etiqueta);
		this.grafo.get(verticeId1).add(arco);
		this.grafo.get(verticeId2).add(arco);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		/*LinkedList<Arco<T>>listArco=this.grafo.get(verticeId1);

		Iterator<Arco<T>>it1=listArco.iterator();
		*/
		LinkedList<Arco<T>>listArco2=this.grafo.get(verticeId2);
		Iterator<Arco<T>>it1=this.grafo.get(verticeId1).iterator();
		Iterator<Arco<T>>it2=listArco2.iterator();
		while (it1.hasNext()){
			Arco<T>arco=it1.next();
			if(arco.getVerticeOrigen()==verticeId1&&arco.getVerticeDestino()==verticeId2){
				it1.remove();
				break;
			}
		}
		while (it2.hasNext()){
			Arco<T>arco=it2.next();
			if(arco.getVerticeOrigen()==verticeId1&&arco.getVerticeDestino()==verticeId2){
				it2.remove();
				break;
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return this.grafo.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		boolean existe=false;
		if(this.grafo.containsKey(verticeId1)){
			Iterator<Arco<T>>it=this.grafo.get(verticeId1).iterator();
			while(!existe&&it.hasNext()){
				if(it.next().getVerticeDestino()==verticeId2)
					existe=true;
			}
		}
		return existe;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Iterator<Arco<T>>it1=this.grafo.get(verticeId1).iterator();
		while (it1.hasNext()){
			Arco<T>arco=it1.next();
			if(arco.getVerticeOrigen()==verticeId1&&arco.getVerticeDestino()==verticeId2){
				return arco;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return this.grafo.size();
	}

	@Override
	public int cantidadArcos() {
		int totalArcos = 0;
		Iterator<List<Arco>> it = grafo.values().iterator();
		while (it.hasNext()) {
			List<Arco> listaArcos = it.next();
			totalArcos += listaArcos.size();
		}
		totalArcos = totalArcos / 2;
		return totalArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
