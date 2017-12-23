package main;

public class Calle {
	
	String esquinaInicio;
	String esquinaFin;
	
	public Calle(String esquinaInicio, String esquinaFin)
	{
		this.esquinaInicio = esquinaInicio;
		this.esquinaFin = esquinaFin;
	}
	
	public boolean sonIguales(Calle c)
	{
		if(esquinaInicio.equals(c.esquinaFin) && esquinaFin.equals(c.esquinaInicio))
		{
			return true;
		}
		return false;
	}

}
