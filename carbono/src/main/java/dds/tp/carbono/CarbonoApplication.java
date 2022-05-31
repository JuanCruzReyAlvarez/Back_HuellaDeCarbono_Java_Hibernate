package dds.tp.carbono;

import dds.tp.carbono.http.context.ServerWithDI;

public class CarbonoApplication {

	public static void main(String[] args) {
		new ServerWithDI().init();
	}
}
