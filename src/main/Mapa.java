package main;

import java.io.File;
import java.util.Scanner;

public class Mapa {
	
	Dijkstra dijkstra;
	//Grafo grafo; // Calles con las esquinas que las rodean. //
	Integer cantEsquinas; // Esta es la cantidad de nodos del grafo. //
	String esquinaPartida;
	String esquinaDestino; // Esta es la esquina donde esta la escuela. //
	Integer cantCalles;  // Esta es la cantidad de aristas del grafo. //
	Calle[] calles;
	
	public Mapa(File archIn)
	{
		Scanner sc;
		Scanner sc2;
		try
		{
			sc = new Scanner(archIn);
			sc2 = new Scanner(archIn);
			for(int i = 0; i<2; i++) // Al terminar este for tengo al sc2 parado en las calles. //
			{
				sc2.nextLine();
			}
			cantEsquinas = sc.nextInt();
			esquinaPartida = sc.next();
			esquinaDestino = sc.next();
			cantCalles = sc.nextInt();
			Grafo grafo = new Grafo(cantEsquinas, cantCalles*2);
			grafo.cargarGrafoNodirigido(sc);
			dijkstra = new Dijkstra(esquinaPartida,grafo);
			calles = new Calle[cantCalles];
			String auxCalleInicio;
			String auxCalleFin;
			for(int i = 0; i<calles.length; i++)
			{
				auxCalleInicio = sc2.next();
				auxCalleFin = sc2.next();
				sc2.next();
				calles[i] = new Calle(auxCalleInicio, auxCalleFin);
			}
			try
			{
				sc.close();
				sc2.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	public void resolver()
	{
		String[] dev = dijkstra.resolver();
		Integer indexInicio;
		Integer indexFin;
		String lineaATrabajar = dev[Integer.parseInt(esquinaDestino)-1];
		indexInicio = lineaATrabajar.indexOf(":")+2;
		indexFin = lineaATrabajar.indexOf(".", indexInicio);
		String costo = lineaATrabajar.substring(indexInicio, indexFin);
		indexInicio = lineaATrabajar.indexOf(":", indexFin)+2;
		String[] callesTomadas = lineaATrabajar.substring(indexInicio).split(" ");
		Integer cantCallesQueCambianDeMano = 0;
		Calle auxParaCompararCalle;
		String callesQueCambian = "";
		for(int i = 0; i<callesTomadas.length-1; i++)
		{
			auxParaCompararCalle = new Calle(callesTomadas[i], callesTomadas[i+1]);
			for(int j = 0; j<cantCalles; j++)
			{
				if(!auxParaCompararCalle.sonIguales(calles[j]))
				{
					cantCallesQueCambianDeMano++;
					callesQueCambian = callesQueCambian+" "+i;
					break;
				}
			}
		}
		
		System.out.println(cantCallesQueCambianDeMano+"\n"+callesQueCambian);
	}

}
