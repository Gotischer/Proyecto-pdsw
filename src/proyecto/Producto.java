package proyecto;
/**
 * @author Sebastian
 *
 */
public class Producto {
	private Integer id;
	private String nombre;
	private String descripcion;
	private double precio;
	private Integer cantidad;

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(Integer id){
		super();
		this.setId(id);
	}
	
	public Producto(Integer id,String nombre,String descripcion,double precio,Integer cantidad){
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
		this.setCantidad(cantidad);
	}
	
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime*result+((id==null) ? 0 : id.hashCode());
		return result;
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if(id == null){
			if(other.id != null)
				return false;
		}else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String toString(){
		return "Producto[id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion +", precio" + precio + ", Cantidad" + cantidad +"]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
