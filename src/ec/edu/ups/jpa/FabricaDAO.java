package ec.edu.ups.jpa;

public class FabricaDAO {

	public FabricaDAO() {
	}
	
	public static JPAComidaDAO getComidaDAO() {
		return new JPAComidaDAO();
	}
	
	public static JPATarjetaCreditoDAO getTarjetaCreditoDAO() {
		return new JPATarjetaCreditoDAO();
	}
	
	public static JPAPedidoDAO getPedidoDAO() {
		return new JPAPedidoDAO();
	}
}
