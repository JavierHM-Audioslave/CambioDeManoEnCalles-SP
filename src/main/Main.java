package main;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		Mapa mapa = new Mapa(new File("in1.in"));
		mapa.resolver();
	}

}
