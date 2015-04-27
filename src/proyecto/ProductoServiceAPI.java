/**
 * 
 */
package proyecto;

import java.util.ArrayList;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;

/**
 * @author Sebastian
 *
 */
@Api(name="producto", version="v1", description="API de la lista de productos")

public class ProductoServiceAPI {

	public static List<Producto> productos = new ArrayList<Producto>();
	@ApiMethod(name="add")
	public Producto addProducto(@Named("id")Integer id, @Named("Nombre")String nombre, @Named("Descripcion")String descripcion, @Named("Precio")double precio,@Named("Cantidad")Integer cantidad)
	throws NotFoundException{
		int index = productos.indexOf(new Producto(id));
		if(index!=-1)throw new NotFoundException("Producto Record already exist");
		Producto q = new Producto(id, nombre, descripcion, precio, cantidad);
		productos.add(q);
		return q;
	}
	
	@ApiMethod(name = "update")
	public Producto updateProducto(Producto q) throws NotFoundException{
		int index = productos.indexOf(q);
		if(index == -1)
			throw new NotFoundException("Producto Record does not exist");
		Producto currentProducto = productos.get(index);
		currentProducto.setCantidad(q.getCantidad());
		currentProducto.setDescripcion(q.getDescripcion());
		currentProducto.setNombre(q.getNombre());
		currentProducto.setPrecio(q.getPrecio());
		return q;
	}
	
	@ApiMethod(name="remove")
	public void removeProducto(@Named("id")Integer id) throws NotFoundException{
		int index = productos.indexOf(new Producto(id));
		if(index == -1)
			throw new NotFoundException("Producto Record does not exist");
		productos.remove(index);
	}
	
	@ApiMethod(name="list")
	public List<Producto> getproductos(){
			return productos;
	}
	
	@ApiMethod(name="listarProNombre")
	public List<Producto> getproductosByAuthor(@Named("Nombre") String nombre){
		List<Producto> results = new ArrayList<Producto>();
		for(Producto Producto : productos){
			if(Producto.getNombre().indexOf(nombre) != -1){
				results.add(Producto);
			}
		}
		return results;
	}
	
	@ApiMethod(name="getProducto")
	public Producto getProducto(@Named("id") Integer id) throws NotFoundException{
		int index = productos.indexOf(new Producto(id));
		if(index == -1) throw new NotFoundException("Producto Record does not exist");
		
		return productos.get(index);
	}
}
