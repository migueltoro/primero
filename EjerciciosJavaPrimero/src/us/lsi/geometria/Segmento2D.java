package us.lsi.geometria;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Segmento2D implements ObjetoGeometrico2D {

	public static Segmento2D of(Punto2D p1, Punto2D p2) {
		return new Segmento2D(p1, p2);
	}

	private Punto2D p1;
	private Punto2D p2;
	
	private Segmento2D(Punto2D p1, Punto2D p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public Punto2D getP1() {
		return p1;
	}

	public Punto2D getP2() {
		return p2;
	}
	
	public Vector2D vector() {
		return Vector2D.of(this.p1,this.p2);
	}
	
	public Double getLongitud(){
		return p1.getDistanciaA(p2);
	}
	
	@Override
	public Segmento2D rota(Punto2D p, Double angulo) {
		return Segmento2D.of(this.p1.rota(p,angulo), this.p2.rota(p,angulo));
	}

	@Override
	public Segmento2D traslada(Vector2D v) {
		return Segmento2D.of(this.p1.traslada(v), this.p2.traslada(v));
	}
	
	@Override
	public Segmento2D homotecia(Punto2D p, Double factor) {
		return Segmento2D.of(this.p1.homotecia(p,factor), this.p2.homotecia(p,factor));
	}
	
	@Override
	public Segmento2D proyectaSobre(Recta2D r) {
		return Segmento2D.of(this.p1.proyectaSobre(r), this.p2.proyectaSobre(r));
	}
	
	@Override
	public Segmento2D simetrico(Recta2D r) {
		return Segmento2D.of(this.p1.simetrico(r), this.p2.simetrico(r));
	}
	
	@Override
	public Segmento2D transform() {
		return Segmento2D.of(this.p1.transform(), this.p2.transform());
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Segmento2D t = this.transform();
		g2.draw(new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY()));		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segmento2D other = (Segmento2D) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("(%s,%s)",this.p1,this.p2);
	}

}
